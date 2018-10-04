package com.beginningdeveloper.maven.NewProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {
	
	WebDriver driver;
	By Username = By.id("yourEmail");
	By Password = By.id("yourPwd");
	By loginBtn = By.id("login-submit-btn");	
	public Login(WebDriver driver) {
		this.driver=driver;
	}
	public void loginPanna(String uname,String pwd) {
		System.out.println("driver "+driver);
		
		driver.findElement(Username).sendKeys(uname);
		driver.findElement(Password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
	}

}
