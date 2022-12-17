package AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PagaObject.CartPage;

public class AbstractComponent {
	WebDriver driver;
	public AbstractComponent(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement addToCartPagebtnp;
	
	public void waitForElementToAppear(By findBy) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void waitForElementToDisAppear(WebElement ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
		}
	
	public CartPage goToCartPage() {
		addToCartPagebtnp.click();
		CartPage CartPage= new CartPage(driver);
		return CartPage;
		
	}

}
