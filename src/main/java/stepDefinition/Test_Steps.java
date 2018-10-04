//package stepDefinition;
//
//import java.util.concurrent.TimeUnit;
//
//import org.apache.log4j.Logger;
//import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//import com.beginningdeveloper.maven.NewProject.Login;
//
////import com.mroads.verify.One;
//
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//
//public class Test_Steps {
//	static ChromeDriver driver;
//	String Homeurl = "https://panya.mroads.com";
//	String Loginurl = "https://panna-play.mroads.com/panna/#/login";
//	String customPrepare = "https://panna-play.mroads.com/panna/#/on-demand-interview";
//	//String unmae = "sandeep@mroads.com";
//	//String pwd = "Test@123";
//	Logger log = Logger.getLogger(Test_Steps.class.getName());
//	Login l = new Login(driver);
//	
//	@Given("^User is on Home Page$")
//	public void user_is_on_Home_Page() throws Throwable {
//		System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
//		driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		driver.manage().window().fullscreen();
//        driver.get(Homeurl);
//        Thread.sleep(4000);
//		}
//
//	@When("^User Navigate to LogIn Page$")
//	public void user_Navigate_to_LogIn_Page() throws Throwable {
//		driver.get(Loginurl);
//		Thread.sleep(4000);
//		}
// 
//	@When("^User enters UserName and Password$")
//	public void user_enters_UserName_and_Password() throws Throwable {
//		l.loginPanna("sandeep@mroads.com","mRoads@123");
////		driver.findElement(By.id("yourEmail")).sendKeys(unmae); 	 
////		log.info("entered username");
////	    driver.findElement(By.id("yourPwd")).sendKeys(pwd);
////	    driver.findElement(By.id("login-submit-btn")).click();
//		}
//	
////	@When("^User enters \"(.*)\" and \"(.*)\"$")
////	public void user_enters_UserName_and_Password(String username, String password) throws Throwable {
////		driver.findElement(By.id("yourEmail")).sendKeys(unmae); 	 
////	    driver.findElement(By.id("yourPwd")).sendKeys(pwd);
////	    driver.findElement(By.id("login-submit-btn")).click();
////		}
//	
// 
//	@Then("^Message displayed Login Successfully$")
//	public void message_displayed_Login_Successfully() throws Throwable {
//		System.out.println("Login Successfully");
//		Thread.sleep(2000);
//	}
// 
//	@When("^User LogOut from the Application$")
//	public void user_LogOut_from_the_Application() throws Throwable {
//		driver.get(customPrepare);
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("/html/body/app-root/app-one-way-interview/div/div/div/div[2]/div[2]/span")).click();
//	}
// 
//	@Then("^Message displayed LogOut Successfully$")
//	public void message_displayed_Logout_Successfully() throws Throwable {
//        driver.quit();
//		System.out.println("LogOut Successfully");
//	}
//}
