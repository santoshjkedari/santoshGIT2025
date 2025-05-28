package pompackage;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyFindYourAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mmcoe.edu.in/");
		driver.manage().window().maximize();
		
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
		
		else
		{
			System.out.println("Message is wrong");
		}
	}
}
