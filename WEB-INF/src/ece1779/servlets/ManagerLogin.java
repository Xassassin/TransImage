package ece1779.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ManagerLogin extends HttpServlet {
    public void doGet(HttpServletRequest request,
	              HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
	
        HttpSession session = request.getSession();
	String  loggedIn = (String)session.getAttribute("loggedIn");

        String login = null;
        

        if (loggedIn == null) {
            login = request.getParameter("login");
            String password = request.getParameter("password");

            if (login != null && login.compareTo("admin") == 0 && 
                password != null && password.compareTo("admin") == 0) {
                loggedIn = "true";
            }
        }
        
	out.println("<head><title>Manager Login</title></head>");
	out.println("<body>");
	out.println("<h1>Manager Login</h1>");

	if (loggedIn != null) {
            session.setAttribute("loggedIn", loggedIn);
	    response.sendRedirect("/B1/jsp/managerPage.jsp");
	}
	else {
	    if (login != null)
		out.println("Login failed!  Try again. <br>");
	    out.println("<form action='ManagerLogin'> ");
	    out.println("Login <input type='text' name='login' />");
	    out.println("Password <input type='text' name='password' />");
	    out.println("<input type='submit' />");
	    out.println("</form>");
	}
        out.println("</body>");
        out.println("</html>");
    }
}
