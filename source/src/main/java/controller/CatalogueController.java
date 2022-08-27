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
import model.entities.Pet;

@WebServlet("/CatalogueController")
public class CatalogueController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

    public CatalogueController() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		processRequest(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		//Integer petId = Integer.parseInt(request.getParameter("petId"));
		
		// 2. Talk with the model
		//Preference petPreference = DAOFactory.getFactory().getPreferenceDAO().getPreferenceByPetId(petId);
		//List<Pet> petApplicants = DAOFactory.getFactory().getPetDAO().getPetsByPreference(petPreference);
		List<Pet> petApplicants = DAOFactory.getFactory().getPetDAO().getPetsByOwnerEmail("francisco.encalada01@epn.edu.ec");
				
		
		// 3. Send data to the view
		request.setAttribute("catalogue", petApplicants);
		getServletContext().getRequestDispatcher("/jsp/Catalogue.jsp").forward(request, response);
	}

}
