package pompackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindYourAccount {

	private WebDriver driver;
	@FindBy (xpath="//input[@id='identify_email']")
    private WebElement phoneOrEmail;
	
	
	@FindBy (xpath="//div[contains(text(),'Please enter your email address or mobile number to search for your account.')]")
    private WebElement getTextMessage;
	


       public FindYourAccount (WebDriver driver)
       {
    	   PageFactory.initElements(driver, this);
   			this.driver=driver;
       }

       public void sendEmailOrPhone(String emailOrPhone)
   	{
    	   phoneOrEmail.sendKeys(emailOrPhone);
   	}
       
       public String textMessage()
   	{
   		String text=getTextMessage.getText();
   		System.out.println(text);
   		return text;	
   	}
}