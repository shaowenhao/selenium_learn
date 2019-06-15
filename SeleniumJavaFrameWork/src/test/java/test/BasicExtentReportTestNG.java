package test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import pages.GoogleSearchPageObjects;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;

public class BasicExtentReportTestNG {
	WebDriver driver = null;
	ExtentReports extent = null;

	@BeforeSuite
	public void generateExtentReport() {
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("Index2.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

	}

	@BeforeTest
	public void setUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/driver/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test
	public void googleSearchTest() {
		// creates a toggle for the given test, adds all log events under it
		ExtentTest test = extent.createTest("Google Search Test case1", "Input test in serch box and search it");
		test.log(Status.INFO, "Start test");
		driver.get("https://google.com");
		test.pass("switch to google");
		WebElement inputContentBox = driver.findElement(By.xpath("//input[@name='q']"));
		inputContentBox.sendKeys("TIBCO");
		test.pass("Input TIBCO in text box and search it");
		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
		driver.quit();
		test.pass("close the browser");
	}

	@Test
	public void test2() {
	
		ExtentTest test = extent.createTest("Test case2", "Input test in serch box and search it");
		test.log(Status.INFO, "Start test");
		 // log with snapshot
        try {
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        // test with snapshot
        try {
			test.fail("details").addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@AfterSuite
	public void flushExtentReport() {
		extent.flush();
	}

}
