package com.atmecs.testscripts;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.atmecs.browser.SetUp;
import com.atmecs.constant.ConstantClass;
import com.atmecs.helper.HelperClass;
import com.atmecs.reader.PropertyReader;
import com.atmecs.testdata.DataProviderClass;

public class ChatClass extends SetUp {

	Properties locators;

	@Test(dataProvider = "Data", dataProviderClass = DataProviderClass.class)

	public void startChat(String name, String email, String whatsapp) throws InterruptedException {
		locators = PropertyReader.readProperty(ConstantClass.LOCATORS_PATH);

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.switchTo().frame(locators.getProperty("Frame_Id"));
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.getProperty("ChatWidget"))));

		HelperClass.jsClick(driver, locators.getProperty("ChatWidget"));
		HelperClass.sendKeyById(driver, locators.getProperty("NameData"), name);
		HelperClass.ElementSendKeys(driver, locators.getProperty("WhatsApp"), whatsapp);
		HelperClass.sendKeyById(driver, locators.getProperty("EmailData"), email);

		HelperClass.selectFromDropDown(driver, locators.getProperty("Dropdown"), locators.getProperty("value"));
		HelperClass.jsClick(driver, locators.getProperty("StartChat"));

		driver.switchTo().defaultContent();

	}

}
