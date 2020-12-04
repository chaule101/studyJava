package poly.entity;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
//import org.apache.poi.hpsf.Date;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class LIST_ALL {
	// Thực hiện LIST kèm excel
	public List<User> list(int shett_user) throws EncryptedDocumentException, InvalidFormatException, IOException{
		List<User> list = new ArrayList<User>();
		//Luồng lất file cần đọc
		FileInputStream inputstream = new FileInputStream(new File("D:\\KTNC\\ASM_final\\test_ASM\\excel\\testdata.xlsx"));
		Workbook workbook = WorkbookFactory.create(inputstream);
		Sheet sheet = workbook.getSheetAt(shett_user);

	
		//định dạng cột
		DataFormatter fmt = new DataFormatter();
		Iterator<Row> iterator = sheet.iterator();
		Row fRow = iterator.next();
		Cell fCell = fRow.getCell(0);
		
		  while(iterator.hasNext()) {
	    	   Row curr = iterator.next();
	    	   User test = new User();
	    		   test.setUsername(fmt.formatCellValue(curr.getCell(0)));
                    test.setPassword(fmt.formatCellValue(curr.getCell(1)));
                    test.setFullname(fmt.formatCellValue(curr.getCell(2)));
                   
	    	   list.add(test);
	    	     
	       }
	       
		return list;
	}
	
	public List<Depart> list_depart(int depart) throws EncryptedDocumentException, InvalidFormatException, IOException{
		List<Depart> list = new ArrayList<Depart>();

		// Luá»“ng láº¥t file cáº§n Ä‘á»�c
		FileInputStream inputstream = new FileInputStream(new File("testdata.xlsx"));
		Workbook workbook = WorkbookFactory.create(inputstream);
		Sheet sheet = workbook.getSheetAt(depart);
		// Ä‘á»‹nh dáº¡ng cá»™t
		DataFormatter fmt = new DataFormatter();
		Iterator<Row> iterator = sheet.iterator();
		Row fRow = iterator.next();
		Cell fCell = fRow.getCell(0);

		while (iterator.hasNext()) {
			Row curr = iterator.next();
			Depart test = new Depart();
			test.setId(fmt.formatCellValue(curr.getCell(0)));
			test.setName(fmt.formatCellValue(curr.getCell(1)));
			list.add(test);

		}

		return list;
	}
	
	//LIST Staffs
//	public List<Staff> listStaff(int numbersheet)
//			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
//		List<Staff> list = new ArrayList<Staff>();
//		// Luồng lất file cần đọc
//		FileInputStream inputstream = new FileInputStream(
//				new File("testdata.xlsx"));
//		Workbook workbook = WorkbookFactory.create(inputstream);
//		Sheet sheet = workbook.getSheetAt(numbersheet);
//		// định dạng cột
//		DataFormatter fmt = new DataFormatter();
//		Iterator<Row> iterator = sheet.iterator();
//		Row fRow = iterator.next();
//		Cell fCell = fRow.getCell(0);
//
//		while (iterator.hasNext()) {
//			 SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
////			 formatCellValue =  = sdf.format(currentCell.getDateCellValue());
//			
//			Row curr = iterator.next();
//			Staff test = new Staff();
//			test.setId(fmt.formatCellValue(curr.getCell(0)));
//			test.setName(fmt.formatCellValue(curr.getCell(1)));
//			test.setGender(curr.getCell(2).equals("true") ? true : false);
////			test.setActive(curr.getCell(3).equals("true") ? true : false);
//			
////			test.setBirthday(fmt.createFormat("mm/dd/yyyy"));
////			test.setBirthday(fmt.formatCellValue(curr.getCell(4)));
//			test.setEmail(fmt.formatCellValue(curr.getCell(4)));
//			test.setPhone(fmt.formatCellValue(curr.getCell(5)));
////			test.setDepartid(fmt.formatCellValue(curr.getCell(7)));
//			test.setSalary(fmt.formatCellValue(curr.getCell(6)));
//			test.setNotes(fmt.formatCellValue(curr.getCell(7)));
//			list.add(test);
//		}
//		return list;
//		
//		
//
//	}
//	
//	
//	public List<Record> listRecord(int numbersheet)
//			throws EncryptedDocumentException, InvalidFormatException, IOException, ParseException {
//		List<Record> list = new ArrayList<Record>();
//		// Luồng lất file cần đọc
//		FileInputStream inputstream = new FileInputStream(new File(
//				"testdata.xlsx"));
//		Workbook workbook = WorkbookFactory.create(inputstream);
//		Sheet sheet = workbook.getSheetAt(numbersheet);
//		// định dạng cột
//		DataFormatter fmt = new DataFormatter();
//		Iterator<Row> iterator = sheet.iterator();
//		Row fRow = iterator.next();
//		Cell fCell = fRow.getCell(0);
//
//		while (iterator.hasNext()) {
//			Row curr = iterator.next();
//			Record test = new Record();
//			int idrecord = 0; 
//			if (fmt.formatCellValue(curr.getCell(0)).equals("")) {
//				idrecord = 0;
//			}else {
//				idrecord = Integer.parseInt(fmt.formatCellValue(curr.getCell(0)));
//			}
//			test.setId(idrecord);
////			test.setStaffid(fmt.formatCellValue(curr.getCell(1)));
//			test.setType(Integer.parseInt(fmt.formatCellValue(curr.getCell(2))));
//			test.setReason(fmt.formatCellValue(curr.getCell(3)));
//			list.add(test);
//		}
//		return list;
//	}

}
