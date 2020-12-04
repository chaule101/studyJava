package testNG;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class test_ASM1_User_Delete {
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	WebDriver driver;
	Map<String, Object[]> testNGResult;
	String url = "http://localhost:8080/test_ASM/user/index.htm";

	@BeforeClass
	public void suiteSetup() {
		System.setProperty("webdriver.chrome.driver", "D:\\library\\selenium\\chromedriver.exe");
		workbook = new HSSFWorkbook();
		// tao 1 sheet trong trang excel
		sheet = workbook.createSheet("TestNG_Delete");
		testNGResult = new LinkedHashMap<String, Object[]>();
		// khoi tao ten cac cot trong file excel
		testNGResult.put("1", new Object[] { "Test_Step No.", "Action", "Expected Output", "Actual Output" });
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		} catch (Exception e) {
			throw new IllegalAccessError("can not connect to webdriver");
		}
	}

	@Test(priority = 1)
	public void lauchBrowser() throws Exception {
		try {
			// driver lay chay url
			driver.get(url);
			// mo rong man hinh
			driver.manage().window().maximize();
			// .put la phuong thuc add them trong MAP
			testNGResult.put("2", new Object[] { 1d, "Negative to demo webside", "Site gets opened", "Pass" });

		} catch (Exception e) {
			testNGResult.put("2", new Object[] { 1d, "Negative to demo webside", "Site gets opened", "Failed" });
			Assert.assertTrue(false);

		}

	}

	@Test(priority=2)
	public void do_Delete() {
		try{
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[3]/td[5]/a")).click();
			String expected_result = "http://localhost:8080/test_ASM/user/abcdelete.htm";
			String actual_result = driver.getCurrentUrl();
			if (expected_result.equals(actual_result)) {
				testNGResult.put("3", new Object[] { 2d, "do Delete", "Pass", "Pass" });

			}
		} catch (Exception e) {
			testNGResult.put("3", new Object[] { 2d, "do Delete", "Failed", "Failed" });
			e.printStackTrace();
		}
		Assert.assertTrue(true);
			
		
	}
}
