package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.dao.DAOFactory;
import model.entities.Pet;
import model.entities.Preference;

@WebServlet("/PreferenceController")
public class PreferenceController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public PreferenceController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get parameters
		Integer petId = Integer.parseInt(request.getParameter("pet_id"));
		System.out.println(petId);
		// 2. Talk with the model
		Pet pet = DAOFactory.getFactory().getPetDAO().read(petId);		
		if (pet.getPreference() == null) {
			Preference preference = new Preference(null, pet.getType(), changeSex(pet.getSex()), 1, 20, pet);
			DAOFactory.getFactory().getPreferenceDAO().create(preference);
			Preference petPreference = DAOFactory.getFactory().getPreferenceDAO().getPreferenceByPetId(petId);	
			request.setAttribute("preference", petPreference);
		}else {
			Preference petPreference = DAOFactory.getFactory().getPreferenceDAO().getPreferenceByPetId(petId);	
			request.setAttribute("preference", petPreference);
		}
		
		List<String> types = DAOFactory.getFactory().getPetDAO().getTypes();

		// 3. Send data to the view
		//request.setAttribute("preference", petPreference);
		request.setAttribute("types", types);
		request.setAttribute("pet_id", petId);
		System.out.println("HEREEEE");
		getServletContext().getRequestDispatcher("/jsp/Preference.jsp").forward(request, response);
	}

	private String changeSex(String sex) {
		if (sex == "male") {
			return "female";
		} else {
			return "male";
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get parameters
		String preferenceType = request.getParameter("pet_type");
		String preferenceSex = request.getParameter("pet_sex");
		Integer preferenceMinimumAge = Integer.parseInt(request.getParameter("pet_minimum_age"));
		Integer preferenceMaximumAge = Integer.parseInt(request.getParameter("pet_maximum_age"));
		Integer petId = Integer.parseInt(request.getParameter("pet_id"));

		// 2. Talk with the model
		Pet pet = DAOFactory.getFactory().getPetDAO().read(petId);
		Preference updatedPreference = new Preference(0, preferenceType, preferenceSex, preferenceMinimumAge,
				preferenceMaximumAge, pet);

		DAOFactory.getFactory().getPreferenceDAO().setPreferenceByPetId(petId, updatedPreference);

		// 3. Send data to the view
		getServletContext().getRequestDispatcher("/ListPetsController").forward(request, response);
	}

}
