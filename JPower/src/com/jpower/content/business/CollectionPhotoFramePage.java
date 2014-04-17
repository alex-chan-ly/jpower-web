package com.jpower.content.business;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.jpower.cms.upload.common.DBAccess;
import com.jpower.content.model.ScreenPage1DTO;
import com.jpower.content.model.ScreenPage3DTO;

public class CollectionPhotoFramePage implements PhotoFramePage {

	public String generatePage1() {
		// TODO Auto-generated method stub
		String item[] = {"Procelain"};
		String pics[] = {"MSA02.jpg"};
		
		String content = "";
		
		List<ScreenPage1DTO> rsList = getPage1Info();
		for(int i = 0 ; i < rsList.size() ; i++) {
			ScreenPage1DTO dto = (ScreenPage1DTO)rsList.get(i);
			content = content + "<div class=\"photo-inside-1\">\n";
			content = content + "<div class=\"photo-inside-2\"><a href=\"index.jsp?page=collection_2\"><img src=\"content/storage/collection/1/" + dto.getCatImage() + "\" width=\"160\" height=\"160\" /></a></div>\n";
			content = content +  "<div class=\"photo-inside-caption\">" + dto.getCatLabelEng() + "</div>\n";
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
		String pics[] = {"MSA02.jpg", "MSA03.jpg", "MSA02DK1.jpg", "MSA02DM5.jpg", "MSA02DM6.jpg",
						"MSA02DM7.jpg", "MSA02DM8.jpg", "MSA02DM9.jpg", "MSA02DM10.jpg", "MSA02DM11.jpg",
						"MSA02DM12.jpg", "MSA02DM13.jpg", "MSA02DM14.jpg", "MSA02DM15.jpg", "MSA02DM16.jpg"};
		
		String content = "<div class=\"collection-submenu\">\n";
		content = content + theme[0];
		for(int i = 1 ; i < 1 ; i++) {
			content = content + " / ";
			content = content + theme[i];
		}
		content = content + "</div>\n";
		
		content = content + "<div class=\"collection-subtitle\">Porcelain</div>\n";

		
		List<ScreenPage3DTO> dtos = generatePage3Info();
		for(int i = 0 ; i < 1 ; i++) {
			content = content + "<div class=\"collection-susubbtitle\">Sandstone " + "</div>\n";
			content = content + "<div class=\"sp-frame\">\n";
			for(int j = 0 ; j < pics.length ; j++) {
				int iPhotoNum = j + 1;
				ScreenPage3DTO dto = dtos.get(j);
				content = content + "<div class=\"sp-inside-1\">\n";
				content = content + "<div class=\"sp-inside-2\"><a href=\"#nogo\" onclick=\"lb_effect_open('#photo" + iPhotoNum + "','#photo_wrap" + iPhotoNum + "')\"><img src=\"content/storage/collection/3/" + pics[j] + "\" width=\"71\" height=\"71\" /></a></div>\n";
				content = content + "<div class=\"sp-inside-caption\">" + dto.getMaterialID() + "</div>\n";
				content = content + "<div id=\"photo" + iPhotoNum + "\" class=\"lightbox-panel\">\n";
				content = content + "<div class=\"lightbox_left\"><img src=\"content/storage/collection/3/" + pics[j] + "\" width=\"275\" height=\"275\" /></div>\n";
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
		}
		
		content = content + "</div>\n";
		content = content + "<br />\n";
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
	
	private List<ScreenPage1DTO> getPage1Info() {
		Statement stmt = null;
		String query = "select jc.category_label_eng, jc.category_label_chin, jc.category_image, " + 
						"JRLC.lob_category_seq from JPT_LOB jl, JPT_RLT_LOB_CATEGORY JRLC, " + 
						"JPT_CATEGORY jc where sub_lob_id='Collection' and jl.lob_PK=JRLC.lob_pk " + 
						"and JRLC.category_pk=jc.category_pk and jc.rec_status='ACT' order by JRLC.lob_category_seq";
		
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
