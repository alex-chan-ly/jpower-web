package com.jpower.content.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpower.cms.upload.excel.InventoryApplicationProcessor;
import com.jpower.cms.upload.excel.LogProcessor;

public class GenerateLogExcelServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String refIdx = request.getParameter("REF-IDX");
		System.out.println("GenerateLogExcelServlet : REF-IDX : " + refIdx);
		
		OutputStream out = null;
		try {
			response.setContentType("application/vnd.ms-excel");

			response.setHeader("Content-Disposition",
					"attachment; filename=inventoryUploadLog.xls");

			out = response.getOutputStream();
			
			LogProcessor.generateLogDetailWorkbook(Integer.valueOf(refIdx), out);

		} catch (Exception e) {
			throw new ServletException("Exception in generate log Excel Servlet", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
