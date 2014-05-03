package com.jpower.content.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AuthenServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
		String code = req.getParameter("code");
		
		//temporary code
		if(code.equals("jpoweradm")) {
			req.getSession().setAttribute("STATUS", "AUTHENTICATED");
			//production
			//resp.sendRedirect("/upload.jsp");
			//testing development
			resp.sendRedirect(req.getContextPath() + "/upload.jsp");
		} else {
			req.getSession().setAttribute("ERROR", "invalid security code");
			//production
			resp.sendRedirect("/admin.jsp");
			//testing development
//			resp.sendRedirect("/jpower/admin.jsp");
		}
	}

}
