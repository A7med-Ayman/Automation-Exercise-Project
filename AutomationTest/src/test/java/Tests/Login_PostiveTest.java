package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterPage;

public class Login_PostiveTest extends TestBase{
	HomePage homeObject;
	LoginPage loginObject;
	RegisterPage registerObject;
	
	public void intialization() {
		homeObject =new HomePage(driver);
		loginObject = new LoginPage(driver);
		registerObject = new RegisterPage(driver);
	}
	
  @Test (priority = 1 )
  public void LoginwithCorrect_Email() throws InterruptedException {
	  intialization();
	  Assert.assertEquals(homeObject.HomeBtn.getCssValue("color"),"rgba(255, 165, 0, 1)");
	  homeObject.OpenLoginPage();
	  Assert.assertEquals(loginObject.Login_Massege.getText(), "Login to your account");
	  loginObject.login("Test2024@hotmail.com", "123456");
	  Assert.assertTrue(homeObject.LoggedInAs_Message.getText().contains("Logged in as "));
	  Thread.sleep(3000);
	  loginObject.DeleteAccount();
	  Assert.assertEquals(loginObject.Delete_Account_Message.getText(), "ACCOUNT DELETED!");
	  loginObject.continueDeleteAccount();
	  Assert.assertEquals(homeObject.HomeBtn.getCssValue("color"),"rgba(255, 165, 0, 1)");
  }
  @Test (priority = 2 )
  public void Function_toRegister() throws InterruptedException {
	  intialization();
	  Assert.assertEquals(homeObject.HomeBtn.getCssValue("color"),"rgba(255, 165, 0, 1)");
	  homeObject.OpenRegistrationPage();
	  //Assert.assertEquals(registerObject.NewUser_Signup_Message.getText(), "New User Signup!");
	  registerObject.newUserSignUp("Test","Test2024@hotmail.com");
	  Assert.assertEquals(registerObject.SignUp_Message.getText(), "ENTER ACCOUNT INFORMATION");
	  Assert.assertEquals(registerObject.assretName.getAttribute("value"), "Test");
	  Thread.sleep(2000);
	  registerObject.RegisterwithMandatory("123456","Ahmed", "Mohamed", "address1", "United States", "state", "city","12345","01012346578");
	  Assert.assertEquals(registerObject.AccountCreated_Message.getText(), "ACCOUNT CREATED!");
	  registerObject.accountContinue();
	  Assert.assertTrue(homeObject.LoggedInAs_Message.getText().contains("Logged in as "));
  }
}
