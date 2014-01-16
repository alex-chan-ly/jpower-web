package com.jpower.content.business;

import java.util.ArrayList;
import java.util.List;

import com.jpower.content.model.Stock;

public class CommercialPhotoFramePage implements PhotoFramePage {

	public String generatePage1() {
		// TODO Auto-generated method stub
		String[] title = {"Retail Shop", "Office Building", "Swimming Pool", "Miscellaneous"};
		String content = "<div class=\"photo-frame-com\">";
		
		for(int i = 0 ; i < title.length ; i++) {
			content = content + "<div class=\"photo-inside-1-com\">\n";
			content = content + "<div class=\"photo-inside-2-com\"><a href=\"index.jsp?page=commercial_2\">";
			content = content + "<img src=\"content/storage/commercial/1/" + "collection-sample-pic.jpg\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content + "<div class=\"photo-inside-caption-com\">" + title[i] + "</div>\n";
			content = content + "</div>\n";			
		}
		
		content = content + "</div>";
		
		return content;
	}

	public String generatePage1_Chn() {
		// TODO Auto-generated method stub
		String[] title = {"Retail Shop", "Office Building", "Swimming Pool", "Miscellaneous"};
		String content = "<div class=\"photo-frame-com\">";
		
		for(int i = 0 ; i < title.length ; i++) {
			content = content + "<div class=\"photo-inside-1-com\">\n";
			content = content + "<div class=\"photo-inside-2-com\"><a href=\"index.jsp?page=commercial_2\">";
			content = content + "<img src=\"../content/storage/commercial/1/" + "collection-sample-pic.jpg\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content + "<div class=\"photo-inside-caption-com\">" + title[i] + "</div>\n";
			content = content + "</div>\n";			
		}
		
		content = content + "</div>";
		
		return content;
	}

	public String generatePage2() {
		// TODO Auto-generated method stub
		String[] title = {"Retail Shop", "Office Building", "Swimming Pool", "Miscellaneous"};
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
				content = content + "<div class=\"ap-photo-inside-2-com\"><a href=\"index.jsp?page=commercial_3\">";
				content = content + "<img src=\"content/storage/commercial/2/" + "application-commercial-photo.jpg\" width=\"229\" height=\"168\" /></a></div>\n";
				content = content + "<div class=\"ap-photo-inside-caption\">Sample" + " " + (i + 1) + "</div>\n";
				content = content + "</div>\n";
			}
			
			content = content + "</div>\n";
		}		
		return content;		
	}

	public String generatePage2_Chn() {
		// TODO Auto-generated method stub
		String[] title = {"Retail Shop", "Office Building", "Swimming Pool", "Miscellaneous"};
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
				content = content + "<div class=\"ap-photo-inside-2-com\"><a href=\"index.jsp?page=commercial_3\">";
				content = content + "<img src=\"../content/storage/commercial/2/" + "application-commercial-photo.jpg\" width=\"229\" height=\"168\" /></a></div>\n";
				content = content + "<div class=\"ap-photo-inside-caption\">Sample" + " " + (i + 1) + "</div>\n";
				content = content + "</div>\n";
			}
			
			content = content + "</div>\n";
		}		
		return content;		

	}

	public String generatePage3(String catPK, String seriesPK) {
		// TODO Auto-generated method stub
		List stocks = getStocks();
		
		String content = "<div class=\"collection-submenu\">Commercial  &gt;  Retail Shop  &gt;  Sample A</div>\n";
		content = content + "<div class=\"app-commercial-frame2\">\n";
		content = content + "<div class=\"big-photo-frame\">\n";
		content = content + "<div class=\"big-photo-frame-inside-1\"><img src=\"content/storage/commercial/3/application-commercial-bigphoto.jpg\" width=\"495\" height=\"375\" /></div>\n";
		content = content + "</div>\n";
		content = content + "<div class=\"big-photo-right-frame\">\n";
		
		//Develop code here.
		for(int i = 0 ; i < stocks.size() ; i++) {
			Stock stock = (Stock)stocks.get(i);
			
			content = content + "<div class=\"rightoutsideframe-com\">\n";
			content = content + "<div class=\"sp-photo-left-com\">\n";
			content = content + "<div class=\"sp-photo-left-inside-com\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo" + (i + 1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"";
			content = content + stock.getSmallPictureName() + "\" width=\"130\" height=\"130\" /></a></div>\n";
			content = content + "</div>\n";
			content = content + "<div class=\"sp-photo-right-com\">\n";
			content = content + "<div class=\"caption-app-1-com\"><span class=\"captionfont-1-com\">" + stock.getName() + "</span><br />";
			content = content + "<span class=\"captionfont-2\">" + stock.getCode() + "</span><br />";
			content = content + "<span class=\"captionfont-3\">" + stock.getDescription() + "<br />";
			content = content + "</span> <br />\n";
			content = content + "</div>\n";
			content = content + "<div class=\"caption-app-2-com\"><img src=\"images/series-bt.jpg\" width=\"75\" height=\"19\" id=\"Image9\" onmouseover=\"MM_swapImage('Image9','','images/series-bt-over.jpg',1)\" onmouseout=\"MM_swapImgRestore()\" /></div>\n";
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

	public String generatePage3_Chn(String catPK, String sereisPK) {
		// TODO Auto-generated method stub
		List stocks = getStocks();
		
		String content = "<div class=\"collection-submenu\">Commercial  &gt;  Retail Shop  &gt;  Sample A</div>\n";
		content = content + "<div class=\"app-commercial-frame2\">\n";
		content = content + "<div class=\"big-photo-frame\">\n";
		content = content + "<div class=\"big-photo-frame-inside-1\"><img src=\"../content/storage/commercial/3/application-commercial-bigphoto.jpg\" width=\"495\" height=\"375\" /></div>\n";
		content = content + "</div>\n";
		content = content + "<div class=\"big-photo-right-frame\">\n";
		
		//Develop code here.
		for(int i = 0 ; i < stocks.size() ; i++) {
			Stock stock = (Stock)stocks.get(i);
			
			content = content + "<div class=\"rightoutsideframe-com\">\n";
			content = content + "<div class=\"sp-photo-left-com\">\n";
			content = content + "<div class=\"sp-photo-left-inside-com\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo" + (i + 1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"";
			content = content + "../" + stock.getSmallPictureName() + "\" width=\"130\" height=\"130\" /></a></div>\n";
			content = content + "</div>\n";
			content = content + "<div class=\"sp-photo-right-com\">\n";
			content = content + "<div class=\"caption-app-1-com\"><span class=\"captionfont-1-com\">" + stock.getName() + "</span><br />";
			content = content + "<span class=\"captionfont-2\">" + stock.getCode() + "</span><br />";
			content = content + "<span class=\"captionfont-3\">" + stock.getDescription() + "<br />";
			content = content + "</span> <br />\n";
			content = content + "</div>\n";
			content = content + "<div class=\"caption-app-2-com\"><img src=\"../images/series-bt.jpg\" width=\"75\" height=\"19\" id=\"Image9\" onmouseover=\"MM_swapImage('Image9','','../images/series-bt-over.jpg',1)\" onmouseout=\"MM_swapImgRestore()\" /></div>\n";
			content = content + "</div>\n";
			content = content + "<div id=\"photo" + (i+1) + "\" class=\"lightbox-panel\">\n";
			content = content + "<div class=\"lightbox_left\"><img src=\"";
			content = content + "../" + stock.getLargePictureName() + "\" width=\"275\" height=\"275\" /></div>\n";
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
			content = content + "<div class=\"clearfix\"><a href=\"#nogo\" onclick=\"lb_effect_close('#photo" + (i+1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"../images/close.png\" /></a></div></div>\n";
			content = content + "<!-- /lightbox-panel -->\n<div id=\"photo_wrap" + (i+1) + "\" class=\"lightbox\"></div>\n<!-- /lightbox -->\n";
		}
		
		content = content + "</div>\n";
		//content = content + //navigator;  
		content = content + "<br/>\n";
		content = content + "</div></div>";
		
		
		return content;

	}
	
	private List<Stock> getStocks() {
		
		List<Stock> stocks = new ArrayList<Stock>();
		
		for(int i = 0 ; i < 1 ; i++) {
			Stock stock = new Stock();
			stock.setCategory("Commercial");
			stock.setName("Material A");
			stock.setCode("no.cb0030");
			stock.setDescription("Description");
			stock.setSmallPictureName("content/storage/commercial/3/application-commercial-right-photo.jpg");
			stock.setLargePictureName("content/storage/commercial/3/application-commercial-right-photo-large.jpg");							
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
