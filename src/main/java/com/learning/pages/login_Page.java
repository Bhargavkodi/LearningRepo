package com.learning.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.learning.base.TestBase;

public class login_Page extends TestBase {

	   //Page Factory - OR:
		@FindBy(id="yourEmail")
		public static
		WebElement username;
		
		@FindBy(id = "yourPwd")
		static
		WebElement password;
		
		@FindBy(xpath="//*[@id=\"login-submit-btn\"]")
		static
		WebElement loginBtn;
		
		@FindBy(xpath="/html/body/app-root/app-reports/app-header-component/div/div[1]/div[1]/img")
		WebElement pannaLogo;
		
		public static
		@FindBy(xpath="/html/body/app-root/app-reports/app-header-component/div/div[1]/div[1]/img")
		WebElement authorityDropdown;
		
		public login_Page(){
			PageFactory.initElements(driver, this);
			System.out.println("driver "+TestBase.driver);
		}
		
		public static void login(String un, String pwd){
			username.sendKeys(un);
			System.out.println("entered username:" +un);
			password.sendKeys(pwd);
			System.out.println("entered pwd:" +pwd);
			loginBtn.click();
			    
		}
		
		public boolean validateCRMImage(){
			return pannaLogo.isDisplayed();
		}
		
		public static void adminViaDropDown(int index) {
		      Select drop = new Select(authorityDropdown);
		      drop.selectByIndex(index);  
		}
		
		public static void buttonClick (By path) {
			driver.findElement(path).click(); 
		}
		
		public static void SendText (By path, String keys) {
			driver.findElement(path).sendKeys(keys);
		}
		
		

}
