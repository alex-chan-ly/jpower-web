package com.jpower.content.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.zip.ZipFile;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadServlet extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String fileName = null;
//		String destination = "/home/benson/apache-tomcat-6.0.32/webapps/jpower/content/zip";
		String destination = "/home/jpoweradm/public_html/content/zip";
		
//		super.doPost(req, resp);
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig().getServletContext();
		File repository = (File) servletContext.getAttribute(destination);
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		req.getSession().removeAttribute("RESULT");
        try {
        	// Parse the request
        	List<FileItem> items = upload.parseRequest(req);
        	FileItem fileItem = items.get(0);   //Get the only one file.
        	fileName = fileItem.getName();
        	File finalFile = new File(destination + "/" + fileItem.getName());
        	fileItem.write(finalFile);  
        	if(isZipFile(finalFile)) {
        		req.getSession().setAttribute("RESULT", "File "+fileItem.getName()+ " uploaded successfully.");
        	} else {
        		req.getSession().setAttribute("RESULT", "File "+fileItem.getName()+ " is not a valid zip file.");
        		finalFile.delete();
        	}
        } catch(FileUploadException e) {
        	e.printStackTrace();
          	req.getSession().setAttribute("RESULT", "Exception in uploading file.");
        } catch(Exception e) {
        	e.printStackTrace();
          	req.getSession().setAttribute("RESULT", "Exception in uploading file.");
        }
        
        //production
        resp.sendRedirect("/upload.jsp");
        //testing development
//        resp.sendRedirect("/jpower/upload.jsp");
		Runtime.getRuntime().exec("chown jpoweradm " + "/home/jpoweradm/public_html/content/zip/" + fileName);
		Runtime.getRuntime().exec("chgrp jpoweradm " + "/home/jpoweradm/public_html/content/zip/" + fileName);
        
	}
	
	private Boolean isZipFile(File file) {
		
		try {
			ZipFile zip = new ZipFile(file);
		} catch(IOException e) {
			return false;
		}
		
		return true;
		
		
	}

}
