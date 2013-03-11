package ece1779.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import ece1779.manager.Manager;

public class AutoScaling extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String gthr = request.getParameter("gthr");
		String sthr = request.getParameter("sthr");
		String gratio = request.getParameter("gratio");
		String sratio = request.getParameter("sratio");
		int error = 0;
		double gthrNum = 0;
		double sthrNum = 0;
		int sratioNum = 0, gratioNum = 0;
		if (gthr.equals("") && sthr.equals("") && gratio.equals("")
				&& sratio.equals("")) {
			error = 2;
		} else {
			if (!gthr.equals(""))
				try {
					gthrNum = Double.parseDouble(gthr);
				} catch (NumberFormatException nfe) {
					error = 1;
				}
			else
				gthrNum = 0;
			if (!sthr.equals(""))
				try {
					sthrNum = Double.parseDouble(sthr);
				} catch (NumberFormatException nfe) {
					error = 1;
				}
			else
				sthrNum = 0;
			if (!gratio.equals(""))
				try {
					gratioNum = Integer.parseInt(gratio);
				} catch (NumberFormatException nfe) {
					error = 1;
				}
			else
				gratioNum = 0;
			if (!sratio.equals(""))
				try {
					sratioNum = Integer.parseInt(sratio);
				} catch (NumberFormatException nfe) {
					error = 1;
				}
			else
				sratioNum = 0;
		}
		// Do autoscaling pool
		Manager.autoScale(getServletContext(), gthrNum, sthrNum, gratioNum,
				sratioNum);

		if (error == 1)
			request.setAttribute("error3", "Please type in an integer!");
		else if (error == 2)
			request.setAttribute("error3", "Please type in integer values");
		else
			request.setAttribute("error3", "auto-scale pool.");
		request.getRequestDispatcher("/jsp/managerPage.jsp").forward(request,
				response);

	}

}
