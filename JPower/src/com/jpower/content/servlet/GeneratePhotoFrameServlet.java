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
		} else if(app.equals("residential-2")) {
			content = generateResidential2();
		} else if(app.equals("residential-3")) {
			content = generateResidential3();
		}
		
		PrintWriter out = resp.getWriter();
		out.println(content);
	}
	
	private String generateResidential1() {
		
		String[] title = {"Living room", "Bathroom", "Kitchen", "Miscellaneous"};
		String content = "<div class=\"photo-frame\">";
		
		for(int i = 0 ; i < title.length ; i++) {
			content = content + "<div class=\"photo-inside-1\">\n";
			content = content + "<div class=\"photo-inside-2\"><a href=\"index.jsp?page=residential_2\">";
			content = content + "<img src=\"images/collection-sample-pic.jpg\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content + "<div class=\"photo-inside-caption\">" + title[i] + "</div>\n";
			content = content + "</div>\n";			
		}
		
		content = content + "</div>";
		
		return content;
		
	}
	
	private String generateResidential2() {
		String[] title = {"Living Room", "Bathroom", "Kitchen", "Miscellaneous"};
		String content = "<div class=\"collection-submenu\">";
		
		for(int i = 0 ; i < title.length ; i++) {
			content = content + title[i];
			if(i != title.length - 1) {
				content = content + " / ";
			}
		}
		
		content = content + "</div>\n";
		for(int j = 0 ; j < title.length ; j++) {
			content = content + "<div class=\"app-commer-subsub\">" + title[j] + "</div>\n";
			content = content + "<div class=\"ap-photo-frame\">\n";
			for(int i = 0 ; i < 3 ; i++) {
				content = content + "<div class=\"ap-photo-inside-1\">\n";
				content = content + "<div class=\"ap-photo-inside-2\"><a href=\"index.jsp?page=residential_3\">";
				content = content + "<img src=\"images/application-commercial-photo.jpg\" width=\"229\" height=\"168\" /></a></div>\n";
				content = content + "<div class=\"ap-photo-inside-caption\">Sample" + " " + (i + 1) + "</div>\n";
				content = content + "</div>\n";
			}
			
			content = content + "</div>\n";
		}		
		return content;		
	}
	
	private String generateResidential3() {
		String content = "<div class=\"collection-submenu\">Residential  &gt;  Bathroom  &gt;  Sample A</div>\n";
		content = content + "<div class=\"app-commercial-frame2\">\n";
		content = content + "<div class=\"big-photo-frame\">\n";
		content = content + "<div class=\"big-photo-frame\">\n";
		content = content + "<div class=\"big-photo-frame-inside-1\"><img src=\"images/application-commercial-bigphoto.jpg\" width=\"495\" height=\"375\" /></div>\n";
		content = content + "</div>\n";
		content = content + "<div class=\"big-photo-right-frame\">\n";
		
		//Develop code here.
		
		content = content + "</div>\n";
		
		return content;
	}

}
