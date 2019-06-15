import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BrowseTest {

	static String browser;
	static WebDriver driver;

	public static void main(String[] args) {
      
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://seleniumhq.org/");
		driver.quit();
		
//		HtmlUnitDriver h1 = new HtmlUnitDriver();
//		h1.get("http://seleniumhq.org/");
//		System.out.println("Title:"+ h1.getTitle());
		
      //   setBrower();
      //   setBrowserConfiguration();
      //   runTest();
		// readProperties();
	}

	//read properties 
	public static void readProperties() {
		// create properties class
		Properties properties = new Properties();
		try {
			// create a object of class input Stream
			InputStream input = new FileInputStream(getProjectDir()+"/src/test/java/config/config.properties");
			//load properties file
			properties.load(input);
			//get values from properties file
			String browser = properties.getProperty("browser");
			System.out.println(browser);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// set browser
	public static void setBrower() {
		browser = "Chrome";
	}
   
	public static String getProjectDir() {
		
		String property = System.getProperty("user.dir");
		return property;
	}
	
	// set browser configuration
	public static void setBrowserConfiguration() {
		if (browser.contains("Chrome")) {
			String property = System.getProperty("user.dir");
			System.out.println("property :" + property);
			System.setProperty("webdriver.chrome.driver", property + "/driver/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.contains("Firefox")) {
			String property = System.getProperty("user.dir");
			System.out.println("property :" + property);
			System.setProperty("webdriver.gecko.driver", property + "/driver/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}
	}

	// Run test
	public static void runTest() {
		driver.get("http://seleniumhq.org/");
		driver.quit();
	}
}
