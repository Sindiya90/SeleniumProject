package com.framework.testng.api.base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.framework.selenium.api.base.SeleniumBase;
import com.framework.utils.DataLibrary;

public class ProjectSpecificMethods extends SeleniumBase {

	@DataProvider(name = "fetchData", indices = 0)
	public Object[][] fetchData() throws IOException {
		return DataLibrary.readExcelData(excelFileName);
	}

	@Parameters({"browser"})
	@BeforeMethod
	public void preCondition(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {

		   if(System.getProperty("devserverurl")==null)
		    startApp("chrome", false, prop.getProperty("url"));
		   else
		    startApp("chrome", false, "http://"+System.getProperty("devserverurl")+"/");
		setNode();
		} else if(browserName.equalsIgnoreCase("firefox")) {
			if(System.getProperty("devserverurl")==null)
			    startApp("firefox", false, prop.getProperty("url"));
			else
				startApp("chrome", false, "http://"+System.getProperty("devserverurl")+"/");
			setNode();
		}
	}

	@AfterMethod
	public void postCondition() {
		close();

	}

}
