package com.beginningdeveloper.maven.NewProject;

import java.io.File;
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
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;
import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class PannaSchedule {

	public static Properties prop;
	static ChromeDriver driver;
	static Logger log = Logger.getLogger(PannaSchedule.class.getName());
	String userName = "mroads.vnr@gmail.com";

	// -------------------------------------------------//
	// Change this below 9 based on request before run//
	static String unmae = "test@panna.ai";
	static String pwd = "test";
	static String RequisitionID = "DTCP-02: DTCP-02";
	static String ID = "DTCP-02: DTCP-02";
	// custom //preset
	static String IntType = "preset";
	static String Expiry = "1";
	// excel //properties
	static String Candidateinfo = "properties";
	static String excelPath = "/Users/ethirajp/Downloads/surya.xlsx";
	static String reportMail = "srikanth.yasareni@mroads.com";
	// -------------------------------------------------//
	// --------------------------------------------------//

	static void sendEmail(String receiver) {

		String userName = "mroads.vnr@gmail.com";
		String password = "gaurav14";
		String fromAddress = "mroads.vnr@gmail.com";
		String subject = "Panna Interviews";
		String message = "Successfully scheduled interview(s)" + '\n' + '\n' + '\n'
				+ "This is an auto generated email after successful schedule from script";

		final String HOST = "smtp.gmail.com";
		final int PORT = 465;
		final boolean SSL_FLAG = true;

		try {
			Email email = new SimpleEmail();
			email.setHostName(HOST);
			email.setSmtpPort(PORT);
			email.setAuthenticator(new DefaultAuthenticator(userName, password));
			email.setSSLOnConnect(SSL_FLAG);
			email.setFrom(fromAddress);
			email.setSubject(subject);
			email.setMsg(message);
			email.addTo(receiver);
			email.send();
			log.info("Successfully sent email ---> " + reportMail);
		} catch (Exception ex) {
			log.info("Unable to send email");
			log.info(ex);
		}
	}

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
		driver.manage().deleteAllCookies();
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toUpperCase();
		log.info("Opened Browser  ----> " + browserName);
		String os = cap.getPlatform().toString();
		log.info("System OS  ----> " + os);
		String ver = cap.getVersion().toString();
		log.info("Browser version is  ----> " + browserName + ver);
		driver.manage().timeouts().pageLoadTimeout(Integer.valueOf(prop.getProperty("PAGE_LOAD_TIMEOUT")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);

		String Loginurl = "https://app.panna.ai/panna/#/login";
		String OnDeamand = "https://app.panna.ai/panna/#/on-demand-interview";

		boolean codestop = false;
		boolean isContinue = true;

		try {
			driver.get(Loginurl);
			log.info("URL is " + driver.getCurrentUrl());
			Thread.sleep(3000);
		} catch (TimeoutException e) {
			isContinue = false;
			log.info("Unable to load the page within expected time  ----> " + prop.getProperty("PAGE_LOAD_TIMEOUT")
					+ " Seconds");
			driver.quit();
			log.info("Quitted browser due to page load failure  -->   " + Loginurl);
		}

		if (!isContinue)
			return;

		log.info("Successfully landed -----> " + Loginurl);
		log.info(driver.getTitle());

		WebElement userEmail = driver.findElement(By.id("yourEmail"));
		userEmail.sendKeys(unmae);
		log.info("Successfully entered uname -----> " + unmae);

		WebElement userPwd = driver.findElement(By.id("yourPwd"));
		userPwd.sendKeys(pwd);
		log.info("Successfully entered pwd -----> " + "*******");

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

		// Enter Interview type
		if (IntType.equals("custom")) {

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
		} else if (IntType.equals("preset")) {
			log.info("Successfully selected Preset interview");
		}

		// Enter Requisition ID
		try {
			WebElement RID = driver.findElement(
					By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[1]/div[2]/app-dropdown/div/input"));

			RID.sendKeys(RequisitionID);
			Thread.sleep(3000);
			log.info("Successfully entered RID -----> " + RequisitionID);
			Thread.sleep(2000);
			WebElement button = driver.findElement(By.id(ID));
			button.click();
			log.info("Successfully selected Job Position -----> " + button);
		} catch (Exception e) {
			isContinue = false;
			log.info("Unable to find the interview position ----> " + RequisitionID);
			driver.quit();
			log.info("Quitted browser due to invalid interview position  -->   " + Loginurl);
		}

		if (!isContinue)
			return;

		// Enter expiry days
		WebElement exp = driver
				.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[1]/div[3]/input"));

		exp.sendKeys(Expiry);
		log.info("Successfully entered expiry -----> " + Expiry);

		Thread.sleep(2000);

		if (Candidateinfo.equals("properties")) {
			// Enter candidate info
			String[] emails = prop.getProperty("Emails").split(",");
			log.info("Picking data of candidate(s) from properties file");
			log.info("Interviews to be scheduled for " + emails.length + " candidates");

			for (int i = 0; i < emails.length; i++) {
				String Email = emails[i];
				String firstName = Email.substring(0, Email.indexOf("@"));
				String lastName = Email.substring(0, 1).toUpperCase();
				int j = i + 1;

				WebElement Fanme = driver.findElement(
						By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
								+ "]/td[1]/input"));

				Fanme.sendKeys(firstName);

				WebElement Lanme = driver.findElement(
						By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
								+ "]/td[2]/input"));

				Lanme.sendKeys(lastName);

				WebElement mail = driver.findElement(
						By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
								+ "]/td[3]/input"));

				mail.sendKeys(Email);
				log.info("Successfully entered email -----> " + (i + 1) + ":" + Email);

				if (i == emails.length - 1)
					break;

				driver.findElement(By.xpath("//*[@id='one-way-schedule-div']/div/div/div[3]/div[2]/div[3]/div[1]"))
						.click();
			}

			if (codestop == true) {
				log.info("successfully stopped code execution");
				return;
			}
			Thread.sleep(4000);

			WebElement Schedule = driver.findElement(
					By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/div[2]/button[1]"));

			Schedule.click();
			log.info("successfully clicked on schedule button ----> " + Schedule);

			log.info("Successfully scheduled interview for ----> " + emails.length);
			Thread.sleep(15000);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, -250);");
			Thread.sleep(4000);

			String bodyText = driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/button"))
					.getText();
			String expectedText = "SCHEDULE NEW INTERVIEW";

			if (bodyText.equals(expectedText)) {
				log.info("Verification Successful & Scheduled the interview for ----> " + emails.length);
			} else {
				System.out.println("Verification Failed");
				log.info("Actual URL is : " + bodyText);
				log.info("Expected URL is : " + expectedText);
			}
		}

		else if (Candidateinfo.equals("excel")) {
			File src = new File(excelPath);  

			// load file
			FileInputStream fis = new FileInputStream(src);

			// Load workbook
			@SuppressWarnings("resource")
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Load sheet- Here we are loading first sheet
			XSSFSheet sh1 = wb.getSheetAt(0);

			log.info("Picking data of candidate(s) from excel sheet");
			log.info("Excel path is ---> "+excelPath);
			int End, start;
			start = sh1.getFirstRowNum();
			log.info("First row number in excel sheet ----> " + start);

			End = sh1.getLastRowNum();
			log.info("Last row number in excel sheet ----> " + End);

			log.info("Active rows in excel sheet---> " + sh1.getPhysicalNumberOfRows());

			for (int sheet = 1; sheet <= End; sheet++) {

				Row row = sh1.getRow(sheet);

				String Email = row.getCell(0).toString();
				String firstName = Email.substring(0, Email.indexOf("@"));
				String lastName = Email.substring(0, 1).toUpperCase();

				int j = (sheet - 1) + 1;

				WebElement Fanme = driver.findElement(
						By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
								+ "]/td[1]/input"));

				Fanme.sendKeys(firstName);

				WebElement Lanme = driver.findElement(
						By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
								+ "]/td[2]/input"));

				Lanme.sendKeys(lastName);

				WebElement mail = driver.findElement(
						By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/table/tbody/tr[" + j
								+ "]/td[3]/input"));

				mail.sendKeys(Email);
				log.info("Successfully entered email -----> " + sheet + ":" + Email);

				if (sheet == End)
					break;

				driver.findElement(By.xpath("//*[@id='one-way-schedule-div']/div/div/div[3]/div[2]/div[3]/div[1]"))
						.click();
			}
			if (codestop == true) {
				log.info("Successfully stopped code execution");
				return;
			}
			Thread.sleep(4000);

			WebElement Schedule = driver.findElement(
					By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/div[3]/div[2]/div[3]/div[2]/button[1]"));

			Schedule.click();
			log.info("Successfully clicked on schedule button ----> " + Schedule);

			log.info("Successfully scheduled interview for ----> " + End);
			Thread.sleep(15000);

			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("scroll(0, -250);");
			Thread.sleep(4000);

			String bodyText = driver.findElement(By.xpath("//*[@id=\"one-way-schedule-div\"]/div/div/button"))
					.getText();
			String expectedText = "SCHEDULE NEW INTERVIEW";

			if (bodyText.equals(expectedText)) {
				log.info("Verification Successful & Scheduled the interview for ----> " + End);
			} else {
				log.info("Verification unSuccessful");
				log.info("Actual text on page is : " + bodyText);
				log.info("Expected text on page is : " + expectedText);
			}
		}
		driver.quit();
		log.info("Successfully quitted from browser ---> " + browserName);
		log.info("Sending email to -----> " +reportMail);
		PannaSchedule.sendEmail(reportMail);
	}

}