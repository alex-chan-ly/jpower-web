package com.jpower.content.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GeneratePhotoFrameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String content = "";
		String app = req.getParameter("app");
		if(app.equals("residential-1")) {
			content = generateResidential1();
		}
		
		PrintWriter out = resp.getWriter();
		out.println(content);
	}
	
	private String generateResidential1() {
		
		String[] title = {"Living room", "Bathroom", "Kitchen", "Miscellaneous"};
		String content = "<div class=\"photo-frame\">";
		
		for(int i = 0 ; i < 4 ; i++) {
			content = content + "<div class=\"photo-inside-1\">\n";
			content = content + "<div class=\"photo-inside-2\"><a href=\"application-residential-2.html\">";
			content = content + "<img src=\"images/collection-sample-pic.jpg\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content + "<div class=\"photo-inside-caption\">" + title[i] + "</div>\n";
			content = content + "</div>\n";			
		}
		
		content = content + "</div>";
		
		return content;
		
	}

}
