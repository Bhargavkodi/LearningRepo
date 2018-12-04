package NewThings;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.sun.glass.events.KeyEvent;

public class initialise {

	public static WebDriver driver;
	public static Properties prop;
	static Logger log = Logger.getLogger(initialise.class.getName());

	static {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"/Users/ethirajp/eclipse-workspace1/NewProject/src/main/java/com/learning/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Launching Browser
	public static void browserLaunch() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/ethirajp/Desktop/chromedriver");
			driver = new ChromeDriver();
			log.info(browserName);
		} else if (browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/ethirajp/Desktop/geckodriver");
			driver = new FirefoxDriver();
			log.info("FireFox");
		}
		driver.manage().window().fullscreen();
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String BrowserName = cap.getBrowserName().toLowerCase();
		log.info("Opened Browser  ----> " + BrowserName);
		String os = cap.getPlatform().toString();
		log.info("System OS  ----> " + os);
		String ver = cap.getVersion().toString();
		log.info("Browser version is  ----> " + ver);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Integer.valueOf(prop.getProperty("PAGE_LOAD_TIMEOUT")),
				TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Integer.valueOf(prop.getProperty("IMPLICIT_WAIT")), TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));

	}

	// Button click Action
	public static void buttonClick(By path) {
		driver.findElement(path).click();
		log.info("Success in clicking button "+path);
	}

	// Send Text Action
	public static void SendText(By path, String keys) {
		driver.findElement(path).sendKeys(keys);
		log.info("Success in finding path  "+path+"  and sending info "+keys);
	}

	// Gmail Login Action
	public static void gmail_Login() throws InterruptedException {

		try {
			driver.get("https://www.gmail.com");
			log.info("Success in landing gmail LOGIN page");
			driver.findElement(By.id("identifierId")).sendKeys(prop.getProperty("Gmail"));
			Thread.sleep(1000);
			log.info("Success in entering the username");
			driver.findElement(By.id("identifierNext")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys(prop.getProperty("gmailPwd"));
			Thread.sleep(1000);
			log.info("Success in entering the password");
			driver.findElement(By.id("passwordNext")).click();
			Thread.sleep(3000);
			log.info("Successfully logged IN");

		} catch (Exception e) {
			driver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).sendKeys("gaurav14");
			Thread.sleep(1000);
			driver.findElement(By.id("passwordNext")).click();
		}
	}

	//TAB button Action
	public static void TAB_button() {
		Actions builder = new Actions(driver);
		builder.sendKeys(Keys.TAB).perform();
		Action submitTheTransperentButton = builder.build();
		submitTheTransperentButton.perform();
	}

	//Scroll down the page
	public static void SCROLLDOWN(int scrollValue) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0, " + scrollValue + ")", "");
	}

	//Scroll Up the page
	public static void SCROLLUP(int scrollValue) {
		JavascriptExecutor javascript = (JavascriptExecutor) driver;
		javascript.executeScript("window.scrollBy(0, -(" + scrollValue + "))", "");
	}
	
	// Upload a file from button Action
	public static void UploadButton(String path) throws AWTException, InterruptedException {
		StringSelection File = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(File, null);
		Robot Keyboard = new Robot();
		
		Thread.sleep(1000);
		
		Keyboard.keyPress(KeyEvent.VK_CONTROL);
		Keyboard.keyPress(KeyEvent.VK_V);
		
		Thread.sleep(1000);
		
		Keyboard.keyRelease(KeyEvent.VK_CONTROL);
		Keyboard.keyRelease(KeyEvent.VK_V);
		
		Thread.sleep(1000);
		
		Keyboard.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(1000);
		
		Keyboard.keyRelease(KeyEvent.VK_ENTER);

	}
	public static void Login(String un, String pwd) throws InterruptedException {
		driver.findElement(By.id("yourEmail")).sendKeys(un);
		driver.findElement(By.id("yourPwd")).sendKeys(pwd);
		driver.findElement(By.id("login-submit-btn")).click();
		Thread.sleep(1000);
	}
	
	//switch between tabs
	public static void HandleTabs(String tab) throws InterruptedException {
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

		int tabNumber = Integer.parseInt(tab);

		log.info("Swithing to tab:-----> " + tabNumber);

		driver.switchTo().window(tabs.get(tabNumber));

		Thread.sleep(1000);
	}
	
}
