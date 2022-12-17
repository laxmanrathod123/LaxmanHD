package PagaObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	WebDriver driver;
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProduct;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutBtn;
	
	public CartPage(WebDriver driver) {

		this.driver= driver;
		PageFactory.initElements(driver, this);
	}

	public boolean verifyProductDisplay(String productName) {
		boolean match=cartProduct.stream().anyMatch(product-> product.getText().equals(productName));
		return match;
	}
	
	public CheckOut goToCheckOut() {
		checkoutBtn.click();
		CheckOut CheckOut=new CheckOut(driver);
		return CheckOut;
		
	}

}
