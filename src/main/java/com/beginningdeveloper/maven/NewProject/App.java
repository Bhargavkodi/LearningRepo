package com.beginningdeveloper.maven.NewProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class App {

	static ChromeDriver driver;

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().fullscreen();

		String Loginurl = "https://panna-play.mroads.com/panna/#/login";
		
		
		driver.get(Loginurl);
		
		WebDriverWait wait = new WebDriverWait(driver, 15); //you can play with the time integer  to wait for longer than 15 seconds.`
		wait.until(ExpectedConditions.titleContains("title")); //if you want to wait for a particular title to show up


		
		
		
		
		
		//Verifying the success
		String bodyText = driver.findElement(By.xpath("/html/body/app-root/ng-component/app-interview/div/div/app-welcome/div/div/div[2]")).getText();
		
		String expectedText = "Here are the questions that will be asked during the interview.";
		 
		if (bodyText.equals(expectedText)){
			System.out.println("Verification Successful & prepared the custom interview");
		}else{
			System.out.println("Verification Failed");
			//In case of Fail, you like to print the actual and expected MSG for the record purpose
			System.out.println("Actual URL is : " + bodyText);
			System.out.println("Expected URL is : " + expectedText);
		}
		
		 driver.close();
	}

}
