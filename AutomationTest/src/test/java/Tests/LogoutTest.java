package Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;

public class LogoutTest extends TestBase{
	HomePage homeObject;
	LoginPage loginObject;
	public void intialization() {
		homeObject =new HomePage(driver);
		loginObject = new LoginPage(driver);
	}
  @Test
  public void LogOut_Test() throws InterruptedException {
	  intialization();
	  Assert.assertEquals(homeObject.HomeBtn.getCssValue("color"),"rgba(255, 165, 0, 1)");
	  homeObject.OpenLoginPage();
	  Assert.assertEquals(loginObject.Login_Massege.getText(), "Login to your account");
	  loginObject.login("John@hotmail.com", "123456");
	  Assert.assertTrue(homeObject.LoggedInAs_Message.getText().contains("Logged in as "));
	  homeObject.logOut();
	  Thread.sleep(3000);
	  Assert.assertEquals(homeObject.SignUpLoginBtn.getCssValue("color"),"rgba(255, 165, 0, 1)");  
  }
}
