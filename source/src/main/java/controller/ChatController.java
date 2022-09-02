package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		// 2. Talk with the model
		// 3. Send data to the view
		response.sendRedirect("jsp/Chat.jsp");
	}

}
