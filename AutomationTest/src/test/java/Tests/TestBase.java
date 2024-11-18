package Tests;


import org.testng.annotations.BeforeTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class TestBase {
	WebDriver driver;
	String Url ="https://automationexercise.com/";
  
  @BeforeTest
  public void OpenBrowser() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to(Url);
  }

  @AfterTest
  public void CloseBrowser() {
	  driver.close();
  }

}
