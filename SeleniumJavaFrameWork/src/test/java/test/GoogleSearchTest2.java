package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.GoogleSearchPage;
import pages.GoogleSearchPageObjects;
/*
 *  POM Chapter 7 and 8
 */
public class GoogleSearchTest2 {

	public static void main(String[] args) {
		//googleSearch();
       googleSearchTest();
	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		GoogleSearchPage.inputBox_search(driver).sendKeys("TIBCO");

		GoogleSearchPage.button_search(driver).sendKeys(Keys.RETURN);

		driver.quit();
		
	}
	
	public static void googleSearchTest() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		GoogleSearchPageObjects gspObjects = new GoogleSearchPageObjects(driver);
        gspObjects.setTextInSearchBox("ABC");
        gspObjects.clickButton();
		driver.quit();
		
	}

}
