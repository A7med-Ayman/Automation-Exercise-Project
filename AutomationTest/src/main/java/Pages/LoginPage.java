package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{
	
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath = "//h2[contains(.,'Login to your account')]")
	public
	WebElement Login_Massege;
	@FindBy(xpath ="//input[@data-qa='login-email']")
	public
	WebElement loginEmailTxt;
	
	@FindBy(xpath ="//input[@data-qa='login-password']")
	WebElement loginPasswordTxt;
	@FindBy(xpath="//button[contains(@data-qa,'login-button')]")
	WebElement loginBtn;
	
	@FindBy(linkText = "Delete Account")
	WebElement Delete_AccountBtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement continue_deleteAccountBtn;
	
	@FindBy(xpath ="//*[@id=\"form\"]/div[1]/div[1]/div[1]/h2[1]/b[1]")
	public
	WebElement Delete_Account_Message;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div/div/div[1]/div/form/p")
	public
	WebElement incorrectEmail_Massege;
	
	public void login(String email, String password) {
		loginEmailTxt.sendKeys(email);
		loginPasswordTxt.sendKeys(password);
		loginBtn.click();
	}
	public void DeleteAccount() {
		Delete_AccountBtn.click();
	}
	public void continueDeleteAccount() {
		continue_deleteAccountBtn.click();
	}


}
