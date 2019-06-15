package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
 *   POM what is POM chapter 7
 */
public class GoogleSearchPage {
   
	static WebElement element = null;
	
	public static WebElement inputBox_search(WebDriver driver) {
		element = driver.findElement(By.xpath("//input[@name='q']"));	
		return element;
	}
	
	public static WebElement button_search(WebDriver driver) {
		
		element = driver.findElement(By.name("btnK"));	
		return element;
	}
}
