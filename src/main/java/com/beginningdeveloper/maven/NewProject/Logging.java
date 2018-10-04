package com.beginningdeveloper.maven.NewProject;

import java.io.IOException;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logging {
	static ChromeDriver driver;
	


static Logger log = LoggerFactory.getLogger(Logging.class);


	public static void main(String[] args) throws IOException, InterruptedException, Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();


		String Loginurl = "https://panna-play.mroads.com/panna/#/login";
		String customPrepare = "https://panna-play.mroads.com/panna/#/on-demand-interview";
		String unmae = "sandeep@mroads.com";
		String pwd = "Test@123";
		String RequisitionID = "Hilton015p1";
		String PositionTitle = "Hilton014";
try {
	
	driver.get(Loginurl);
	Thread.sleep(3000);
	
	WebElement userEmail=driver.findElement(By.id("yourEmail"));
    userEmail.sendKeys(unmae);
    
    WebElement userPwd=driver.findElement(By.id("yourPwd"));
    userPwd.sendKeys(pwd);
    
    driver.findElement(By.id("login-submit-btn")).click();
    
    Thread.sleep(3000);
    
    driver.get(customPrepare);
	Thread.sleep(2000);
	
	WebElement reqID=driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/app-prepare-preset/div/div/div/form/div[1]/div[1]/input"));
	reqID.sendKeys(RequisitionID);
	
	WebElement posTitle=driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/app-prepare-preset/div/div/div/form/div[1]/div[2]/input"));
	posTitle.sendKeys(PositionTitle);
	
	//Adding req skills
	WebElement skill=driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/app-prepare-preset/div/div/div/form/div[3]/div/tag-input/div/div/tag-input-form/form/input"));
	Thread.sleep(2000);
	skill.sendKeys("JAVASCRIPT");
	
	Thread.sleep(1000);
	
	WebElement textbox = driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/app-prepare-preset/div/div/div/form/div[3]/div/tag-input/div/div/tag-input-form/form/input"));
	textbox.sendKeys(Keys.ENTER);

	
	//prepare interview
	driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/app-prepare-preset/div/div/div/form/div[4]/button[1]")).click();
	
	Thread.sleep(4000);
	//Verifying the success
			String bodyText = driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/app-prepare-preset/div/div/div/div/div[1]")).getText();
			
			String expectedText = "You have successfully prepared an interview for the position of " + PositionTitle +". You can edit this interview from view/modify.";
			 
			if (bodyText.equals(expectedText)){
				System.out.println("Verification Successful & prepared the preset interview");
			}else{
				System.out.println("Verification Failed");
				//In case of Fail, you like to print the actual and expected MSG for the record purpose
				System.out.println("Actual URL is : " + bodyText);
				System.out.println("Expected URL is : " + expectedText);
			}
	
	driver.quit();
	
	}

catch (Exception e){
	
	// Printing logs for my report
	 
	log.error("Report Category button element is not found."+e);

	// Taking screenshot for defect reporting


	// After doing my work, now i want to stop my test case

    throw(e);
	}
driver.close();
driver.quit();

}
	
}