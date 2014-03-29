package com.jpower.content.business;

public class CollectionPhotoFramePage implements PhotoFramePage {

	public String generatePage1() {
		// TODO Auto-generated method stub
		String item[] = {"Procelain", "Mosaics", "Hand-made Tiles", "Floor Heating", "Other"};
		
		String content = "";
		
		for(int i = 0 ; i < item.length ; i++) {
			content = content + "<div class=\"photo-inside-1\">\n";
			content = content + "<div class=\"photo-inside-2\"><a href=\"index.jsp?page=collection_2\"><img src=\"content/storage/collection/1/collection-sample-pic.jpg\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content +  "<div class=\"photo-inside-caption\">" + item[i] + "</div>\n";
			content = content + "</div>\n";
		}
		
		return content;
	}

	public String generatePage1_Chn() {
		// TODO Auto-generated method stub
		String item[] = {"瓷", "馬賽克", "手工製作的瓷磚", "地板采暖", "其他"};
		
		String content = "";
		
		for(int i = 0 ; i < item.length ; i++) {
			content = content + "<div class=\"photo-inside-1\">\n";
			content = content + "<div class=\"photo-inside-2\"><a href=\"index.jsp?page=collection_2\"><img src=\"../content/storage/collection/1/collection-sample-pic.jpg\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content +  "<div class=\"photo-inside-caption\">" + item[i] + "</div>\n";
			content = content + "</div>\n";
		}
		
		return content;
	}

	public String generatePage2() {
		// TODO Auto-generated method stub
		return null;
	}

	public String generatePage2_Chn() {
		// TODO Auto-generated method stub
		return null;
	}

	public String generatePage3(String catPK, String seriesPK, String title, String subpage) {
		// TODO Auto-generated method stub
		String theme[] = {"Porcelain", "Mosaics", "Hand-made Tiles", "Floor Heating", "Others"};
		
		String content = "<div class=\"collection-submenu\">\n";
		content = content + theme[0];
		for(int i = 1 ; i < theme.length ; i++) {
			content = content + " / ";
			content = content + theme[i];
		}
		content = content + "</div>\n";
		
		content = content + "<div class=\"collection-subtitle\">Porcelain</div>\n";

		
		for(int i = 0 ; i < 2 ; i++) {
			content = content + "<div class=\"collection-susubbtitle\">Colortone " + (i+1) + "</div>\n";
			content = content + "<div class=\"sp-frame\">\n";
			for(int j = 0 ; j < 1 ; j++) {
				content = content + "<div class=\"sp-inside-1\">\n";
				content = content + "<div class=\"sp-inside-2\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo22','#photo_wrap22')\"><img src=\"content/storage/collection/2/collection-06.jpg\" width=\"71\" height=\"71\" /></a></div>\n";
				content = content + "<div class=\"sp-inside-caption\">ct0001</div>\n";
				content = content + "<div id=\"photo22\" class=\"lightbox-panel\">\n";
				content = content + "<div class=\"lightbox_left\"><img src=\"content/storage/collection/2/application-commercial-right-photo-large.jpg\" width=\"275\" height=\"275\" /></div>\n";
				content = content + "<div class=\"lightbox_right\">\n";
				content = content + "<h2>ct0001</h2>\n";
				content = content + "<table>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Ref number</strong></td>\n";
				content = content + "<td>xxxxxx</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Series</strong></td>\n";
				content = content + "<td>Portugal Series</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Available Sizes</strong></td>\n";
				content = content + "<td>100mm x 100mm</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Tile Thickness</strong></td>\n";
				content = content + "<td>10mm</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Colour</strong></td>\n";
				content = content + "<td>White/ Black</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Finishing</strong></td>\n";
				content = content + "<td>Matt surface</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Application</strong></td>\n";
				content = content + "<td>Floor / Wall</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Remarks</strong></td>\n";
				content = content + "<td>Conform to International Standard\n";
				content = content + "<ul>\n";
				content = content + "<li>Slip resistance</li>\n";
				content = content + "<li>Water absorption</li>\n";
				content = content + "<li>Breaking strength</li>\n";
				content = content + "</ul>\n";
				content = content + "</td>\n";
				content = content + "</tr>\n";
				content = content + "</table>\n";
				content = content + "</div>\n";
				content = content + "<div class=\"clearfix\"><a href=\"#nogo\" onclick=\"lb_effect_close('#photo22','#photo_wrap22')\"><img src=\"images/close.png\" /></a></div>\n";
				content = content + "</div>\n";
				content = content + "<!-- /lightbox-panel -->\n";
				content = content + "<div id=\"photo_wrap22\" class=\"lightbox\"></div>\n";
				content = content + "<!-- /lightbox -->\n";
				content = content + "</div>\n";
				content = content + "</div>\n";
				content = content + "<br />\n";
				
			}
		}
		
		
		return content;
	}

	public String generatePage3_Chn(String catPK, String seriesPK, String title, String subpage) {
		// TODO Auto-generated method stub
		String theme[] = {"瓷", "馬賽克", "手工製作的瓷磚", "地板采暖", "其他"};
		
		String content = "<div class=\"collection-submenu\">\n";
		content = content + theme[0];
		for(int i = 1 ; i < theme.length ; i++) {
			content = content + " / ";
			content = content + theme[i];
		}
		content = content + "</div>\n";
		
		content = content + "<div class=\"collection-subtitle\">瓷</div>\n";

		
		for(int i = 0 ; i < 2 ; i++) {
			content = content + "<div class=\"collection-susubbtitle\">Colortone " + (i+1) + "</div>\n";
			content = content + "<div class=\"sp-frame\">\n";
			for(int j = 0 ; j < 1 ; j++) {
				content = content + "<div class=\"sp-inside-1\">\n";
				content = content + "<div class=\"sp-inside-2\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo22','#photo_wrap22')\"><img src=\"../content/storage/collection/2/collection-06.jpg\" width=\"71\" height=\"71\" /></a></div>\n";
				content = content + "<div class=\"sp-inside-caption\">ct0001</div>\n";
				content = content + "<div id=\"photo22\" class=\"lightbox-panel\">\n";
				content = content + "<div class=\"lightbox_left\"><img src=\"../content/storage/collection/2/application-commercial-right-photo-large.jpg\" width=\"275\" height=\"275\" /></div>\n";
				content = content + "<div class=\"lightbox_right\">\n";
				content = content + "<h2>ct0001</h2>\n";
				content = content + "<table>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Ref number</strong></td>\n";
				content = content + "<td>xxxxxx</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Series</strong></td>\n";
				content = content + "<td>Portugal Series</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Available Sizes</strong></td>\n";
				content = content + "<td>100mm x 100mm</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Tile Thickness</strong></td>\n";
				content = content + "<td>10mm</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Colour</strong></td>\n";
				content = content + "<td>White/ Black</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Finishing</strong></td>\n";
				content = content + "<td>Matt surface</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Application</strong></td>\n";
				content = content + "<td>Floor / Wall</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Remarks</strong></td>\n";
				content = content + "<td>Conform to International Standard\n";
				content = content + "<ul>\n";
				content = content + "<li>Slip resistance</li>\n";
				content = content + "<li>Water absorption</li>\n";
				content = content + "<li>Breaking strength</li>\n";
				content = content + "</ul>\n";
				content = content + "</td>\n";
				content = content + "</tr>\n";
				content = content + "</table>\n";
				content = content + "</div>\n";
				content = content + "<div class=\"clearfix\"><a href=\"#nogo\" onclick=\"lb_effect_close('#photo22','#photo_wrap22')\"><img src=\"images/close.png\" /></a></div>\n";
				content = content + "</div>\n";
				content = content + "<!-- /lightbox-panel -->\n";
				content = content + "<div id=\"photo_wrap22\" class=\"lightbox\"></div>\n";
				content = content + "<!-- /lightbox -->\n";
				content = content + "</div>\n";
				content = content + "</div>\n";
				content = content + "<br />\n";
				
			}
		}
		
		
		return content;

	}

}
