package poly.selenium;

import java.awt.Desktop;
import java.io.File;
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
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;

import poly.entity.LIST;
import poly.entity.answers;
import poly.entity.questions;
import poly.entity.users;

public class SeleniumASM {

	private static String userAdmin = "admin";
	private static String passAdmin = "$Son1998";
	public static ChromeDriver driver;
	// static ChromeDriverService service =
	// ChromeDriverService.createDefaultService();

	public String working;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static Map<String, Object[]> TestNGResults;
	static LIST li = new LIST();
	// public static String driverPath = "C:\\";

	static List<String> demPass = new ArrayList<String>();
	static List<String> demFail = new ArrayList<String>();

	@BeforeClass(alwaysRun = true)
	public static void suitsetup() {
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Ket Qua Test");
		TestNGResults = new LinkedHashMap<String, Object[]>();
		System.setProperty("webdriver.chrome.driver", "D:\\Poly\\Nhom2_ASM_UD15102\\Lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.close();
	}

	// test case Login
	@org.testng.annotations.Test(groups = "selenium", priority = 1)
	public static void Test1()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			TestNGResults.put("1", new Object[] { "ID", "Test Data", "Expected Results", "Actual Results", "Status" });
			List<users> list = li.list_user(0);
			for (int i = 0; i < list.size(); i++) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to("https://toanthu24h.com/profile/" + list.get(i).getUsername() + "/");
				Thread.sleep(7000);
				driver.findElementByXPath("//*[@id=\"wrap\"]/div[1]/header/div/div[2]/a[2]").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name=\"log\"]").sendKeys(list.get(i).getUsername());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name=\"pwd\"]").sendKeys(list.get(i).getPassword());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"login-panel\"]/div[1]/div[2]/form/p").click();
				Thread.sleep(500);
				String error = "";
				try {					
					error = driver.findElementByXPath("//*[@id=\"login-panel\"]/div[1]/div[2]/form/div[1]/div").getText();
				} catch (Exception e) {}	
				System.out.println(error);
				Thread.sleep(7000);
								
				// ket qua mong muon dang nhap thanh cong
				
				if (error != "") {
					TestNGResults.put("2" + i,
							new Object[] {
									"Test_Login_" + (i + 1), "Login \t\n with Username = '" + list.get(i).getUsername()
											+ "'\t\n Password = '" + list.get(i).getPassword() + "'",
									"Dang nhap that bai", error, "FAILED" });
					demFail.add("FAILED");
				} else {
					TestNGResults.put("2" + i,
							new Object[] { "Test_Login_" + (i + 1),
									"Login \t\n with Username = '" + list.get(i).getUsername() + "'\t\n Password = '"
											+ list.get(i).getPassword() + "'",
									"Dang nhap thanh cong", "PASS", "PASSED" });
					demPass.add("PASSED");
					
				}
				Thread.sleep(5000);
				driver.close();
			}

		} catch (Exception e) {
			TestNGResults.put("3", new Object[] { "Error", "Fill login from data (Username/Password)", "Login that bai", "" + e, "Fail" });					
			Assert.assertTrue(false);
			System.out.println("loi gi " + e);
		} finally {}	
	}

	// test case ADD user
	@org.testng.annotations.Test(groups = "selenium", priority = 2)
	public static void Test2() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "https://toanthu24h.com/";

			List<users> list = li.list_user(1);

			for (int i = 0; i < list.size(); i++) {
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.navigate().to(url);
				Thread.sleep(7000);
				// //*[@id="email"]
				driver.findElementByXPath("//*[@id='wrap']/div[2]/div[2]/div/div[2]/a").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name='user_name']").sendKeys(list.get(i).getUsername());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name='email']").sendKeys(list.get(i).getEmail());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name='pass1']").sendKeys(list.get(i).getPassword());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name='pass2']").sendKeys(list.get(i).getConfirmpassword());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name='register']").click();
				Thread.sleep(500);
				String error = "";
				try {
					error = driver.findElementByXPath("//*[@id=\"signup-panel\"]/div[1]/div[2]/form/div[1]/div/span").getText();
							
				} catch (Exception e) {	}

				System.out.println(error);
				Thread.sleep(7000);

				// ket qua mong muon them thanh cong

				List<users> count = li.list_user(0);
				
				if (!error.equals("")) {
					TestNGResults.put("2" + (count.size() + i),
							new Object[] { "Test_createAcount_" + (i + 1),
									"Add an account with username:" + list.get(i).getUsername() + "\t\n" + "email:"
											+ list.get(i).getEmail() + "\t\n" + "password:" + list.get(i).getPassword()
											+ "\t\n" + "confirm:" + list.get(i).getConfirmpassword() + "\t\n",
									"Them that bai", error, "FAILDED" });

					demFail.add("FAILED");

				} else {
					TestNGResults.put("2" + (count.size() + i),
							new Object[] { "Test_createAcount_" + (i + 1),
									"Add an account with username:" + list.get(i).getUsername() + "\t\n" + "email:"
											+ list.get(i).getEmail() + "\t\n" + "password:" + list.get(i).getPassword()
											+ "\t\n" + "confirm:" + list.get(i).getConfirmpassword() + "\t\n",
									"Them thanh cong", error, "PASSED" });

					demPass.add("PASSED");

				}
				Thread.sleep(5000);
				driver.close();

				// Assert.assertTrue(true);
			}

		} catch (Exception e) {
			// TODO: handle exception

			TestNGResults.put("3", new Object[] { "Error", "Add Login", "Them that bai", "" + e, "Faild" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		}

	}

	// test case add question
	@org.testng.annotations.Test(groups = "selenium", priority = 3)
	public static void Test3()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {

			String url = "https://toanthu24h.com/";
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			Thread.sleep(7000);
			// Login with admin
			driver.findElementByXPath("//*[@id=\"wrap\"]/div[1]/header/div/div[2]/a[2]").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"log\"]").sendKeys(userAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"pwd\"]").sendKeys(passAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@id=\"login-panel\"]/div[1]/div[2]/form/p").click();
			Thread.sleep(7000);
			List<questions> list = li.list_question(3);

			for (int i = 0; i < list.size(); i++) {
				driver.navigate().to(url);
				Thread.sleep(7000);

				// Add question
				// click your question
				driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[2]/div[1]/a").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name='title']").sendKeys(list.get(i).getTitle());
				Thread.sleep(3000);

				driver.findElementByXPath("//*[@name='category']").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name='category']/option[8]").click(); // *[@name="category"]/option[8]
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"wpqa-question\"]/div/form/div/p[2]/ul/li/input")
						.sendKeys(list.get(i).getTag());

				Thread.sleep(3000);
				driver.findElementByXPath("//*[text()=\"Văn bản\" and @type='button']").click();
				;
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name=\"comment\"]").sendKeys(list.get(i).getContent());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[text()=\"Văn bản\" and @type='button']").sendKeys(list.get(i).getContent());
						
				Thread.sleep(3000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollTo(0, 500)");
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@name='terms_active']").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"wpqa-question\"]/div/form/p/input[4]").click();
				Thread.sleep(500);
				String error = "";
				try {
					error = driver.findElementByXPath("//*[@id=\"wpqa-question\"]/div/form/div[1]").getText();
				} catch (Exception e) {
					// TODO: handle exception
				}

				System.out.println(error);
				Thread.sleep(5000);

				// ket qua mong muon them thanh cong

				List<users> count1 = li.list_user(0);
				List<users> count2 = li.list_user(1);
				int count = count1.size() + count2.size();			

				if (!error.equals("")) {
					TestNGResults.put("2" + (count + i),
							new Object[] { "Test_createQuestion_" + (i + 1),
									"Add an question with title:" + list.get(i).getTitle() + "\t\n" + "Category:"
											+ list.get(i).getCategory() + "\t\n" + "Tag:" + list.get(i).getTag()
											+ "\t\n" + "Content:" + list.get(i).getContent() + "\t\n",
									"Them that bai", error, "FAILDED" });

					demFail.add("FAILED");

				} else {
					TestNGResults.put("2" + (count + i),
							new Object[] { "Test_createQuestion_" + (i + 1),
									"Add an question with title:" + list.get(i).getTitle() + "\t\n" + "Category:"
											+ list.get(i).getCategory() + "\t\n" + "Tag:" + list.get(i).getTag()
											+ "\t\n" + "Content:" + list.get(i).getContent() + "\t\n",
									"Them thanh cong", error, "PASSED" });

					demPass.add("PASSED");

				}
				// Assert.assertTrue(true);

			}
			Thread.sleep(3000);
			driver.close();

		} catch (Exception e) {
			// TODO: handle exception

			TestNGResults.put("3", new Object[] { "Error", "Add question", "Them that bai", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		}

	}

	// test case update question
	@org.testng.annotations.Test(groups = "selenium", priority = 4)
	public static void Test4()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "https://toanthu24h.com/";
			List<questions> list = li.list_question(4);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			Thread.sleep(7000);
			// Login with admin
			driver.findElementByXPath("//*[@id=\"wrap\"]/div[1]/header/div/div[2]/a[2]").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"log\"]").sendKeys(userAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"pwd\"]").sendKeys(passAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@id=\"login-panel\"]/div[1]/div[2]/form/p").click();
			Thread.sleep(7000);
			for (int i = 0; i < list.size(); i++) {

				driver.navigate().to(url);
				Thread.sleep(7000);

				driver.findElementByXPath("//*[@id=\"search-2\"]/form/label/input").sendKeys(list.get(i).getTitle());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"search-2\"]/form/input").click();
				Thread.sleep(5000);
				// click vao question
				// click vao question
				String idd = list.get(i).getTitle();
				driver.navigate().to("https://toanthu24h.com/question/cau-nay-demo-" + idd.substring(idd.length() - 1) + "/");						
				Thread.sleep(5000);
				// edit question
				driver.findElementByXPath("//*[text()='Edit']").click();
				Thread.sleep(3000);
				// edit tag: update
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[3]/form/div/p[2]/ul/li[2]/input").sendKeys(list.get(i).getTag());										
				Thread.sleep(3000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollTo(0, 500)");
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[3]/form/p/input[4]").click();
				Thread.sleep(5000);
				String error = "";
				try {
					error = driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[2]").getText();
							
				} catch (Exception e) {
					// TODO: handle exception
				}

				System.out.println(error);
				Thread.sleep(3000);

				// ket qua mong muon sua thanh cong

				List<users> count1 = li.list_user(0);
				List<users> count2 = li.list_user(1);
				List<questions> count3 = li.list_question(3);
				int count = count1.size() + count2.size() + count3.size();

				if (error.equals("")) {
					TestNGResults.put("2" + (count + i),
							new Object[] {
									"Test_updateQuestion_" + (i + 1), "Update an question with title:"
											+ list.get(i).getTitle() + "\t\n" + "Tag:" + list.get(i).getTag() + "\t\n",
									"Update that bai", error, "FAILDED" });
					demFail.add("FAILED");

				} else {
					TestNGResults.put("2" + (count + i),
							new Object[] {
									"Test_updateQuestion_" + (i + 1), "Update an question with title:"
											+ list.get(i).getTitle() + "\t\n" + "Tag:" + list.get(i).getTag() + "\t\n",
									"Update thanh cong", error, "PASSED" });

					demPass.add("PASSED");

				}
				// Assert.assertTrue(true);

			}
			Thread.sleep(3000);
			driver.close();

		} catch (Exception e) {
			// TODO: handle exception

			TestNGResults.put("3", new Object[] { "Error", "Update question", "update that bai", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		}

	}

	// test case delete question
	@org.testng.annotations.Test(groups = "selenium", priority = 5)
	public static void Test5()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "https://toanthu24h.com/";
			List<questions> list = li.list_question(5);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			Thread.sleep(7000);
			// Login with admin
			driver.findElementByXPath("//*[@id=\"wrap\"]/div[1]/header/div/div[2]/a[2]").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"log\"]").sendKeys(userAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"pwd\"]").sendKeys(passAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@id=\"login-panel\"]/div[1]/div[2]/form/p").click();
			Thread.sleep(7000);

			for (int i = 0; i < list.size(); i++) {
				driver.navigate().to(url);

				driver.findElementByXPath("//*[@id=\"search-2\"]/form/label/input").sendKeys(list.get(i).getTitle());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"search-2\"]/form/input").click();
				Thread.sleep(3000);
				// click vao question
				String idd = list.get(i).getTitle();

				driver.navigate().to("https://toanthu24h.com/question/cau-nay-demo-" + idd.substring(idd.length() - 1) + "/");						
				Thread.sleep(3000);
				// delete question
				driver.findElementByXPath("//*[text()='Delete']").click();
				Thread.sleep(5000);

				// ket qua mong muon xoa thanh cong

				List<users> count1 = li.list_user(0);
				List<users> count2 = li.list_user(1);
				List<questions> count3 = li.list_question(3);
				List<questions> count4 = li.list_question(4);
				int count = count1.size() + count2.size() + count3.size() + count4.size();
				String error = "";
				try {
					error = driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[1]").getText();
				} catch (Exception e) {
					// TODO: handle exception
				}

				if (error.equals("")) {
					TestNGResults.put("2" + (count + i),
							new Object[] { "Test_deleteQuestion_" + (i + 1),
									"Delete an question with title:" + list.get(i).getTitle() + "\t\n", "Xoa that bai",
									"Error", "FAILDED" });

					demFail.add("FAILED");

				} else {
					TestNGResults.put("2" + (count + i),
							new Object[] { "Test_deleteQuestion_" + (i + 1),
									"Delete an question with title:" + list.get(i).getTitle() + "\t\n",
									"Xoa thanh cong", error, "PASSED" });

					demPass.add("PASSED");

				}
				// Assert.assertTrue(true);

			}
			Thread.sleep(3000);
			driver.close();

		} catch (Exception e) {
			// TODO: handle exception

			TestNGResults.put("3", new Object[] { "Error", "Xoa question", "Xoa that bai", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		}

	}

	// test case add answers
	@org.testng.annotations.Test(groups = "selenium", priority = 6)
	public static void Test6()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "https://toanthu24h.com/";
			List<answers> list = li.list_answer(6);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			Thread.sleep(7000);
			// Login with admin
			driver.findElementByXPath("//*[@id=\"wrap\"]/div[1]/header/div/div[2]/a[2]").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"log\"]").sendKeys(userAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"pwd\"]").sendKeys(passAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@id=\"login-panel\"]/div[1]/div[2]/form/p").click();
			Thread.sleep(7000);

			for (int i = 0; i < list.size(); i++) {
				driver.navigate().to(url);
				Thread.sleep(5000);
				driver.findElementByXPath("//*[@id=\"search-2\"]/form/label/input").sendKeys(list.get(i).getQuestion());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"search-2\"]/form/input").click();
				Thread.sleep(3000);
				// click vao question
				String idd = list.get(i).getQuestion();

				driver.navigate().to("https://toanthu24h.com/question/cau-nay-demo-" + idd.substring(idd.length() - 1) + "/");						

				Thread.sleep(3000);
				// add answer
				driver.findElementByXPath("//*[text()='Answers']").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"comment\"]").sendKeys(list.get(i).getAnswers());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"submit\"]").click();
				Thread.sleep(4000);
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollTo(600, 0)");
				Thread.sleep(500);
				// ket qua mong muon them thanh cong

				List<users> count1 = li.list_user(0);
				List<users> count2 = li.list_user(1);
				List<questions> count3 = li.list_question(3);
				List<questions> count4 = li.list_question(4);
				List<questions> count5 = li.list_question(5);
				int count = count1.size() + count2.size() + count3.size() + count4.size() + count5.size();
				String error = "";
				try {
					error = driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[2]").getText();

				} catch (Exception e) {
					// TODO: handle exception
				}

				if (error.equals("")) {
					TestNGResults
							.put("2" + (count + i),
									new Object[] { "Test_addAnswer_" + (i + 1),
											"Add an answer for question:" + list.get(i).getQuestion() + "\t\n"
													+ "Answer:" + list.get(i).getAnswers() + "\t\n",
											"Them that bai", "Error", "FAILDED" });

					demFail.add("FAILED");

				} else {
					TestNGResults
							.put("2" + (count + i),
									new Object[] { "Test_addAnswer_" + (i + 1),
											"Add an answer for question:" + list.get(i).getQuestion() + "\t\n"
													+ "Answer:" + list.get(i).getAnswers() + "\t\n",
											"Them thanh cong", error, "PASSED" });

					demPass.add("PASSED");

				}
				// Assert.assertTrue(true);

			}
			Thread.sleep(3000);
			driver.close();

		} catch (Exception e) {
			// TODO: handle exception

			TestNGResults.put("3", new Object[] { "Error", "Them answer", "Them that bai", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		}

	}

	// test case update answers
	@org.testng.annotations.Test(groups = "selenium", priority = 7)
	public static void Test7()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "https://toanthu24h.com/";
			List<answers> list = li.list_answer(7);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			Thread.sleep(7000);
			// Login with admin
			driver.findElementByXPath("//*[@id=\"wrap\"]/div[1]/header/div/div[2]/a[2]").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"log\"]").sendKeys(userAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"pwd\"]").sendKeys(passAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@id=\"login-panel\"]/div[1]/div[2]/form/p").click();
			Thread.sleep(7000);

			for (int i = 0; i < list.size(); i++) {
				driver.navigate().to(url);
				Thread.sleep(5000);
				driver.findElementByXPath("//*[@id=\"search-2\"]/form/label/input").sendKeys(list.get(i).getQuestion());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"search-2\"]/form/input").click();
				Thread.sleep(3000);
				// click vao question
				String idd = list.get(i).getQuestion();
				driver.navigate()
						.to("https://toanthu24h.com/question/cau-nay-demo-" + idd.substring(idd.length() - 1) + "/");
				Thread.sleep(3000);
				// delete answer
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollTo(0, 700)");
				Thread.sleep(3000);

				driver.findElementByXPath("//*[@class='icon-dot-3']").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@class=\"comment-edit-link edit-comment\"]").click();
				Thread.sleep(5000);
				driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[3]/form/div[3]/p/textarea").sendKeys(list.get(i).getAnswers());
				Thread.sleep(3000);
				
				driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[3]/form/p/input[3]").click();
				Thread.sleep(6000);

				jse.executeScript("window.scrollTo(700, 0)");
				Thread.sleep(500);
				// ket qua mong muon them thanh cong

				List<users> count1 = li.list_user(0);
				List<users> count2 = li.list_user(1);
				List<questions> count3 = li.list_question(3);
				List<questions> count4 = li.list_question(4);
				List<questions> count5 = li.list_question(5);
				List<answers> count6 = li.list_answer(6);
				int count = count1.size() + count2.size() + count3.size() + count4.size() + count5.size() + count6.size();						
				String error = "";
				try {
					error = driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[2]").getText();

				} catch (Exception e) {
				}
				Thread.sleep(3000);
				if (error.equals("")) {
					TestNGResults
							.put("2" + (count + i),
									new Object[] { "Test_updateAnswer_" + (i + 1),
											"Update an answer for question:" + list.get(i).getQuestion() + "\t\n"
													+ "Answer:" + list.get(i).getAnswers() + "\t\n",
											"Update that bai", "Error", "FAILDED" });

					demFail.add("FAILED");

				} else {
					TestNGResults
							.put("2" + (count + i),
									new Object[] { "Test_updateAnswer_" + (i + 1),
											"Update an answer for question:" + list.get(i).getQuestion() + "\t\n"
													+ "Answer:" + list.get(i).getAnswers() + "\t\n",
											"Update thanh cong", error, "PASSED" });

					demPass.add("PASSED");

				}
				// Assert.assertTrue(true);

			}
			Thread.sleep(3000);
			driver.close();

		} catch (Exception e) {
			// TODO: handle exception

			TestNGResults.put("3", new Object[] { "Error", "Update answer", "Upate that bai", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		}

	}

	// test case delete answers
	@org.testng.annotations.Test(groups = "selenium", priority = 8)
	public static void Test8()
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		try {
			String url = "https://toanthu24h.com/";
			List<answers> list = li.list_answer(8);
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.navigate().to(url);
			Thread.sleep(7000);
			// Login with admin
			driver.findElementByXPath("//*[@id=\"wrap\"]/div[1]/header/div/div[2]/a[2]").click();
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"log\"]").sendKeys(userAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@name=\"pwd\"]").sendKeys(passAdmin);
			Thread.sleep(3000);
			driver.findElementByXPath("//*[@id=\"login-panel\"]/div[1]/div[2]/form/p").click();
			Thread.sleep(7000);

			for (int i = 0; i < list.size(); i++) {
				driver.navigate().to(url);
				Thread.sleep(5000);
				driver.findElementByXPath("//*[@id=\"search-2\"]/form/label/input").sendKeys(list.get(i).getQuestion());
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@id=\"search-2\"]/form/input").click();
				Thread.sleep(3000);
				// click vao question
				String idd = list.get(i).getQuestion();
				driver.navigate().to("https://toanthu24h.com/question/cau-nay-demo-" + idd.substring(idd.length() - 1) + "/");						
				Thread.sleep(3000);
				// delete answer
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				jse.executeScript("window.scrollTo(0, 600)");
				Thread.sleep(3000);

				driver.findElementByXPath("//*[@class='icon-dot-3']").click();
				Thread.sleep(3000);
				driver.findElementByXPath("//*[@class=\"delete-comment delete-answer\"]").click();
				Thread.sleep(5000);
				// ket qua mong muon them thanh cong

				List<users> count1 = li.list_user(0);
				List<users> count2 = li.list_user(1);
				List<questions> count3 = li.list_question(3);
				List<questions> count4 = li.list_question(4);
				List<questions> count5 = li.list_question(5);
				List<answers> count6 = li.list_answer(6);
				List<answers> count7 = li.list_answer(7);
				int count = count1.size() + count2.size() + count3.size() + count4.size() + count5.size()+ count6.size() + count7.size();						
				String error = "";
				try {
					error = driver.findElementByXPath("//*[@id=\"wrap\"]/div[2]/div/div/main/div/div[1]/div[2]").getText();

				} catch (Exception e) {
					// TODO: handle exception
				}
				Thread.sleep(3000);
				if (error.equals("")) {
					TestNGResults
							.put("2" + (count + i),
									new Object[] { "Test_deleteAnswer_" + (i + 1),
											"Delete an answer for question:" + list.get(i).getQuestion() + "\t\n"
													+ "Answer:" + list.get(i).getAnswers() + "\t\n",
											"Xoa that bai", "Error", "FAILDED" });

					demFail.add("FAILED");

				} else {
					TestNGResults
							.put("2" + (count + i),
									new Object[] { "Test_deleteAnswers_" + (i + 1),
											"Delete an answer for question:" + list.get(i).getQuestion() + "\t\n"
													+ "Answer:" + list.get(i).getAnswers() + "\t\n",
											"Xoa thanh cong", error, "PASSED" });
					demPass.add("PASSED");

				}
				// Assert.assertTrue(true);

			}
			Thread.sleep(3000);
			driver.close();

		} catch (Exception e) {
			// TODO: handle exception

			TestNGResults.put("3", new Object[] { "Error", "Xoa answer", "Xoa that bai", "" + e, "Fail" });
			Assert.assertTrue(false);
			System.out.println(e);
		} finally {
		}

	}
	
	// Write 
		@org.testng.annotations.Test(groups = "selenium",priority = 9)
		public void suiteTearDown() throws EncryptedDocumentException, InvalidFormatException, IOException {
			for(int i=0;i<demPass.size();i++) {
				System.out.println(demPass.get(i));
			}
			List<users> count1 = li.list_user(0);
			List<users> count2 = li.list_user(1);
			List<questions> count3 = li.list_question(3);
			List<questions> count4 = li.list_question(4);
			List<questions> count5 = li.list_question(5);
			List<answers> count6 = li.list_answer(6);
			List<answers> count7 = li.list_answer(7);
			List<answers> count8 = li.list_answer(8);
			int count = count1.size() + count2.size() + count3.size() + count4.size() + count5.size() + count6.size() + count7.size() + count8.size();
			
			TestNGResults.put("2" + count, new Object[] {"TOTAL: " + (demFail.size() + demPass.size()) , "PASSED: " + demPass.size(), "FAILED: " + demFail.size() + "" });
			Set<String> keyset = TestNGResults.keySet();
			int rownum = 1;
			for(String key: keyset) {
				XSSFRow row = sheet.createRow(rownum++);
				Object[] objArr = TestNGResults.get(key);
				sheet.setColumnWidth(0, 9080);
				sheet.setColumnWidth(1, 20000);
				sheet.setColumnWidth(2, 15000);
				sheet.setColumnWidth(3, 10000);
				sheet.setColumnWidth(4, 8000);
				sheet.setColumnWidth(5, 8000);
				int cellnum = 0; 
				for(Object obj :objArr) {
					XSSFCell cell = row.createCell(cellnum++);
					XSSFCellStyle style = workbook.createCellStyle();
					org.apache.poi.ss.usermodel.Font font = workbook.createFont();
					style.setWrapText(true);
					font.setBold(true);
					style.setFont(font);
					style.setVerticalAlignment(VerticalAlignment.CENTER);
			        style.setAlignment(HorizontalAlignment.CENTER);
				    style.setBorderRight(BorderStyle.THIN);
				    style.setRightBorderColor(IndexedColors.BLACK.getIndex());
				    style.setBorderLeft(BorderStyle.THIN);
				    style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
				    style.setBorderTop(BorderStyle.THIN);
				    style.setTopBorderColor(IndexedColors.BLACK.getIndex());
				    style.setBorderBottom(BorderStyle.THIN);
				    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
				    style.setBorderBottom(BorderStyle.THIN); 
				    style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
					if(obj instanceof Date) {
						cell.setCellValue((Date) obj);
					}else 
					if(obj instanceof Boolean) {
						cell.setCellValue((Boolean) obj);
					}
					else 
						if(obj instanceof String) {
							cell.setCellValue((String) obj);
						}
						else 
							if(obj instanceof Double) {
								cell.setCellValue((Double) obj);
							}
					cell.setCellStyle(style);
					
				}
			}
			//ghi file ra
			try {
				FileOutputStream out = new FileOutputStream(new File("TestCase.xlsx"));
				workbook.write(out);
				Desktop.getDesktop().open(new File("TestCase.xlsx"));
				out.close();
				System.out.println("ghi thanh cong");
			driver.close();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("That bai " + e);
			}
		}

	public static void main(String[] args)
			throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		suitsetup();
		Test3();
	}

}
