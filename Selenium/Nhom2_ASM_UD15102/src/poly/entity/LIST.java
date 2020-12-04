package poly.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LIST {
	// Thực hiện LIST kèm excel

	private XSSFWorkbook wb;

	// List Users
	public List<users> list_user(int sheet_user)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		List<users> list = new ArrayList<users>();
		try {

			// file excel cần đọc
			FileInputStream inputstream = new FileInputStream(new File("testdata.xlsx"));
			wb = new XSSFWorkbook(inputstream);
			// Chọn Sheet
			XSSFSheet sheet = wb.getSheetAt(sheet_user);

			// định dạng cột
			DataFormatter fmt = new DataFormatter();
			Iterator<Row> iterator = sheet.iterator();
			Row fRow = iterator.next();
			Cell fCell = fRow.getCell(0);

			while (iterator.hasNext()) {
				Row curr = iterator.next();
				users test = new users();
				test.setUsername(fmt.formatCellValue(curr.getCell(0)));
				test.setEmail(fmt.formatCellValue(curr.getCell(1)));
				test.setPassword(fmt.formatCellValue(curr.getCell(2)));
				test.setConfirmpassword(fmt.formatCellValue(curr.getCell(3)));
				test.setFirstname(fmt.formatCellValue(curr.getCell(4)));
				test.setLastname(fmt.formatCellValue(curr.getCell(5)));
				list.add(test);
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("loi gi " + e);
		}

		return list;
	}

	// List Questions
	public List<questions> list_question(int sheet_question)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		List<questions> list = new ArrayList<questions>();
		// file excel cần đọc
		FileInputStream inputstream = new FileInputStream(new File("testdata.xlsx"));
		wb = new XSSFWorkbook(inputstream);
		// Chọn Sheet
		XSSFSheet sheet = wb.getSheetAt(sheet_question);

		// định dạng cột
		DataFormatter fmt = new DataFormatter();
		Iterator<Row> iterator = sheet.iterator();
		Row fRow = iterator.next();
		Cell fCell = fRow.getCell(0);

		while (iterator.hasNext()) {
			Row curr = iterator.next();
			questions test = new questions();
			test.setTitle(fmt.formatCellValue(curr.getCell(0)));
			test.setCategory(fmt.formatCellValue(curr.getCell(1)));
			test.setTag(fmt.formatCellValue(curr.getCell(2)));
			test.setContent(fmt.formatCellValue(curr.getCell(3)));
			test.setDescription(fmt.formatCellValue(curr.getCell(4)));
			list.add(test);
		}
		return list;
	}

	// List Answers
	public List<answers> list_answer(int sheet_answer)
			throws EncryptedDocumentException, InvalidFormatException, IOException {
		List<answers> list = new ArrayList<answers>();
		// file excel cần đọc
		FileInputStream inputstream = new FileInputStream(new File("testdata.xlsx"));
		wb = new XSSFWorkbook(inputstream);
		// Chọn Sheet
		XSSFSheet sheet = wb.getSheetAt(sheet_answer);

		// định dạng cột
		DataFormatter fmt = new DataFormatter();
		Iterator<Row> iterator = sheet.iterator();
		Row fRow = iterator.next();
		Cell fCell = fRow.getCell(0);

		while (iterator.hasNext()) {
			Row curr = iterator.next();
			answers test = new answers();
			test.setQuestion(fmt.formatCellValue(curr.getCell(0)));
			test.setAnswers(fmt.formatCellValue(curr.getCell(1)));

			list.add(test);
		}

		return list;
	}

}
