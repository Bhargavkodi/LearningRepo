package com.learning.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("/Users/ethirajp/eclipse-workspace1/NewProject/src/main/java/com/learning/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

}
	


public static void initialization(){
	String browserName = prop.getProperty("browser");
	
	if(browserName.equals("chrome")){
		System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");	
		driver = new ChromeDriver(); 
		System.out.println(browserName);
	}
	else if(browserName.equals("FF")){
		System.setProperty("webdriver.gecko.driver", "/Users/ethirajp/Desktop/geckodriver");	
		driver = new FirefoxDriver(); 
		System.out.println("FireFox");
	}
	
	driver.manage().window().fullscreen();
	Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
    String BrowserName = cap.getBrowserName().toLowerCase();
    System.out.println("Opened Browser  ----> " + BrowserName);
    String os = cap.getPlatform().toString();
    System.out.println("System OS  ----> " + os);
    String ver = cap.getVersion().toString();
    System.out.println("Browser version is  ----> " + ver);
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(Integer.valueOf(prop.getProperty("PAGE_LOAD_TIMEOUT")), TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(Integer.valueOf(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);
	
	driver.get(prop.getProperty("url"));
}

}