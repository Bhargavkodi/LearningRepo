package com.beginningdeveloper.maven.NewProject;

import java.io.FileInputStream;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.log4j.Logger;

public class PannaSchedule {

	public static Properties prop;
	static ChromeDriver driver;
	static Logger log = Logger.getLogger(PannaSchedule.class.getName());

	public static void main(String[] args) throws IOException, InterruptedException, Exception {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/ethirajp/eclipse-workspace1/NewProject/src/main/java/com/learning/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
	    String browserName = cap.getBrowserName().toLowerCase();
	    log.info("Opened Browser  ----> " + browserName);
	    String os = cap.getPlatform().toString();
	    log.info("System OS  ----> " + os);
	    String ver = cap.getVersion().toString();
	    log.info("Browser version is  ----> " + ver);
		driver.manage().timeouts().pageLoadTimeout(Integer.valueOf(prop.getProperty("PAGE_LOAD_TIMEOUT")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);

		String Loginurl = "https://app.panna.ai/panna/#/login";
		String OnDeamand = "https://app.panna.ai/panna/#/on-demand-interview";
		String unmae = "sampleuser@yopmail.com";
		String pwd = "test";
		
		//Change this below 3 upon on ur request before run//
		String RequisitionID = "MROADS-CSM: SCRUM MASTER"; 
		String ID = "MROADS-CSM: SCRUM MASTER"; 
		String IntType = "custom"; 
		//-------------------------------------------------//
		
		String Expiry = "1";
		String name = "Test";
		String Lastname = "Test";
        boolean isContinue = true;
        
		try {
		driver.get(Loginurl);
		log.info("URL is " + driver.getCurrentUrl());
		Thread.sleep(3000);
		}
		catch (TimeoutException e){
			isContinue=false;
			log.info("Unable to load the page within expected time  ----> " + prop.getProperty("PAGE_LOAD_TIMEOUT") + " Seconds");
			driver.quit();
			log.info("Quitted browser due to page load failure  -->   " + Loginurl);
		}
		
		if(!isContinue) 
			return;
		
		log.info("Successfully landed -----> " + Loginurl);
		log.info(driver.getTitle());

		WebElement userEmail = driver.findElement(By.id("yourEmail"));
		userEmail.sendKeys(unmae);
		log.info("Successfully entered uname -----> " + unmae);

		WebElement userPwd = driver.findElement(By.id("yourPwd"));
		userPwd.sendKeys(pwd);
		log.info("Successfully entered pwd -----> " + pwd);

		driver.findElement(By.id("login-submit-btn")).click();
		Thread.sleep(3000);

		driver.get(OnDeamand);
		Thread.sleep(2000);
		log.info("Moved to OnDemand Interview Page -----> " + OnDeamand);
		log.info(driver.getTitle());

		driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/div[2]/div[3]/span"))
				.click();
		log.info(driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[2]")).getText());
		log.info("Now Landed on schedule page");
		Thread.sleep(2000);
		
		if(IntType.equals("custom")){
			
			WebElement INT = driver.findElement(
					By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[1]/div[1]/app-dropdown/div/input"));
			
			INT.clear();
			INT.sendKeys(IntType);
			Thread.sleep(2000);
			log.info("Successfully entered Type 0f interview -----> " + IntType);
			Thread.sleep(2000);
			WebElement button = driver.findElement(By.id("Custom"));
			button.click();
			log.info("Successfully selected Type 0f interview -----> " + button);
		}
		else if(IntType.equals("preset")){
			
			WebElement INT = driver.findElement(
					By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[1]/div[1]/app-dropdown/div/input"));
			
			INT.clear();
			INT.sendKeys(IntType);
			Thread.sleep(2000);
			log.info("Successfully entered Type 0f interview -----> " + IntType);
			Thread.sleep(2000);
			WebElement button = driver.findElement(By.id("Panna Preset"));
			button.click();
			log.info("Successfully selected Type 0f interview -----> " + button);
		}

		WebElement RID = driver.findElement(
				By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[1]/div[2]/app-dropdown/div/input"));

		RID.sendKeys(RequisitionID);
		Thread.sleep(4000);
		log.info("Successfully entered RID -----> " + RequisitionID);
		Thread.sleep(2000);
		WebElement button = driver.findElement(By.id(ID));
		button.click();
		log.info("Successfully selected Job Position -----> " + button);

		WebElement exp = driver
				.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[1]/div[3]/input"));

		exp.sendKeys(Expiry);
		log.info("Successfully entered expiry -----> " + Expiry);

		Thread.sleep(5000);

		String[] emails = prop.getProperty("Emails").split(",");
		log.info("Interviews to be scheduled for " + emails.length + " candidates");

		for (int i = 0; i < emails.length; i++) {
			String Email = emails[i];
			int j = i + 1;

			WebElement Fanme = driver.findElement(
					By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
							+ "]/td[1]/input"));

			Fanme.sendKeys(name);
			Thread.sleep(1000);

			WebElement Lanme = driver.findElement(
					By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
							+ "]/td[2]/input"));

			Lanme.sendKeys(Lastname);

			Thread.sleep(1000);

			WebElement mail = driver.findElement(
					By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
							+ "]/td[3]/input"));

			mail.sendKeys(Email);
			log.info("Successfully entered email -----> " + Email);

			if (i == emails.length - 1)
				break;

			driver.findElement(By.xpath("//*[@id='one-way-schedule-div']/div/div/div[3]/div[2]/div[3]/div[1]")).click();
		}
		Thread.sleep(4000);
		WebElement Schedule = driver.findElement(
				By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/div[2]/button[1]"));

		Schedule.click();
		log.info("clicked on ----> " + Schedule);

		log.info("Successfully scheduled interview for ----> " + emails.length);
		Thread.sleep(15000);

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("scroll(0, -250);");
		Thread.sleep(4000);

		String bodyText = driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/button")).getText();

		String expectedText = "SCHEDULE NEW INTERVIEW";

		if (bodyText.equals(expectedText)) {
			log.info("Verification Successful & Scheduled the interview for----> " + emails.length);
		} else {
			System.out.println("Verification Failed");
			// In case of Fail, you like to print the actual and expected MSG for the record
			// purpose
			log.info("Actual URL is : " + bodyText);
			log.info("Expected URL is : " + expectedText);
		}
		driver.quit();
		log.info("Successfully quitted from browser ---> " + browserName);
	}
}