package TestNgPack2;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Browser;
import pompackage.FacultyInfoPage;
import pompackage.FindYourAccount;
import pompackage.HostelRegistrationForm;

public class VerifyHostelForm extends Browser {

	private WebDriver driver;
	private FacultyInfoPage facultyInfoPage;
	private FindYourAccount findYourAccount;
	private  HostelRegistrationForm hostelRegistrationForm;
	
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
	
	@Test  (priority=1)
	public void verifyFacultyPageInfo() {
		driver.get("https://mmcoe.edu.in/");
	
		facultyInfoPage.moveMouseAndClickMechDept();
		facultyInfoPage.clickFaculty();
		String actual=facultyInfoPage.textMessage();
        String expected="Mr. Santosh J. Kedari";
		
		Assert.assertEquals(actual, expected);
				
		
	}
	
	
	@Test (enabled=false)
	public void verifyHostelForm() {
			
	
		facultyInfoPage.moveMouseAndClickHostel();
		facultyInfoPage.clickRegistrationForm();

		ArrayList<String> add=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		
		hostelRegistrationForm.sendEmailOrPhone("santoshkedari@mmcoe.edu.in");
		hostelRegistrationForm.clickNext();
		
	}
	
	@Test  (priority=2)
	public void verifyFindYourAccount() {
			
        facultyInfoPage.clickFacebook();
		facultyInfoPage.sendEmail("santosh");
		facultyInfoPage.sendPass("kedari");
		facultyInfoPage.clickForgetAccount();
        
        
        ArrayList<String> add=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		
		findYourAccount.sendEmailOrPhone("9049657550");
		
		String actual=findYourAccount.textMessage();
		String expected="Please enter your email address or mobile number to search for your account.";
		
		Assert.assertEquals(actual, expected);
	}
	
	
				
		@AfterClass
		public void afterclass()
		{
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



