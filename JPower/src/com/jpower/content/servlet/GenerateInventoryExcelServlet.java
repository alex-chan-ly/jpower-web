package com.jpower.content.servlet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpower.cms.upload.common.FileHelper;
import com.jpower.cms.upload.common.Util;
import com.jpower.cms.upload.excel.InventoryApplicationProcessor;

public class GenerateInventoryExcelServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int rtnCode = 0;
		FileInputStream fis = null;
		OutputStream out = null;
		
		File tmpDirectory = new File(FileHelper.getConfigProperty("tmp.home")); 
		File f = new File(tmpDirectory + File.separator + Long.toString(System.nanoTime()));
		f.mkdir();
		
		try {
			if (f.isDirectory()) {
				String cmdLine = "cd " + FileHelper.getConfigProperty("storage.home") + ";" 
						+ "zip -r " + f.getPath() + File.separator + "package.zip .;"
						+ "cd " + f.getPath() + ";"
						+ "zip -u " + f.getPath() + File.separator + "package.zip " 
						+ Util.EXCEL_APPLICATION_EXCEL;
 
//				System.out.println ("cmdLine : " + cmdLine);
				InventoryApplicationProcessor.generateInventoryApplicationWorkbook(f.getPath());

				String[] cmd = {
						"/bin/sh",
						"-c",
						cmdLine
					};
		
				Process p = Runtime.getRuntime().exec(cmd);
				int rtn = p.waitFor();
				if (rtn == 0) {
					rtnCode = 0;
						
					File outFile = new File(f.getPath() + File.separator + "package.zip");
										
					response.setContentType("application/zip");
					response.setContentLength((int) outFile.length());
					response.setHeader("Content-Disposition",
							"attachment; filename=package.zip");
					byte[] arBytes = new byte[(int) outFile.length()];
					fis = new FileInputStream(outFile);
					fis.read(arBytes);
					out = response.getOutputStream();
					out.write(arBytes);
					out.flush();
					
					String[] cmd1 = {
							"/bin/sh",
							"-c",
							"rm -fr " + f.getPath()
						};
					Process p1 = Runtime.getRuntime().exec(cmd1);
					int rtn1 = p1.waitFor();
					
				} else {
					rtnCode = -1;
				}
			} else {
				throw new IOException("Directory creation error " + f.getPath());
			}
			
		} catch (Exception e) {
			throw new ServletException("Exception in generate inventory Excel Servlet", e);
		} finally {
			if (out != null) {
				out.close();
			}
			if (fis != null) {
				fis.close();
			}
		}
	}
	
}
