package com.assignments;

import org.testng.annotations.DataProvider;

public class assignments01_testcase {
	@DataProvider(name = "product")
	public Object[][] product() {
		return new Object[][] {

				{"MyMoney", },
				{"FamilyAlbum"} ,
				{"ScreenSaver" }
		};
		}

}
