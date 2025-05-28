package pompackage;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HostelRegistrationForm {

	
	
	
	private WebDriver driver;
	private Actions act;
	
	
	@FindBy (xpath="//input[@type='email']")
     private WebElement emailOrPhone;
	
	@FindBy (xpath="//span[text()='Next']")
    private WebElement next;
	
	
	@FindBy (xpath="//input[@type='password']")
   private WebElement password;
	
	public  HostelRegistrationForm (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		act=new Actions(driver);
	}
	
	public void sendEmailOrPhone(String email)
	{
		//emailOrPhone.sendKeys(email);
		emailOrPhone.click();
	}
	public void clickNext()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", next);
	
	}
	public void sendPassword(String pass)
	{
		
		password.sendKeys(pass);
		
		
		/*WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(password));
		password.sendKeys(pass);*/
		
		
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", password);*/
		
		
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.display = 'block';",password);
		password.sendKeys(pass);*/
	}
}
