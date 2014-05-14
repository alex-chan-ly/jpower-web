package com.jpower.dispatcher;

import java.io.FileOutputStream;
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
		out.println("<br/>");
		out.println("user.dir=" + System.getProperty("user.dir"));
		out.println("<br/><br/>");
		out.println("</body></html>");
		
/*		FileOutputStream output = new FileOutputStream("/home/jpoweradm/public_html/content/zip/test.txt");
		output.write("Testing 123".getBytes());
		output.close()*/;
//		Runtime.getRuntime().exec("chown jpoweradm " + "/home/jpoweradm/public_html/content/zip/wcrhpg300-106.zip");
//		Runtime.getRuntime().exec("chgrp jpoweradm " + "/home/jpoweradm/public_html/content/zip/wcrhpg300-106.zip");
//		Runtime.getRuntime().exec("chown jpoweradm " + "/home/jpoweradm/public_html/hello.jsp");
//		Runtime.getRuntime().exec("chgrp jpoweradm " + "/home/jpoweradm/public_html/hello.jsp");
//		Runtime.getRuntime().exec("chown jpoweradm " + "/home/jpoweradm/public_html/servlets-examples.tar.gz");
//		Runtime.getRuntime().exec("chgrp jpoweradm " + "/home/jpoweradm/public_html/servlets-examples.tar.gz");
//		Runtime.getRuntime().exec("chown jpoweradm " + "/home/jpoweradm/public_html/test.txt");
//		Runtime.getRuntime().exec("chgrp jpoweradm " + "/home/jpoweradm/public_html/test.txt");
		Runtime.getRuntime().exec("chown -R jpoweradm " + "/home/jpoweradm/public_html/content/tmp/1400084060862845000");
		Runtime.getRuntime().exec("chgrp -R jpoweradm " + "/home/jpoweradm/public_html/content/tmp/1400084060862845000");

		

	}
}
