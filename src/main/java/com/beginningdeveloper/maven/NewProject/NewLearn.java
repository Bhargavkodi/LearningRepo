package com.beginningdeveloper.maven.NewProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLearn {
	
	public static WebDriver driver;
	
	//Page Factory - OR:
			@FindBy(id="yourEmail")
			public
			WebElement username;
			
			@FindBy(id = "yourPwd")
			WebElement password;
			
			@FindBy(xpath="//*[@id=\"login-submit-btn\"]")
			WebElement loginBtn;
			
			@FindBy(xpath="/html/body/app-root/app-reports/app-header-component/div/div[1]/div[1]/img")
			WebElement pannaLogo;
			
			public NewLearn(){
				PageFactory.initElements(driver, this);
				System.out.println("driver "+ driver);
			}
			
			

}
