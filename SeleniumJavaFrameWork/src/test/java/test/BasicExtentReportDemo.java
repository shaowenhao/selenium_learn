package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
/*
 *  Extent Report chapter 10 Basic
 *  http://extentreports.com/docs/versions/3/java/#examples
 */
public class BasicExtentReportDemo {

	public static void main(String[] args) {
		   // start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("GoogleSearchTest.html");
    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test = extent.createTest("Google Search Test case1", "Input test in serch box and search it");
        
        test.log(Status.INFO, "Start test");
    	String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com");
		test.pass("switch to google");
		WebElement inputContentBox = driver.findElement(By.xpath("//input[@name='q']"));
		inputContentBox.sendKeys("TIBCO");
		test.pass("Input TIBCO in text box and search it");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.quit();
		test.pass("close the browser");
        extent.flush();
	}

}
