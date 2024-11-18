package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	@FindBy(linkText = "Signup / Login")
	public
	WebElement SignUpLoginBtn;
	@FindBy(xpath = "//a[contains(.,' Home')]")
	public
	WebElement HomeBtn;
	
	@FindBy(xpath = "//*[@id=\"header\"]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[10]/a[1]")
	public
	WebElement LoggedInAs_Message;
	
	@FindBy(xpath ="//*[@id=\"header\"]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[4]/a[1]")
	WebElement logOutBtn;
	
	public void OpenRegistrationPage() {
		SignUpLoginBtn.click();
	}
	public void OpenLoginPage() {
		SignUpLoginBtn.click();
	}
	public void logOut() {
		logOutBtn.click();
	}

}
