package ece1779.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import ece1779.manager.Manager;

public class GrowPool extends HttpServlet {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String growWorkers = request.getParameter("growWorkers"); 
		boolean error = false;
		try {
			int growWorkerNum = Integer.parseInt(growWorkers);
			Manager.startInstances(getServletContext(), growWorkerNum);
		} catch (NumberFormatException nfe) {
			error = true;
		} 
		// Do grow pool
		if (error) 
		    request.setAttribute("error1", "Please type in an integer!");
		else 
		    request.setAttribute("error1", "Increased worker pool.");
	    	request.getRequestDispatcher("/jsp/managerPage.jsp").forward(request, response); 			
	}

}
