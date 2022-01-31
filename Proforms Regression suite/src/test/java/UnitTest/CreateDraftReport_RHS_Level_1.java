package UnitTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateDraftReport_RHS_Level_1 extends UserdefinedFunctions {

@BeforeTest
public void InvokeBrowser() throws IOException, InterruptedException {
invokeChromeBrowser("chrome");
System.out.println("Chrome Browser invoked successfully");
}
	
@Test(priority = 1)
	
public void CreateDraftReport_RHSLevel1() throws IOException, InterruptedException {
		ConfigFileReader();
	//	String loginFlag = obj.getProperty("loginwithGoogle");
		
	/*
		//	if (loginFlag == "Yes")
		{
			googleLogin();
		}
	/*	else
		{
			RICSLogin();
		} */
//Login with RICS
		RICSLogin();
//Click New button to create new report	
		clickNewButton();
//Start creating report Level 1
		createRHSLevelOne();
//Click Download Draft Report
		clickDownloadDraftButton();
//Check that Draft Report opens on a new tab
		checkDraftReportOpensOnNewTabLevel1();
//Rename the downloaded draft report
		renameActualDraftLvl1();
		Thread.sleep(3000);
//Compare expected Draft and actual Draft reports
		compareDraftReportsLvl1();
		Thread.sleep(3000);	
	}
@AfterTest
public void closeBrowser() {
   	
driver.quit();


}
}
		
	
	
	