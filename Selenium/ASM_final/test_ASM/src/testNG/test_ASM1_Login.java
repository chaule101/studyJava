package testNG;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import poly.entity.LIST_ALL;
import poly.entity.User;

import org.openqa.selenium.Alert;

import testNG.ExcelUtils;

public class test_ASM1_Login {
	HSSFWorkbook workbook;
	HSSFSheet sheet;
	// WebDriver driver;
	static Map<String, Object[]> testNGResult;
	String url = "http://localhost:8080/test_ASM/checkLogin.jsp";
	static LIST_ALL li = new LIST_ALL();
	static List<String> demPass = new ArrayList<String>();
	static List<String> demFail = new ArrayList<String>();
	public static ChromeDriver driver;

	@BeforeClass
	public void suiteSetup() {
		System.setProperty("webdriver.chrome.driver", "D:\\library\\selenium\\chromedriver.exe");
		workbook = new HSSFWorkbook();
		// tao 1 sheet trong trang excel
		sheet = workbook.createSheet("TestNG_FillLogin");
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

//test case Login
	@Test(dataProvider = "testdata", priority = 2)
	public void fill_loginForm(String username, String password)
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		// testNGResult = new LinkedHashMap<String, Object[]>();
		System.out.println(username + " | " + password);
//			List<User> list = li.list(0);
		driver.get("http://localhost:8080/test_ASM/checkLogin.jsp");
		try {
			List<User> list = li.list(0);
			for (int i = 0; i < list.size(); i++) {
				driver.findElement(By.id("username")).sendKeys(username);
				Thread.sleep(2000);
				driver.findElement(By.id("password")).sendKeys(password);
				Thread.sleep(2000);
				driver.findElement(By.id("submit")).click();
				Thread.sleep(2000);
				// driver.findElement(By.id("submit")).submit();
				Thread.sleep(2000);
				String error = "";
				try {
				error = driver.switchTo().alert().getText();
				System.out.println("ERRRR" + error);
				AssertJUnit.assertEquals(error, "Login Failed");				
				testNGResult.put("3" + i, new Object[] { 2d, "fill with " + " ' " + list.get(i).username + " ' "
							+ " pass " + " ' " + list.get(i).password + " ' ", "Failed", "Failed" });
				
				}catch(Exception e){
					testNGResult.put("4" + i, new Object[] { 3d, "fill with " + " ' " + list.get(i).username + " ' "
							+ " pass " + " ' " + list.get(i).password + " ' ", "Passed", "Passed" });
				}
			}
		}finally{}
				
					
				
		}
				
				
				
			

		

	@DataProvider(name = "testdata")
	public Object[][] getData() {
		String excelPath = "D:\\KTNC\\ASM_final\\test_ASM\\excel\\testdata.xlsx";
		Object data[][] = testData(excelPath, "login");
		return data;
		// D:\KTNC\ASM_final\test_ASM\excel\testdata.xlsx
		// D:\KTNC\ASM_final\test_ASM\excel\testdata.xlsx

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
			FileOutputStream out = new FileOutputStream(new File("testNG_FILLLogin.xls"));
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
//
	}

	public static void main(String[] args) {
		String error = "";
		error = driver.switchTo().alert().getText();
		System.out.println("Errrorrrr" + error);
	}

}
