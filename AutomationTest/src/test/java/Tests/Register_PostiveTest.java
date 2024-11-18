package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.RegisterPage;

public class Register_PostiveTest extends TestBase{
	HomePage homeObject;
	RegisterPage registerObject;
	public void intialization() {
		homeObject = new HomePage(driver);
		registerObject = new RegisterPage(driver);
	}
	
  @Test (priority = 1)
  public void Register_withAllData() throws InterruptedException {
	  intialization();
	  Assert.assertEquals(homeObject.HomeBtn.getCssValue("color"),"rgba(255, 165, 0, 1)");
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("Ahmed", "Ahmed@h.com");
	  Assert.assertEquals(registerObject.SignUp_Message.getText(), "ENTER ACCOUNT INFORMATION");
	  Assert.assertEquals(registerObject.assretName.getAttribute("value"), "Ahmed");
	  Thread.sleep(2000);
	  registerObject.RegisterwithAllData("123456","2", "5","1999","Ahmed", "Mohamed", "company", "address1","address2", "United States", "state", "city","12345","01012346578");
	  Assert.assertEquals(registerObject.AccountCreated_Message.getText(), "ACCOUNT CREATED!");
	  registerObject.accountContinue();
	  Assert.assertTrue(homeObject.LoggedInAs_Message.getText().contains("Logged in as "));
	  Thread.sleep(2000);
	  registerObject.DeleteAccount();
	  Assert.assertEquals(registerObject.Delete_Account_Message.getText(), "ACCOUNT DELETED!");
	  registerObject.continueDeleteAccount();
	  
  }
  @Test (priority = 2)
  public void Register_withMandatory() throws InterruptedException {
	  intialization();
	  homeObject.OpenRegistrationPage();
	  Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("Ahmed", "Ahmed@h.com");
	  Assert.assertEquals(registerObject.SignUp_Message.getText(), "ENTER ACCOUNT INFORMATION");
	  Assert.assertEquals(registerObject.assretName.getAttribute("value"), "Ahmed");
	  Thread.sleep(2000);
	  registerObject.RegisterwithMandatory("123456","Ahmed", "Mohamed", "address1", "United States", "state", "city","12345","01012346578");
	  Assert.assertEquals(registerObject.AccountCreated_Message.getText(), "ACCOUNT CREATED!");
	  registerObject.accountContinue();
	  Assert.assertTrue(homeObject.LoggedInAs_Message.getText().contains("Logged in as "));
	  Thread.sleep(2000);
	  registerObject.DeleteAccount();
	  Assert.assertEquals(registerObject.Delete_Account_Message.getText(), "ACCOUNT DELETED!");
	  registerObject.continueDeleteAccount();
	  
  }
}
