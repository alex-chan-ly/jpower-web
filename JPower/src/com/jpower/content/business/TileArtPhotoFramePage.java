package com.jpower.content.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.jpower.cms.upload.common.DBAccess;
import com.jpower.content.model.ScreenPage3DTO;

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
		List<ScreenPage3DTO> dtos = this.generatePage3Info();
		System.out.println("dtos.size=" + dtos.size());
		
		
		int iStartIndex = (Integer.parseInt(subpage) - 1) * 6;
		int iEndIndex = iStartIndex + 6;
		if(dtos.size() <= iEndIndex - 1) {
			iEndIndex = dtos.size();
		}
		
		int iNumFullPage = dtos.size() / 6;
		if((dtos.size() % 6) > 0) {
			iNumFullPage = iNumFullPage + 1;
		}
		
		
		String content = "<div class=\"app-tileart-frame\">\n";
		
		content = content + "<div class=\"big-photo-frame2\">\n";
		content = content +  "<div class=\"big-photo-frame-inside-2\"><img src=\"content/storage/tile_art/3/" + dtos.get(iStartIndex).getSeriesImageLarge() + "\" width=\"365\" height=\"365\" name=\"showImage\" id=\"showImage\" /><br />\n";
		content = content + "<img src=\"content/storage/tile_art/1/application-tileart-bigphoto_title.jpg\" width=\"365\" /></div>\n";
		content = content + "</div>\n";
		
		content = content + "<div class=\"big-photo-right-frame2\">\n";
		for(int i = iStartIndex ; i < iEndIndex ; i++) {
			content = content + "<div class=\"photo-inside-1-tile\">\n";
			content = content + "<div class=\"photo-inside-2-tile\"><img src=\"content/storage/tile_art/3/" + dtos.get(i).getSubSeriesImageSmall() + "\" width=\"160\" height=\"160\" onMouseOver=\"$('#showImage').attr('src','content/storage/tile_art/3/" + dtos.get(i).getSubSeriesImageSmall() + "');\" /></div>\n";
			//content = content + "<div class=\"photo-inside-caption-tile\">" + name[i] + "</div>\n";
			content = content + "</div>\n";
		}
		
		if(iNumFullPage > 1) {
			if(subpage.equals("1"))
				content = content + "<div class=\"page-select\"><strong>1</strong>  <a href=\"index.jsp?page=tile_art&subpage=2" + "\">2</a>   <a href=\"index.jsp?page=tile_art&subpage=2" + "\">Next</a></div>";
			else if(Integer.parseInt(subpage) == iNumFullPage)
				content = content + "<div class=\"page-select\"><a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) - 1) + "\">Previous</a>  <a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) - 1) + "\">"+ (Integer.parseInt(subpage) - 1) + "</a>  <strong>" + subpage + "</strong></div>";					
			else 
				content = content + "<div class=\"page-select\"><a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) - 1) + "\">Previous</a>  <a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) - 1) + "\">" + (Integer.parseInt(subpage) - 1) + "</a>  <strong>" + subpage + "</strong>  <a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) + 1) + "\">" + (Integer.parseInt(subpage) + 1) + "</a>  <a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) + 1) + "\">Next</a></div>";
		}
		
		content = content + "</div>\n";
		content = content + "</div></div>\n";
		
		
		
		return content;
	}

	public String generatePage3_Chn(String catPK, String seriesPK, String title, String subpage) {
		// TODO Auto-generated method stub
		List<ScreenPage3DTO> dtos = this.generatePage3Info();
		//System.out.println("dtos.size=" + dtos.size());
		
		
		int iStartIndex = (Integer.parseInt(subpage) - 1) * 6;
		int iEndIndex = iStartIndex + 6;
		if(dtos.size() <= iEndIndex - 1) {
			iEndIndex = dtos.size();
		}
		
		int iNumFullPage = dtos.size() / 6;
		if((dtos.size() % 6) > 0) {
			iNumFullPage = iNumFullPage + 1;
		}
		
		
		String content = "<div class=\"app-tileart-frame\">\n";
		
		content = content + "<div class=\"big-photo-frame2\">\n";
		content = content +  "<div class=\"big-photo-frame-inside-2\"><img src=\"../content/storage/tile_art/3/" + dtos.get(iStartIndex).getSeriesImageLarge() + "\" width=\"365\" height=\"365\" name=\"showImage\" id=\"showImage\" /><br />\n";
		content = content + "<img src=\"../content/storage/tile_art/1/application-tileart-bigphoto_title.jpg\" width=\"365\" /></div>\n";
		content = content + "</div>\n";
		
		content = content + "<div class=\"big-photo-right-frame2\">\n";
		for(int i = iStartIndex ; i < iEndIndex ; i++) {
			content = content + "<div class=\"photo-inside-1-tile\">\n";
			content = content + "<div class=\"photo-inside-2-tile\"><img src=\"../content/storage/tile_art/3/" + dtos.get(i).getSubSeriesImageSmall() + "\" width=\"160\" height=\"160\" onMouseOver=\"$('#showImage').attr('src','../content/storage/tile_art/3/" + dtos.get(i).getSubSeriesImageSmall() + "');\" /></div>\n";
			//content = content + "<div class=\"photo-inside-caption-tile\">" + name[i] + "</div>\n";
			content = content + "</div>\n";
		}
		
		if(iNumFullPage > 1) {
			if(subpage.equals("1"))
				content = content + "<div class=\"page-select\"><strong>1</strong>  <a href=\"index.jsp?page=tile_art&subpage=2" + "\">2</a>   <a href=\"index.jsp?page=tile_art&subpage=2" + "\">Next</a></div>";
			else if(Integer.parseInt(subpage) == iNumFullPage)
				content = content + "<div class=\"page-select\"><a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) - 1) + "\">Previous</a>  <a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) - 1) + "\">"+ (Integer.parseInt(subpage) - 1) + "</a>  <strong>" + subpage + "</strong></div>";					
			else 
				content = content + "<div class=\"page-select\"><a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) - 1) + "\">Previous</a>  <a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) - 1) + "\">" + (Integer.parseInt(subpage) - 1) + "</a>  <strong>" + subpage + "</strong>  <a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) + 1) + "\">" + (Integer.parseInt(subpage) + 1) + "</a>  <a href=\"index.jsp?page=tile_art&subpage=" + (Integer.parseInt(subpage) + 1) + "\">Next</a></div>";
		}
		
		content = content + "</div>\n";
		content = content + "</div></div>\n";
		
		
		
		return content;

	}
	
	private List<ScreenPage3DTO> generatePage3Info() {
		
		PreparedStatement ps = null;
		
		String query = "select  jss.sub_series_image_small, jss.sub_series_image_large " +
						"from jpt_sub_series jss, jpt_rlt_series_sub_series jrsss, " + 
						"jpt_series js where jss.sub_series_pk=jrsss.sub_series_pk " + 
						"and jrsss.series_pk=js.series_pk and js.series_id='TILE-ART'";
		
		List<ScreenPage3DTO> dtos = new ArrayList<ScreenPage3DTO>();
		try {
			Connection conn = DBAccess.getDBConnection();
			ResultSet result = conn.createStatement().executeQuery(query);
			while(result.next()) {
				ScreenPage3DTO dto = new ScreenPage3DTO();
				dto.setSubSeriesImageSmall(result.getString(1));
				dto.setSeriesImageLarge(result.getString(2));
				
				dtos.add(dto);
			}
			result.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return dtos;
	}

}
