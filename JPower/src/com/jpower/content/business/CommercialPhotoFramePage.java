package com.jpower.content.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.jpower.cms.upload.common.DBAccess;
import com.jpower.content.model.ScreenPage1DTO;
import com.jpower.content.model.ScreenPage2DTO;
import com.jpower.content.model.ScreenPage3DTO;
import com.jpower.content.model.Stock;

public class CommercialPhotoFramePage implements PhotoFramePage {

	public String generatePage1() {
		// TODO Auto-generated method stub
		String[] title = {"Retail Shop", "Office Building", "Swimming Pool", "Miscellaneous"};
		String content = "<div class=\"photo-frame-com\">";
		
		List<ScreenPage1DTO> rsList = getPage1Info();
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage1DTO dto = (ScreenPage1DTO)rsList.get(i);
			content = content + "<div class=\"photo-inside-1-com\">\n";
			content = content + "<div class=\"photo-inside-2-com\"><a href=\"index.jsp?page=commercial_2#" + (i+1) + "\">";
			content = content + "<img src=\"content/storage/commercial/1/" + dto.getCatImage() + "\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content + "<div class=\"photo-inside-caption-com\">" + dto.getCatLabelEng() + "</div>\n";
			content = content + "</div>\n";			
		}
		
		content = content + "</div>";
		
		return content;
	}

	public String generatePage1_Chn() {
		// TODO Auto-generated method stub
		String[] title = {"Retail Shop", "Office Building", "Swimming Pool", "Miscellaneous"};
		String content = "<div class=\"photo-frame-com\">";
		
		List<ScreenPage1DTO> rsList = getPage1Info();
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage1DTO dto = (ScreenPage1DTO)rsList.get(i);
			content = content + "<div class=\"photo-inside-1-com\">\n";
			content = content + "<div class=\"photo-inside-2-com\"><a href=\"index.jsp?page=commercial_2#" + (i+1) + "\">";
			content = content + "<img src=\"../content/storage/commercial/1/" + dto.getCatImage() + "\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content + "<div class=\"photo-inside-caption-com\">" + dto.getCatLabelChn() + "</div>\n";
			content = content + "</div>\n";			
		}
		
		content = content + "</div>";
		
		return content;
	}

	public String generatePage2() {
		// TODO Auto-generated method stub
		String[] title = {"Retail Shop", "Office Building", "Swimming Pool", "Miscellaneous"};
		String content = "<div class=\"collection-submenu\">";
		
		List<ScreenPage2DTO> rsList = getPage2Info();
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage2DTO dto = rsList.get(i);
			content = content + "<a href=\"#" + (i+1) + "\">" + dto.getCatLabelEng() + "</a>";
			if(i != rsList.size() - 1) {
				content = content + " / ";
			}
		}
		
		content = content + "</div>\n";
		for(int j = 0 ; j < rsList.size() ; j++) {
			ScreenPage2DTO dto = rsList.get(j);
			content = content + "<div class=\"app-commer-subsub\"><a id=\"" + (j+1) + "\"></a>" + dto.getCatLabelEng() + "</div>\n";
			content = content + "<div class=\"ap-photo-frame\">\n";
			List<String> imageList = dto.getImageList();
			List<Integer> seriesPKs = dto.getSeriesPKs();
			for(int i = 0 ; i < imageList.size() ; i++) {
				content = content + "<div class=\"ap-photo-inside-1\">\n";
				content = content + "<div class=\"ap-photo-inside-2-com\"><a href=\"index.jsp?page=commercial_3&cat=" + dto.getCatPK() + "&series=" + seriesPKs.get(i) + "&title=" + (i+1) + "\">";
				content = content + "<img src=\"content/storage/commercial/2/" + imageList.get(i) + "\" width=\"229\" height=\"168\" /></a></div>\n";
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
		
		List<ScreenPage2DTO> rsList = getPage2Info();
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage2DTO dto = rsList.get(i);
			content = content + "<a href=\"#" + (i+1) + "\">" + dto.getCatLabelChn() + "</a>";
			if(i != rsList.size() - 1) {
				content = content + " / ";
			}
		}
		
		content = content + "</div>\n";
		for(int j = 0 ; j < rsList.size() ; j++) {
			ScreenPage2DTO dto = rsList.get(j);
			content = content + "<div class=\"app-commer-subsub\"><a id=\"" + (j+1) + "\"></a>" + dto.getCatLabelChn() + "</div>\n";
			content = content + "<div class=\"ap-photo-frame\">\n";
			List<String> imageList = dto.getImageList();
			List<Integer> seriesPKs = dto.getSeriesPKs();
			for(int i = 0 ; i < imageList.size() ; i++) {
				content = content + "<div class=\"ap-photo-inside-1\">\n";
				content = content + "<div class=\"ap-photo-inside-2-com\"><a href=\"index.jsp?page=commercial_3&cat=" + dto.getCatPK() + "&series=" + seriesPKs.get(i) + "&title=" + (i+1) + "\">";				
				content = content + "<img src=\"../content/storage/commercial/2/" + imageList.get(i) + "\" width=\"229\" height=\"168\" /></a></div>\n";
				content = content + "<div class=\"ap-photo-inside-caption\">樣本" + " " + (i + 1) + "</div>\n";
				content = content + "</div>\n";
			}
			
			content = content + "</div>\n";
		}		
		return content;		

	}

	public String generatePage3(String catPK, String seriesPK, String title) {
		// TODO Auto-generated method stub
		List stocks = getStocks();
		
		List<ScreenPage3DTO> dtos = this.generatePage3Info(seriesPK);
		ScreenPage3DTO dto = dtos.get(0);
		
		String content = "<div class=\"collection-submenu\"><a href=\"index.jsp?page=commercial\">Commercial</a>  &gt;  <a href=\"index.jsp?page=commercial_2#" + dto.getLobCatSeq() + "\">" + dto.getCatLabelEng() + "</a> &gt;  Sample " + title + "</div>\n";		
		content = content + "<div class=\"app-commercial-frame2\">\n";
		content = content + "<div class=\"big-photo-frame\">\n";
		content = content + "<div class=\"big-photo-frame-inside-1\"><img src=\"content/storage/commercial/3/" + dto.getSeriesImageLarge() + "\" width=\"495\" height=\"375\" /></div>\n";
		content = content + "</div>\n";
		content = content + "<div class=\"big-photo-right-frame\">\n";
		
		//Develop code here.
		for(int i = 0 ; i < dtos.size() ; i++) {
			ScreenPage3DTO dtoEntry = dtos.get(i);
			
			content = content + "<div class=\"rightoutsideframe-com\">\n";
			content = content + "<div class=\"sp-photo-left-com\">\n";
			content = content + "<div class=\"sp-photo-left-inside-com\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo" + (i + 1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"";
			content = content + "content/storage/commercial/3/" + dtoEntry.getSubSeriesImageSmall() + "\" width=\"130\" height=\"130\" /></a></div>\n";
			content = content + "</div>\n";
			content = content + "<div class=\"sp-photo-right-com\">\n";
			content = content + "<div class=\"caption-app-1-com\"><span class=\"captionfont-1-com\">" + "Material " + (i+1) + "</span><br />";
			content = content + "<span class=\"captionfont-2\">" + dtoEntry.getSubSeriesID() + "</span><br />";
			content = content + "<span class=\"captionfont-3\">" + "" + "<br />";
			content = content + "</span> <br />\n";
			content = content + "</div>\n";
			content = content + "<div class=\"caption-app-2-com\"><img src=\"images/series-bt.jpg\" width=\"75\" height=\"19\" id=\"Image9\" onmouseover=\"MM_swapImage('Image9','','images/series-bt-over.jpg',1)\" onmouseout=\"MM_swapImgRestore()\" /></div>\n";
			content = content + "</div>\n";
			content = content + "<div id=\"photo" + (i+1) + "\" class=\"lightbox-panel\">\n";
			content = content + "<div class=\"lightbox_left\"><img src=\"";
			content = content + "content/storage/commercial/3/" + dtoEntry.getSubSeriesImageLarge() + "\" width=\"275\" height=\"275\" /></div>\n";
			content = content + "<div class=\"lightbox_right\">\n";
			content = content + "<h2>" + "Material " + (i+1) + "</h2>\n";
			content = content + "<table>\n";
			content = content + "<tr><td><strong>Ref number</strong></td><td>" + dtoEntry.getSubSeriesID() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Series</strong></td><td>" + dtoEntry.getSeries() + "</td></tr>\n";
			content = content + "<tr><td><strong>Available Sizes</strong></td><td>" + dtoEntry.getAvailableSize() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Tile Thickness</strong></td><td>" + dtoEntry.getTileThickness() + "</td></tr>";
			content = content + "<tr><td><strong>Colour</strong></td><td>" + dtoEntry.getColor() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Finishing</strong></td><td>" + dtoEntry.getFinishing() + "</td></tr>\n";
			content = content + "<tr><td><strong>Application</strong></td><td>" + dtoEntry.getApplication() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Remarks</strong></td><td>" + dtoEntry.getRemarks_1() + "</td></tr>\n";
			content = content + "</table>\n</div>\n";
			content = content + "<div class=\"clearfix\"><a href=\"#nogo\" onclick=\"lb_effect_close('#photo" + (i+1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"images/close.png\" /></a></div></div>\n";
			content = content + "<!-- /lightbox-panel -->\n<div id=\"photo_wrap" + (i+1) + "\" class=\"lightbox\"></div>\n<!-- /lightbox -->\n</div>";
		}
		
		//content = content + "</div>\n";
		//content = content + //navigator;  
		content = content + "<br/>\n";
		content = content + "</div></div>";
		
		
		return content;

	}

	public String generatePage3_Chn(String catPK, String seriesPK, String title) {
		// TODO Auto-generated method stub
		List stocks = getStocks();
		
		List<ScreenPage3DTO> dtos = this.generatePage3Info(seriesPK);
		ScreenPage3DTO dto = dtos.get(0);
		
		String commercial = "商業";
		String content = "<div class=\"collection-submenu\"><a href=\"index.jsp?page=commercial\">" + commercial + "</a> &gt; <a href=\"index.jsp?page=commercial_2#" + dto.getLobCatSeq() + "\">" + dto.getCatLabelChn() + "</a> &gt; 樣本 " + title + "</div>\n";				
		content = content + "<div class=\"app-commercial-frame2\">\n";
		content = content + "<div class=\"big-photo-frame\">\n";
		content = content + "<div class=\"big-photo-frame-inside-1\"><img src=\"../content/storage/commercial/3/" + dto.getSeriesImageLarge() + "\" width=\"495\" height=\"375\" /></div>\n";
		content = content + "</div>\n";
		content = content + "<div class=\"big-photo-right-frame\">\n";
		
		//Develop code here.
		for(int i = 0 ; i < dtos.size() ; i++) {
			ScreenPage3DTO dtoEntry = dtos.get(i);
			
			content = content + "<div class=\"rightoutsideframe-com\">\n";
			content = content + "<div class=\"sp-photo-left-com\">\n";
			content = content + "<div class=\"sp-photo-left-inside-com\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo" + (i + 1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"";
			content = content + "../content/storage/commercial/3/" + dtoEntry.getSubSeriesImageSmall() + "\" width=\"130\" height=\"130\" /></a></div>\n";
			content = content + "</div>\n";
			content = content + "<div class=\"sp-photo-right-com\">\n";
			content = content + "<div class=\"caption-app-1-com\"><span class=\"captionfont-1-com\">" + "物品 " + (i+1) + "</span><br />";
			content = content + "<span class=\"captionfont-2\">" + dtoEntry.getSubSeriesID() + "</span><br />";
			content = content + "<span class=\"captionfont-3\">" + "" + "<br />";
			content = content + "</span> <br />\n";
			content = content + "</div>\n";
			content = content + "<div class=\"caption-app-2-com\"><img src=\"../images/series-bt.jpg\" width=\"75\" height=\"19\" id=\"Image9\" onmouseover=\"MM_swapImage('Image9','','../images/series-bt-over.jpg',1)\" onmouseout=\"MM_swapImgRestore()\" /></div>\n";
			content = content + "</div>\n";
			content = content + "<div id=\"photo" + (i+1) + "\" class=\"lightbox-panel\">\n";
			content = content + "<div class=\"lightbox_left\"><img src=\"";
			content = content + "../content/storage/commercial/3/" + dtoEntry.getSubSeriesImageLarge() + "\" width=\"275\" height=\"275\" /></div>\n";
			content = content + "<div class=\"lightbox_right\">\n";
			content = content + "<h2>" + "物品 " + (i+1) + "</h2>\n";
			content = content + "<table>\n";
			content = content + "<tr><td><strong>Ref number</strong></td><td>" + dtoEntry.getSubSeriesID() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Series</strong></td><td>" + dtoEntry.getSeries() + "</td></tr>\n";
			content = content + "<tr><td><strong>Available Sizes</strong></td><td>" + dtoEntry.getAvailableSize() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Tile Thickness</strong></td><td>" + dtoEntry.getTileThickness() + "</td></tr>";
			content = content + "<tr><td><strong>Colour</strong></td><td>" + dtoEntry.getColor() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Finishing</strong></td><td>" + dtoEntry.getFinishing() + "</td></tr>\n";
			content = content + "<tr><td><strong>Application</strong></td><td>" + dtoEntry.getApplication() + "</td></tr>\n";
			content = content + "<tr class=\"spec_bg\"><td><strong>Remarks</strong></td><td>" + dtoEntry.getRemarks_1() + "</td></tr>\n";
			content = content + "</table>\n</div>\n";
			content = content + "<div class=\"clearfix\"><a href=\"#nogo\" onclick=\"lb_effect_close('#photo" + (i+1) + "','#photo_wrap" + (i+1) + "')\"><img src=\"../images/close.png\" /></a></div></div>\n";
			content = content + "<!-- /lightbox-panel -->\n<div id=\"photo_wrap" + (i+1) + "\" class=\"lightbox\"></div>\n<!-- /lightbox -->\n</div>";
		}
		
		//content = content + "</div>\n";
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
	
	private List<ScreenPage1DTO> getPage1Info() {
		Statement stmt = null;
		String query = "select jc.category_label_eng, jc.category_label_chin, " + 
						"jc.category_image, JRLC.lob_category_seq from JPT_LOB jl, " + 
						"JPT_RLT_LOB_CATEGORY JRLC, " + 
						"JPT_CATEGORY jc where sub_lob_id='Commercial' " + 
						"and jl.lob_PK=JRLC.lob_pk and JRLC.category_pk=jc.category_pk" +
						" order by JRLC.lob_category_seq";
		
		List<ScreenPage1DTO> rsList = new ArrayList<ScreenPage1DTO>();
		
		
		try {
			Connection conn = DBAccess.getDBConnection();
			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				ScreenPage1DTO dto = new ScreenPage1DTO();
				dto.setCatLabelEng(result.getString(1));
				dto.setCatLabelChn(result.getString(2));
				dto.setCatImage(result.getString(3));
				rsList.add(dto);
			}			
			result.close();
			stmt.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rsList;	
	}
	
	@SuppressWarnings("unchecked")
	private List<ScreenPage2DTO> getPage2Info() {
		Statement stmt = null;
		String query = "select jc.category_label_eng, jc.category_label_chin, " + 
						"jc.category_pk, js.series_image_small, JRLC.lob_category_seq, js.series_pk from JPT_LOB jl, " + 
						"JPT_RLT_LOB_CATEGORY JRLC, JPT_CATEGORY jc, jpt_rlt_category_series jrcs, " + 
						"jpt_series js where sub_lob_id='Commercial' and jl.lob_PK=JRLC.lob_pk " + 
						"and JRLC.category_pk=jc.category_pk and jc.rec_status='ACT' and " + 
						"jrcs.category_pk=jc.category_pk and jrcs.rec_status='ACT' and " + 
						"jrcs.series_pk=js.series_pk and js.rec_status='ACT' order by JRLC.lob_category_seq";
		
		List<ScreenPage2DTO> dtos = new ArrayList<ScreenPage2DTO>();
		Map<Integer, ScreenPage2DTO> catMap = new HashMap<Integer, ScreenPage2DTO>();
		
		try {
			Connection conn = DBAccess.getDBConnection();
			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				int iCatPK = result.getInt(3);
				ScreenPage2DTO dto = catMap.get(Integer.valueOf(iCatPK));
				if(dto == null) {
					dto = new ScreenPage2DTO();
					dto.setCatLabelEng(result.getString(1));
					dto.setCatLabelChn(result.getString(2));
					dto.setCatPK(iCatPK);
					List<String> imageList = new ArrayList<String>();
					List<Integer> seriesPKs = new ArrayList<Integer>();
					imageList.add(result.getString(4));
					dto.setImageList(imageList);
					dto.setLogCategorySeq(result.getInt(5));
					seriesPKs.add(result.getInt(6));
					dto.setSeriesPKs(seriesPKs);
				} else {
					dto.getImageList().add(result.getString(4));
					dto.getSeriesPKs().add(result.getInt(6));
				}
				catMap.put(Integer.valueOf(iCatPK), dto);
			}
			
			
			result.close();
			stmt.close();
			conn.close();
			
			Set<Integer> keySet = catMap.keySet();
			Iterator<Integer> iterator = keySet.iterator();
			ScreenPage2DTO[] dtoArray = new ScreenPage2DTO[keySet.size()];		
			while(iterator.hasNext()) {
				Integer categoryPK = (Integer)iterator.next();
				ScreenPage2DTO dto = catMap.get(categoryPK);
				dtoArray[dto.getLogCategorySeq() - 1] = dto;
			}	
			
			for(int i = 0 ; i < dtoArray.length ; i++) {
				dtos.add(dtoArray[i]);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dtos;
		
	}
	
	private List<ScreenPage3DTO> generatePage3Info(String seriesPK) {
		
		PreparedStatement ps = null;
		
		
		String query = "select jrsss.series_sub_series_seq, jss.sub_series_image_small, " + 
						"jss.sub_series_image_large, js.series_image_large, jad.sub_series_id, " + 
						"jad.series, jad.avaliable_size, jad.tile_thickness, jad.color, " + 
						"jad.finishing, jad.application, jad.remarks_1, jc.category_label_eng, " +
						"jc.category_label_chin, jrlc.lob_category_seq from jpt_rlt_series_sub_series jrsss, " + 
						"jpt_sub_series jss, jpt_series js, jpw_application_detail jad, " + 
						"jpt_rlt_category_series jrcs, jpt_category jc, " + 
						"jpt_rlt_lob_category jrlc where jrsss.series_pk=? and jrsss.rec_status='ACT' " + 
						"and jrsss.sub_series_pk=jss.sub_series_pk and js.series_pk=jrsss.series_pk " + 
						"and js.rec_status=jrsss.rec_status and jrsss.rec_status=jss.rec_status " + 
						"and jss.sub_series_id=jad.sub_series_id and jrcs.series_pk=jrsss.series_pk " + 
						"and jrcs.category_pk=jc.category_pk and " + 
						"jc.category_pk=jrlc.category_pk order by jrsss.series_sub_series_seq";
		
		List<ScreenPage3DTO> dtos = new ArrayList<ScreenPage3DTO>();
		try {
			Connection conn = DBAccess.getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(seriesPK));
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				ScreenPage3DTO dto = new ScreenPage3DTO();
				dto.setSeriesSubSeriesSeq(result.getInt(1));
				dto.setSubSeriesImageSmall(result.getString(2));
				dto.setSubSeriesImageLarge(result.getString(3));
				dto.setSeriesImageLarge(result.getString(4));
				dto.setSubSeriesID(result.getString(5));
				dto.setSeries(result.getString(6));
				dto.setAvailableSize(result.getString(7));
				dto.setTileThickness(result.getString(8));
				dto.setColor(result.getString(9));
				dto.setFinishing(result.getString(10));
				dto.setApplication(result.getString(11));
				dto.setRemarks_1(result.getString(12));
				dto.setCatLabelEng(result.getString(13));
				dto.setCatLabelChn(result.getString(14));
				dto.setLobCatSeq(result.getInt(15));

				
				dtos.add(dto);
			}
			result.close();
			ps.close();
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dtos;
		
	}
	

	

}
