package com.jpower.content.business;

public class TileArtPhotoFramePage implements PhotoFramePage {

	public String generatePage1() {
		// TODO Auto-generated method stub
		
		String name[] = {"Bathroom", "Fayer", "Fireplace", "Kitchen", "Miscellaneous"};
		String content = "<div class=\"app-tileart-frame\">\n";
		
		content = content + "<div class=\"big-photo-frame2\">\n";
		content = content +  "<div class=\"big-photo-frame-inside-2\"><img src=\"content/storage/tile_art/1/application-tileart-1.png\" width=\"365\" height=\"365\" name=\"showImage\" id=\"showImage\" /><br />\n";
		content = content + "<img src=\"content/storage/tile_art/1/application-tileart-bigphoto_title.jpg\" width=\"365\" /></div>\n";
		content = content + "</div>\n";
		
		content = content + "<div class=\"big-photo-right-frame2\">\n";
		for(int i = 0 ; i < name.length ; i++) {
			content = content + "<div class=\"photo-inside-1-tile\">\n";
			content = content + "<div class=\"photo-inside-2-tile\"><img src=\"content/storage/tile_art/1/application-tileart-" + (i+1) + ".png\" width=\"160\" height=\"160\" onMouseOver=\"$('#showImage').attr('src','content/storage/tile_art/1/application-tileart-" + (i+1) + ".png');\" /></div>\n";
			//content = content + "<div class=\"photo-inside-caption-tile\">" + name[i] + "</div>\n";
			content = content + "</div>\n";
		}
		content = content + "</div>\n";
		
		content = content + "</div></div>\n";
		
		
		return content;
		
		
	}

	public String generatePage1_Chn() {
		// TODO Auto-generated method stub
		String name[] = {"浴室", "富爾", "壁爐", "廚房", "雜項"};
		String content = "<div class=\"app-tileart-frame\">\n";
		
		content = content + "<div class=\"big-photo-frame2\">\n";
		content = content +  "<div class=\"big-photo-frame-inside-2\"><img src=\"../content/storage/tile_art/1/application-tileart-1.png\" width=\"365\" height=\"365\" name=\"showImage\" id=\"showImage\" /><br />\n";
		content = content + "<img src=\"../content/storage/tile_art/1/application-tileart-bigphoto_title.jpg\" width=\"365\" /></div>\n";
		content = content + "</div>\n";
		
		content = content + "<div class=\"big-photo-right-frame2\">\n";
		for(int i = 0 ; i < name.length ; i++) {
			content = content + "<div class=\"photo-inside-1-tile\">\n";
			content = content + "<div class=\"photo-inside-2-tile\"><img src=\"../content/storage/tile_art/1/application-tileart-" + (i+1) + ".png\" width=\"160\" height=\"160\" onMouseOver=\"$('#showImage').attr('src','../content/storage/tile_art/1/application-tileart-" + (i+1) + ".png');\" /></div>\n";
			//content = content + "<div class=\"photo-inside-caption-tile\">" + name[i] + "</div>\n";
			content = content + "</div>\n";
		}
		content = content + "</div>\n";
		content = content + "</div></div>\n";
		
		
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
