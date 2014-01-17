package com.jpower.content.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jpower.content.business.CollectionPhotoFramePage;
import com.jpower.content.business.CommercialPhotoFramePage;
import com.jpower.content.business.PhotoFramePage;
import com.jpower.content.business.ResidentialPhotoFramePage;
import com.jpower.content.business.TileArtPhotoFramePage;
import com.jpower.content.model.Stock;

public class GeneratePhotoFrameServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doGet(req, resp);
		String content = "";
		String app = req.getParameter("app");
		String page = req.getParameter("page");
		String lang = req.getParameter("lang");
		PhotoFramePage pfp = null;
		if(app.equals("residential")) {
			pfp = new ResidentialPhotoFramePage();			
		} else if(app.equals("commercial")) {
			pfp = new CommercialPhotoFramePage(); 
		} else if(app.equals("tile_art")) {
			pfp = new TileArtPhotoFramePage();
		} else if(app.equals("collection")) {
			pfp = new CollectionPhotoFramePage();
		}
		
		if(page.equals("1")) {
			if(lang.equals("eng"))
				content = pfp.generatePage1();
			else
				content = pfp.generatePage1_Chn();
		} else if(page.equals("2")) {
			if(lang.equals("eng"))
				content = pfp.generatePage2();
			else
				content = pfp.generatePage2_Chn();
		} else if(page.equals("3")) {
			String catPK = req.getParameter("cat");
			String seriesPK = req.getParameter("series");
			String title = req.getParameter("title");
			if(lang.equals("eng"))
				content = pfp.generatePage3(catPK, seriesPK, title);
			else
				content = pfp.generatePage3_Chn(catPK, seriesPK, title);
		}
		
		
		PrintWriter out = resp.getWriter();
		out.println(content);
	}
	
	


}
