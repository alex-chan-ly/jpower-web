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
import java.util.logging.Logger;

import com.jpower.cms.upload.common.DBAccess;
import com.jpower.content.model.ScreenPage1DTO;
import com.jpower.content.model.ScreenPage2DTO;
import com.jpower.content.model.ScreenPage3DTO;

public class CollectionPhotoFramePage implements PhotoFramePage {

	Logger log = Logger.getLogger(this.getClass().getName());
	
	public String generatePage1() {
		// TODO Auto-generated method stub
		String item[] = {"Procelain"};
		String pics[] = {"MSA02.jpg"};
		
		String content = "";
		
		List<ScreenPage2DTO> rsList = getPage1Info();
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage2DTO dto = (ScreenPage2DTO)rsList.get(i);
			content = content + "<div class=\"photo-inside-1\">\n";
			content = content + "<div class=\"photo-inside-2\"><a href=\"index.jsp?page=collection_2&cat=" + dto.getCatPK() + "\"><img src=\"content/storage/collection/1/" + dto.getCatImage() + "\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content +  "<div class=\"photo-inside-caption\">" + dto.getCatLabelEng() + "</div>\n";
			content = content + "</div>\n";
		}
		
		return content;
	}

	public String generatePage1_Chn() {
		// TODO Auto-generated method stub
		String item[] = {"瓷", "馬賽克", "手工製作的瓷磚", "地板采暖", "其他"};
		
		String content = "";
		
		List<ScreenPage2DTO> rsList = getPage1Info();
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage2DTO dto = (ScreenPage2DTO)rsList.get(i);
			content = content + "<div class=\"photo-inside-1\">\n";
			content = content + "<div class=\"photo-inside-2\"><a href=\"index.jsp?page=collection_2&cat=" + dto.getCatPK() + "\"><img src=\"../content/storage/collection/1/" + dto.getCatImage() + "\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content +  "<div class=\"photo-inside-caption\">" + dto.getCatLabelChn() + "</div>\n";
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
		String pics[] = {"MSA02.jpg", "MSA03.jpg", "MSA02DK1.jpg", "MSA02DM5.jpg", "MSA02DM6.jpg",
						"MSA02DM7.jpg", "MSA02DM8.jpg", "MSA02DM9.jpg", "MSA02DM10.jpg", "MSA02DM11.jpg",
						"MSA02DM12.jpg", "MSA02DM13.jpg", "MSA02DM14.jpg", "MSA02DM15.jpg", "MSA02DM16.jpg"};
		
		List<ScreenPage2DTO> rsList = getPage1Info();
		List<ScreenPage3DTO> dtos = generatePage3Info(catPK);
		
		String content = "<div class=\"collection-submenu\">\n";
		//content = content + theme[0];
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage2DTO dto = rsList.get(i);
			Integer catSeriesPK = dto.getCatPK();
			if(i > 0) {
				content = content + " / ";
			}
			content = content + "<a href=\"index.jsp?page=collection_2&cat=" + catSeriesPK + "\">" + dto.getCatLabelEng() + "</a>";
			
		}
		content = content + "</div>\n";
		if(dtos.size() == 0)
			return content;		//no records
		
		
		ScreenPage3DTO dtoTmp = dtos.get(0);
		content = content + "<div class=\"collection-subtitle\">" + dtoTmp.getCatLabelEng() + "</div>\n";

		Map<String, List<ScreenPage3DTO>> seriesMap = classifySeries(dtos);
		Set<String> keys = seriesMap.keySet();
		//keys..
		Object[] keyArr = keys.toArray();
		
		
		int iPhotoNum = 0;
		for(int i = 0 ; i < keyArr.length ; i++) {
			
			String key = (String)keyArr[i];
			content = content + "<div class=\"collection-susubbtitle\">" + key + " </div>\n";
			content = content + "<div class=\"sp-frame\">\n";
			List<ScreenPage3DTO> dtoMaterials = seriesMap.get(keyArr[i]);
			for(int j = 0 ; j < dtoMaterials.size() ; j++) {
				iPhotoNum++;
				ScreenPage3DTO dto = dtoMaterials.get(j);
				content = content + "<div class=\"sp-inside-1\">\n";
				content = content + "<div class=\"sp-inside-2\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo" + iPhotoNum + "','#photo_wrap" + iPhotoNum + "')\"><img src=\"content/storage/collection/3/" + dto.getSubSeriesImageSmall() + "\" width=\"71\" height=\"71\" /></a></div>\n";
				content = content + "<div class=\"sp-inside-caption\">" + dto.getMaterialID() + "</div>\n";
				content = content + "<div id=\"photo" + iPhotoNum + "\" class=\"lightbox-panel\">\n";
				content = content + "<div class=\"lightbox_left\"><img src=\"content/storage/collection/3/" + dto.getSubSeriesImageLarge() + "\" width=\"275\" height=\"275\" /></div>\n";
				content = content + "<div class=\"lightbox_right\">\n";
				content = content + "<h2>" + dto.getMaterialID() + "</h2>\n";
				content = content + "<table>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Ref number</strong></td>\n";
				content = content + "<td>" + dto.getMaterialID() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Series</strong></td>\n";
				content = content + "<td>" + dto.getSeries() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Available Sizes</strong></td>\n";
				content = content + "<td>" + dto.getAvailableSize() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Tile Thickness</strong></td>\n";
				content = content + "<td>" + dto.getTileThickness() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Colour</strong></td>\n";
				content = content + "<td>" + dto.getColor() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Finishing</strong></td>\n";
				content = content + "<td>" + dto.getFinishing() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Application</strong></td>\n";
				content = content + "<td>" + dto.getApplication() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Remarks</strong></td>\n";
				content = content + "<td>" + dto.getRemarks_1() + "</td>\n";
			/*	content = content + "<td>Conform to International Standard\n";
				content = content + "<ul>\n";
				content = content + "<li>Slip resistance</li>\n";
				content = content + "<li>Water absorption</li>\n";
				content = content + "<li>Breaking strength</li>\n";
				content = content + "</ul>\n";
				content = content + "</td>\n";*/
				
				content = content + "</tr>\n";
				content = content + "</table>\n";
				content = content + "</div>\n";
				content = content + "<div class=\"clearfix\"><a href=\"#nogo\" onclick=\"lb_effect_close('#photo" + iPhotoNum + "','#photo_wrap" + iPhotoNum + "')\"><img src=\"images/close.png\" /></a></div>\n";
				content = content + "</div>\n";
				content = content + "<!-- /lightbox-panel -->\n";
				content = content + "<div id=\"photo_wrap" + iPhotoNum + "\" class=\"lightbox\"></div>\n";
				content = content + "<!-- /lightbox -->\n";
				content = content + "</div>\n";
				//content = content + "</div>\n";
				//content = content + "<br />\n";
				
			}
			content = content + "</div>\n";
		}
		
		//content = content + "</div>\n";
		content = content + "<br />\n";
		return content;
	}

	public String generatePage3_Chn(String catPK, String seriesPK, String title, String subpage) {
		// TODO Auto-generated method stub
		String theme[] = {"瓷", "馬賽克", "手工製作的瓷磚", "地板采暖", "其他"};
		
		List<ScreenPage2DTO> rsList = getPage1Info();
		List<ScreenPage3DTO> dtos = generatePage3Info(catPK);
		
		String content = "<div class=\"collection-submenu\">\n";
		//content = content + theme[0];
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage2DTO dto = rsList.get(i);
			Integer catSeriesPK = dto.getCatPK();
			if(i > 0) {
				content = content + " / ";
			}
			content = content + "<a href=\"index.jsp?page=collection_2&cat=" + catSeriesPK + "\">" + dto.getCatLabelChn() + "</a>";
			
		}
		content = content + "</div>\n";
		if(dtos.size() == 0)
			return content;		//no records
		
		ScreenPage3DTO dtoTmp = dtos.get(0);
		content = content + "<div class=\"collection-subtitle\">" + dtoTmp.getCatLabelChn() + "</div>\n";
		Map<String, List<ScreenPage3DTO>> seriesMap = classifySeries(dtos);
		Set<String> keys = seriesMap.keySet();
		//keys..
		Object[] keyArr = keys.toArray();

		int iPhotoNum = 0;
		for(int i = 0 ; i < keyArr.length ; i++) {
			String key = (String)keyArr[i];
			content = content + "<div class=\"collection-susubbtitle\">" + key + "</div>\n";
			content = content + "<div class=\"sp-frame\">\n";
			List<ScreenPage3DTO> dtoMaterials = seriesMap.get(keyArr[i]);
			for(int j = 0 ; j < dtoMaterials.size() ; j++) {
				iPhotoNum++;
				ScreenPage3DTO dto = dtoMaterials.get(j);
				content = content + "<div class=\"sp-inside-1\">\n";
				content = content + "<div class=\"sp-inside-2\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo" + iPhotoNum + "','#photo_wrap" + iPhotoNum + "')\"><img src=\"../content/storage/collection/3/" + dto.getSubSeriesImageSmall() + "\" width=\"71\" height=\"71\" /></a></div>\n";
				content = content + "<div class=\"sp-inside-caption\">" + dto.getMaterialID() + "</div>\n";
				content = content + "<div id=\"photo" + iPhotoNum + "\" class=\"lightbox-panel\">\n";
				content = content + "<div class=\"lightbox_left\"><img src=\"../content/storage/collection/3/" + dto.getSubSeriesImageLarge() + "\" width=\"275\" height=\"275\" /></div>\n";
				content = content + "<div class=\"lightbox_right\">\n";
				content = content + "<h2>" + dto.getMaterialID() + "</h2>\n";
				content = content + "<table>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Ref number</strong></td>\n";
				content = content + "<td>" + dto.getMaterialID() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Series</strong></td>\n";
				content = content + "<td>" + dto.getSeries() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Available Sizes</strong></td>\n";
				content = content + "<td>" + dto.getAvailableSize() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Tile Thickness</strong></td>\n";
				content = content + "<td>" + dto.getTileThickness() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Colour</strong></td>\n";
				content = content + "<td>" + dto.getColor() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Finishing</strong></td>\n";
				content = content + "<td>" + dto.getFinishing() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr>\n";
				content = content + "<td><strong>Application</strong></td>\n";
				content = content + "<td>" + dto.getApplication() + "</td>\n";
				content = content + "</tr>\n";
				content = content + "<tr class=\"spec_bg\">\n";
				content = content + "<td><strong>Remarks</strong></td>\n";
				content = content + "<td>" + dto.getRemarks_1() + "</td>\n";
			/*	content = content + "<td>Conform to International Standard\n";
				content = content + "<ul>\n";
				content = content + "<li>Slip resistance</li>\n";
				content = content + "<li>Water absorption</li>\n";
				content = content + "<li>Breaking strength</li>\n";
				content = content + "</ul>\n";
				content = content + "</td>\n";*/
				
				content = content + "</tr>\n";
				content = content + "</table>\n";
				content = content + "</div>\n";
				content = content + "<div class=\"clearfix\"><a href=\"#nogo\" onclick=\"lb_effect_close('#photo" + iPhotoNum + "','#photo_wrap" + iPhotoNum + "')\"><img src=\"../images/close.png\" /></a></div>\n";
				content = content + "</div>\n";
				content = content + "<!-- /lightbox-panel -->\n";
				content = content + "<div id=\"photo_wrap" + iPhotoNum + "\" class=\"lightbox\"></div>\n";
				content = content + "<!-- /lightbox -->\n";
				content = content + "</div>\n";
				//content = content + "</div>\n";
				//content = content + "<br />\n";
				
			}
			content = content + "</div>\n";
		}
		
		content = content + "<br />\n";
		return content;

	}
	
	private List<ScreenPage2DTO> getPage1Info() {
		Statement stmt = null;
		String query = "select jc.category_label_eng, jc.category_label_chin, " +
						"jc.category_pk, jc.category_image, JRLC.lob_category_seq " +
						"from JPT_LOB jl, JPT_RLT_LOB_CATEGORY JRLC, JPT_CATEGORY jc where " +
						"sub_lob_id='Collection' and jl.lob_PK=JRLC.lob_pk and " +
						"JRLC.category_pk=jc.category_pk and jc.rec_status='ACT' order by JRLC.lob_category_seq";
		
		List<ScreenPage2DTO> dtos = new ArrayList<ScreenPage2DTO>();
		Map<Integer, ScreenPage2DTO> catMap = new HashMap<Integer, ScreenPage2DTO>();
		//log.info("query=" + query);
		
		
		try {
			Connection conn = DBAccess.getDBConnection();
			stmt = conn.createStatement();
			ResultSet result = stmt.executeQuery(query);
			while(result.next()) {
				ScreenPage2DTO dto = new ScreenPage2DTO();
				dto = new ScreenPage2DTO();
				dto.setCatLabelEng(result.getString(1));
				dto.setCatLabelChn(result.getString(2));
				dto.setCatPK(result.getInt(3));
				dto.setCatImage(result.getString(4));				
				dto.setLobCategorySeq(result.getInt(5));
				
				dtos.add(dto);
			}
			
			
			result.close();
			stmt.close();
			conn.close();
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return dtos;
	}
	
	private List<ScreenPage3DTO> generatePage3Info(String catPK) {
		
		PreparedStatement ps = null;
		
		
		String query = "select jrsss.series_sub_series_seq, jss.sub_series_image_small, " + 
						"jss.sub_series_image_large, js.series_image_large, jm.material_id, " +
						"jm.series, jm.avaliable_size, jm.tile_thickness, jm.color, jm.finishing, " + 
						"jm.application, jm.remarks_1, jc.category_label_eng, jc.category_label_chin, " + 
						"jrlc.lob_category_seq from jpt_rlt_category_series jrcs, jpt_category jc, jpt_series " + 
						"js,jpt_rlt_series_sub_series jrsss, jpt_sub_series jss, jpt_material jm, jpt_rlt_lob_category " + 
						"jrlc where jrcs.category_pk=? and jc.category_pk=jrcs.category_pk and " + 
						"jc.category_pk=jrlc.category_pk and jrcs.series_pk=js.series_pk and " + 
						"jrsss.series_pk=jrcs.series_pk and jrsss.sub_series_pk=jss.sub_series_pk and " + 
						"jss.material_id=jm.material_id";
		
		List<ScreenPage3DTO> dtos = new ArrayList<ScreenPage3DTO>();
		try {
			Connection conn = DBAccess.getDBConnection();
			ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(catPK));
			ResultSet result = ps.executeQuery();
			while(result.next()) {
				ScreenPage3DTO dto = new ScreenPage3DTO();
				dto.setSeriesSubSeriesSeq(result.getInt(1));
				dto.setSubSeriesImageSmall(result.getString(2));
				dto.setSubSeriesImageLarge(result.getString(3));
				dto.setSeriesImageLarge(result.getString(4));
				dto.setMaterialID(result.getString(5));
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
	
	private Map<String, List<ScreenPage3DTO>> classifySeries(List<ScreenPage3DTO> dtos) {
		Map<String, List<ScreenPage3DTO>> seriesMap = new HashMap<String, List<ScreenPage3DTO>>();
		
		for(int i = 0 ; i < dtos.size() ; i++) {
			ScreenPage3DTO srcDto = (ScreenPage3DTO) dtos.get(i);
			
			List<ScreenPage3DTO> tmpDtos = (List<ScreenPage3DTO>) seriesMap.get(srcDto.getSeries());
			if(tmpDtos == null) {
				List<ScreenPage3DTO> destDtos = new ArrayList<ScreenPage3DTO>();
				destDtos.add(srcDto);
				seriesMap.put(srcDto.getSeries(), destDtos);
			} else {
				tmpDtos.add(srcDto);
				seriesMap.put(srcDto.getSeries(), tmpDtos);
			}
		}
		
		
		return seriesMap;
		
	}

	
	private List<ScreenPage3DTO>  generatePage3Info() {
		
		List<ScreenPage3DTO> dtos = new ArrayList<ScreenPage3DTO>();
		ScreenPage3DTO dto1 = new ScreenPage3DTO();
		dto1.setMaterialID("MSA02");dto1.setSeries("Sandstone");dto1.setAvailableSize("300 x300mm; 300 x 600mm; 600 x600mm");
		dto1.setTileThickness("10mm");dto1.setColor("Grey");dto1.setFinishing("Matt");dto1.setApplication("Floor / Wall");dto1.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto1);
		
		ScreenPage3DTO dto2 = new ScreenPage3DTO();
		dto2.setMaterialID("MSA03");dto2.setSeries("Sandstone");dto2.setAvailableSize("300 x300mm; 300 x 600mm; 600 x600mm");
		dto2.setTileThickness("10mm");dto2.setColor("Beige");dto2.setFinishing("Matt");dto2.setApplication("Floor / Wall");dto2.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto2);
		
		ScreenPage3DTO dto3 = new ScreenPage3DTO();
		dto3.setMaterialID("MSA02DK1");dto3.setSeries("Sandstone");dto3.setAvailableSize("300 x 300mm");
		dto3.setTileThickness("10mm");dto3.setColor("Grey");dto3.setFinishing("Matt");dto3.setApplication("Floor / Wall");dto3.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto3);

		ScreenPage3DTO dto4 = new ScreenPage3DTO();
		dto4.setMaterialID("MSA02DM5");dto4.setSeries("Sandstone");dto4.setAvailableSize("300 x 300mm");
		dto4.setTileThickness("10mm");dto4.setColor("Grey");dto4.setFinishing("Matt");dto4.setApplication("Floor / Wall");dto4.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto4);

		ScreenPage3DTO dto5 = new ScreenPage3DTO();
		dto5.setMaterialID("MSA02DM6");dto5.setSeries("Sandstone");dto5.setAvailableSize("300 x 300mm");
		dto5.setTileThickness("10mm");dto5.setColor("Grey");dto5.setFinishing("Matt");dto5.setApplication("Floor / Wall");dto5.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto5);
		
		ScreenPage3DTO dto6 = new ScreenPage3DTO();
		dto6.setMaterialID("MSA02DM7");dto6.setSeries("Sandstone");dto6.setAvailableSize("300 x 300mm");
		dto6.setTileThickness("10mm");dto6.setColor("Grey");dto6.setFinishing("Matt");dto6.setApplication("Floor / Wall");dto6.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto6);
		
		ScreenPage3DTO dto7 = new ScreenPage3DTO();
		dto7.setMaterialID("MSA02DM8");dto7.setSeries("Sandstone");dto7.setAvailableSize("310 x 322mm");
		dto7.setTileThickness("10mm");dto7.setColor("Grey");dto7.setFinishing("Matt");dto7.setApplication("Floor / Wall");dto7.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto7);

		ScreenPage3DTO dto8 = new ScreenPage3DTO();
		dto8.setMaterialID("MSA02DM9");dto8.setSeries("Sandstone");dto8.setAvailableSize("300 x 300mm");
		dto8.setTileThickness("10mm");dto8.setColor("Grey");dto8.setFinishing("Matt");dto8.setApplication("Floor / Wall");dto8.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto8);

		ScreenPage3DTO dto9 = new ScreenPage3DTO();
		dto9.setMaterialID("MSA02DM10");dto9.setSeries("Sandstone");dto9.setAvailableSize("298 x 298mm");
		dto9.setTileThickness("10mm");dto9.setColor("Grey");dto9.setFinishing("Matt");dto9.setApplication("Floor / Wall");dto9.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto9);

		ScreenPage3DTO dto10 = new ScreenPage3DTO();
		dto10.setMaterialID("MSA02DM11");dto10.setSeries("Sandstone");dto10.setAvailableSize("300 x 305mm");
		dto10.setTileThickness("10mm");dto10.setColor("Grey");dto10.setFinishing("Matt");dto10.setApplication("Floor / Wall");dto10.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto10);

		ScreenPage3DTO dto11 = new ScreenPage3DTO();
		dto11.setMaterialID("MSA02DM12");dto11.setSeries("Sandstone");dto11.setAvailableSize("300 x 305mm");
		dto11.setTileThickness("10mm");dto11.setColor("Grey");dto11.setFinishing("Matt");dto11.setApplication("Floor / Wall");dto11.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto11);

		ScreenPage3DTO dto12 = new ScreenPage3DTO();
		dto12.setMaterialID("MSA02DM13");dto12.setSeries("Sandstone");dto12.setAvailableSize("300 x 300mm");
		dto12.setTileThickness("10mm");dto12.setColor("Grey");dto12.setFinishing("Matt");dto12.setApplication("Floor / Wall");dto12.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto12);

		ScreenPage3DTO dto13 = new ScreenPage3DTO();
		dto13.setMaterialID("MSA02DM14");dto13.setSeries("Sandstone");dto13.setAvailableSize("300 x 300mm");
		dto13.setTileThickness("10mm");dto13.setColor("Grey");dto13.setFinishing("Matt");dto13.setApplication("Floor / Wall");dto13.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto13);

		ScreenPage3DTO dto14 = new ScreenPage3DTO();
		dto14.setMaterialID("MSA02DM15");dto14.setSeries("Sandstone");dto14.setAvailableSize("300 x 300mm");
		dto14.setTileThickness("10mm");dto14.setColor("Grey");dto14.setFinishing("Matt");dto14.setApplication("Floor / Wall");dto14.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto14);

		ScreenPage3DTO dto15 = new ScreenPage3DTO();
		dto15.setMaterialID("MSA02DM16");dto15.setSeries("Sandstone");dto15.setAvailableSize("300 x 300mm");
		dto15.setTileThickness("10mm");dto15.setColor("Grey");dto15.setFinishing("Matt");dto15.setApplication("Floor / Wall");dto15.setRemarks_1("Conform to International Standard; Slip Resistance; Water Absorption on Breaking Strength");
		dtos.add(dto15);
		
		return dtos;

	}

}
