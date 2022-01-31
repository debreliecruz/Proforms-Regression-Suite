package UnitTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PublishCompletedReport_RHS_Level3 extends UserdefinedFunctions {
	@BeforeTest
	public void InvokeBrowser() throws IOException, InterruptedException {
	invokeChromeBrowser("chrome");
	System.out.println("Chrome Browser invoked successfully");
	}
		
	@Test(priority = 7)
	public void PublishCompReport_RHSLevel3() throws IOException, InterruptedException {
		ConfigFileReader();
		String loginFlag = obj.getProperty("loginwithGoogle");
		System.out.println(loginFlag);
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
//Start creating report Level 2 with Valudation
	createRHSLevelThree();
//Click Download Draft Report
		clickPublishButton();
//Click Generate button
		//clickGenerateButton();
		//Click Publish Report button
				clickPublishReportButton();
//Click Download Report button
		DownloadCompletedButton();
//Check that Completed Report opens on a new tab
	//	checkCompletedReportOpensOnNewTabLevel3();
//Rename the downloaded completed report
		renameActualReportLvl3();
		Thread.sleep(3000);
//Compare expected Draft and actual Draft reports
		compareCompletedReportsLvl3();
		Thread.sleep(3000);	
	}
@AfterTest
public void closeBrowser() {
   	
	driver.quit();


}
}
