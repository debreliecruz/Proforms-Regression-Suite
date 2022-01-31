package UnitTest;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CommonFunctions {
	public String baseUrl = "https://proforms-sat.azurewebsites.net/";
	String driverPath ="C:\\Selenium\\chromedriver_win32\\chromedriver.exe";
	public static WebDriver driver;
	public Properties obj;
	String propertyFilePath = System.getProperty("user.dir")+"\\src\\test\\resources\\ObjectRepository\\projectConfig.properties";
	String defaultDirectory = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";
	BufferedReader reader;
	
	public void invokeChromeBrowser(String browsername) throws IOException,InterruptedException
	 {
	//Invoke browser
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\driver\\chromedriver");
	ChromeOptions opt = new ChromeOptions();
	opt.setBinary("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe");
	opt.addArguments("--no-sandbox");
	opt.addArguments("enable-automation");
	opt.addArguments("--disable-infobars");
	opt.addArguments("--disable-features=VizDisplayCompositor");
	opt.addArguments("--disable-dev-shm-usage"); 
	opt.addArguments("--disable-browser-side-navigation"); 
	opt.addArguments("--disable-gpu");
	opt.addArguments("start-maximized");
	opt.addArguments("--disable-web-security");
	opt.addArguments("--no-proxy-server");
	opt.addArguments("enable-cookies");
	
	Map<String, Object> prefs = new HashMap<String, Object>();
	prefs.put("credentials_enable_service", false);
	prefs.put("profile.password_manager_enabled", false);
	prefs.put("plugins.always_open_pdf_externally", true);
	prefs.put("download.default_directory", defaultDirectory);
	opt.setExperimentalOption("prefs", prefs);
	opt.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
	opt.setExperimentalOption("useAutomationExtension", false);
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(opt);
	driver.manage().deleteAllCookies();
	driver.get(baseUrl);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	
	 }
	
	public void ConfigFileReader(){
		
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			obj = new Properties();
			
			try {
				obj.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	}
	}
	
	public void googleLogin() throws IOException {
		clickOnElement("xpathKey_loginPage");
		SendKeysbyname("nameKey_userName_loginGoogle", "data_userName_loginGoogle");
		clickOnElement("xpathKey_googlePage");
		SendKeysbyclassname("classnameKey_password_loginGoogle", "data_password_loginGoogle");
		clickOnElement("xpathKey_googlePage");
		System.out.println("User successfully signed into Google Account");
		clickOnElement("xpathKey_loginPage");
		System.out.println("Homepage is loaded successfully with Google Login");
		
			
	}	
	
	public void RICSLogin() throws IOException, InterruptedException {
	
		clickOnElementJS("xpath_loginRICSAlt");
		SendKeysbyxpath("xpath_RICSEmail", "data_userName_loginRICSMC");
		SendKeysbyxpath("xpath_RICSPassword", "data_password_loginRICSMC");
		clickOnElementJS("xpath_LogIn_button");
		System.out.println("Homepage is loaded successfully with RICS Login");
		Thread.sleep(20000);
		
		
		
		
	}
	
	

	
	
	
	
	public void OpenApp(String websiteURLKey) {
		driver.get(websiteURLKey);
	}

	public WebElement element(String xpathKey) {
		WebElement element = driver.findElement(By.xpath(obj.getProperty(xpathKey)));
		return element;
		}
	
	public void clickOnElement(String xpathKey) {
		WebDriverWait wait = new WebDriverWait(driver,50);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty(xpathKey))));
		driver.findElement(By.xpath(obj.getProperty(xpathKey))).click();
	}
	
	public void clickOnElementByID(String idKey) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.id(obj.getProperty(idKey))));
		driver.findElement(By.id(obj.getProperty(idKey))).click();
	}
	
	public void clickOnElementJS(String xpathKey) {
		WebDriverWait wait = new WebDriverWait(driver,90);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty(xpathKey))));
		executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(obj.getProperty(xpathKey))));
	}
	
	public void ActionOnElement(String xpathKey) {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath(obj.getProperty(xpathKey)))).click().build().perform();
	}
	
		public void ScrollDown(String xpathKey) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(obj.getProperty(xpathKey))));
			
		}
		public void GetNewWindow(WebDriver driver) {
			
			for (String windowName : driver.getWindowHandles()) {
				   driver.switchTo().window(windowName);
			   		} 
		}
		
public void SendKeysbyxpath(String xpathKey, String data) {
			
	driver.findElement(By.xpath(obj.getProperty(xpathKey))).sendKeys(obj.getProperty(data));
		}
public void SendKeys(String xpathKey, String data) {
	
	driver.findElement(By.xpath(obj.getProperty(xpathKey))).sendKeys(data);
		}
public void SendKeysbyname(String nameKey, String data) {
	
	driver.findElement(By.name(obj.getProperty(nameKey))).sendKeys(obj.getProperty(data));
	
	}
public void SendKeysbyId(String idKey, String data) {
	
	driver.findElement(By.id(obj.getProperty(idKey))).sendKeys(obj.getProperty(data));
	
	}



public void SendKeysbyclassname(String classnameKey, String data) {
	
	driver.findElement(By.name(obj.getProperty(classnameKey))).sendKeys(obj.getProperty(data));
}


public void clickOnElementJS2(String xpath) {
	WebDriverWait wait = new WebDriverWait(driver,90);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty(xpath))));
	executor.executeScript("arguments[0].click()", driver.findElement(By.xpath(obj.getProperty(xpath))));

}

public WebElement element2(String xpath) {
	WebElement element = driver.findElement(By.xpath(obj.getProperty(xpath)));
	return element;
	}

public void clickOnElement2(String xpath) {
	WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath(obj.getProperty(xpath))));
	driver.findElement(By.xpath(obj.getProperty(xpath))).click();
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
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id(obj.getProperty(idKey))));
}
public void WaitForElementExistXpath (String xpath) {
	WebDriverWait wait = new WebDriverWait(driver,50);
	wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(obj.getProperty(xpath))));
}
public boolean isDisplayed(String xpath) {
	boolean eleSelected = driver.findElement(By.xpath(obj.getProperty(xpath))).isDisplayed();
	return eleSelected;
}
public void ScrollIntoView(String xpath) {
	JavascriptExecutor executor = (JavascriptExecutor) driver;
	executor.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(obj.getProperty(xpath))));    
}

public void SendKeysAction(String xpath, String data) {
	Actions action =new Actions(driver);
	driver.findElement(By.xpath(obj.getProperty(xpath))).sendKeys(data);
	action.sendKeys(Keys.RETURN);
}
//To capture the screenshot  
public void Takescreenshot(String SS_name) throws IOException {
File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
// paste the screenshot in the desired location  
String screenshotsDir = System.getProperty("user.dir")+"\\src\\test\\resources\\screenshots\\";
FileUtils.copyFile(scrFile, new File(screenshotsDir + SS_name)); 

}  


}