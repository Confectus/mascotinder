package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.DAOFactory;
import model.entities.Match;
import model.entities.Owner;
import model.entities.Pet;

@WebServlet("/ListPetsController")
public class ListPetsController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ListPetsController() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		getRequest(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		getRequest(request, response);
	}

	private void getRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1. Get parameters
		HttpSession sessionOwner = request.getSession();
		Owner loggedOwner = (Owner) sessionOwner.getAttribute("loggedOwner");

		// 2. Talk with the model
		List<Pet> pets = DAOFactory.getFactory().getPetDAO().getPetsByOwnerEmail(loggedOwner.getEmail());

		for (Pet pet : pets) {
			List<Match> petMatches = DAOFactory.getFactory().getMatchDAO().getMatchesByPetId(pet.getId());
			pet.setMatches(petMatches);
		}

		// 3. Send data to the view
		request.setAttribute("pets", pets);
		getServletContext().getRequestDispatcher("/jsp/ListPets.jsp").forward(request, response);
	}
}
