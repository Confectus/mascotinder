package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.DAOFactory;

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
		request.setAttribute("pets", DAOFactory.getFactory().getPetDAO().getPetsByOwnerEmail("andres.lozano@epn.edu.ec"));
		// 3. Send data to the view
		request.getRequestDispatcher("/jsp/listPets.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		response.sendRedirect("ListPetsController");
	}

}
