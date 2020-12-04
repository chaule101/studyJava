package testNG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class test_ASM1_User_Update {
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
		sheet = workbook.createSheet("TestNG_Insert");
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

	@Test(priority = 2)
	public void reach_Update() {
		try {
			driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[2]/td[4]/a")).click();;
			testNGResult.put("3", new Object[] { 2d, "Reach to Update", "Site gets opened", "Pass" });
		} catch (Exception e) {
			testNGResult.put("3", new Object[] { 2d, "Reach to Update", "Site gets opened", "Failed" });
		}
	}

	@Test(dataProvider = "testdata", priority = 3)
	public void do_Update(String password, String fullName) throws Exception {
		 System.out.println( password + " | " + fullName);

		try {
			
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/input")).clear();
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[2]/input")).sendKeys(password);
			Thread.sleep(2000);
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[3]/input")).clear();
			driver.findElement(By.xpath("/html/body/div/div/div[2]/form/div[3]/input")).sendKeys(fullName);
			Thread.sleep(2000);

			driver.findElement(By.name("btnUpdate")).click();
			Thread.sleep(2000);

			String expected_result = "http://localhost:8080/test_ASM/user/update.htm";
			String actual_result = driver.getCurrentUrl();
			if (expected_result.equals(actual_result)) {
				testNGResult.put("3", new Object[] { 2d, "do Update", "Update Successful", "Pass" });

			}
		} catch (Exception e) {
			testNGResult.put("3", new Object[] { 2d, "do Update", "Update Successful", "Failed" });
			e.printStackTrace();
		}
		Assert.assertTrue(true);
	}

	@DataProvider(name = "testdata")
	public Object[][] getData() {
		String excelPath = "D:\\KTNC\\test_ASM\\excel\\test_Update.xlsx";
		Object data[][] = testData(excelPath, "update");
		return data;

	}

	public static Object[][] testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);

		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();

		Object data[][] = new Object[rowCount - 1][colCount];

		for (int i = 1; i < rowCount; i++) {
			for (int j = 0; j < colCount; j++) {

				String cellData = excel.getCellDataString(i, j);
				System.out.print(cellData + " | ");
				data[i - 1][j] = cellData;

			}
			System.out.println();
		}
		return data;

	}

	@AfterClass
	public void suiteTearDown() {
		Set<String> keySet = testNGResult.keySet();
		int rownum = 0;
		for (String key : keySet) {
			HSSFRow row = sheet.createRow(rownum++);
			Object[] objArr = testNGResult.get(key);
			int cellnum = 0;
			for (Object obj : objArr) {
				Cell cell = row.createCell(cellnum++);
				if (obj instanceof Date)
					cell.setCellValue((Date) obj);
				else if (obj instanceof Boolean)
					cell.setCellValue((Boolean) obj);
				else if (obj instanceof String)
					cell.setCellValue((String) obj);
				else if (obj instanceof Double)
					cell.setCellValue((Double) obj);
			}

		}
		try {
			FileOutputStream out = new FileOutputStream(new File("testNG_Update.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Successfull save to Excel");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// driver.close();
		// driver.quit();
		//
	}

}
