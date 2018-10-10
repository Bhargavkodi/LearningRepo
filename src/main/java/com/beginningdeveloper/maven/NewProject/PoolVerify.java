package com.beginningdeveloper.maven.NewProject;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import Database.DBTest;

public class PoolVerify {
	static ChromeDriver driver;
	


static Logger log = LoggerFactory.getLogger(PoolVerify.class);


	public static void main(String[] args) throws IOException, InterruptedException, Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();


		String Loginurl = "https://panna-play.mroads.com/panna/#/login";
		String Reports = "https://panna-play.mroads.com/panna/#/reports";
		String unmae = "sandeep@mroads.com";
		String pwd = "Test@123";

	
	driver.get(Loginurl);
	Thread.sleep(3000);
	
	WebElement userEmail=driver.findElement(By.id("yourEmail"));
    userEmail.sendKeys(unmae);
    
    WebElement userPwd=driver.findElement(By.id("yourPwd"));
    userPwd.sendKeys(pwd);
    
    driver.findElement(By.id("login-submit-btn")).click();
    
    Thread.sleep(3000);
    
    driver.get(Reports);
	Thread.sleep(2000);
	
	ResultSet rsData=DBTest.selectDBdata();
	
	String a = rsData.getString(1);
	
				String bodyText = driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/app-prepare-preset/div/div/div/div/div[1]")).getText();
			 
			if (bodyText.equals(a))
				System.out.println("Verification Successful & prepared the preset interview");
			
	driver.quit();
	
	}


	


}
	
