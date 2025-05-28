package TestNgPack2;
import java.io.IOException;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Browser;
import pompackage.FacultyInfoPage;
import pompackage.FindYourAccount;
import pompackage.HostelRegistrationForm;
import utils.Utility;

public class VerifyFacultyPage2 extends Browser {

	
	private WebDriver driver;
	private FacultyInfoPage facultyInfoPage;
	private FindYourAccount findYourAccount;
	private  HostelRegistrationForm hostelRegistrationForm;
	String testId;
	
	@Parameters("browser123")
	@BeforeTest
	public void launchBrowser(String browser) {
		
		if(browser.equals("Chrome"))
		{
			driver=openChromeBrowser();
		}
		if(browser.equals("Firefox"))
		{
			driver=openFirefoxBrowser();
		}
	   
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.get("https://mmcoe.edu.in/");
		driver.manage().window().maximize();	
	}
	
	@BeforeClass
	public void pomObject()
	{
		 facultyInfoPage=new FacultyInfoPage(driver);
		hostelRegistrationForm=new HostelRegistrationForm(driver);
		 findYourAccount=new FindYourAccount(driver);
	}
	
	@Test  
	public void verifyFacultyPageInfo() {
		testId="T01";
		driver.get("https://mmcoe.edu.in/");
	
		facultyInfoPage.moveMouseAndClickMechDept();
		facultyInfoPage.clickFaculty();
		String actual=facultyInfoPage.textMessage();
		String expected="Mr. Santosh J.";
		
		
		Assert.assertEquals(actual, expected);
		
		/*SoftAssert soft=new SoftAssert();
		soft.assertEquals(actual,expected);
		soft.assertAll();*/
		
		
		/*if(actual.equals("Mr. Santosh J. Kedari"))
		{
			System.out.println("Message is right");
		}
		else
		{
			System.out.println("Message is wrong");
		}*/
				
		
	}
	
	
	@Test (enabled=false)
	public void verifyHostelForm() {
		testId="T02";
			
	
		facultyInfoPage.moveMouseAndClickHostel();
		facultyInfoPage.clickRegistrationForm();

		ArrayList<String> add=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		
		hostelRegistrationForm.sendEmailOrPhone("santoshkedari@mmcoe.edu.in");
		hostelRegistrationForm.clickNext();
		
	}
	
	@Test 
	public void verifyFindYourAccount() throws IOException {
		testId="T03";
			
        facultyInfoPage.clickFacebook();
		
      //fetching data from excel sheet using utils package & UtilityClass
      	String filePath=System.getProperty("user.dir")+"\\excelTestData\\emailpass.xlsx";
        facultyInfoPage.sendEmail(Utility.getDataFromExcel(filePath,"TestData",1, 0));
		facultyInfoPage.sendPass(Utility.getDataFromExcel(filePath,"TestData",1, 1));
		
		/*facultyInfoPage.sendEmail("santosh");
		facultyInfoPage.sendPass("kedari");*/
		
		facultyInfoPage.clickForgetAccount();
        
        
        ArrayList<String> add=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		
		findYourAccount.sendEmailOrPhone("9049657550");
		
		String actual=findYourAccount.textMessage();
		String expected="Please enter your email address or mobile number to search for your account.";
		
		Assert.assertEquals(actual, expected);
		
		/*SoftAssert soft=new SoftAssert();
		soft.assertEquals(actual,expected);
		soft.assertAll();*/
		
		
		/*if(actual.equals("Please enter your email address or mobile number to search for your account."))
		{
			System.out.println("Message is right");
		}*/
	}
	
	
				
		@AfterClass
		public void afterclass(ITestResult result) throws IOException
		{
			if(ITestResult.FAILURE==result.getStatus()) 
			{
				Utility.captureScreenShot(testId);
			}
		
		 facultyInfoPage= null; 
		 hostelRegistrationForm= null;
		findYourAccount= null;
		}
		
		
		@AfterTest
		public void afterTest()
		{
		 driver.close();
		 driver=null;
		 System.gc();
		}
	
		
	
}
