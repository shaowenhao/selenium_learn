package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

public class ExcelDataProvider {
    WebDriver driver;
    
   // @Parameters("browser") define in testng xml then can used in test case
	@BeforeTest
	public void testSetUp() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath+"/driver/chromedriver/chromedriver.exe"); 
		driver = new ChromeDriver();
	}
	
	
	@Test(dataProvider="testCase1")
	public void test1(String username,String password) {
		System.out.println(username + " | " + password);
	}
	
	@DataProvider(name = "testCase1")
	public  Object[][] getData() {
		Object[][] data = testData();
		return data;
	}
	
	
	public  Object[][] testData() {

		ExcelUtils excel = new ExcelUtils();
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object[][] data = new Object[rowCount-1][colCount]; 

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				String cellData = excel.getCellDataString(i, j);
				//System.out.println(cellData );
				data[i-1][j] = cellData;
			}
		}
		return data;
	}
}
  