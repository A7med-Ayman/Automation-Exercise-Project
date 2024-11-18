package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class Login_NegativeTest extends TestBase{
	HomePage homeObject;
	LoginPage loginObject;
	
	public void intialization() {
		homeObject =new HomePage(driver);
		loginObject = new LoginPage(driver);
	}
	
  @Test (priority = 1 )
  public void LoginwithInCorrect_Email() throws InterruptedException {
	  intialization();
	  Assert.assertEquals(homeObject.HomeBtn.getCssValue("color"),"rgba(255, 165, 0, 1)");
	  homeObject.OpenLoginPage();
	  Assert.assertEquals(loginObject.Login_Massege.getText(), "Login to your account");
	  loginObject.login("aa@hotmail.com", "123456");
	  Assert.assertTrue(loginObject.incorrectEmail_Massege.getText().contains("Your email or password is incorrect!"));
	  Thread.sleep(3000);
  }
}
