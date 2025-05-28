package TestNGPack;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pompackage.FacultyInfoPage;
import pompackage.FindYourAccount;
import pompackage.HostelRegistrationForm;

public class VerifyFacultyPages {

	
	private WebDriver driver;
	
	
	@BeforeClass
	public void launchBrowser(String browser) {
		
		
	     driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mmcoe.edu.in/");
		driver.manage().window().maximize();	
	}
	
	@Test (priority=1)
	public void verifyFacultyPageInfo() {
			
         FacultyInfoPage facultyInfoPage=new FacultyInfoPage(driver);
		
		facultyInfoPage.moveMouseAndClickMechDept();
		facultyInfoPage.clickFaculty();
		String actual=facultyInfoPage.textMessage();
		if(actual.equals("Mr. Santosh J. Kedari"))
		{
			System.out.println("Message is right");
		}
		else
		{
			System.out.println("Message is wrong");
		}
				
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.kotak.com/en/personal-banking/insurance/health-insurance/kotak-health-premier.html");
	}
	
	
	@Test (enabled=false)
	public void verifyHostelForm() {
			
		FacultyInfoPage facultyInfoPage=new FacultyInfoPage(driver);
		facultyInfoPage.moveMouseAndClickHostel();
		facultyInfoPage.clickRegistrationForm();

		ArrayList<String> add=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		
		HostelRegistrationForm hostelRegistrationForm=new HostelRegistrationForm(driver);
		
		hostelRegistrationForm.sendEmailOrPhone("santoshkedari@mmcoe.edu.in");
		hostelRegistrationForm.clickNext();
		
	}
	
	@Test (enabled=false)
	public void verifyFindYourAccount() {
			
		FacultyInfoPage facultyInfoPage=new FacultyInfoPage(driver);
        facultyInfoPage.clickFacebook();
		facultyInfoPage.sendEmail("santosh");
		facultyInfoPage.sendPass("kedari");
		facultyInfoPage.clickForgetAccount();
        
        
        ArrayList<String> add=new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(add.get(1));
		
		FindYourAccount findYourAccount=new FindYourAccount(driver);
		findYourAccount.sendEmailOrPhone("9049657550");
		
		String actual=findYourAccount.textMessage();
		
		if(actual.equals("Please enter your email address or mobile number to search for your account."))
		{
			System.out.println("Message is right");
		}
	}
	
		@AfterClass
		public void tearDown() 
		{
		
	     driver.quit();	
		}
	
}
