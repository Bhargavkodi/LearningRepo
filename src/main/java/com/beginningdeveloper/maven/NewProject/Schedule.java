package com.beginningdeveloper.maven.NewProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.log4j.Logger;

public class Schedule {
	static ChromeDriver driver;
	
	static Logger log = Logger.getLogger(Schedule.class.getName());

	


		public static void main(String[] args) throws IOException, InterruptedException, Exception {

			System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/eclipse-workspace1/NewProject/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
			
			String Loginurl = "https://app.panna.ai/panna/#/login";
			String OnDeamand = "https://app.panna.ai/panna/#/on-demand-interview";
			String unmae = "sampleuser@yopmail.com";
			String pwd = "test";
			String RequisitionID = "Preset_709";
			String ID = "Preset_709: SmokeTest_Preset";
			String Expiry = "1";
			int strength = 20;
			String name = "Test";
	     
			String Lastname = "Test";
			
			driver.get(Loginurl);
			Thread.sleep(3000);
			log.info("Successfully landed ----->" +Loginurl);
			
			WebElement userEmail=driver.findElement(By.id("yourEmail"));
		    userEmail.sendKeys(unmae);
		    log.info("Successfully entered uname ----->" +unmae);
		    
		    WebElement userPwd=driver.findElement(By.id("yourPwd"));
		    userPwd.sendKeys(pwd);
		    log.info("Successfully entered pwd ----->" +pwd);
		    
		    driver.findElement(By.id("login-submit-btn")).click();
		    
		    Thread.sleep(3000);
		  
		    driver.get(OnDeamand);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/div[2]/div[3]/span")).click();
			
			WebElement RID=driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[1]/div[2]/app-dropdown/div/input"));
			RID.sendKeys(RequisitionID);
			Thread.sleep(2000);
			log.info("Successfully entered RID ----->" +RequisitionID);
			
			driver.findElement(By.id(ID)).click();
			
			WebElement exp=driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[1]/div[3]/input"));
			exp.sendKeys(Expiry);
			log.info("Successfully entered expiry ----->" +Expiry);
			
			Thread.sleep(4000);
			
			for(int i=1;i<strength;i++){
			String Email = "panna" + i+ "@yopmail.com";
				WebElement Fanme=driver.findElement(By.xpath(" //*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr["+i+"]/td[1]/input"));
				Fanme.sendKeys(name);
				 Thread.sleep(1000);
				
				WebElement Lanme=driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr["+i+"]/td[2]/input"));
				Lanme.sendKeys(Lastname);
				
				 Thread.sleep(1000);
				
				WebElement mail=driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr["+i+"]/td[3]/input"));
				mail.sendKeys(Email);
				log.info("Successfully entered email ----->"  +Email);
				if(i==20)
					break;
				driver.findElement(By.xpath("//*[@id='one-way-schedule-div']/div/div/div[3]/div[2]/div[3]/div[1]")).click();
				
			}
			 Thread.sleep(10000);
			
			//driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/div[2]/button[1]")).click();

}
}