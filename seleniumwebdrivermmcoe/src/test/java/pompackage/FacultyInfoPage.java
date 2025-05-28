package pompackage;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FacultyInfoPage {
	
	
	private WebDriver driver;
	private Actions act;
	
	
	@FindBy (xpath="(//a[text()='Academic'])[1]")
     private WebElement academic;
	
	@FindBy (xpath="(//a[@class='menu-link'])[23]")
    private WebElement UGPrograme;
	
	@FindBy (xpath="(//a[contains(@href,'https://mmcoe.edu.in/departments/mechanical')])[1]")
    private WebElement mechanicalEngg;
	
	@FindBy (xpath="(//span[text()='Faculty'])[2]")
    private WebElement faculty;
	
	@FindBy (xpath="(//div[@class='team_member_box_overlay_title'])[27]")
    private WebElement getTextMessage;
	
	@FindBy (xpath="(//a[contains(@href,'https://mmcoe.edu.in/facilities')])[3]")
    private WebElement facility;
	
	@FindBy (xpath="(//a[contains(@href,'https://mmcoe.edu.in/facilities/hostel')])[1]")
    private WebElement hostel;
	
	@FindBy (xpath="//i[contains(@class,'fa fa-facebook')]")
    private WebElement facebook;
	
	@FindBy (xpath="(//input[@name='email'])[1]")
    private WebElement email;
	
	@FindBy (xpath="(//input[@name='pass'])[2]")
    private WebElement pass;
	
	@FindBy (xpath="//span[@dir='auto' and text()='Forgotten password?']")
    private WebElement forgetPassword;
	
	
	@FindBy (xpath="//span[text()='Registration Form']")
    private WebElement registrationForm;
	
	
	public  FacultyInfoPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
		
	}
	
	public void moveMouseAndClickMechDept()
	{
		act.moveToElement(academic).moveToElement(UGPrograme).moveToElement(mechanicalEngg).click().build().perform();
	}
	
	public void clickFaculty()
	{
		faculty.click();
	}
	
	public String textMessage()
	{
		String text=getTextMessage.getText();
		System.out.println(text);
		return text;	
	}
	
	public void moveMouseAndClickHostel()
	{
		act.moveToElement(facility).moveToElement(hostel).click().build().perform();
	}
	
	
	public void clickFacebook()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", facebook);
	}
	
	public void sendEmail(String emails)
	{
		email.sendKeys(emails);
	}
	
	public void sendPass(String password)
	{
		pass.sendKeys(password);
	}
	
	public void clickForgetAccount()
	{
		forgetPassword.click();
	}
	
	public void clickRegistrationForm()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].click();", registrationForm);
		
		
		/*WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(registrationForm));
		registrationForm.click();*/
	}
}
