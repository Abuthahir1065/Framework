
package com.atmecs.browser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.atmecs.constant.ConstantClass;



public class SetUp {
	
	public static WebDriver driver;
	public static Properties properties;
	String url;
	@BeforeMethod
	public void declaration() throws FileNotFoundException, IOException
	{
		System.setProperty("webdriver.chrome.driver", ConstantClass.CHROME_PATH);
	     driver=new ChromeDriver();
		properties=com.atmecs.reader.PropertyReader.readProperty(ConstantClass.LOCATORS_PATH);
		url=properties.getProperty("url");
		driver.get(url);
		driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.MINUTES);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}
	

}
