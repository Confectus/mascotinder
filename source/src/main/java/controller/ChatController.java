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
import model.entities.Message;
import model.entities.Owner;

@WebServlet("/ChatController")
public class ChatController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChatController() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getRequest(request, response);
	}
	
	private void getRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		String receiverOwnerEmail = request.getParameter("receiver_owner_email");
		HttpSession sessionOwner = request.getSession();
		Owner loggedOwner = (Owner) sessionOwner.getAttribute("loggedOwner");
		
		// 2. Talk with the model
		List<Message> messages = DAOFactory.getFactory().getMessageDAO().getMessagesByOwnersEmails(receiverOwnerEmail, loggedOwner.getEmail());
		
		// 3. Send data to the view
		request.setAttribute("receiver_owner_email", receiverOwnerEmail);
		request.setAttribute("messages", messages);
		response.sendRedirect("jsp/Chat.jsp");
	}

}
