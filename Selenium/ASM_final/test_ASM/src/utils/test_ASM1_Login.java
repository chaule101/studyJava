package utils;


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
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.ExcelUtils;

public class test_ASM1_Login {
	Map<String, Object[]> testNGResult;
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	WebDriver driver;
	String url = "http://localhost:8080/test_ASM/checkLogin.jsp";
	
//	@BeforeTest
//	public void setUpTest() {
////		String projectPath = System.getProperty("user.dir");
//			System.setProperty("webdriver.chrome.driver","D:/library/selenium/chromedriver.exe");
//			driver = new ChromeDriver();
//	}
	
	@Test(dataProvider="test1data",priority=1)
	public  void testdata(String username, String password) throws Exception {
		System.out.println(username+" | "+password);
		
//		driver.get("http://localhost:8080/test_ASM/checkLogin.jsp");
//		driver.findElement(By.id("username")).sendKeys(username);
//		driver.findElement(By.id("password")).sendKeys(password);
//		Thread.sleep(2000);
//		driver.findElement(By.id("submit")).click();
//		
		
//		driver.get("http://localhost:8080/test_ASM/checkLogin.jsp");
//		driver.findElement(By.id("username")).clear();
		
		
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).sendKeys(password);
		Thread.sleep(2000);
		driver.findElement(By.id("submit")).click();
		driver.findElement(By.id("submit")).submit();
//		
			
		}
		
	
	
	@DataProvider(name = "test1data")
	public Object[][] getData() throws InterruptedException {
		String excelPath = "D:\\KTNC\\projects\\test_ASM\\excel\\testdata.xlsx";
		Object data[][] = testData(excelPath, "Sheet1");
		return data;
		
	}
	
	
	public Object[][] testData(String excelPath, String sheetName) throws InterruptedException {
		
		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		
		int rowCount = excel.getRowCount();
		int colCount = excel.getColCount();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i=1; i<rowCount; i++) {
			for(int j=0; j<colCount; j++) {
//				
				String cellData = excel.getCellDataString(i, j);
				
				data[i-1][j] = cellData;
//				
			}
			
		}
		return data;
		
	}
	
	@Test
	public void lauchBrowser() throws Exception {
		try {
			// driver lay chay url
			driver.get(url);
			// mo rong man hinh
			driver.manage().window().maximize();
			// .put la phuong thuc add them trong MAP
			testNGResult.put("2", new Object[] { 1d, "Negative to demo webside", "", "", "Site gets opened", "Pass" });

		} catch (Exception e) {
			testNGResult.put("2", new Object[] { 1d, "Negative to demo webside", "Site gets opened", "Failed" });
			Assert.assertTrue(false);
		}
	}
	
	@BeforeClass
	public void suiteSetup() {
		System.setProperty("webdriver.chrome.driver", "D:\\library\\selenium\\chromedriver.exe");
		workbook = new HSSFWorkbook();
		// tao 1 sheet trong trang excel
		sheet = workbook.createSheet("TestNG_Login");
		testNGResult = new LinkedHashMap<String, Object[]>();
		// khoi tao ten cac cot trong file excel
		testNGResult.put("1",
				new Object[] { "Test_Step No.", "Action", "Expected Output", "Actual Output" });
		try {
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		} catch (Exception e) {
			throw new IllegalAccessError("can not connect to webdriver");
		}
	}

	//
	// //chay sau cung, ghi vao file excel
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
			FileOutputStream out = new FileOutputStream(new File("testNG_Login.xls"));
			workbook.write(out);
			out.close();
			System.out.println("Successfull save to Excel");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
//		driver.close();
//		driver.quit();

	}

}
