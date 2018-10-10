package com.beginningdeveloper.maven.NewProject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail {
	
	static ChromeDriver driver;

	static Logger log = Logger.getLogger(PannaSchedule.class.getName());
	
	public static void main(String[] args) throws IOException, InterruptedException, Exception {

		System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		String Gmailnurl = "https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin";
		String unmae = "mroads.vnr@gmail.com";
		String pwd = "gaurav14";
		
		driver.get(Gmailnurl);
		String Title = driver.getTitle();
		Thread.sleep(2000);
		log.info("Landed on Gmail login page: " + Title );
		driver.findElement(By.id("identifierId")).sendKeys(unmae);
        Thread.sleep(1000);
        log.info("Successfully entered uname -----> " + unmae);
        driver.findElement(By.id("identifierNext")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(pwd);
        Thread.sleep(1000);
        log.info("Successfully entered pwd -----> " + pwd);
        driver.findElement(By.id("passwordNext")).click();
        Thread.sleep(3000);
        
        driver.quit();

		
		
		
		
	}
	
	

}
