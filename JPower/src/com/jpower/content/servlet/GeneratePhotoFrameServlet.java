package com.jpower.content.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpower.content.model.Stock;

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
		List stocks = getStocks("Residential");
		
		String content = "<div class=\"collection-submenu\">Residential  &gt;  Bathroom  &gt;  Sample A</div>\n";
		content = content + "<div class=\"app-commercial-frame2\">\n";
		content = content + "<div class=\"big-photo-frame\">\n";
		content = content + "<div class=\"big-photo-frame-inside-1\"><img src=\"images/application-commercial-bigphoto.jpg\" width=\"495\" height=\"375\" /></div>\n";
		content = content + "</div>\n";
		content = content + "<div class=\"big-photo-right-frame\">\n";
		
		//Develop code here.
		for(int i = 0 ; i < stocks.size() ; i++) {
			Stock stock = (Stock)stocks.get(i);
			
			content = content + "<div class=\"rightoutsideframe\">\n";
			content = content + "<div class=\"sp-photo-left\">\n";
			content = content + "<div class=\"sp-photo-left-inside\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo" + (i + 1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"";
			content = content + stock.getSmallPictureName() + "\" width=\"130\" height=\"130\" /></a></div>\n";
			content = content + "</div>\n";
			content = content + "<div class=\"sp-photo-right\">\n";
			content = content + "<div class=\"caption-app-1\"><span class=\"captionfont-1\">" + stock.getName() + "</span><br />";
			content = content + "<span class=\"captionfont-2\">" + stock.getCode() + "</span><br />";
			content = content + "<span class=\"captionfont-3\">" + stock.getDescription() + "<br />";
			content = content + "</span> <br />\n";
			content = content + "</div>\n";
			content = content + "<div class=\"caption-app-2\"><img src=\"images/series-bt.jpg\" width=\"75\" height=\"19\" id=\"Image9\" onmouseover=\"MM_swapImage('Image9','','images/series-bt-over.jpg',1)\" onmouseout=\"MM_swapImgRestore()\" /></div>\n";
			content = content + "</div>\n";
			content = content + "<div id=\"photo" + (i+1) + "\" class=\"lightbox-panel\">\n";
			content = content + "<div class=\"lightbox_left\"><img src=\"";
			content = content + stock.getLargePictureName() + "\" width=\"275\" height=\"275\" /></div>\n";
			content = content + "<div class=\"lightbox_right\">\n";
			content = content + "<h2>" + stock.getName() + "</h2>\n";
			content = content + "<table>\n";
			content = content + "<tr><td><strong>Ref number</strong></td><td>" + stock.getRefNum() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Series</strong></td><td>" + stock.getSeries() + "</td></tr>\n";
			content = content + "<tr><td><strong>Available Sizes</strong></td><td>" + stock.getSizes() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Tile Thickness</strong></td><td>" + stock.getThickness() + "</td></tr>";
			content = content + "<tr><td><strong>Colour</strong></td><td>" + stock.getColor() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Finishing</strong></td><td>" + stock.getFinishing() + "</td></tr>\n";
			content = content + "<tr><td><strong>Application</strong></td><td>" + stock.getApplication() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Remarks</strong></td><td>" + stock.getRemarks() + "</td></tr>\n";
			content = content + "</table>\n</div>\n";
			content = content + "<div class=\"clearfix\"><a href=\"#nogo\" onclick=\"lb_effect_close('#photo" + (i+1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"images/close.png\" /></a></div></div>\n";
			content = content + "<!-- /lightbox-panel -->\n<div id=\"photo_wrap" + (i+1) + "\" class=\"lightbox\"></div>\n<!-- /lightbox -->\n";
		}
		
		content = content + "</div>\n";
		//content = content + //navigator;  
		content = content + "<br/>\n";
		content = content + "</div></div>";
		
		
		return content;
	}
	
	private List<Stock> getStocks(String category) {
		
		List<Stock> stocks = new ArrayList<Stock>();
		
		for(int i = 0 ; i < 1 ; i++) {
			Stock stock = new Stock();
			stock.setCategory(category);
			stock.setName("Material A");
			stock.setCode("no.cb0030");
			stock.setDescription("Description");
			stock.setSmallPictureName("images/application-commercial-right-photo.jpg");
			stock.setLargePictureName("images/application-commercial-right-photo-large.jpg");
			stock.setRefNum("xxxxxx");
			stock.setSeries("Portugal Series");
			stock.setSizes("100mm x 100mm");
			stock.setThickness("10mm");
			stock.setColor("White/ Black");
			stock.setFinishing("Matt surface");
			stock.setApplication("Floor / Wall");
			stock.setRemarks("Conform to International Standard<ul><li>Slip resistance</li><li>Water absorption</li><li>Breaking strength</li></ul>");
			stocks.add(stock);
		}
		
		return stocks;
		
	}

}
