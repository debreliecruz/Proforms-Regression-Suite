package UnitTest;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateDraftReport_RHS_Level3 extends UserdefinedFunctions {

@BeforeTest
public void InvokeBrowser() throws IOException, InterruptedException {
invokeChromeBrowser("chrome");
System.out.println("Chrome Browser invoked successfully");
}
	
@Test(priority = 4)
	
public void CreateDraftReport_RHS_Lev3() throws IOException, InterruptedException {
//Read projectConfig.properties file		
	ConfigFileReader();
//Login via RICS
	RICSLogin();
//Click New button to create new report	
		clickNewButton();
//Start creating report Level 2 with Valudation
		createRHSLevelThree();
//Click Download Draft Report
	clickDownloadDraftButton();
//Check that Draft Report opens on a new tab
	checkDraftReportOpensOnNewTabLevel3();
//Rename the downloaded draft report
	renameActualDraftLvl3();
	Thread.sleep(3000);
//Compare expected Draft and actual Draft reports
	compareDraftReportsLvl3();
	Thread.sleep(3000);
}
	@AfterTest
    public void closeBrowser() {
       	
		driver.quit();
	
	
	}
	
	
	
	
	
	
}
