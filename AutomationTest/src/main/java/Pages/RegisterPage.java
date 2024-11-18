package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends PageBase{
	
	
	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(name = "name")
	public
	WebElement nameTxt;
	@FindBy(xpath ="//*[@id=\"form\"]/div[1]/div[1]/div[3]/div[1]/form[1]/input[3]")
	public
	WebElement emailTxt;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div[1]/div[1]/div[3]/div[1]/form[1]/button[1]")
	WebElement SignUpBtn;
	
	@FindBy(xpath ="//*[@id=\"form\"]/div[1]/div[1]/div[3]/div[1]/h2[1]")
	public
	WebElement NewUser_Signup_Message;
	@FindBy(xpath ="//*[@id=\"form\"]/div[1]/div[1]/div[1]/div[1]/h2[1]/b[1]")
	public
	WebElement SignUp_Message;
	
	@FindBy(xpath ="//*[@id=\"form\"]/div[1]/div[1]/div[1]/h2[1]/b[1]")
	public
	WebElement AccountCreated_Message;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement continueBtn;
	
	@FindBy(linkText = "Delete Account")
	WebElement Delete_AccountBtn;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div[1]/div[1]/div[1]/div[1]/a[1]")
	WebElement continue_deleteAccountBtn;
	
	@FindBy(xpath ="//*[@id=\"form\"]/div[1]/div[1]/div[1]/h2[1]/b[1]")
	public
	WebElement Delete_Account_Message;
	
	@FindBy(xpath = "//*[@id=\"form\"]/div[1]/div[1]/div[3]/div[1]/form[1]/p[1]")
	public
	WebElement emailExsit_Message;
	
	@FindBy(id ="name")
	public
	WebElement assretName;
	
	@FindBy(id = "id_gender1")
	WebElement maleGenderRadioBtn;
	
	@FindBy(id ="password")
	public
	WebElement passwordTxt;
	
	@FindBy(id ="days")
	WebElement daysList;
	
	@FindBy(id ="months")
	WebElement monthsList;
	
	@FindBy(id ="years")
	WebElement yearsList;
	
	@FindBy(id ="newsletter")
	WebElement newsletterCheckBox;
	
	@FindBy(id ="optin")
	WebElement SpicalOfferCheckBox;
	@FindBy(id = "first_name")
	public
	WebElement fristNameTxt;
	
	@FindBy(id ="last_name")
	public
	WebElement lastNameTxt;
	
	@FindBy(id ="company")
	WebElement companyTxt;
	
	@FindBy(id ="address1")
	public
	WebElement address1Txt;
	
	@FindBy(id ="address2")
	WebElement address2Txt;
	
	@FindBy(id ="country")
	public
	WebElement countryDropdown;
	
	@FindBy(id ="state")
	public
	WebElement stateTxt;
	
	@FindBy(id ="city")
	public
	WebElement cityTxt;
	
	@FindBy(id ="zipcode")
	public
	WebElement zipcodeTxt;
	
	@FindBy(id ="mobile_number")
	public
	WebElement mobileNumberTxt;
	
	@FindBy(css= "button.btn.btn-default")
	WebElement createAccountBtn;
	
	public void newUserSignUp(String name, String email) {
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(email);
		SignUpBtn.click();
	}
	
	public void RegisterwithAllData
	(String password, String day, String month, String year,String name, String lname, String company, String address1, String address2, String country, String state, String city, String zipCode, String mobileNumber ) {
		maleGenderRadioBtn.click();
		passwordTxt.sendKeys(password);
		Select makeDaysList = new Select(daysList);
		Select makeMonthsList = new Select(monthsList);
		Select makeYearsList = new Select(yearsList);
		Select makeCountryList = new Select(countryDropdown);
		makeDaysList.selectByValue(day);
		makeMonthsList.selectByValue(month);
		makeYearsList.selectByValue(year);
		newsletterCheckBox.click();
		SpicalOfferCheckBox.click();
		fristNameTxt.sendKeys(name);
		lastNameTxt.sendKeys(lname);
		companyTxt.sendKeys(company);
		address1Txt.sendKeys(address1);
		address2Txt.sendKeys(address2);
		makeCountryList.selectByValue(country);
		stateTxt.sendKeys(state);
		cityTxt.sendKeys(city);
		zipcodeTxt.sendKeys(zipCode);
		mobileNumberTxt.sendKeys(mobileNumber);
		createAccountBtn.click();
	}
	public void RegisterwithMandatory
	(String password,String name, String lname, String address1, String country, String state, String city, String zipCode, String mobileNumber ) {
		maleGenderRadioBtn.click();
		passwordTxt.sendKeys(password);
		Select makeCountryList = new Select(countryDropdown);
		newsletterCheckBox.click();
		SpicalOfferCheckBox.click();
		fristNameTxt.sendKeys(name);
		lastNameTxt.sendKeys(lname);
		address1Txt.sendKeys(address1);
		makeCountryList.selectByValue(country);
		stateTxt.sendKeys(state);
		cityTxt.sendKeys(city);
		zipcodeTxt.sendKeys(zipCode);
		mobileNumberTxt.sendKeys(mobileNumber);
		createAccountBtn.click();	
	}
	public void RegisterwithBlank() {
		createAccountBtn.click();	
	}
	public void accountContinue() {
		continueBtn.click();
	}
	public void DeleteAccount() {
		Delete_AccountBtn.click();
	}
	public void continueDeleteAccount() {
		continue_deleteAccountBtn.click();
	}

}
