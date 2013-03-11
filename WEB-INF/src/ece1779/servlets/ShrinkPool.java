package ece1779.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import ece1779.manager.Manager;

public class ShrinkPool extends HttpServlet {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reduceWorkers = request.getParameter("reduceWorkers"); 
		boolean error = false;
		try {
			int reduceWorkerNum = Integer.parseInt(reduceWorkers);
			Manager.stopInstances(getServletContext(), reduceWorkerNum);
		} catch (NumberFormatException nfe) {
			error = true;
		} 
		// Do shrink pool
		
		if (error) 
			request.setAttribute("error2", "Please type in an integer!");
		else 
		    request.setAttribute("error2", "Shrink worker pool.");
 	    request.getRequestDispatcher("/jsp/managerPage.jsp").forward(request, response); 	


	}

}
