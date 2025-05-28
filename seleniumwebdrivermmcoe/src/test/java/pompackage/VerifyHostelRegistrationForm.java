package pompackage;

import java.time.Duration;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class VerifyHostelRegistrationForm {
	public static void main(String[] args) {
	
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://mmcoe.edu.in/");
	driver.manage().window().maximize();
	
	FacultyInfoPage facultyInfoPage=new FacultyInfoPage(driver);
	facultyInfoPage.moveMouseAndClickHostel();
	facultyInfoPage.clickRegistrationForm();

	ArrayList<String> add=new ArrayList<String> (driver.getWindowHandles());
	driver.switchTo().window(add.get(1));
	
	HostelRegistrationForm hostelRegistrationForm=new HostelRegistrationForm(driver);
	
	hostelRegistrationForm.sendEmailOrPhone("santoshkedari@mmcoe.edu.in");
	hostelRegistrationForm.clickNext();
	hostelRegistrationForm.sendPassword("santosh123");
	hostelRegistrationForm.clickNext();
	
	
	}
}
