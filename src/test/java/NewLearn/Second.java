package NewLearn;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import org.testng.annotations.Test;

public class Second {

	public WebDriver driver;
	String Loginurl = "https://panna-play.mroads.com/panna/#/login";
	String unmae = "sandeep@mroads.com";
	String pwd = "mroads123";
  @Test

  public void f() throws InterruptedException {

	  System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().fullscreen();
		  
			driver.get(Loginurl);
			Thread.sleep(3000);
			
			 WebElement userEmail=driver.findElement(By.id("yourEmail"));
		      userEmail.sendKeys(unmae);
		      
		      WebElement userPwd=driver.findElement(By.id("yourPwd"));
		      userPwd.sendKeys(pwd);
		      
		      WebElement button =  driver.findElement(By.id("login-submit-btn"));
		      
		      

      Assert.assertTrue(button.isDisplayed());

      //My Account will be clicked only if the above condition is true

      button.click();
      
      Thread.sleep(3000);
      
      driver.quit();

  }

}