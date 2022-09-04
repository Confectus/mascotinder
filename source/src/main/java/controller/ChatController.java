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
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		Boolean sendFlag = Boolean.parseBoolean(request.getParameter("send_flag"));
		String content = request.getParameter("content");
		String senderOwnerEmail = request.getParameter("sender_email");
		String receiverOwnerEmail = request.getParameter("receiver_email");
		
		// 2. Talk with the model
		if (sendFlag) {
			Owner sender = DAOFactory.getFactory().getOwnerDAO().read(senderOwnerEmail);
			Owner receiver = DAOFactory.getFactory().getOwnerDAO().read(receiverOwnerEmail);
			Message message = new Message(content,sender,receiver);
			DAOFactory.getFactory().getMessageDAO().create(message);
		}
		
		List<Message> messages = DAOFactory.getFactory().getMessageDAO().getMessagesByOwnersEmails(senderOwnerEmail, receiverOwnerEmail);
		
		// 3. Send data to the view
		request.setAttribute("messages", messages);
		getServletContext().getRequestDispatcher("/jsp/Chat.jsp").forward(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. Get parameters
		String receiverOwnerEmail = request.getParameter("receiver_owner_email");
		HttpSession sessionOwner = request.getSession();
		Owner loggedOwner = (Owner) sessionOwner.getAttribute("loggedOwner");
		
		// 2. Talk with the model
		List<Message> messages = DAOFactory.getFactory().getMessageDAO().getMessagesByOwnersEmails(receiverOwnerEmail, loggedOwner.getEmail());
		
		// 3. Send data to the view
		request.setAttribute("sender_owner_email", loggedOwner.getEmail());
		request.setAttribute("receiver_owner_email", receiverOwnerEmail);
		request.setAttribute("messages", messages);
		getServletContext().getRequestDispatcher("/jsp/Chat.jsp").forward(request, response);
	}

}
