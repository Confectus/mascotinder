package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.dao.DAOFactory;
import model.entities.Owner;
import model.entities.Pet;

@WebServlet("/ListPetsController")
public class ListPetsController extends HttpServlet {
	/* Attributes */
	/* ----------------------------------------------------------------------- */
	private static final long serialVersionUID = 1L;

	/* Constructor */
	/* ----------------------------------------------------------------------- */
    public ListPetsController() {
    	
    }

    /* Methods */
	/* ----------------------------------------------------------------------- */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		getRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		getRequest(request, response);
	}
	
	private void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		HttpSession sessionOwner = request.getSession();
		Owner loggedOwner = (Owner) sessionOwner.getAttribute("loggedOwner");
		//sessionScope.loggedUser.getName()

		// 2. Talk with the model
		request.setAttribute("pets", DAOFactory.getFactory().getPetDAO().getPetsByOwnerEmail(loggedOwner.getEmail()));
		// 3. Send data to the view
		getServletContext().getRequestDispatcher("/jsp/ListPets.jsp").forward(request, response);
	}
	
	

}
