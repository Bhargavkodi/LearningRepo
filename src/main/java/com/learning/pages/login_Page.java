package com.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.learning.base.TestBase;

public class login_Page extends TestBase {

	   //Page Factory - OR:
		@FindBy(id="yourEmail")
		WebElement username;
		
		@FindBy(id = "yourPwd")
		WebElement password;
		
		@FindBy(xpath="//*[@id=\"login-submit-btn\"]")
		WebElement loginBtn;
		
		@FindBy(xpath="/html/body/app-root/app-reports/app-header-component/div/div[1]/div[1]/img")
		WebElement pannaLogo;
		
		public login_Page(){
			PageFactory.initElements(driver, this);
			System.out.println("driver "+TestBase.driver);
		}
		
		public void login(String un, String pwd){
			username.sendKeys(un);
			System.out.println("entered username:" +un);
			password.sendKeys(pwd);
			System.out.println("entered pwd:" +pwd);
			loginBtn.click();
			    
		}
		
		public boolean validateCRMImage(){
			return pannaLogo.isDisplayed();
		}
}
