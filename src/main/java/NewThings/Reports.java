package NewThings;

import org.openqa.selenium.By;

public class Reports extends initialise {
	
	public static void LoginPage(String un, String pwd) throws InterruptedException {
		driver.findElement(By.id("yourEmail")).sendKeys(un);
		driver.findElement(By.id("yourPwd")).sendKeys(pwd);
		driver.findElement(By.id("login-submit-btn")).click();
		Thread.sleep(1000);
	}

}
