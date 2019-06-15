package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 *  How to create first selenium test Chapter 6
 */
public class GoogleSearchTest {

	public static void main(String[] args) {
		googleSearch();

	}
	
	public static void googleSearch() {
		
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		
		WebElement inputContentBox = driver.findElement(By.xpath("//input[@name='q']"));
		inputContentBox.sendKeys("TIBCO");
		
		//driver.findElement(By.xpath("//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")).click();
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.quit();
	}

}
