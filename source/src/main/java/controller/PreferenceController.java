package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DAOFactory;
import model.entities.Preference;

@WebServlet("/PreferenceController")
public class PreferenceController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public PreferenceController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		Integer petId = Integer.parseInt(request.getParameter("petId"));
		
		// 2. Talk with the model
		Preference petPreference = DAOFactory.getFactory().getPreferenceDAO().getPreferenceByPetId(petId);
		List<String> types = DAOFactory.getFactory().getPetDAO().getTypes();
		
		// 3. Send data to the view
		request.setAttribute("pet_preference", petPreference);
		request.setAttribute("types", types);
		getServletContext().getRequestDispatcher("/jsp/Preference.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
