package pompackage;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyFacultyPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://mmcoe.edu.in/");
		driver.manage().window().maximize();
		
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
		
		//facultyInfoPage.moveMouseAndClickHostel();
		facultyInfoPage.clickFacebook();
		facultyInfoPage.sendEmail("santosh");
		facultyInfoPage.sendPass("kedari");
		facultyInfoPage.clickForgetAccount();
		
		
		//facultyInfoPage.clickRegistrationForm();
	}

}
