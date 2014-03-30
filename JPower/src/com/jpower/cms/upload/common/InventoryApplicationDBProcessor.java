package com.jpower.cms.upload.common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;

import com.jpower.cms.vo.InventoryApplicationVO;

public class InventoryApplicationDBProcessor {

	public static String insertSql = "insert into JPW_APPLICATION(LOB, SUB_LOB, SUB_LOB_LABEL_ENG, SUB_LOB_LABEL_CHIN, CATEGORY, CATEGORY_SEQ, CATEGORY_LABEL_ENG, CATEGORY_LABEL_CHIN," +
			"CATEGORY_IMAGE, SERIES, SERIES_SEQ, SERIES_LABEL_ENG, SERIES_LABEL_CHIN, SERIES_IMAGE_SMALL, SERIES_IMAGE_LARGE, SUB_SERIES, " +
			"SUB_SERIES_SEQ, SUB_SERIES_LABEL_ENG, SUB_SERIES_LABEL_CHIN, SUB_SERIES_ID, SUB_SERIES_IMAGE_SMALL, SUB_SERIES_IMAGE_LARGE, TRAN_ACTION, TRAN_STATUS, CREATE_USER, UPDATE_USER, " +
			"CREATE_DATE, UPDATE_DATE, REF_IDX, EXCEL_ROW_ID, EXCEL_ROW_DATA) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp,current_timestamp,?,?,?)";

	public static PreparedStatement psInsert = null;

	public static void saveToDB(List<InventoryApplicationVO> voList, int refIdx) {
		Connection conn = DBAccess.getDBConnection();
		try {
			psInsert = conn.prepareStatement(insertSql);
			for (Iterator<InventoryApplicationVO> i = voList.iterator(); i.hasNext();) {
				InventoryApplicationVO vo = (InventoryApplicationVO) i.next();
				psInsert.setString(1, vo.getLob());
				psInsert.setString(2, vo.getSubLob());
				psInsert.setString(3, vo.getSubLobLabelEng());
				psInsert.setString(4, vo.getSubLobLabelChin());
				psInsert.setString(5, vo.getCategory());
				psInsert.setInt(6, vo.getCategorySeq());
				psInsert.setString(7, vo.getCategoryLabelEng());
				psInsert.setString(8, vo.getCategoryLabelChin());
				psInsert.setString(9, vo.getCategoryImagePath());
				psInsert.setString(10, vo.getSeries());
				psInsert.setInt(11, vo.getSeriesSeq());
				psInsert.setString(12, vo.getSeriesLabelEng());
				psInsert.setString(13, vo.getSeriesLabelChin());
				psInsert.setString(14, vo.getSeriesImageSmallPath());
				psInsert.setString(15, vo.getSeriesImageLargePath());
				psInsert.setString(16, vo.getSubSeries());
				psInsert.setInt(17, vo.getSubSeriesSeq());
				psInsert.setString(18, vo.getSubSeriesLabelEng());
				psInsert.setString(19, vo.getSubSeriesLabelChin());
				psInsert.setString(20, vo.getSubSeriesID());
				psInsert.setString(21, vo.getSubSeriesImageSmallPath());
				psInsert.setString(22, vo.getSubSeriesImageLargePath());
				psInsert.setString(23, vo.getTranAction().toUpperCase());
				psInsert.setString(24, Util.TRAN_STATUS_AWV);
				psInsert.setString(25, Util.USER_ID_DEFAULT);
				psInsert.setString(26, Util.USER_ID_DEFAULT);
//				psInsert.setInt(27, MemCache.getUploadSeq());
				psInsert.setInt(27, refIdx);
				psInsert.setInt(28, vo.getExcelRowID());
				psInsert.setString(29, vo.getExcelRowData());
				psInsert.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (psInsert != null) {psInsert.close();}
				if (conn != null) {conn.close();}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}		

	}
}

