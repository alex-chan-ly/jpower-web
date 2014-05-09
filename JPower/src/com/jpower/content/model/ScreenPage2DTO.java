package com.jpower.content.model;

import java.util.List;

public class ScreenPage2DTO {
	
	private String catLabelEng;
	private String catLabelChn;
	private String catImage;

	private List<String> imageList;
	private Integer catPK;
	private List<Integer> seriesPKs;
	private Integer lobCategorySeq;

	public String getCatLabelEng() {
		return catLabelEng;
	}

	public void setCatLabelEng(String catLabelEng) {
		this.catLabelEng = catLabelEng;
	}

	public String getCatLabelChn() {
		return catLabelChn;
	}

	public void setCatLabelChn(String catLabelChn) {
		this.catLabelChn = catLabelChn;
	}

	public Integer getLobCategorySeq() {
		return lobCategorySeq;
	}

	public void setLobCategorySeq(Integer lobCategorySeq) {
		this.lobCategorySeq = lobCategorySeq;
	}

	public Integer getCatPK() {
		return catPK;
	}

	public void setCatPK(Integer catPK) {
		this.catPK = catPK;
	}

	public List<String> getImageList() {
		return imageList;
	}

	public void setImageList(List<String> imageList) {
		this.imageList = imageList;
	}

	public List<Integer> getSeriesPKs() {
		return seriesPKs;
	}

	public void setSeriesPKs(List<Integer> seriesPKs) {
		this.seriesPKs = seriesPKs;
	}

	public String getCatImage() {
		return catImage;
	}

	public void setCatImage(String catImage) {
		this.catImage = catImage;
	}
	
	
	
	


	
	
	
	
	
	
	
	
	
}
