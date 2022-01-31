package UnitTest;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctionsXpathOnly {

	public String baseUrl = "https://proforms-sit.azurewebsites.net/";
	String driverPath ="C:\\Program Files\\selenium\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	public Properties obj;
	
	public void invokeChromeBrowser(String browsername) throws IOException,InterruptedException
	 {
		//Invoke browser
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
		opt.addArguments("--no-sandbox");
		opt.addArguments("start-maximized");
		
		opt.addArguments("--disable-web-security");
		opt.addArguments("--no-proxy-server");
		opt.addArguments("enable-cookies");

		Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
		prefs.put("profile.password_manager_enabled", false);

		opt.setExperimentalOption("prefs", prefs);
		
		opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
		opt.setExperimentalOption("useAutomationExtension", false);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(opt);
		//driver.manage().deleteAllCookies();
		
		
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	// Specify the file location
		
	//File src=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\ObjectRepository\\projectConfig.properties");
	
	// Create Properties class object to read properties file
	//if (obj == null) {
	//obj=new Properties();
	// Create FileInputStream object
	//FileInputStream objfile=new FileInputStream(src);
	// Load file so we can use into our script
	//obj.load(objfile);

	//System.out.println("Property class loaded");
	//}
	}
	
	public void OpenApp(String websiteURLKey) {
		driver.get(websiteURLKey);
	}

	public WebElement element(String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		return element;
	}
	
	public WebElement elementByID(String id) {
		WebElement element = driver.findElement(By.id(id));
		return element;
	}
	
	public void clickOnElement(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		driver.findElement(By.xpath(xpath)).click();
	}
	
	public void clickOnElementByID(String id) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(id)));
		driver.findElement(By.id(id)).click();
	}
	
	public void clickOnElementJS(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver,90);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(xpath)));
	}
	
	public void ActionOnElement(String xpath) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(xpath))).click().build().perform();
	}
	
		public void ScrollDown(String xpath) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpath)));
			
		}
		
		public void ScrollUp() {
			JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
			jsExecuter.executeScript("window.scrollTo(0,document.body.scrollTop)");
		}
		
		public void ScrollList(String xpath) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(xpath)));
			
		}
		public void GetNewWindow(WebDriver driver) {
			
			for (String windowName : driver.getWindowHandles()) {
				   driver.switchTo().window(windowName);
			   		} 
		}
		
		public void ActionOnList(String xpath) {
			WebElement menuItem = driver.findElement(By.xpath(xpath));
			Actions action = new Actions(driver);
			action.moveToElement(menuItem);
			action.perform();
			menuItem.click();
		}
		
public void SendKeys(String xpath, String data) {
			
	driver.findElement(By.xpath(xpath)).sendKeys(data);
		}
public void ScrollDown2(String xpath) {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpath)));
	
}
public void DriverQuit(WebDriver driver) {
	
	driver.quit();

}

public void WaitForElementExistID (String idKey) {
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id(idKey)));
}
public void WaitForElementExistXpath (String xpath) {
	WebDriverWait wait = new WebDriverWait(driver,30);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
}
}