package com.WebOrder;

import org.testng.annotations.DataProvider;

public class assignment_testdata {
	@DataProvider(name = "login")
	public Object[][] product() {
		return new Object[][] {

				{"MyMoney"},
				{"FamilyAlbum"} ,
				{"ScreenSaver"}
		};
		}
}
