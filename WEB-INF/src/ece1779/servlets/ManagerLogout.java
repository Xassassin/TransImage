package ece1779.servlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ManagerLogout extends HttpServlet {
    public void doGet(HttpServletRequest request,
	              HttpServletResponse response)
    throws IOException, ServletException
    {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

	HttpSession session = request.getSession(false);
	if (session != null)	session.invalidate();
        out.println("Successfully log out. Click <a href = 'ManagerLogin'>here</a> to login");

    }
}
