package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleSearchPageObjects;

/*
 *  chapter 9 TestNG
 */
public class TestNGDemo {
	WebDriver driver = null;
  
	@BeforeTest
	public void testSetUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver();
	}
	
  @Test
  public void testCase1() {
	  driver.get("https://google.com");
	  GoogleSearchPageObjects gspObjects = new GoogleSearchPageObjects(driver);
      gspObjects.setTextInSearchBox("ABC");
      gspObjects.clickButton();
  }
  
  @AfterTest
  public void shutdown() {
	  driver.quit();
  }
}
