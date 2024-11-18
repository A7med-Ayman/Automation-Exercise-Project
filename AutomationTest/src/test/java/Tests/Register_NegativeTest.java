package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.RegisterPage;

public class Register_NegativeTest extends TestBase{
	HomePage homeObject;
	RegisterPage registerObject;
	public void intialization() {
		homeObject = new HomePage(driver);
		registerObject = new RegisterPage(driver);
	}
  @Test (priority = 1)
  public void Register_withExist_Email() {
	  intialization();
	  Assert.assertEquals(homeObject.HomeBtn.getCssValue("color"),"rgba(255, 165, 0, 1)");
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("John","John@hotmail.com");
	  Assert.assertEquals(registerObject.emailExsit_Message.getText(), "Email Address already exist!");
  }
  @Test (priority = 2)
  public void Register_Invalid_Email_Withoutdomain() throws InterruptedException {
	  intialization();
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("John","John");
	  Assert.assertTrue(registerObject.emailTxt.getAttribute("validationMessage").contains("Please include an '@' in the email address") );
	  Thread.sleep(3000);
  }
  @Test (priority = 3)
  public void Register_withInvalid_Email() throws InterruptedException {
	  intialization();
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("John","John@");
	  Assert.assertTrue(registerObject.emailTxt.getAttribute("validationMessage").contains("Please enter a part following '@'") );
	  Thread.sleep(3000);
  }
  @Test (priority = 4)
  public void Register_withspacesIn_Email() throws InterruptedException {
	  intialization();
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("John","John@  gmail.com");
	  Assert.assertTrue(registerObject.emailTxt.getAttribute("validationMessage").contains("A part following '@' should not contain the symbol ' '.") );
	  Thread.sleep(3000);
  }
  @Test (priority = 5)
  public void Register_withsBlankname() throws InterruptedException {
	  intialization();
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("","Test@gmail.com");
	  Assert.assertTrue(registerObject.nameTxt.getAttribute("validationMessage").contains("Please fill out this field.") );
	  Thread.sleep(3000);
  }
  @Test (priority = 6)
  public void Register_withsBlankemail() throws InterruptedException {
	  intialization();
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("Test","");
	  Assert.assertTrue(registerObject.emailTxt.getAttribute("validationMessage").contains("Please fill out this field."));
	  Thread.sleep(3000);
  }
  @Test (priority = 7)
  public void Register_withMandatoryBlank() throws InterruptedException {
	  intialization();
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("Ahmed", "Ahmed@test1.com");
	  Assert.assertEquals(registerObject.SignUp_Message.getText(), "ENTER ACCOUNT INFORMATION");
	  Assert.assertEquals(registerObject.assretName.getAttribute("value"), "Ahmed");
	  Thread.sleep(2000);
	  registerObject.RegisterwithBlank();
	  Assert.assertTrue(registerObject.passwordTxt.getAttribute("validationMessage").contains("Please fill out this field."));
	  Assert.assertTrue(registerObject.fristNameTxt.getAttribute("validationMessage").contains("Please fill out this field."));
	  Assert.assertTrue(registerObject.lastNameTxt.getAttribute("validationMessage").contains("Please fill out this field."));
	  Assert.assertTrue(registerObject.stateTxt.getAttribute("validationMessage").contains("Please fill out this field."));
	  Assert.assertTrue(registerObject.cityTxt.getAttribute("validationMessage").contains("Please fill out this field."));
	  Assert.assertTrue(registerObject.zipcodeTxt.getAttribute("validationMessage").contains("Please fill out this field."));
	  Assert.assertTrue(registerObject.mobileNumberTxt.getAttribute("validationMessage").contains("Please fill out this field."));
	  Thread.sleep(3000);
	  
  }  
}
