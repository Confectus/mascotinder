package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		//request.setAttribute("pets", DAOFactory.getFactory().getPetDAO().getPetsByOwnerEmail("andres.lozano@epn.edu.ec"));
		// 3. Send data to the view
		//request.getRequestDispatcher("/jsp/listPets.jsp").forward(request, response);
		getRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		// 3. Send data to the view
		//response.sendRedirect("ListPetsController");
		getRequest(request, response);
	}
	
	private void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		// 2. Talk with the model
		System.out.println("Controller!!!!!");
		builOwner();
		buildPet();
		request.setAttribute("pets", DAOFactory.getFactory().getPetDAO().getPetsByOwnerEmail("daniel.garrido@epn.edu.ec"));
		// 3. Send data to the view
		getServletContext().getRequestDispatcher("/jsp/ListPets.jsp").forward(request, response);
	}
	
	
	/* Prueba */
	
	public static void builOwner() {
		Owner ow = new Owner();
		ow.setName("Daniel");
		ow.setEmail("daniel.garrido@epn.edu.ec");
		ow.setPassword("daniel123");
		
		Owner ow2 = new Owner();
		ow.setName("Juan");
		ow.setEmail("juan.perez@epn.edu.ec");
		ow.setPassword("juan123");
		
		DAOFactory.getFactory().getOwnerDAO().create(ow);
		DAOFactory.getFactory().getOwnerDAO().create(ow2);
		
	}
	
	public static void buildPet() {
		Pet pt = new Pet();
		pt.setName("Alta");
		pt.setAge(12);
		pt.setSpecie("x");
		pt.setType("y");
		
		Pet pt2 = new Pet();
		pt.setName("Mope");
		pt.setAge(2);
		pt.setSpecie("x");
		pt.setType("y1");
		
		DAOFactory.getFactory().getPetDAO().create(pt);
		DAOFactory.getFactory().getPetDAO().create(pt2);
		
	}
	
	public static void listarMascotas(String correo) {
		List<Pet> lista = DAOFactory.getFactory().getPetDAO().getPetsByOwnerEmail(correo);
		for (Pet pet : lista) {
			System.out.println(pet.toString());
		}
	}

}
