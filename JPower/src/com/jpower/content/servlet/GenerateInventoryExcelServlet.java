package com.jpower.content.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpower.cms.upload.excel.InventoryApplicationProcessor;

public class GenerateInventoryExcelServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		OutputStream out = null;
		try {
			response.setContentType("application/vnd.ms-excel");

			response.setHeader("Content-Disposition",
					"attachment; filename=applicationInventory.xls");

			out = response.getOutputStream();
			
			InventoryApplicationProcessor
					.generateInventoryApplicationWorkbook(out);
		} catch (Exception e) {
			throw new ServletException("Exception in generate inventory Excel Servlet", e);
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
