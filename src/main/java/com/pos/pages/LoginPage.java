package com.pos.pages;

import com.framework.selenium.api.base.ConfigProperties;
import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.ProjectSpecificMethods;
import org.aeonbits.owner.ConfigFactory;

public class LoginPage  extends ProjectSpecificMethods{

	ConfigProperties generalConfig = ConfigFactory.create(ConfigProperties.class);
	public LoginPage enterUserName(String userName) {
		clearAndType(locateElement(Locators.NAME, "username"), userName);
		reportStep(userName+" username is entered successfully", "pass");
		return this;
	}
	public LoginPage enterPassword(String password) {
		clearAndType(locateElement(Locators.NAME, "password"), password);
		reportStep(password+" password is entered successfully", "pass");
		return this;
	}
	public PointOfSalePage clickLoginButton() {
		
		click(locateElement(Locators.XPATH, "//span[text()='Login']"));
		reportStep("Login Button clicked  successfully", "pass");
		
		return new PointOfSalePage();
	}
	
	public PointOfSalePage login() {
		enterUserName(generalConfig.username());
		enterPassword(generalConfig.password());
		clickLoginButton();
		return new PointOfSalePage();
	}
}
