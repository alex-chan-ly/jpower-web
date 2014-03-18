package com.jpower.content.business;

public class CollectionPhotoFramePage implements PhotoFramePage {

	public String generatePage1() {
		// TODO Auto-generated method stub
		String item[] = {"Procelain", "Mosaics", "Hand-made Tiles", "Floor Heating", "Other"};
		
		String content = "";
		
		for(int i = 0 ; i < item.length ; i++) {
			content = content + "<div class=\"photo-inside-1\">\n";
			content = content + "<div class=\"photo-inside-2\"><a href=\"collection-2.html\"><img src=\"content/storage/collection/1/collection-sample-pic.jpg\" width=\"160\" height=\"160\" /></a></div>\n";
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
			content = content + "<div class=\"photo-inside-2\"><a href=\"collection-2.html\"><img src=\"../content/storage/collection/1/collection-sample-pic.jpg\" width=\"160\" height=\"160\" /></a></div>\n";
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
		return null;
	}

	public String generatePage3_Chn(String catPK, String seriesPK, String title, String subpage) {
		// TODO Auto-generated method stub
		return null;
	}

}
