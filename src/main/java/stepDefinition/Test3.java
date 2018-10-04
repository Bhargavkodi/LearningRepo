package stepDefinition;

import com.learning.base.TestBase;
import com.learning.pages.login_Page;
import org.apache.log4j.Logger;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Test3 extends TestBase {
	String Loginurl = "https://panna-play.mroads.com/panna/#/login";
	String Homeurl = "https://panna-play.mroads.com/panna/#/reports";
	Logger log = Logger.getLogger(Test3.class.getName());
	login_Page l;

	@Given("^User is on Home Page$")
	public void user_is_on_Home_Page() throws Throwable {
		TestBase.initialization();
		l = new login_Page();
		log.info("Successfully done with browser intialisation");
	}

	@When("^User Navigate to LogIn Page$")
	public void user_Navigate_to_LogIn_Page() throws Throwable {
		driver.get(Loginurl);
		Thread.sleep(4000);
	}

	@When("^User enters UserName and Password$")
	public void user_enters_UserName_and_Password() throws Throwable {
		l.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Successfully done with login to application");
		Thread.sleep(2000);
		// l.login();
	}

	@Then("^Message displayed Login Successfully$")
	public void message_displayed_Login_Successfully() throws Throwable {
		driver.get(Homeurl);
		boolean flag = l.validateCRMImage();
		Assert.assertTrue(flag);
		log.info("Verifying the flag status is:"  +flag);
		System.out.println(flag);
	}

	@When("^User LogOut from the Application$")
	public void user_LogOut_from_the_Application() throws Throwable {
		System.out.println("Login Successfully");
	}

	@Then("^Message displayed LogOut Successfully$")
	public void message_displayed_Logout_Successfully() throws Throwable {
		driver.quit();
		System.out.println("LogOut Successfully");
	}

}
