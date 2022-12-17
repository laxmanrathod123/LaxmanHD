package PagaObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AbstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent{
	
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	WebDriver driver;
	@FindBy(id="userEmail")
	WebElement username;
	
	@FindBy(id="userPassword")
	WebElement passwordele;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginbutton;
	
	public void goTo() {
		
		// here we can keep our Dev, Test, and Production url
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	public ProductCatelogue LoginToApplication(String email,String password) {
		username.sendKeys(email);
		passwordele.sendKeys(password);
		loginbutton.click();
		ProductCatelogue ProductCatelogue = new ProductCatelogue(driver);
		return ProductCatelogue;
	}
	
	

}
