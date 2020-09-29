package com.atmecs.testscripts;


import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.atmecs.browser.SetUp;
import com.atmecs.constant.ConstantClass;
import com.atmecs.testdata.DataProviderClass;
import com.atmecs.testdata.XlsReader;

import helper.HelperClass;
import reader.PropertyReader;
import sun.awt.SunHints.Value;



public class ChatClass extends SetUp{
	
	Properties locators,testdata;
	
	
	@Test(dataProvider="Data" , dataProviderClass=DataProviderClass.class)
	
	public void startChat(String name,String email,String whatsapp) throws InterruptedException
	{
      	locators=PropertyReader.readProperty(ConstantClass.LOCATORS_PATH);
   
        

      driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.switchTo().frame(locators.getProperty("Frame_Id"));
		WebDriverWait wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locators.getProperty("ChatWidget"))));

        HelperClass.jsClick(driver, locators.getProperty("ChatWidget"));
        HelperClass.sendKeyById(driver, locators.getProperty("NameData"),name);
        HelperClass.ElementSendKeys(driver, locators.getProperty("WhatsApp"), whatsapp);
        HelperClass.sendKeyById(driver, locators.getProperty("EmailData"), email);

        HelperClass.selectFromDropDown(driver, locators.getProperty("Dropdown"), locators.getProperty("value"));
        HelperClass.jsClick(driver, locators.getProperty("StartChat"));
      
    /*   HelperClass.sendKeyById(driver, locators.getProperty("NameData"), locators.getProperty("Name"));
        HelperClass.ElementSendKeys(driver, locators.getProperty("WhatsApp"), locators.getProperty("WhatsAppNo"));
        HelperClass.sendKeyById(driver, locators.getProperty("EmailData"), locators.getProperty("Email"));

        HelperClass.selectFromDropDown(driver, locators.getProperty("Dropdown"), locators.getProperty("value"));
        HelperClass.jsClick(driver, locators.getProperty("StartChat"));*/
	
		driver.switchTo().defaultContent();


	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void fill(String field,String value)
	{
	
		
		System.out.println(field+".............."+value);
		
	}*/
	/*@Test
	public void testChatMethod() throws IOException
	{
		System.out.println("Executing.............");
		XlsReader read=new XlsReader(ConstantClass.TESTDATA_PATH);
		read.readData("DataSheet");
	}*/
	
	}
     

