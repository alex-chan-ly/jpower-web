package com.jpower.content.business;

public interface PhotoFramePage {
	
	public String generatePage1();
	public String generatePage1_Chn();
	public String generatePage2();
	public String generatePage2_Chn();
	public String generatePage3(String catPK, String seriesPK);
	public String generatePage3_Chn(String catPK, String seriesPK);

}
