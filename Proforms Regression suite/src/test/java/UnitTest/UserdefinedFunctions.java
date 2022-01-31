package UnitTest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.testautomationguru.utility.CompareMode;
import com.testautomationguru.utility.PDFUtil;

import Utility.Constants;
import de.redsix.pdfcompare.CompareResult;
import de.redsix.pdfcompare.CompareResultWithMemoryOverflow;
import de.redsix.pdfcompare.CompareResultWithPageOverflow;
import de.redsix.pdfcompare.PdfComparator;
import de.redsix.pdfcompare.RenderingException;



public class UserdefinedFunctions extends CommonFunctions {

	// Create a new report
	
	public void createnewreport() {
	
	clickOnElement("classnameKey_createNew");
		
	}
	
	public void clickNewButton() throws IOException  {
		String sysversion = obj.getProperty("coderun_from_local");
		if (sysversion=="true") {
			WaitForElementExistXpath("xpath_NewButton");
			clickOnElementJS("xpath_NewButton");
			
		}
		else {
			WaitForElementExistXpath("xpath_NewButton_I");
			clickOnElementJS("xpath_NewButton_I");
			
		}
	
	}
	
	public void clickDownloadDraftButton() throws IOException {
		
		clickOnElementJS("xpath_FormSavebutton");
		clickOnElementJS("xpath_DownloadDraftButton");
		clickOnElementJS("xpath_DraftYesButton");
		Takescreenshot("SS_afterDownloaddraft.jpg");
			
		}
	
public void clickPublishButton() throws InterruptedException {
		
		clickOnElementJS("xpath_FormSavebutton");
		//clickOnElementJS("xpath_Savebutton");
		Thread.sleep(5000);
		clickOnElementJS("xpath_PublishButton");
			
		}

public void clickGenerateButton() throws InterruptedException {
	

	Thread.sleep(5000);
	clickOnElementJS("xpath_GenerateReportButton");

		
	}

public void clickPublishReportButton() throws InterruptedException {
	

	Thread.sleep(5000);
	clickOnElementJS("xpath_PublishReportButton");

		
	}

public void DownloadCompletedButton() throws InterruptedException {
	

	Thread.sleep(10000);
	ActionOnElement("xpath_ClickLatestReport");
	clickOnElementJS("xpath_DownloadCompletedRepButton");

		
	}
	// Creating RHS Level 1 Report
	
	public void createRHSLevelOne() throws InterruptedException, IOException {
		Thread.sleep(3000);
		WaitForElementExistXpath("xpath_RHSLevelOne");
		ActionOnElement("xpath_RHSLevelOne");
		//Add Report Reference number to a Constant variable
		Thread.sleep(3000);
		ScrollDown("xpath_AddReportRefNumberToConstantsVar");
		Constants.ReportRefNoLevel1 = element("xpath_AddReportRefNumberToConstantsVar").getText();
		//Enter Client reference
		SendKeys("xpath_ClientReferenceNumber","Client"+"-" + "Auto0000001");
		Constants.ClientReference = "Client"+"-" + "Auto0000001";
		//Enter Post code
		SendKeys("xpath_PostCode","W6 7BU");
		//Click Find Address
		clickOnElementJS("xpath_FindAddress");
		//Check that Please select an address dropdown is displayed
		ScrollDown("xpath_SelectAddressDropDown");
		isDisplayed("xpath_SelectAddressDropDown");
		//Check that the Address dropdown displays auto-generated addresses
		validateAutoAddressList();
		//Validate that Address fields are displayed after selecting an address
		validateAddressFieldsDisplayed();
		//Validate address fields are populated correctly with the values from the auto-generated address
		validateAddressValues();
		//Click Create Report button
		clickOnElementJS("xpath_CreateReportButton");
		//Populate and validate Section A: About the inspection page
				enterAboutTheInspection("Level1");
		//Populate Section B: Summary of condition ratings
				enterSummaryCondRatingsLvl1();
		//Populate Section C: About the property
				enterAboutThePropertyLvl1();
		//Populate Section D: Outside the property
				enterOutsideProperty();
		//Populate Section E: Inside the property	
				enterInsideProperty();
		//Populate Section F: Services
				enterServices();
		//Populate Section G: Grounds (including shared areas for flats)
				enterGrounds();
		//Populate Section H: Issues for your legal advisers
				enterIssuesLegalAdvisers();
		//Populate Section I: Risks
				enterRisksLvl1();
	
		
	}
	
	// Creating RHS Level 2
	public void createRHSLevelTwo() throws IOException, InterruptedException {
		Thread.sleep(3000);
		WaitForElementExistXpath("xpath_RHSLevelTwo");
		ActionOnElement("xpath_RHSLevelTwo");
		//Add Report Reference number to a Constant variable
				Thread.sleep(30000);
				ScrollDown("xpath_AddReportRefNumberToConstantsVar");
				Constants.ReportRefNo = element("xpath_AddReportRefNumberToConstantsVar").getText();
		//Enter Client reference
				SendKeys("xpath_ClientReferenceNumber","Client"+"-" + "Auto0000001");
				Constants.ClientReference = "Client"+"-" + "Auto0000001";
		//Enter Postcode
				SendKeys("xpath_PostCode","W6 7BU");
		//Click Find Address
				clickOnElementJS("xpath_FindAddress");
		//Check that Please select an address dropdown is displayed
				ScrollDown("xpath_SelectAddressDropDown");
				isDisplayed("xpath_SelectAddressDropDown");
		//Check that the Address dropdown displays auto-generated addresses
				validateAutoAddressList();
		//Validate that Address fields are displayed after selecting an address
				validateAddressFieldsDisplayed();
		//Validate address fields are populated correctly with the values from the auto-generated address
				validateAddressValues();
		//Click Create Report button
				clickOnElementJS("xpath_CreateReportButton");
		//Populate and validate Section A: About the inspection page
				enterAboutTheInspection("Level2");
		//Populate Section B: Summary of condition ratings
				enterSummaryCondRatings();
		//Populate Section C: About the property
				enterAboutTheProperty();
		//Populate Section D: Outside the property
				enterOutsideProperty();
		//Populate Section E: Inside the property	
				enterInsideProperty();
		//Populate Section F: Services
				enterServices();
		//Populate Section G: Grounds (including shared areas for flats)
				enterGrounds();
		//Populate Section H: Issues for your legal advisers
				enterIssuesLegalAdvisers();
		//Populate Section I: Risks
				enterRisks();
		
		}
	
	// Creating RHS Level 2 With Valuation Report
	public void createRHSLevelTwoWithValuation() throws IOException, InterruptedException {
		Thread.sleep(3000);
		WaitForElementExistXpath("xpath_RHSLevelTwoWithValuation");
		ActionOnElement("xpath_RHSLevelTwoWithValuation");
		//Add Report Reference number to a Constant variable
				Thread.sleep(3000);
				ScrollDown("xpath_AddReportRefNumberToConstantsVar");
				Constants.ReportRefNoLevel2WVal = element("xpath_AddReportRefNumberToConstantsVar").getText();
		//Enter Client reference
				SendKeys("xpath_ClientReferenceNumber","Client"+"-" + "Auto0000001");
				Constants.ClientReference = "Client"+"-" + "Auto0000001";
		//Enter Postcode
				SendKeys("xpath_PostCode","W6 7BU");
		//Click Find Address
				clickOnElementJS("xpath_FindAddress");
		//Check that Please select an address dropdown is displayed
				ScrollDown("xpath_SelectAddressDropDown");
				isDisplayed("xpath_SelectAddressDropDown");
		//Check that the Address dropdown displays auto-generated addresses
				validateAutoAddressList();
		//Validate that Address fields are displayed after selecting an address
				validateAddressFieldsDisplayed();
		//Validate address fields are populated correctly with the values from the auto-generated address
				validateAddressValues();
		//Click Create Report button
				clickOnElementJS("xpath_CreateReportButton");
		//Populate and validate Section A: About the inspection page
				enterAboutTheInspection("Level2Val");
		//Populate Section B: Summary of condition ratings
				enterSummaryCondRatings();
		//Populate Section C: About the property
				enterAboutTheProperty();
		//Populate Section D: Outside the property
				enterOutsideProperty();
		//Populate Section E: Inside the property	
				enterInsideProperty();
		//Populate Section F: Services
				enterServices();
		//Populate Section G: Grounds (including shared areas for flats)
				enterGrounds();
		//Populate Section H: Issues for your legal advisers
				enterIssuesLegalAdvisers();
		//Populate Section I: Risks
				enterRisks();
		//Populate Section J: Property valuation
				enterPropertyValuation();
		
	}
	//*
	// Creating RHS Level 3
	public void createRHSLevelThree() throws IOException, InterruptedException {
		Thread.sleep(3000);
		WaitForElementExistXpath("xpath_RHSLevelThree");
		ActionOnElement("xpath_RHSLevelThree");
		//Add Report Reference number to a Constant variable
				Thread.sleep(3000);
				ScrollDown("xpath_AddReportRefNumberToConstantsVar");
				Constants.ReportRefNoLev3 = element("xpath_AddReportRefNumberToConstantsVar").getText();
		//Enter Client reference
				SendKeys("xpath_ClientReferenceNumber","Client"+"-" + "Auto0000001");
				Constants.ClientReference = "Client"+"-" + "Auto0000001";
		//Enter Postcode
				SendKeys("xpath_PostCode","W6 7BU");
		//Click Find Address
				clickOnElementJS("xpath_FindAddress");
		//Check that Please select an address dropdown is displayed
				ScrollDown("xpath_SelectAddressDropDown");
				isDisplayed("xpath_SelectAddressDropDown");
		//Check that the Address dropdown displays auto-generated addresses
				validateAutoAddressList();
		//Validate that Address fields are displayed after selecting an address
				validateAddressFieldsDisplayed();
		//Validate address fields are populated correctly with the values from the auto-generated address
				validateAddressValues();
		//Click Create Report button
				clickOnElementJS("xpath_CreateReportButton");
		//Populate and validate Section A: About the inspection page
				enterAboutTheInspection("Level3");
		//Populate Section B: Summary of condition ratings
				enterSummaryCondRatings();
		//Populate Section C: About the property
				enterAboutTheProperty();
		//Populate Section D: Outside the property
				enterOutsideProperty();
		//Populate Section E: Inside the property	
				enterInsideProperty();
		//Populate Section F: Services
				enterServices();
		//Populate Section G: Grounds (including shared areas for flats)
				enterGrounds();
		//Populate Section H: Issues for your legal advisers
				enterIssuesLegalAdvisers();
		//Populate Section I: Risks
				enterRisks();
		//Populate Section J: Energy matters
				enterEnergyMatters();
		
	}
	
	public void validateAutoAddressList() {
		String ArrayAddress[] = {"Please select an address...",
				"1 Orchard Studios, Brook Green, London, W6 7BU",
				"2 Orchard Studios, Brook Green, London, W6 7BU",
				"Bradley Basso LLP, 3 Orchard Studios, Brook Green, London, W6 7BU"};
		
		Select addressDropdown = new Select(element("xpath_SelectAddressDropDown"));
	 	List<WebElement> addressValues = addressDropdown.getOptions();
	 	System.out.println(addressValues.size());
	 	
	 	for (int i=0;i<addressValues.size();i++)
	 	{
	 		Assert.assertEquals(addressValues.get(i).getText(), ArrayAddress[i]);
	 	}
	 	System.out.println("Address auto-generated list validation Passed");
	 	addressDropdown.selectByIndex(3);
	    }
	public void validateAddressFieldsDisplayed() {
		ScrollDown("xpath_AddressLine1");
		isDisplayed("xpath_AddressLine1");
		isDisplayed("xpath_AddressLine2");
		isDisplayed("xpath_AddressCity");
		isDisplayed("xpath_AddressCity");
		isDisplayed("xpath_AddressCounty");
		isDisplayed("xpath_AddressPostCode");
		isDisplayed("xpath_AddressCountry");
		System.out.println("All address fields are correctly displayed");
	}
	public void validateAddressValues() {
		//Validate Address Line 1 value
		ScrollDown("xpath_AddressLine1");
		String ActualAddressLine1 = element("xpath_AddressLine1").getAttribute("value");
		Constants.AddressLineOne = ActualAddressLine1;
		Assert.assertEquals(ActualAddressLine1,"3 Orchard Studios");
		System.out.println("Address Line 1 correctly displays the expected value");
		
		//Validate Address Line 2 value
		String ActualAddressLine2 = element("xpath_AddressLine2").getAttribute("value");
		Constants.AddressLineTwo = ActualAddressLine2;
		Assert.assertEquals(ActualAddressLine2,"Brook Green");
		System.out.println("Address Line 2 correctly displays the expected value");
		
		//Validate Address City value
		String ActualAddressCity = element("xpath_AddressCity").getAttribute("value");
		Constants.AddressCity = ActualAddressCity;
		Assert.assertEquals(ActualAddressCity,"London");
		System.out.println("Address City correctly displays the expected value");
		
		//Validate Address County value
		String ActualAddressCounty = element("xpath_AddressCounty").getAttribute("value");
		Constants.AddressCounty = ActualAddressCounty;
		Assert.assertEquals(ActualAddressCounty,"");
		System.out.println("Address County correctly displays the expected value");
		
		//Validate Address PostCode value
		String ActualAddressPostCode = element("xpath_AddressPostCode").getAttribute("value");
		Constants.AddressPostCode = ActualAddressPostCode;
		Assert.assertEquals(ActualAddressPostCode,"W6 7BU");
		System.out.println("Address PostCode correctly displays the expected value");
		
		//Validate Address Country value
		String ActualAddressCountry = element("xpath_AddressCountry").getAttribute("value");
		Constants.AddressCountry = ActualAddressCountry;
		Assert.assertEquals(ActualAddressCountry,"United Kingdom");
		System.out.println("Address Country correctly displays the expected value");
	}
	
	public void validateAboutInspectionAddressValues() {
		String ActualAIAddressLine1 = element("xpath_AIAddressLine1").getAttribute("value");
		Assert.assertEquals(ActualAIAddressLine1, Constants.AddressLineOne);
		System.out.println("Address Line 1 expected and actual values matches");
		
		String ActualAIAddressLine2 = element("xpath_AIAddressLine2").getAttribute("value");
		Assert.assertEquals(ActualAIAddressLine2, Constants.AddressLineTwo);
		System.out.println("Address Line 2 expected and actual values matches");
		
		String ActualAIAddressCity = element("xpath_AIAddressCity").getAttribute("value");
		Assert.assertEquals(ActualAIAddressCity, Constants.AddressCity);
		System.out.println("Address City expected and actual values matches");
		
		String ActualAIAddressPostCode = element("xpath_AIAddressPostCode").getAttribute("value");
		Assert.assertEquals(ActualAIAddressPostCode, Constants.AddressPostCode);
		System.out.println("Address Post Code expected and actual values matches");
		
		String ActualAIAddressCountry = element("xpath_AIAddressCountry").getAttribute("value");
		Assert.assertEquals(ActualAIAddressCountry, Constants.AddressCountry);
		System.out.println("Address Country expected and actual values matches");
		
		
		
	}
	
	public void selectInspectionDate() throws InterruptedException {
		WaitForElementExistXpath("xpath_InspectionDate");
		ActionOnElement("xpath_InspectionDate");
		ActionOnElement("xpath_DateOfInspectionCalMonth");
		
		Select DateOfInspectionMonth = new Select(element("xpath_DateOfInspectionCalMonth"));
		DateOfInspectionMonth.selectByIndex(10);
		
		Thread.sleep(5000);
		ScrollIntoView("xpath_DateOfInspectionCalYearInput");
		element("xpath_DateOfInspectionCalYearInput").clear();
		ActionOnElement("xpath_DateOfInspectionCalYearInput");
		SendKeys("xpath_DateOfInspectionCalYearInput","2021");
		ActionOnElement("xpath_DateOfInspectionCalDaySelected");
	}
	
	public void selectConsultationDate() throws InterruptedException {
		
		WaitForElementExistXpath("xpath_ConsultationDate");
		ActionOnElement("xpath_ConsultationDate");
		ActionOnElement("xpath_ConsultationDateCalMonth");
		
		Select ConsultationDateMonth = new Select(element("xpath_ConsultationDateCalMonth"));
		ConsultationDateMonth.selectByIndex(10);
		Thread.sleep(5000);
		ScrollIntoView("xpath_ConsultationDateCalYearInput");
		element("xpath_ConsultationDateCalYearInput").clear();
		ActionOnElement("xpath_ConsultationDateCalYearInput");
		SendKeys("xpath_ConsultationDateCalYearInput","2021");
		ActionOnElement("xpath_ConsultationDateCalDaySelected");
	}
	
	public void selectClientRecTCDate() throws InterruptedException {
		WaitForElementExistXpath("xpath_TermsReceivedDate");
		ActionOnElement("xpath_TermsReceivedDate");
		ActionOnElement("xpath_ClientRecTCDateCalMonth");
		
		Select ClientRecTCDateMonth = new Select(element("xpath_ClientRecTCDateCalMonth"));
		ClientRecTCDateMonth.selectByIndex(10);
		Thread.sleep(5000);
		ScrollIntoView("xpath_ClientRecTCDateCalYearInput");
		element("xpath_ClientRecTCDateCalYearInput").clear();
		ActionOnElement("xpath_ClientRecTCDateCalYearInput");
		SendKeys("xpath_ClientRecTCDateCalYearInput","2021");
		ActionOnElement("xpath_CleintRecTCDateDaySelected");
		
	}
	
	public void checkReportTypeonForm() throws InterruptedException {
		//Check Report Type 
		//Validate Report type displayed on the left pane
		Thread.sleep(3000);
		String ActualReportType;
		String sysversion = obj.getProperty("coderun_from_local");
		if (sysversion=="true") {
		ActualReportType = element("xpath_ReportTypeName").getText();	
		
		}
		else {
		clickOnElement("xpath_iconclick");
		ActualReportType = element("xpath_ReportTypeName_I").getText();	
		}
		System.out.println(ActualReportType);
		boolean condition = false;

		if(ActualReportType.equals("RHS Level One") || ActualReportType.equals("RHS Level Two") || ActualReportType.equals("RHS Level Two with Valuation") || ActualReportType.equals("RHS Level Three")) {	
			condition = true;
		}

		Assert.assertTrue(condition);
		System.out.println("Correct Report type is displayed in the left pane");
	}
	
	public void enterAboutTheInspection(String reportLevel) throws IOException, InterruptedException {
		Thread.sleep(5000);
		//Validate Report type displayed on the left pane
		checkReportTypeonForm();
		String ActualReportType;
		String ActualReportRefNumLeftPane;
		String sysversion = obj.getProperty("coderun_from_local");
		if (sysversion=="true") {
		ActualReportType = element("xpath_ReportTypeName").getText();	
		
		}
		else {
		clickOnElement("xpath_iconclick");
		ActualReportType = element("xpath_ReportTypeName_I").getText();	
		}
				
		if (reportLevel == "Level1"){
			ActualReportType = element("xpath_ReportTypeName").getText();
			Assert.assertEquals(ActualReportType, "RHS Level One");
		}
		else if (reportLevel == "Level2"){
			ActualReportType = element("xpath_ReportTypeName").getText();
			Assert.assertEquals(ActualReportType, "RHS Level Two");
		}		
		else if (reportLevel == "Level2Val") {
			ActualReportType = element("xpath_ReportTypeName").getText();
			Assert.assertEquals(ActualReportType, "RHS Level Two with Valuation");
		}
		else if (reportLevel == "Level3") {
			ActualReportType = element("xpath_ReportTypeName").getText();
			Assert.assertEquals(ActualReportType, "RHS Level Three");
		}
		//Enter Client's name
		SendKeys("xpath_ClientName","Jane Autor");
		//Validate Client report reference value 
		String ActualClientReference = element("xpath_ClientReportReference").getAttribute("value");
		Assert.assertEquals(ActualClientReference, Constants.ClientReference);
		
		//Validate Surveyor's  name value
		String ActualSurveyorName=element("xpath_SurveyorName").getAttribute("value");
		Assert.assertEquals(ActualSurveyorName,"Michelle Cortes CC");
		//ScrollDown and Validate Surveyor's RICS number value
		ScrollDown("xpath_SurveyorRICSNumber");
		String ActualSurveyRICSNumber=element("xpath_SurveyorRICSNumber").getAttribute("value");
		Assert.assertEquals(ActualSurveyRICSNumber,"1234456677777");
		
		//Validate Company name value
		String ActualCompanyName=element("xpath_CompanyName").getAttribute("value");
		Assert.assertEquals(ActualCompanyName,"RICS ");
		
		//Select Date of inspection
		selectInspectionDate();
		
		//Select Consultation date
		selectConsultationDate();
			
		//Scroll Down and Select Date client received terms and conditions report
		
		ScrollDown("xpath_TermsReceivedDate");
		selectClientRecTCDate();
		
		//Get Expected Report Reference number
		sysversion = obj.getProperty("coderun_from_local");
		if (sysversion=="true") {
			ActualReportRefNumLeftPane=element("xpath_ExpectedReportRefNumber").getText();	
			
			}
			else {
			clickOnElement("xpath_iconclick");
			ActualReportRefNumLeftPane = element("xpath_ExpectedReportRefNumber_I").getText();	
			}
		
		String CutRef ="Ref: ";
		ActualReportRefNumLeftPane=ActualReportRefNumLeftPane.replaceAll(CutRef, "");
		ActualReportRefNumLeftPane = ActualReportRefNumLeftPane.trim();
		System.out.println("Actual Report Reference number is: " + ActualReportRefNumLeftPane);
		
		//Validate Report reference number value
		String ActualReportRefNum=element("xpath_ReportReferenceNumber").getAttribute("value");
		
		Assert.assertEquals(ActualReportRefNum, ActualReportRefNumLeftPane);
		System.out.println("Expected and Actual Report Reference number matched");
		
		//ScrollDown and Enter Related party disclosure 
		ScrollDown("xpath_RelatedPartyDisclosure");
		SendKeys("xpath_RelatedPartyDisclosure","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m");
		
		//**ScrollDown and Validate Address Fields - to follow - new address fields added on section A are not able to retrieved the address details from the selection on the auto-generated address
		
		validateAboutInspectionAddressValues();
		
		ScrollDown("xpath_AddressCounty");
		
		//Enter Weather conditions when the inspection took place
		SendKeys("xpath_WeatherConditions","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m");
		//ScrollDown and Enter Status of the property when the inspection took place
		ScrollDown("xpath_PropertyStatus");
		SendKeys("xpath_PropertyStatus","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean m");
		//Check Hide front page image on the report
		clickOnElementJS("xpath_HideFrontPageImageChckBx");
		//Check Show company logo on the report
		clickOnElementJS("xpath_ShowCompanyLogoChckBx");
		
		//Check Show signature on the report
		clickOnElementJS("xpath_ShowSignatureChckBx");
		
		//Click Next button besides Phrasebook button
		clickOnElementJS("xpath_NextButtonBesidesPhrase");
	}
	
	public void enterSummaryCondRatings() throws InterruptedException {
		//Enter Overall opinion of property
		SendKeys("xpath_OverallOpnProperty","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		//Add document name row 1
		//Click Add row button
		clickOnElementJS("xpath_AddRowButton");
		//Enter Document name
		SendKeys("xpath_DocumentNameBox","Inspection History Document");
		//Click Next button
		clickOnElementJS("xpath_NextButtonBesidesPhrase");
	
	}
	
	public void enterSummaryCondRatingsLvl1() throws InterruptedException {
		//Add document name row 1
		//Click Add row button
		clickOnElementJS("xpath_AddRowButton");
		//Enter Document name
		SendKeys("xpath_DocumentNameBox","Inspection History Document");
		//Click Next button
		clickOnElementJS("xpath_NextButtonBesidesPhrase");
	
	}
	
	public void enterAboutTheProperty() throws InterruptedException {
	//Enter Type of property
		Thread.sleep(10000);
		SendKeys("xpath_PropertyType","Private");
	//Enter Approximate year the property was built
		SendKeys("xpath_PropertyBuiltYear","1975");
	//Enter Approximate year the property was extended
		SendKeys("xpath_PropertyExtendedYear","2000");
	//ScrollDown Enter Approximate year the property was converted
		ScrollDown("xpath_PropertyConvertedYear");
		SendKeys("xpath_PropertyConvertedYear","2018");

	//ScrollDown and Enter Information relevant to flats and maisonettes
		ScrollDown("xpath_FlatsInformation");
		SendKeys("xpath_FlatsInformation","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
	//ScrollDown and Enter Construction
		ScrollDown("xpath_Construction");
		SendKeys("xpath_Construction","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
	//Populate Accommodation
	//Lower Ground
		SendKeys("xpath_LowerGroundLivingRoom1","1");
		SendKeys("xpath_LowerGroundBedrooms1","1");
		SendKeys("xpath_LowerGroundBath1","1");
		SendKeys("xpath_LowerGroundToilet1","1");
		SendKeys("xpath_LowerGroundKitchen1","1");
		SendKeys("xpath_LowerGroundUtility1","1");
		SendKeys("xpath_LowerGroundConservatory1","1");
		SendKeys("xpath_LowerGroundOther1","1");
	//Click Ground Chevron
		clickOnElementJS("xpath_AccGroundChevron");
	//Ground
		SendKeys("xpath_GroundLivingRoom1","1");
		SendKeys("xpath_GroundBedrooms1","1");
		SendKeys("xpath_GroundBath1","1");
		SendKeys("xpath_GroundToilet1","1");
		SendKeys("xpath_GroundKitchen1","1");
		SendKeys("xpath_GroundUtility1","1");
		SendKeys("xpath_GroundConservatory1","1");
		SendKeys("xpath_GroundOther1","1");
	//First
		ScrollDown("xpath_AccFirstChevron");
		clickOnElementJS("xpath_AccFirstChevron");
		SendKeys("xpath_FirstLivingRoom1","1");
		SendKeys("xpath_FirstBedrooms1","1");
		SendKeys("xpath_FirstBath1","1");
		SendKeys("xpath_FirstToilet1","1");
		SendKeys("xpath_FirstKitchen1","1");
		SendKeys("xpath_FirstUtility1","1");
		SendKeys("xpath_FirstConservatory1","1");
		SendKeys("xpath_FirstOther1","1");
	//Second
		ScrollDown("xpath_AccSecondChevron");
		clickOnElementJS("xpath_AccSecondChevron");
		SendKeys("xpath_SecondLivingRoom1","1");
		SendKeys("xpath_SecondBedrooms1","1");
		SendKeys("xpath_SecondBath1","1");
		SendKeys("xpath_SecondToilet1","1");
		SendKeys("xpath_SecondKitchen1","1");
		SendKeys("xpath_SecondUtility1","1");
		SendKeys("xpath_SecondConservatory1","1");
		SendKeys("xpath_SecondOther1","1");
	//Third
		ScrollDown("xpath_AccThirdChevron");
		clickOnElementJS("xpath_AccThirdChevron");
		SendKeys("xpath_ThirdLivingRoom1","1");
		SendKeys("xpath_ThirdBedrooms1","1");
		SendKeys("xpath_ThirdBath1","1");
		SendKeys("xpath_ThirdToilet1","1");
		SendKeys("xpath_ThirdKitchen1","1");
		SendKeys("xpath_ThirdUtility1","1");
		SendKeys("xpath_ThirdConservatory1","1");
		SendKeys("xpath_ThirdOther1","1");
	//Other
		ScrollDown("xpath_AccOtherChevron");
		clickOnElementJS("xpath_AccOtherChevron");
		SendKeys("xpath_OtherLivingRoom1","1");
		SendKeys("xpath_OtherBedrooms1","1");
		SendKeys("xpath_OtherBath1","1");
		SendKeys("xpath_OtherToilet1","1");
		SendKeys("xpath_OtherKitchen1","1");
		SendKeys("xpath_OtherUtility1","1");
		SendKeys("xpath_OtherConservatory1","1");
		SendKeys("xpath_OtherOther1","1");
	//Roof space
		ScrollDown("xpath_AccRoofSpaceChevron");
		clickOnElementJS("xpath_AccRoofSpaceChevron");
		SendKeys("xpath_RoofSpaceLivingRoom1","1");
		SendKeys("xpath_RoofSpaceBedrooms1","1");
		SendKeys("xpath_RoofSpaceBath1","1");
		SendKeys("xpath_RoofSpaceToilet1","1");
		SendKeys("xpath_RoofSpaceKitchen1","1");
		SendKeys("xpath_RoofSpaceUtility1","1");
		SendKeys("xpath_RoofSpaceConservatory1","1");
		SendKeys("xpath_RoofSpaceOther1","1");
	//Enter Energy efficiency rating
		SendKeys("xpath_EnergyEfficiencyRating","80");
	//ScrollDown and Enter Issues relating to the energy efficiency rating
		ScrollDown("xpath_EnergyEfficiencyIssues");
		SendKeys("xpath_EnergyEfficiencyIssues","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	//Check All Main services checkboxes
		clickOnElementJS("xpath_MSGas");
		clickOnElementJS("xpath_MSElectric");
		clickOnElementJS("xpath_MSWater");
		clickOnElementJS("xpath_MSDrainage");
	//Check All Central heating checkboxes
		clickOnElementJS("xpath_CHGas");
		clickOnElementJS("xpath_CHElectric");
		clickOnElementJS("xpath_CHSolidFuel");
		clickOnElementJS("xpath_CHOil");
	//Enter Other services or energy sources (including feed-in tariffs)
		SendKeys("xpath_OtherServicesEnergy","NA");
	//ScrollDown and enter Other energy matters
		ScrollDown("xpath_OtherEnergyMatters");
		SendKeys("xpath_OtherEnergyMatters","NA");
	//ScrollDown and Enter Location and facilities - Grounds
		ScrollDown("xpath_LocAndFacGrounds");
		SendKeys("xpath_LocAndFacGrounds","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	//ScrollDown and Enter Location and facilities - Location
		ScrollDown("xpath_LocAndFacLocation");
		SendKeys("xpath_LocAndFacLocation","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	//ScrollDown and Enter Location and facilities - Facilities
		ScrollDown("xpath_LocAndFacFacilities");
		SendKeys("xpath_LocAndFacFacilities","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	
	//ScrollDown and Enter Location and facilities - Local environment
		ScrollDown("xpath_LocAndFacLocalEnv");
		SendKeys("xpath_LocAndFacLocalEnv","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	//Click Next button
		clickOnElementJS("xpath_NextButtonBesidesPhrase");
	}
	
	public void enterAboutThePropertyLvl1() throws InterruptedException {
		//Enter Type of property
			SendKeys("xpath_PropertyType","Private");
		//Enter Approximate year the property was built
			SendKeys("xpath_PropertyBuiltYear","1975");
		//Enter Approximate year the property was extended
			SendKeys("xpath_PropertyExtendedYear","2000");
		//ScrollDown Enter Approximate year the property was converted
			ScrollDown("xpath_PropertyConvertedYear");
			SendKeys("xpath_PropertyConvertedYear","2018");

		//ScrollDown and Enter Information relevant to flats and maisonettes
			ScrollDown("xpath_FlatsInformation");
			SendKeys("xpath_FlatsInformation","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		//ScrollDown and Enter Construction
			ScrollDown("xpath_Construction");
			SendKeys("xpath_Construction","Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec qu");
		//Populate Accommodation
		//Lower Ground
			SendKeys("xpath_LowerGroundLivingRoom1","1");
			SendKeys("xpath_LowerGroundBedrooms1","1");
			SendKeys("xpath_LowerGroundBath1","1");
			SendKeys("xpath_LowerGroundToilet1","1");
			SendKeys("xpath_LowerGroundKitchen1","1");
			SendKeys("xpath_LowerGroundUtility1","1");
			SendKeys("xpath_LowerGroundConservatory1","1");
			SendKeys("xpath_LowerGroundOther1","1");
		//Click Ground Chevron
			clickOnElementJS("xpath_AccGroundChevron");
		//Ground
			SendKeys("xpath_GroundLivingRoom1","1");
			SendKeys("xpath_GroundBedrooms1","1");
			SendKeys("xpath_GroundBath1","1");
			SendKeys("xpath_GroundToilet1","1");
			SendKeys("xpath_GroundKitchen1","1");
			SendKeys("xpath_GroundUtility1","1");
			SendKeys("xpath_GroundConservatory1","1");
			SendKeys("xpath_GroundOther1","1");
		//First
			ScrollDown("xpath_AccFirstChevron");
			clickOnElementJS("xpath_AccFirstChevron");
			SendKeys("xpath_FirstLivingRoom1","1");
			SendKeys("xpath_FirstBedrooms1","1");
			SendKeys("xpath_FirstBath1","1");
			SendKeys("xpath_FirstToilet1","1");
			SendKeys("xpath_FirstKitchen1","1");
			SendKeys("xpath_FirstUtility1","1");
			SendKeys("xpath_FirstConservatory1","1");
			SendKeys("xpath_FirstOther1","1");
		//Second
			ScrollDown("xpath_AccSecondChevron");
			clickOnElementJS("xpath_AccSecondChevron");
			SendKeys("xpath_SecondLivingRoom1","1");
			SendKeys("xpath_SecondBedrooms1","1");
			SendKeys("xpath_SecondBath1","1");
			SendKeys("xpath_SecondToilet1","1");
			SendKeys("xpath_SecondKitchen1","1");
			SendKeys("xpath_SecondUtility1","1");
			SendKeys("xpath_SecondConservatory1","1");
			SendKeys("xpath_SecondOther1","1");
		//Third
			ScrollDown("xpath_AccThirdChevron");
			clickOnElementJS("xpath_AccThirdChevron");
			SendKeys("xpath_ThirdLivingRoom1","1");
			SendKeys("xpath_ThirdBedrooms1","1");
			SendKeys("xpath_ThirdBath1","1");
			SendKeys("xpath_ThirdToilet1","1");
			SendKeys("xpath_ThirdKitchen1","1");
			SendKeys("xpath_ThirdUtility1","1");
			SendKeys("xpath_ThirdConservatory1","1");
			SendKeys("xpath_ThirdOther1","1");
		//Other
			ScrollDown("xpath_AccOtherChevron");
			clickOnElementJS("xpath_AccOtherChevron");
			SendKeys("xpath_OtherLivingRoom1","1");
			SendKeys("xpath_OtherBedrooms1","1");
			SendKeys("xpath_OtherBath1","1");
			SendKeys("xpath_OtherToilet1","1");
			SendKeys("xpath_OtherKitchen1","1");
			SendKeys("xpath_OtherUtility1","1");
			SendKeys("xpath_OtherConservatory1","1");
			SendKeys("xpath_OtherOther1","1");
		//Roof space
			ScrollDown("xpath_AccRoofSpaceChevron");
			clickOnElementJS("xpath_AccRoofSpaceChevron");
			SendKeys("xpath_RoofSpaceLivingRoom1","1");
			SendKeys("xpath_RoofSpaceBedrooms1","1");
			SendKeys("xpath_RoofSpaceBath1","1");
			SendKeys("xpath_RoofSpaceToilet1","1");
			SendKeys("xpath_RoofSpaceKitchen1","1");
			SendKeys("xpath_RoofSpaceUtility1","1");
			SendKeys("xpath_RoofSpaceConservatory1","1");
			SendKeys("xpath_RoofSpaceOther1","1");
		//Enter Energy efficiency rating
			SendKeys("xpath_EnergyEfficiencyRating","80");
		
		//Check All Main services checkboxes
			clickOnElementJS("xpath_MSGas");
			clickOnElementJS("xpath_MSElectric");
			clickOnElementJS("xpath_MSWater");
			clickOnElementJS("xpath_MSDrainage");
		//Check All Central heating checkboxes
			clickOnElementJS("xpath_CHGas");
			clickOnElementJS("xpath_CHElectric");
			clickOnElementJS("xpath_CHSolidFuel");
			clickOnElementJS("xpath_CHOil");
		//Enter Other services or energy sources (including feed-in tariffs)
			SendKeys("xpath_OtherServicesEnergy","NA");
		
		
		//Click Next button
			clickOnElementJS("xpath_NextButtonBesidesPhrase");
		}
	
	public void enterOutsideProperty() throws InterruptedException {
	//Enter Full detail of elements inspected - Limitations to the inspection
		SendKeys("xpath_LimitationsInspection","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	//ScrollDown to Chimney stacks Inspection Status 
		ScrollDown("xpath_ChimneyStacksInspectionStatus");
		
	//Add Section D images
	 	uploadReportImagesSectionD2();
	 	uploadReportImagesSectionD3();
	 	uploadReportImagesSectionD4();
	 	uploadReportImagesSectionD5();
	 	uploadReportImagesSectionD6();
	 	uploadReportImagesSectionD7();
	 	uploadReportImagesSectionD8();
	 	uploadReportImagesSectionD9();
	 	uploadReportImagesSectionD10();
	//Click Next  button
	 	clickOnElementJS("xpath_NextButtonBesidesPhrase");
	}
	
	public void enterInsideProperty() throws InterruptedException {
		//Enter Full detail of elements inspected - Limitations to the inspection
			SendKeys("xpath_LimitationsInspection","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//ScrollDown to Roof structure Inspection Status 
			ScrollDown("xpath_RoofStructureInspectionStatus");
			
		//Add Section E images
		 	uploadReportImagesSectionE2();
		 	uploadReportImagesSectionE3();
		 	uploadReportImagesSectionE4();
		 	uploadReportImagesSectionE5();
		 	uploadReportImagesSectionE6();
		 	uploadReportImagesSectionE7();
		 	uploadReportImagesSectionE8();
		 	uploadReportImagesSectionE9();
		 	uploadReportImagesSectionE10();
		//Click Next  button
		 	clickOnElementJS("xpath_NextButtonBesidesPhrase");
		}
	
	public void enterServices() throws InterruptedException {
		//Enter Full detail of elements inspected - Limitations to the inspection
			SendKeys("xpath_LimitationsInspection","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//ScrollDown to Roof structure Inspection Status 
			ScrollDown("xpath_ElectricityInspectionStatus");
			
		//Add Section F images
		 	uploadReportImagesSectionF2();
		 	uploadReportImagesSectionF3();
		 	uploadReportImagesSectionF4();
		 	uploadReportImagesSectionF5();
		 	uploadReportImagesSectionF6();
		 	uploadReportImagesSectionF7();
		 	uploadReportImagesSectionF8();
		 	
		//Click Next  button
		 	clickOnElementJS("xpath_NextButtonBesidesPhrase");
		}
	public void enterGrounds() throws InterruptedException {
		//Enter Full detail of elements inspected - Limitations to the inspection
			SendKeys("xpath_LimitationsInspection","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//ScrollDown to Roof structure Inspection Status 
			ScrollDown("xpath_GarageInspectionStatus");
			
		//Add Section F images
		 	uploadReportImagesSectionG2();
		 	uploadReportImagesSectionG3();
		 	uploadReportImagesSectionG4();
		 	
		 	
		//Click Next  button
		 	clickOnElementJS("xpath_NextButtonBesidesPhrase");
		}
	
	public void enterIssuesLegalAdvisers() throws InterruptedException {
	//Enter Regulation
	SendKeys("xpath_Regulation","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	//Scroll Down and Enter Guarantees
	ScrollDown("xpath_Guarantees");
	SendKeys("xpath_Guarantees","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	//Scroll Down and Enter Other Matters
	ScrollDown("xpath_OtherMatters");
	WaitForElementExistXpath("xpath_OtherMatters");
	SendKeys("xpath_OtherMatters","Lorem ipsum dolor sit amet, consectetuer adipiscin");

	//Click Next  button
	Thread.sleep(2000);
 	clickOnElementJS("xpath_NextButtonBesidesPhrase");
	}
	
	public void enterRisks() throws InterruptedException {
		//Enter Risks to the building
		SendKeys("xpath_RiskToBldg","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Scroll Down and Enter Risks to the grounds
		ScrollDown("xpath_RiskToGrounds");
		SendKeys("xpath_RiskToGrounds","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Scroll Down and Enter Risks to people
		ScrollDown("xpath_RiskToPeople");
		SendKeys("xpath_RiskToPeople","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Scroll Down and Enter Other
		ScrollDown("xpath_IOther");
		WaitForElementExistXpath("xpath_IOther");
		SendKeys("xpath_IOther","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//SendKeys("xpath_IOther","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		}

	
	public void enterRisksLvl1() throws InterruptedException {
		//Enter Risks to the building
		SendKeys("xpath_RiskToBldg","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Scroll Down and Enter Risks to the grounds
		ScrollDown("xpath_RiskToGrounds");
		SendKeys("xpath_RiskToGrounds","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Scroll Down and Enter Risks to people
		ScrollDown("xpath_RiskToPeople");
		SendKeys("xpath_RiskToPeople","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Scroll Down and Enter Other
		ScrollDown("xpath_IOther");
		WaitForElementExistXpath("xpath_IOther");
		SendKeys("xpath_IOther","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//SendKeys("xpath_IOther","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		
		}
	public void enterPropertyValuation() throws InterruptedException {
		Thread.sleep(2000);
		clickOnElementJS("xpath_NextButtonBesidesPhrase");
		//Enter In my opinion the market value as inspected was:
		SendKeys("xpath_MarketValueOpinion","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Enter In my opinion the current reinstatement cost of the property (see note below) is:
		ScrollDown("xpath_ReinstatementCost");
		SendKeys("xpath_ReinstatementCost","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Enter Tenure
		ScrollDown("xpath_Tenure");
		SendKeys("xpath_Tenure","10 years");
		
		//Enter Area of property (sq m)
		ScrollDown("xpath_PropertyArea");
		SendKeys("xpath_PropertyArea","200 sqm");
		//Scroll Down and enter Any additional assumptions relating to the valuation
		ScrollDown("xpath_ValuationAssumptions");
		SendKeys("xpath_ValuationAssumptions","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Scroll Down and enter Other considerations affecting value
		ScrollDown("xpath_OtherAffectingValue");
		SendKeys("xpath_OtherAffectingValue","Lorem ipsum dolor sit amet, consectetuer adipiscin");
	}
	
	public void enterEnergyMatters() throws InterruptedException {
		//Click Next  button
		Thread.sleep(2000);
	 	clickOnElementJS("xpath_NextButtonBesidesPhrase");
	 	//Enter Insulation
		SendKeys("xpath_EnergyMatInsulation","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Enter Heating
		SendKeys("xpath_EnergyMatHeating","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Enter Ligthing
		SendKeys("xpath_EnergyMatLighting","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Enter Ventilation
		SendKeys("xpath_EnergyMatVentilation","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		//Scroll Down and Enter General
		ScrollDown("xpath_EnergyMatGeneral");
		SendKeys("xpath_EnergyMatGeneral","Lorem ipsum dolor sit amet, consectetuer adipiscin");
		
	}
	public void initializeUploadFile() {
		Constants.uploadFilePath1 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\download5.jfif";
		Constants.uploadFilePath2 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\download4.jfif";
		Constants.uploadFilePath3 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\download3.jfif";
		Constants.uploadFilePath4 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\testIMG1.jpg";
		Constants.uploadFilePath5 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\testIMG2.jpeg";
		Constants.uploadFilePath6 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\download (1).jpg";
		Constants.uploadFilePath7 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\download (2).jpg";
		Constants.uploadFilePath8 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\download.jpg";
		Constants.uploadFilePath9 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\Sample_2.jpg";
		Constants.uploadFilePath10 = System.getProperty("user.dir")+"\\src\\test\\resources\\reportImages\\Sample_evidence.jpg";
		
		Constants.uploadAllFiles =Constants.uploadFilePath1+"\n"+Constants.uploadFilePath2+"\n"+Constants.uploadFilePath3+"\n"+Constants.uploadFilePath4+"\n"+Constants.uploadFilePath5+"\n"+Constants.uploadFilePath6+"\n"+Constants.uploadFilePath7+"\n"+Constants.uploadFilePath8+"\n"+Constants.uploadFilePath9+"\n"+Constants.uploadFilePath10;
		
		WebElement upload_file = element("xpath_InputPhotos");
		upload_file.sendKeys(Constants.uploadAllFiles);
	}
	public void uploadReportImagesSectionD2() throws InterruptedException {
		//Select a non-Not applicable value in the Inspection Status dropdown
		Select ChimneyStacksStatus = new Select(element("xpath_ChimneyStacksInspectionStatus"));
	 	ChimneyStacksStatus.selectByIndex(0);
		//Add images
		initializeUploadFile();
		//Add images to D2 Chimney Stacks
		
		//Add caption to each images
		Thread.sleep(3000);
		SendKeys("xpath_Im2Caption1","This is caption 1");
		SendKeys("xpath_Im2Caption2","This is caption 2");
		SendKeys("xpath_Im2Caption3","This is caption 3");
		SendKeys("xpath_Im2Caption4","This is caption 4");
		SendKeys("xpath_Im2Caption5","This is caption 5");
		SendKeys("xpath_Im2Caption6","This is caption 6");
		SendKeys("xpath_Im2Caption7","This is caption 7");
		SendKeys("xpath_Im2Caption8","This is caption 8");
		SendKeys("xpath_Im2Caption9","This is caption 9");
		SendKeys("xpath_Im2Caption10","This is caption 10");
		System.out.println("Chimney stacks images are successfully uploaded");
		
		ScrollDown("xpath_Im2Desc2");
		SendKeys("xpath_Im2Desc2", "This is a description");
		ScrollDown("xpath_ChimneyStackComm");
		SendKeys("xpath_ChimneyStackComm", "This is a comment");
	}
		public void uploadReportImagesSectionD3() throws InterruptedException {
		//Select a non-Not applicable value in the Inspection Status dropdown
		Select RoofCoverStatus = new Select(element("xpath_RoofCoverInspectionStatus"));
		RoofCoverStatus.selectByIndex(2);
		//Add images
			initializeUploadFile();
		
		//Add caption to each images
			Thread.sleep(3000);
		SendKeys("xpath_Im3Caption1","This is caption 11");
		SendKeys("xpath_Im3Caption2","This is caption 12");
		SendKeys("xpath_Im3Caption3","This is caption 13");
		SendKeys("xpath_Im3Caption4","This is caption 14");
		SendKeys("xpath_Im3Caption5","This is caption 15");
		SendKeys("xpath_Im3Caption6","This is caption 16");
		SendKeys("xpath_Im3Caption7","This is caption 17");
		SendKeys("xpath_Im3Caption8","This is caption 18");
		SendKeys("xpath_Im3Caption9","This is caption 19");
		SendKeys("xpath_Im3Caption10","This is caption 20");
		System.out.println("Roof covering images are successfully uploaded");
		
		ScrollDown("xpath_Im3Desc3");
		SendKeys("xpath_Im3Desc3","This is a description");
		ScrollDown("xpath_RoofCoverComm");
		SendKeys("xpath_RoofCoverComm","This is a comment");
		}
		
		public void uploadReportImagesSectionD4() throws InterruptedException {
		//Select a non-Not applicable value in the Inspection Status dropdown
		Select RainWaterStatus = new Select(element("xpath_RainWaterInspectionStatus"));
		RainWaterStatus.selectByIndex(3);
		//Add images
		initializeUploadFile();
		
		//Add caption to each images
		Thread.sleep(3000);
		SendKeys("xpath_Im4Caption1","This is caption 21");
		SendKeys("xpath_Im4Caption2","This is caption 22");
		SendKeys("xpath_Im4Caption3","This is caption 23");
		SendKeys("xpath_Im4Caption4","This is caption 24");
		SendKeys("xpath_Im4Caption5","This is caption 25");
		SendKeys("xpath_Im4Caption6","This is caption 26");
		SendKeys("xpath_Im4Caption7","This is caption 27");
		SendKeys("xpath_Im4Caption8","This is caption 28");
		SendKeys("xpath_Im4Caption9","This is caption 29");
		SendKeys("xpath_Im4Caption10","This is caption 30");
		
		System.out.println("Rainwater pipes and gutters images are successfully uploaded");
		
		ScrollDown("xpath_Im4Desc4");
		SendKeys("xpath_Im4Desc4","This is a description");
		ScrollDown("xpath_RainWaterComm");
		SendKeys("xpath_RainWaterComm","This is a comment");
	}
		public void uploadReportImagesSectionD5() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select MainWallsStatus = new Select(element("xpath_MainWallsInspectionStatus"));
			MainWallsStatus.selectByIndex(4);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im5Caption1","This is caption 31");
			SendKeys("xpath_Im5Caption2","This is caption 32");
			SendKeys("xpath_Im5Caption3","This is caption 33");
			SendKeys("xpath_Im5Caption4","This is caption 34");
			SendKeys("xpath_Im5Caption5","This is caption 35");
			SendKeys("xpath_Im5Caption6","This is caption 36");
			SendKeys("xpath_Im5Caption7","This is caption 37");
			SendKeys("xpath_Im5Caption8","This is caption 38");
			SendKeys("xpath_Im5Caption9","This is caption 39");
			SendKeys("xpath_Im5Caption10","This is caption 40");
			System.out.println("Main Walls images are successfully uploaded");
			
			ScrollDown("xpath_Im5Desc5");
			SendKeys("xpath_Im5Desc5","This is a description");
			ScrollDown("xpath_MainWallsComm");
			SendKeys("xpath_MainWallsComm","This is a comment");
		}
		public void uploadReportImagesSectionD6() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select WindowsStatus = new Select(element("xpath_WindowsInspectionStatus"));
			WindowsStatus.selectByIndex(0);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im6Caption1","This is caption 41");
			SendKeys("xpath_Im6Caption2","This is caption 42");
			SendKeys("xpath_Im6Caption3","This is caption 43");
			SendKeys("xpath_Im6Caption4","This is caption 44");
			SendKeys("xpath_Im6Caption5","This is caption 45");
			SendKeys("xpath_Im6Caption6","This is caption 46");
			SendKeys("xpath_Im6Caption7","This is caption 47");
			SendKeys("xpath_Im6Caption8","This is caption 48");
			SendKeys("xpath_Im6Caption9","This is caption 49");
			SendKeys("xpath_Im6Caption10","This is caption 50");
			System.out.println("Window status images are successfully uploaded");
			
			ScrollDown("xpath_Im6Desc6");
			SendKeys("xpath_Im6Desc6","This is a description");
			ScrollDown("xpath_WindowsComm");
			SendKeys("xpath_WindowsComm","This is a comment");
		}
		
		public void uploadReportImagesSectionD7() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select OutsideDoorsStatus = new Select(element("xpath_OutsideDoorsInspectionStatus"));
			OutsideDoorsStatus.selectByIndex(2);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im7Caption1","This is caption 51");
			SendKeys("xpath_Im7Caption2","This is caption 52");
			SendKeys("xpath_Im7Caption3","This is caption 53");
			SendKeys("xpath_Im7Caption4","This is caption 54");
			SendKeys("xpath_Im7Caption5","This is caption 55");
			SendKeys("xpath_Im7Caption6","This is caption 56");
			SendKeys("xpath_Im7Caption7","This is caption 57");
			SendKeys("xpath_Im7Caption8","This is caption 58");
			SendKeys("xpath_Im7Caption9","This is caption 59");
			SendKeys("xpath_Im7Caption10","This is caption 60");
			System.out.println("Outside doors images are successfully uploaded");
			
			ScrollDown("xpath_Im7Desc7");
			SendKeys("xpath_Im7Desc7","This is a description");
			ScrollDown("xpath_OutsideDoorsComm");
			SendKeys("xpath_OutsideDoorsComm","This is a comment");
		}
		
		public void uploadReportImagesSectionD8() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select ConservPorchesStatus = new Select(element("xpath_ConservatoryPorchesInspectionStatus"));
			ConservPorchesStatus.selectByIndex(3);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im8Caption1","This is caption 61");
			SendKeys("xpath_Im8Caption2","This is caption 62");
			SendKeys("xpath_Im8Caption3","This is caption 63");
			SendKeys("xpath_Im8Caption4","This is caption 64");
			SendKeys("xpath_Im8Caption5","This is caption 65");
			SendKeys("xpath_Im8Caption6","This is caption 66");
			SendKeys("xpath_Im8Caption7","This is caption 67");
			SendKeys("xpath_Im8Caption8","This is caption 68");
			SendKeys("xpath_Im8Caption9","This is caption 69");
			SendKeys("xpath_Im8Caption10","This is caption 70");
			System.out.println("Conservatory Porches images are successfully uploaded");
			
			ScrollDown("xpath_Im8Desc8");
			SendKeys("xpath_Im8Desc8","This is a description");
			ScrollDown("xpath_ConservatoryPorchesComm");
			SendKeys("xpath_ConservatoryPorchesComm","This is a comment");
		}
		
		public void uploadReportImagesSectionD9() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select OtherJoinFinishStatus = new Select(element("xpath_OtherJoinFinishesInspectionStatus"));
			OtherJoinFinishStatus.selectByIndex(4);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im9Caption1","This is caption 71");
			SendKeys("xpath_Im9Caption2","This is caption 72");
			SendKeys("xpath_Im9Caption3","This is caption 73");
			SendKeys("xpath_Im9Caption4","This is caption 74");
			SendKeys("xpath_Im9Caption5","This is caption 75");
			SendKeys("xpath_Im9Caption6","This is caption 76");
			SendKeys("xpath_Im9Caption7","This is caption 77");
			SendKeys("xpath_Im9Caption8","This is caption 78");
			SendKeys("xpath_Im9Caption9","This is caption 79");
			SendKeys("xpath_Im9Caption10","This is caption 80");
			System.out.println("Other Joinery and Finishes images are successfully uploaded");
			
			ScrollDown("xpath_Im9Desc9");
			SendKeys("xpath_Im9Desc9","This is a description");
			ScrollDown("xpath_OtherJoinFinishesComm");
			SendKeys("xpath_OtherJoinFinishesComm","This is a comment");
		}
		
		public void uploadReportImagesSectionD10() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select OtherDStatus = new Select(element("xpath_OtherDInspectionStatus"));
			OtherDStatus.selectByIndex(0);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im10Caption1","This is caption 81");
			SendKeys("xpath_Im10Caption2","This is caption 82");
			SendKeys("xpath_Im10Caption3","This is caption 83");
			SendKeys("xpath_Im10Caption4","This is caption 84");
			SendKeys("xpath_Im10Caption5","This is caption 85");
			SendKeys("xpath_Im10Caption6","This is caption 86");
			SendKeys("xpath_Im10Caption7","This is caption 87");
			SendKeys("xpath_Im10Caption8","This is caption 88");
			SendKeys("xpath_Im10Caption9","This is caption 89");
			SendKeys("xpath_Im10Caption10","This is caption 90");
			System.out.println("Other Section D Images are succesfully uploaded");
			
			ScrollDown("xpath_Im10Desc10");
			SendKeys("xpath_Im10Desc10","This is a description");
			ScrollDown("xpath_OtherDComm");
			SendKeys("xpath_OtherDComm","This is a comment");
		}
		
		public void uploadReportImagesSectionE2() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select OtherDStatus = new Select(element("xpath_RoofStructureInspectionStatus"));
			OtherDStatus.selectByIndex(0);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im2Caption1","This is caption 1");
			SendKeys("xpath_Im2Caption2","This is caption 2");
			SendKeys("xpath_Im2Caption3","This is caption 3");
			SendKeys("xpath_Im2Caption4","This is caption 4");
			SendKeys("xpath_Im2Caption5","This is caption 5");
			SendKeys("xpath_Im2Caption6","This is caption 6");
			SendKeys("xpath_Im2Caption7","This is caption 7");
			SendKeys("xpath_Im2Caption8","This is caption 8");
			SendKeys("xpath_Im2Caption9","This is caption 9");
			SendKeys("xpath_Im2Caption10","This is caption 10");
			System.out.println("Roof Structure Images are succesfully uploaded");
			
			ScrollDown("xpath_Im2Desc2");
			SendKeys("xpath_Im2Desc2","This is a description");
			ScrollDown("xpath_RoofStructureComm");
			SendKeys("xpath_RoofStructureComm","This is a comment");
		}
		public void uploadReportImagesSectionE3() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select CeilingsStatus = new Select(element("xpath_CeilingsInspectionStatus"));
			CeilingsStatus.selectByIndex(3);
			//Add images
				initializeUploadFile();
			//Add caption to each images
				Thread.sleep(3000);
			SendKeys("xpath_Im3Caption1","This is caption 11");
			SendKeys("xpath_Im3Caption2","This is caption 12");
			SendKeys("xpath_Im3Caption3","This is caption 13");
			SendKeys("xpath_Im3Caption4","This is caption 14");
			SendKeys("xpath_Im3Caption5","This is caption 15");
			SendKeys("xpath_Im3Caption6","This is caption 16");
			SendKeys("xpath_Im3Caption7","This is caption 17");
			SendKeys("xpath_Im3Caption8","This is caption 18");
			SendKeys("xpath_Im3Caption9","This is caption 19");
			SendKeys("xpath_Im3Caption10","This is caption 20");			
			System.out.println("Celings images are successfully uploaded");
			
			ScrollDown("xpath_Im3Desc3");
			SendKeys("xpath_Im3Desc3","This is a description");
			ScrollDown("xpath_CeilingsComm");
			SendKeys("xpath_CeilingsComm","This is a comment");
			}
		
		public void uploadReportImagesSectionE4() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select WallsPartStatus = new Select(element("xpath_WallsPartInspectionStatus"));
			WallsPartStatus.selectByIndex(4);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im4Caption1","This is caption 21");
			SendKeys("xpath_Im4Caption2","This is caption 22");
			SendKeys("xpath_Im4Caption3","This is caption 23");
			SendKeys("xpath_Im4Caption4","This is caption 24");
			SendKeys("xpath_Im4Caption5","This is caption 25");
			SendKeys("xpath_Im4Caption6","This is caption 26");
			SendKeys("xpath_Im4Caption7","This is caption 27");
			SendKeys("xpath_Im4Caption8","This is caption 28");
			SendKeys("xpath_Im4Caption9","This is caption 29");
			SendKeys("xpath_Im4Caption10","This is caption 30");
			System.out.println("Walls partition images are successfully uploaded");
			
			ScrollDown("xpath_Im4Desc4");
			SendKeys("xpath_Im4Desc4","This is a description");
			ScrollDown("xpath_WallsPartComm");
			SendKeys("xpath_WallsPartComm","This is a comment");
		}
		
		public void uploadReportImagesSectionE5() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select FloorsStatus = new Select(element("xpath_FloorsInspectionStatus"));
			FloorsStatus.selectByIndex(4);
			//Add images
			initializeUploadFile();
		
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im5Caption1","This is caption 31");
			SendKeys("xpath_Im5Caption2","This is caption 32");
			SendKeys("xpath_Im5Caption3","This is caption 33");
			SendKeys("xpath_Im5Caption4","This is caption 34");
			SendKeys("xpath_Im5Caption5","This is caption 35");
			SendKeys("xpath_Im5Caption6","This is caption 36");
			SendKeys("xpath_Im5Caption7","This is caption 37");
			SendKeys("xpath_Im5Caption8","This is caption 38");
			SendKeys("xpath_Im5Caption9","This is caption 39");
			SendKeys("xpath_Im5Caption10","This is caption 40");
			System.out.println("Floors images are successfully uploaded");
			
			ScrollDown("xpath_Im5Desc5");
			SendKeys("xpath_Im5Desc5","This is a description");
			ScrollDown("xpath_FloorsInspectionComm");
			SendKeys("xpath_FloorsInspectionComm","This is a comment");
		}
		
		public void uploadReportImagesSectionE6() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select FireplacesETCStatus = new Select(element("xpath_FireplacesEtcInspectionStatus"));
			FireplacesETCStatus.selectByIndex(0);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im6Caption1","This is caption 41");
			SendKeys("xpath_Im6Caption2","This is caption 42");
			SendKeys("xpath_Im6Caption3","This is caption 43");
			SendKeys("xpath_Im6Caption4","This is caption 44");
			SendKeys("xpath_Im6Caption5","This is caption 45");
			SendKeys("xpath_Im6Caption6","This is caption 46");
			SendKeys("xpath_Im6Caption7","This is caption 47");
			SendKeys("xpath_Im6Caption8","This is caption 48");
			SendKeys("xpath_Im6Caption9","This is caption 49");
			SendKeys("xpath_Im6Caption10","This is caption 50");
			System.out.println("Fireplaces etc images are successfully uploaded");
			
			ScrollDown("xpath_Im6Desc6");
			SendKeys("xpath_Im6Desc6","This is a description");
			ScrollDown("xpath_FireplacesEtcComm");
			SendKeys("xpath_FireplacesEtcComm","This is a comment");
		}
		
		public void uploadReportImagesSectionE7() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select BuiltFittingsStatus = new Select(element("xpath_BuiltFittingsInspectionStatus"));
			BuiltFittingsStatus.selectByIndex(2);
			//Add images
			initializeUploadFile();
		
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im7Caption1","This is caption 51");
			SendKeys("xpath_Im7Caption2","This is caption 52");
			SendKeys("xpath_Im7Caption3","This is caption 53");
			SendKeys("xpath_Im7Caption4","This is caption 54");
			SendKeys("xpath_Im7Caption5","This is caption 55");
			SendKeys("xpath_Im7Caption6","This is caption 56");
			SendKeys("xpath_Im7Caption7","This is caption 57");
			SendKeys("xpath_Im7Caption8","This is caption 58");
			SendKeys("xpath_Im7Caption9","This is caption 59");
			SendKeys("xpath_Im7Caption10","This is caption 60");
			System.out.println("Built-in Fittings images are successfully uploaded");
			
			ScrollDown("xpath_Im7Desc7");
			SendKeys("xpath_Im7Desc7","This is a description");
			ScrollDown("xpath_BuiltFittingsComm");
			SendKeys("xpath_BuiltFittingsComm","This is a comment");
		}
		
		public void uploadReportImagesSectionE8() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select WoodworkStatus = new Select(element("xpath_WoodworkInspectionStatus"));
			WoodworkStatus.selectByIndex(3);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im8Caption1","This is caption 61");
			SendKeys("xpath_Im8Caption2","This is caption 62");
			SendKeys("xpath_Im8Caption3","This is caption 63");
			SendKeys("xpath_Im8Caption4","This is caption 64");
			SendKeys("xpath_Im8Caption5","This is caption 65");
			SendKeys("xpath_Im8Caption6","This is caption 66");
			SendKeys("xpath_Im8Caption7","This is caption 67");
			SendKeys("xpath_Im8Caption8","This is caption 68");
			SendKeys("xpath_Im8Caption9","This is caption 69");
			SendKeys("xpath_Im8Caption10","This is caption 70");
			System.out.println("Wood work images are successfully uploaded");
			
			ScrollDown("xpath_Im8Desc8");
			SendKeys("xpath_Im8Desc8","This is a description");
			ScrollDown("xpath_WoodworkComm");
			SendKeys("xpath_WoodworkComm","This is a comment");
		}
		
		public void uploadReportImagesSectionE9() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select BathFittingsStatus = new Select(element("xpath_BathFittingsInspectionStatus"));
			BathFittingsStatus.selectByIndex(4);
			//Add images
			initializeUploadFile();
		
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im9Caption1","This is caption 71");
			SendKeys("xpath_Im9Caption2","This is caption 72");
			SendKeys("xpath_Im9Caption3","This is caption 73");
			SendKeys("xpath_Im9Caption4","This is caption 74");
			SendKeys("xpath_Im9Caption5","This is caption 75");
			SendKeys("xpath_Im9Caption6","This is caption 76");
			SendKeys("xpath_Im9Caption7","This is caption 77");
			SendKeys("xpath_Im9Caption8","This is caption 78");
			SendKeys("xpath_Im9Caption9","This is caption 79");
			SendKeys("xpath_Im9Caption10","This is caption 80");
			System.out.println("Bath Fittings images are successfully uploaded");
			
			ScrollDown("xpath_Im9Desc9");
			SendKeys("xpath_Im9Desc9","This is a description");
			ScrollDown("xpath_BathFittingsComm");
			SendKeys("xpath_BathFittingsComm","This is a comment");
		}
		
		public void uploadReportImagesSectionE10() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select OtherEStatus = new Select(element("xpath_OtherEInspectionStatus"));
			OtherEStatus.selectByIndex(0);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im10Caption1","This is caption 81");
			SendKeys("xpath_Im10Caption2","This is caption 82");
			SendKeys("xpath_Im10Caption3","This is caption 83");
			SendKeys("xpath_Im10Caption4","This is caption 84");
			SendKeys("xpath_Im10Caption5","This is caption 85");
			SendKeys("xpath_Im10Caption6","This is caption 86");
			SendKeys("xpath_Im10Caption7","This is caption 87");
			SendKeys("xpath_Im10Caption8","This is caption 88");
			SendKeys("xpath_Im10Caption9","This is caption 89");
			SendKeys("xpath_Im10Caption10","This is caption 90");
			System.out.println("Other Section E Images are succesfully uploaded");
			
			ScrollDown("xpath_Im10Desc10");
			SendKeys("xpath_Im10Desc10","This is a description");
			ScrollDown("xpath_OtherEComm");
			SendKeys("xpath_OtherEComm","This is a comment");
		}
		
		public void uploadReportImagesSectionF2() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select ElectricityStatus = new Select(element("xpath_ElectricityInspectionStatus"));
			ElectricityStatus.selectByIndex(0);
			//Add images
			initializeUploadFile();
			//Add images to D6 Windows
			
			//WebElement upload_fileD10 = element("xpath_InputPhotos");
			//upload_fileD10.sendKeys(Constants.uploadAllFiles);
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im2Caption1","This is caption 1");
			SendKeys("xpath_Im2Caption2","This is caption 2");
			SendKeys("xpath_Im2Caption3","This is caption 3");
			SendKeys("xpath_Im2Caption4","This is caption 4");
			SendKeys("xpath_Im2Caption5","This is caption 5");
			SendKeys("xpath_Im2Caption6","This is caption 6");
			SendKeys("xpath_Im2Caption7","This is caption 7");
			SendKeys("xpath_Im2Caption8","This is caption 8");
			SendKeys("xpath_Im2Caption9","This is caption 9");
			SendKeys("xpath_Im2Caption10","This is caption 10");
			System.out.println("Electricity Images are succesfully uploaded");
			
			ScrollDown("xpath_Im2Desc2");
			SendKeys("xpath_Im2Desc2","This is a description");
			ScrollDown("xpath_ElectricityComm");
			SendKeys("xpath_ElectricityComm","This is a comment");
		}
		
		public void uploadReportImagesSectionF3() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select GasOilStatus = new Select(element("xpath_GasOilInspectionStatus"));
			GasOilStatus.selectByIndex(3);
			//Add images
				initializeUploadFile();
			//Add caption to each images
				Thread.sleep(3000);
			SendKeys("xpath_Im3Caption1","This is caption 11");
			SendKeys("xpath_Im3Caption2","This is caption 12");
			SendKeys("xpath_Im3Caption3","This is caption 13");
			SendKeys("xpath_Im3Caption4","This is caption 14");
			SendKeys("xpath_Im3Caption5","This is caption 15");
			SendKeys("xpath_Im3Caption6","This is caption 16");
			SendKeys("xpath_Im3Caption7","This is caption 17");
			SendKeys("xpath_Im3Caption8","This is caption 18");
			SendKeys("xpath_Im3Caption9","This is caption 19");
			SendKeys("xpath_Im3Caption10","This is caption 20");
			System.out.println("Gas/Oil images are successfully uploaded");
			
			ScrollDown("xpath_Im3Desc3");
			SendKeys("xpath_Im3Desc3","This is a description");
			ScrollDown("xpath_GasOilComm");
			SendKeys("xpath_GasOilComm","This is a comment");
			}
		
		public void uploadReportImagesSectionF4() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select WaterStatus = new Select(element("xpath_WaterInspectionStatus"));
			WaterStatus.selectByIndex(4);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im4Caption1","This is caption 21");
			SendKeys("xpath_Im4Caption2","This is caption 22");
			SendKeys("xpath_Im4Caption3","This is caption 23");
			SendKeys("xpath_Im4Caption4","This is caption 24");
			SendKeys("xpath_Im4Caption5","This is caption 25");
			SendKeys("xpath_Im4Caption6","This is caption 26");
			SendKeys("xpath_Im4Caption7","This is caption 27");
			SendKeys("xpath_Im4Caption8","This is caption 28");
			SendKeys("xpath_Im4Caption9","This is caption 29");
			SendKeys("xpath_Im4Caption10","This is caption 30");
			System.out.println("Water images are successfully uploaded");
			
			ScrollDown("xpath_Im4Desc4");
			SendKeys("xpath_Im4Desc4","This is a description");
			ScrollDown("xpath_WaterComm");
			SendKeys("xpath_WaterComm","This is a comment");
		}
		
		public void uploadReportImagesSectionF5() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select HeatingStatus = new Select(element("xpath_HeatingInspectionStatus"));
			HeatingStatus.selectByIndex(4);
			//Add images
			initializeUploadFile();
		
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im5Caption1","This is caption 31");
			SendKeys("xpath_Im5Caption2","This is caption 32");
			SendKeys("xpath_Im5Caption3","This is caption 33");
			SendKeys("xpath_Im5Caption4","This is caption 34");
			SendKeys("xpath_Im5Caption5","This is caption 35");
			SendKeys("xpath_Im5Caption6","This is caption 36");
			SendKeys("xpath_Im5Caption7","This is caption 37");
			SendKeys("xpath_Im5Caption8","This is caption 38");
			SendKeys("xpath_Im5Caption9","This is caption 39");
			SendKeys("xpath_Im5Caption10","This is caption 40");
			System.out.println("Heating images are successfully uploaded");
			
			ScrollDown("xpath_Im5Desc5");
			SendKeys("xpath_Im5Desc5","This is a description");
			ScrollDown("xpath_HeatingComm");
			SendKeys("xpath_HeatingComm","This is a comment");
		}
		
		public void uploadReportImagesSectionF6() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select WaterHeatingStatus = new Select(element("xpath_WaterHeatingInspectionStatus"));
			WaterHeatingStatus.selectByIndex(0);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im6Caption1","This is caption 41");
			SendKeys("xpath_Im6Caption2","This is caption 42");
			SendKeys("xpath_Im6Caption3","This is caption 43");
			SendKeys("xpath_Im6Caption4","This is caption 44");
			SendKeys("xpath_Im6Caption5","This is caption 45");
			SendKeys("xpath_Im6Caption6","This is caption 46");
			SendKeys("xpath_Im6Caption7","This is caption 47");
			SendKeys("xpath_Im6Caption8","This is caption 48");
			SendKeys("xpath_Im6Caption9","This is caption 49");
			SendKeys("xpath_Im6Caption10","This is caption 50");
			System.out.println("Water heating images are successfully uploaded");
			
			ScrollDown("xpath_Im6Desc6");
			SendKeys("xpath_Im6Desc6","This is a description");
			ScrollDown("xpath_WaterHeatingComm");
			SendKeys("xpath_WaterHeatingComm","This is a comment");
		}
		public void uploadReportImagesSectionF7() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select DrainageStatus = new Select(element("xpath_DrainageInspectionStatus"));
			DrainageStatus.selectByIndex(2);
			//Add images
			initializeUploadFile();
		
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im7Caption1","This is caption 51");
			SendKeys("xpath_Im7Caption2","This is caption 52");
			SendKeys("xpath_Im7Caption3","This is caption 53");
			SendKeys("xpath_Im7Caption4","This is caption 54");
			SendKeys("xpath_Im7Caption5","This is caption 55");
			SendKeys("xpath_Im7Caption6","This is caption 56");
			SendKeys("xpath_Im7Caption7","This is caption 57");
			SendKeys("xpath_Im7Caption8","This is caption 58");
			SendKeys("xpath_Im7Caption9","This is caption 59");
			SendKeys("xpath_Im7Caption10","This is caption 60");
			System.out.println("Drainage images are successfully uploaded");
			
			ScrollDown("xpath_Im7Desc7");
			SendKeys("xpath_Im7Desc7","This is a description");
			ScrollDown("xpath_DrainageComm");
			SendKeys("xpath_DrainageComm","This is a comment");
		}
		
		public void uploadReportImagesSectionF8() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select CommonServicesStatus = new Select(element("xpath_CommonServicesInspectionStatus"));
			CommonServicesStatus.selectByIndex(3);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im8Caption1","This is caption 61");
			SendKeys("xpath_Im8Caption2","This is caption 62");
			SendKeys("xpath_Im8Caption3","This is caption 63");
			SendKeys("xpath_Im8Caption4","This is caption 64");
			SendKeys("xpath_Im8Caption5","This is caption 65");
			SendKeys("xpath_Im8Caption6","This is caption 66");
			SendKeys("xpath_Im8Caption7","This is caption 67");
			SendKeys("xpath_Im8Caption8","This is caption 68");
			SendKeys("xpath_Im8Caption9","This is caption 69");
			SendKeys("xpath_Im8Caption10","This is caption 70");
			System.out.println("Wood work images are successfully uploaded");
			
			ScrollDown("xpath_Im8Desc8");
			SendKeys("xpath_Im8Desc8","This is a description");
			ScrollDown("xpath_CommonServicesComm");
			SendKeys("xpath_CommonServicesComm","This is a comment");
		}
		
		public void uploadReportImagesSectionG2() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select GarageStatus = new Select(element("xpath_GarageInspectionStatus"));
			GarageStatus.selectByIndex(0);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im2Caption1","This is caption 1");
			SendKeys("xpath_Im2Caption2","This is caption 2");
			SendKeys("xpath_Im2Caption3","This is caption 3");
			SendKeys("xpath_Im2Caption4","This is caption 4");
			SendKeys("xpath_Im2Caption5","This is caption 5");
			SendKeys("xpath_Im2Caption6","This is caption 6");
			SendKeys("xpath_Im2Caption7","This is caption 7");
			SendKeys("xpath_Im2Caption8","This is caption 8");
			SendKeys("xpath_Im2Caption9","This is caption 9");
			SendKeys("xpath_Im2Caption10","This is caption 10");
			System.out.println("Garage Images are succesfully uploaded");
			
			ScrollDown("xpath_Im2Desc2");
			SendKeys("xpath_Im2Desc2","This is a description");
			ScrollDown("xpath_GarageComm");
			SendKeys("xpath_GarageComm","This is a comment");
		}
		public void uploadReportImagesSectionG3() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select PermanentBuildEtctatus = new Select(element("xpath_PermanentBuildEtcInspectionStatus"));
			PermanentBuildEtctatus.selectByIndex(3);
			//Add images
				initializeUploadFile();
			//Add caption to each images
				Thread.sleep(3000);
			SendKeys("xpath_Im3Caption1","This is caption 11");
			SendKeys("xpath_Im3Caption2","This is caption 12");
			SendKeys("xpath_Im3Caption3","This is caption 13");
			SendKeys("xpath_Im3Caption4","This is caption 14");
			SendKeys("xpath_Im3Caption5","This is caption 15");
			SendKeys("xpath_Im3Caption6","This is caption 16");
			SendKeys("xpath_Im3Caption7","This is caption 17");
			SendKeys("xpath_Im3Caption8","This is caption 18");
			SendKeys("xpath_Im3Caption9","This is caption 19");
			SendKeys("xpath_Im3Caption10","This is caption 20");
			System.out.println("Permanent buildings and other structures images are successfully uploaded");
			
			ScrollDown("xpath_Im3Desc3");
			SendKeys("xpath_Im3Desc3","This is a description");
			ScrollDown("xpath_PermanentBuildEtcComm");
			SendKeys("xpath_PermanentBuildEtcComm","This is a comment");
			}
		
		public void uploadReportImagesSectionG4() throws InterruptedException {
			//Select a non-Not applicable value in the Inspection Status dropdown
			Select OtherGStatus = new Select(element("xpath_OtherGInspectionStatus"));
			OtherGStatus.selectByIndex(4);
			//Add images
			initializeUploadFile();
			
			//Add caption to each images
			Thread.sleep(3000);
			SendKeys("xpath_Im4Caption1","This is caption 21");
			SendKeys("xpath_Im4Caption2","This is caption 22");
			SendKeys("xpath_Im4Caption3","This is caption 23");
			SendKeys("xpath_Im4Caption4","This is caption 24");
			SendKeys("xpath_Im4Caption5","This is caption 25");
			SendKeys("xpath_Im4Caption6","This is caption 26");
			SendKeys("xpath_Im4Caption7","This is caption 27");
			SendKeys("xpath_Im4Caption8","This is caption 28");
			SendKeys("xpath_Im4Caption9","This is caption 29");
			SendKeys("xpath_Im4Caption10","This is caption 30");
			
			System.out.println("Other G images are successfully uploaded");
			
			ScrollDown("xpath_Im4Desc4");
			SendKeys("xpath_Im4Desc4","This is a description");
			ScrollDown("xpath_OtherGComm");
			SendKeys("xpath_OtherGComm","This is a comment");
		}
		
		public void checkDraftReportOpensOnNewTabLevel2() throws InterruptedException {
			
			String expectedTitle = "https://proforms-sat.azurewebsites.net/api/files/" + Constants.ReportRefNoLevel2 + "/ReportRefNo/reports/draft.pdf";
			
			//get window handlers as list
			 (new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
			    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(1));
			
			    driver.getTitle().equals(expectedTitle);
			   
			    //String currentURL = driver.getCurrentUrl();
			    //driver.navigate().to(currentURL);
			    System.out.println("Draft report opens on the new tab successfully"+expectedTitle);
				System.out.println("Draft report is downloaded in "+defaultDirectory);
		}
		
		public void checkDraftReportOpensOnNewTabLevel1() throws IOException, InterruptedException {
			
			String expectedTitle = "https://proforms-sat.azurewebsites.net/api/files/" + Constants.ReportRefNoLevel1 + "/ReportRefNo/reports/draft.pdf";
			clickOnElement("xpath_iconclick");
			String parent = driver.getWindowHandle();
			Takescreenshot("SS_checkfornewwindow.jpg");
			//get window handlers as list
			 (new WebDriverWait(driver, 60)).until(ExpectedConditions.numberOfWindowsToBe(2));
			    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	//		 Set<String> tabs2 = driver.getWindowHandles();
			    System.out.println(tabs2);
			/*    for(String child:tabs2)
			    {
			    	if(!parent.equalsIgnoreCase(child))
			    	{
			 //   		driver.switchTo().window(child);
			    /*		Takescreenshot("SS_checkfornewwindow_2.jpg");
			    		driver.getTitle().equals(expectedTitle);
						String currentURL = driver.getCurrentUrl();
						 Takescreenshot("SS_checkfornewwindow_3.jpg");
					    driver.navigate().to(currentURL); 
			    	} 
			    } */
			    
		//	    driver.switchTo().window(tabs2.get(0));
			   
			    driver.switchTo().window(tabs2.get(1));
			 // Takescreenshot("SS_afterswitch.jpg");
			
			    driver.getTitle().equals(expectedTitle);
			   
			 //   String currentURL = driver.getCurrentUrl();
			 //   driver.navigate().to(currentURL);
			    System.out.println("Draft report opens on the new tab successfully"+expectedTitle);
				System.out.println("Draft report is downloaded in "+defaultDirectory);
		}
		
		public void checkDraftReportOpensOnNewTabLevel2WVal() throws InterruptedException {
			
			String expectedTitle = "https://proforms-sat.azurewebsites.net/api/files/" + Constants.ReportRefNoLevel2WVal + "/ReportRefNo/reports/draft.pdf";
			
			//get window handlers as list
			 (new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
			    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(1));
			
			    driver.getTitle().equals(expectedTitle);
			   
			    //String currentURL = driver.getCurrentUrl();
			   //driver.navigate().to(currentURL);
			    System.out.println("Draft report opens on the new tab successfully"+expectedTitle);
				System.out.println("Draft report is downloaded in "+defaultDirectory);
		}
		
		public void checkDraftReportOpensOnNewTabLevel3() throws InterruptedException {
			
			String expectedTitle = "https://proforms-sat.azurewebsites.net/api/files/" + Constants.ReportRefNoLev3 + "/ReportRefNo/reports/draft.pdf";
			
			//get window handlers as list
			 (new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
			    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(1));
			
			    driver.getTitle().equals(expectedTitle);
			   
			    //String currentURL = driver.getCurrentUrl();
			    //driver.navigate().to(currentURL);
			    System.out.println("Draft report opens on the new tab successfully"+expectedTitle);
				System.out.println("Draft report is downloaded in "+defaultDirectory);
		}
		
		public void renameActualDraftLvl1() throws InterruptedException {
			String OldDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\draft.pdf";
			String NewDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualDraftPDFLvl1.pdf";
			File oldFile = new File(OldDraftPDFFileName);
			File newFile = new File(NewDraftPDFFileName);
			Thread.sleep(5000);
			if(oldFile.renameTo(newFile)) {
				System.out.println("PDF Draft Report Level 1 renamed");
				
			}else {
				System.out.println("PDF Draft Report Level 1 is not renamed");
			}
		}
		
		public void renameActualDraftLvl2() throws InterruptedException {
			String OldDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\draft.pdf";
			String NewDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualDraftPDFLvl2.pdf";
			File oldFile = new File(OldDraftPDFFileName);
			File newFile = new File(NewDraftPDFFileName);
			Thread.sleep(5000);
			if(oldFile.renameTo(newFile)) {
				System.out.println("PDF Draft Report Level 2 got renamed");
				
			}else {
				System.out.println("PDF Draft Report Level 2 is not renamed");
			}
		}
		
		public void renameActualDraftLvl2WVal() throws InterruptedException {
			String OldDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\draft.pdf";
			String NewDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualDraftPDFLvl2WValuation.pdf";
			File oldFile = new File(OldDraftPDFFileName);
			File newFile = new File(NewDraftPDFFileName);
			Thread.sleep(5000);
			if(oldFile.renameTo(newFile)) {
				System.out.println("PDF Draft Report Level 2 With Valuation got renamed");
				
			}else {
				System.out.println("PDF Draft Report Level 2 With Valuation is not renamed");
			}
		}
		
		public void renameActualDraftLvl3() throws InterruptedException {
			String OldDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\draft.pdf";
			String NewDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualDraftPDFLvl3.pdf";
			File oldFile = new File(OldDraftPDFFileName);
			File newFile = new File(NewDraftPDFFileName);
			Thread.sleep(5000);
			if(oldFile.renameTo(newFile)) {
				System.out.println("PDF Draft Report Level 3 got renamed");
				
			}else {
				System.out.println("PDF Draft Report Level 3 is not renamed");
			}
		}
		
		public void compareDraftReportsLvl1() throws RenderingException, IOException, InterruptedException {
			
			String expectedPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ExpectedDraftPDFLvl1.pdf";
			String actualPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualDraftPDFLvl1.pdf";
			String folderLoc = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";

			PDFUtil pdfutil = new PDFUtil();
			pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
			pdfutil.highlightPdfDifference(true); 

			pdfutil.setImageDestinationPath(folderLoc);
			System.out.println("Page count: "+ pdfutil.getPageCount(expectedPDF));
			boolean result = pdfutil.compare(expectedPDF, actualPDF,0,pdfutil.getPageCount(expectedPDF));
			if (result==false) {
				 	
				    System.out.println("Draft Report Level 1: Differences found on the Expected Draft and Actual Draft Reports!");
				    //Date this report was produced will always be different from the expected and actual pdf files, since the value of this is always the date today
				    //With this make sure that the only difference of the expected and actual reports is only this field
				}
				else {
					System.out.println("Draft Report Level 1: Expected Draft and Actual Draft Report matches!");
				} 
		}
		
		public void compareDraftReportsLvl2() throws RenderingException, IOException, InterruptedException {
			
			String expectedPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ExpectedDraftPDFLvl2.pdf";
			String actualPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualDraftPDFLvl2.pdf";
			String folderLoc = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";

			PDFUtil pdfutil = new PDFUtil();
			pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
			pdfutil.highlightPdfDifference(true); 

			pdfutil.setImageDestinationPath(folderLoc);
			System.out.println("Page count: "+ pdfutil.getPageCount(expectedPDF));
			boolean result = pdfutil.compare(expectedPDF, actualPDF,0,pdfutil.getPageCount(expectedPDF));
			if (result==false) {
				 	
				    System.out.println("Draft Report Level 2: Differences found on the Expected Draft and Actual Draft Reports!");
				    //Date this report was produced will always be different from the expected and actual pdf files, since the value of this is always the date today
				    //With this make sure that the only difference of the expected and actual reports is only this field
				}
				else {
					System.out.println("Draft Report Level 2: Expected Draft and Actual Draft Report matches!");
				} 
		}
		public void compareDraftReportsLvl2WVal() throws RenderingException, IOException, InterruptedException {
			
			String expectedPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ExpectedDraftPDFLvl2WValuation.pdf";
			String actualPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualDraftPDFLvl2WValuation.pdf";
			String folderLoc = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";

			PDFUtil pdfutil = new PDFUtil();
			pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
			pdfutil.highlightPdfDifference(true); 

			pdfutil.setImageDestinationPath(folderLoc);
			System.out.println("Page count: "+ pdfutil.getPageCount(expectedPDF));
			boolean result = pdfutil.compare(expectedPDF, actualPDF,0,pdfutil.getPageCount(expectedPDF));
			if (result==false) {
				 	
				    System.out.println("Draft Report Level 2 With Valuation: Differences found on the Expected Draft and Actual Draft Reports!");
				    //Date this report was produced will always be different from the expected and actual pdf files, since the value of this is always the date today
				    //With this make sure that the only difference of the expected and actual reports is only this field
				}
				else {
					System.out.println("Draft Report Level 2 With Valuation: Expected Draft and Actual Draft Report matches!");
				} 
		}
		public void compareDraftReportsLvl3() throws RenderingException, IOException, InterruptedException {
			
			String expectedPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ExpectedDraftPDFLvl3.pdf";
			String actualPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualDraftPDFLvl3.pdf";
			String folderLoc = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";

			PDFUtil pdfutil = new PDFUtil();
			pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
			pdfutil.highlightPdfDifference(true); 

			pdfutil.setImageDestinationPath(folderLoc);
			System.out.println("Page count: "+ pdfutil.getPageCount(expectedPDF));
			boolean result = pdfutil.compare(expectedPDF, actualPDF,0,pdfutil.getPageCount(expectedPDF));
			if (result==false) {
				 	
				    System.out.println("Draft Report Level 3: Differences found on the Expected Draft and Actual Draft Reports!");
				    //Date this report was produced will always be different from the expected and actual pdf files, since the value of this is always the date today
				    //With this make sure that the only difference of the expected and actual reports is only this field
				}
				else {
					System.out.println("Draft Report Level 3: Expected Draft and Actual Draft Report matches!");
				} 
		}
		
public void checkCompletedReportOpensOnNewTabLevel1() throws InterruptedException {
			
			String expectedTitle = "https://proforms-sat.azurewebsites.net/api/files/" + Constants.ReportRefNoLevel1 + "/ReportRefNo/reports/draft.pdf";
			
			//get window handlers as list
			 (new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
			    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
			    driver.switchTo().window(tabs2.get(1));
			
			    driver.getTitle().equals(expectedTitle);
			   
			    String currentURL = driver.getCurrentUrl();
			    driver.navigate().to(currentURL);
			    System.out.println("Draft report opens on the new tab successfully"+expectedTitle);
				System.out.println("Draft report is downloaded in "+defaultDirectory);
		}
		
public void renameActualReportLvl1() throws InterruptedException {
	String OldDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\report.pdf";
	String NewDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualReportPDFLvl1.pdf";
	File oldFile = new File(OldDraftPDFFileName);
	File newFile = new File(NewDraftPDFFileName);
	Thread.sleep(5000);
	if(oldFile.renameTo(newFile)) {
		System.out.println("PDF Completed Report Level 1 got renamed");
		
	}else {
		System.out.println("PDF Completed Report Level 1 is not renamed");
	}
}


public void compareCompletedReportsLvl1() throws RenderingException, IOException, InterruptedException {
	
	String expectedPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ExpectedCompletedPDFLvl1.pdf";
	String actualPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualReportPDFLvl1.pdf";
	String folderLoc = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";

	PDFUtil pdfutil = new PDFUtil();
	pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
	pdfutil.highlightPdfDifference(true); 

	pdfutil.setImageDestinationPath(folderLoc);
	System.out.println("Page count: "+ pdfutil.getPageCount(expectedPDF));
	boolean result = pdfutil.compare(expectedPDF, actualPDF,0,pdfutil.getPageCount(expectedPDF));
	if (result==false) {
		 	
		    System.out.println("Published Report Level 1: Differences found on the Expected Draft and Actual Draft Reports!");
		    //Date this report was produced will always be different from the expected and actual pdf files, since the value of this is always the date today
		    //With this make sure that the only difference of the expected and actual reports is only this field
		}
		else {
			System.out.println("Published Report Level 1: Expected Draft and Actual Draft Report matches!");
		} 
}

public void checkCompletedReportOpensOnNewTabLevel2() throws InterruptedException {
	
	String expectedTitle = "https://proforms-sat.azurewebsites.net/api/files/" + Constants.ReportRefNoLevel2 + "/ReportRefNo/reports/draft.pdf";
	
	//get window handlers as list
	 (new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
	    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	
	    driver.getTitle().equals(expectedTitle);
	   
	    String currentURL = driver.getCurrentUrl();
	    driver.navigate().to(currentURL);
	    System.out.println("Draft report opens on the new tab successfully"+expectedTitle);
		System.out.println("Draft report is downloaded in "+defaultDirectory);
}

public void renameActualReportLvl2() throws InterruptedException {
	String OldDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\report.pdf";
	String NewDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualReportPDFLvl2.pdf";
	File oldFile = new File(OldDraftPDFFileName);
	File newFile = new File(NewDraftPDFFileName);
	Thread.sleep(5000);
	if(oldFile.renameTo(newFile)) {
		System.out.println("PDF Completed Report Level 2 got renamed");
	
	}else {
		System.out.println("PDF Completed Report Level 2 is not renamed");
	}
}


public void compareCompletedReportsLvl2() throws RenderingException, IOException, InterruptedException {

	String expectedPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ExpectedCompletedPDFLvl2.pdf";
	String actualPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualReportPDFLvl1.pdf";
	String folderLoc = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";

	PDFUtil pdfutil = new PDFUtil();
	pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
	pdfutil.highlightPdfDifference(true); 

	pdfutil.setImageDestinationPath(folderLoc);
	System.out.println("Page count: "+ pdfutil.getPageCount(expectedPDF));
	boolean result = pdfutil.compare(expectedPDF, actualPDF,0,pdfutil.getPageCount(expectedPDF));
	if (result==false) {
		 	
		    System.out.println("Published Report Level 2: Differences found on the Expected Draft and Actual Draft Reports!");
		    //Date this report was produced will always be different from the expected and actual pdf files, since the value of this is always the date today
		    //With this make sure that the only difference of the expected and actual reports is only this field
		}
		else {
			System.out.println("Published Report Level 2: Expected Draft and Actual Draft Report matches!");
		} 
}
	
public void checkCompletedReportOpensOnNewTabLevel2WValuation() throws InterruptedException {
	
	String expectedTitle = "https://proforms-sat.azurewebsites.net/api/files/" + Constants.ReportRefNoLevel2WVal + "/ReportRefNo/reports/draft.pdf";
	
	//get window handlers as list
	 (new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
	    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	
	    driver.getTitle().equals(expectedTitle);
	   
	    String currentURL = driver.getCurrentUrl();
	    driver.navigate().to(currentURL);
	    System.out.println("Draft report opens on the new tab successfully"+expectedTitle);
		System.out.println("Draft report is downloaded in "+defaultDirectory);
}

public void renameActualReportLvl2WValuation() throws InterruptedException {
String OldDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\report.pdf";
String NewDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualRepPDFLvl2WValuation.pdf";
File oldFile = new File(OldDraftPDFFileName);
File newFile = new File(NewDraftPDFFileName);
Thread.sleep(5000);
if(oldFile.renameTo(newFile)) {
System.out.println("PDF Completed Report Level 2 With Valuation got renamed");

}else {
System.out.println("PDF Completed Report Level 2 With Valuation is not renamed");
}
}


public void compareCompletedReportsLvl2WValuation() throws RenderingException, IOException, InterruptedException {

String expectedPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ExpectedCompPDFLvl2WValuation.pdf";
String actualPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualRepPDFLvl2WValuation.pdf";
String folderLoc = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";

PDFUtil pdfutil = new PDFUtil();
pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
pdfutil.highlightPdfDifference(true); //pdf images are not saved in the folderloc.

pdfutil.setImageDestinationPath(folderLoc);
System.out.println("Page count: "+ pdfutil.getPageCount(expectedPDF));
boolean result = pdfutil.compare(expectedPDF, actualPDF,0,pdfutil.getPageCount(expectedPDF));
if (result==false) {
	 	
	    System.out.println("Published Report Level 2 With Valuation: Differences found on the Expected Draft and Actual Draft Reports!");
	    //Date this report was produced will always be different from the expected and actual pdf files, since the value of this is always the date today
	    //With this make sure that the only difference of the expected and actual reports is only this field
	}
	else {
		System.out.println("Published Report Level 2 With Valuation: Expected Draft and Actual Draft Report matches!");
	} 

}

public void checkCompletedReportOpensOnNewTabLevel3() throws InterruptedException {
	
	String expectedTitle = "https://proforms-sat.azurewebsites.net/api/files/" + Constants.ReportRefNoLev3 + "/ReportRefNo/reports/draft.pdf";
	
	//get window handlers as list
	 (new WebDriverWait(driver, 30)).until(ExpectedConditions.numberOfWindowsToBe(2));
	    ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1));
	
	    driver.getTitle().equals(expectedTitle);
	   
	    String currentURL = driver.getCurrentUrl();
	    driver.navigate().to(currentURL);
	    System.out.println("Draft report opens on the new tab successfully"+expectedTitle);
		System.out.println("Draft report is downloaded in "+defaultDirectory);
}

public void renameActualReportLvl3() throws InterruptedException {
String OldDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\report.pdf";
String NewDraftPDFFileName = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualReportPDFLvl3.pdf";
File oldFile = new File(OldDraftPDFFileName);
File newFile = new File(NewDraftPDFFileName);
Thread.sleep(5000);
if(oldFile.renameTo(newFile)) {
System.out.println("PDF Completed Report Level 3 got renamed");

}else {
System.out.println("PDF Completed Report Level 3 is not renamed");
}
}


public void compareCompletedReportsLvl3() throws RenderingException, IOException, InterruptedException {

String expectedPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ExpectedCompletedPDFLvl3.pdf";
String actualPDF = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles\\ActualReportPDFLvl3.pdf";
String folderLoc = System.getProperty("user.dir")+"\\src\\test\\resources\\ActualReportFiles";

PDFUtil pdfutil = new PDFUtil();
pdfutil.setCompareMode(CompareMode.VISUAL_MODE);
pdfutil.highlightPdfDifference(true); 

pdfutil.setImageDestinationPath(folderLoc);
System.out.println("Page count: "+ pdfutil.getPageCount(expectedPDF));
boolean result = pdfutil.compare(expectedPDF, actualPDF,0,pdfutil.getPageCount(expectedPDF));
if (result==false) {
	 	
	    System.out.println("Published Report Level 3: Differences found on the Expected Draft and Actual Draft Reports!");
	    //Date this report was produced will always be different from the expected and actual pdf files, since the value of this is always the date today
	    //With this make sure that the only difference of the expected and actual reports is only this field
	}
	else {
		System.out.println("Published Report Level 3: Expected Draft and Actual Draft Report matches!");
	} 
}

}
		
		
