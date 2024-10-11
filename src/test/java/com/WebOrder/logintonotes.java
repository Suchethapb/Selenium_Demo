package com.WebOrder;

import org.testng.annotations.DataProvider;

public class logintonotes {
	@DataProvider(name = "login")
	public Object[][] product() {
		return new Object[][] {

				{"MyMoney"},
				{"FamilyAlbum"} ,
				{"ScreenSaver"}
		};
		}

}
