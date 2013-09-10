package com.jpower.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class TestServlet extends HttpServlet {

	public TestServlet() {
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = req.getMethod();
		String ip = req.getRemoteAddr();
		
        resp.setContentType("text/html"); 
		PrintWriter out = resp.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " +
                "Transitional//EN\">\n");
		out.println("<html><body>");
		out.println("Method=" + method);
		out.println("<br/>");
		out.println("IP=" + ip);
		out.println("<br/><br/>");
		out.println("</body></html>");
	}
}
