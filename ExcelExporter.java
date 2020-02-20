package com.sample.model;
import java.io.*;
import java.sql.*;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.*;

public class ExcelExporter {





	public static void export(ArrayList<String> approved) {



		String excelFilePath = "OnCall.xlsx";


		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("On Call");

		writeHeaderLine(sheet, workbook);
		ArrayList result =  DBAccess.getExcel("1", approved);
		try {
			writeDataLines(result, workbook, sheet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(excelFilePath);

			workbook.write(outputStream);

			workbook.close();
			
//			System.out.println (excelFilePath.getAbsolutePath());
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		}
	}


	protected static void writeHeaderLine(XSSFSheet sheet, XSSFWorkbook workbook) {

		Row headerRow = sheet.createRow(0);
		CellStyle cs = workbook.createCellStyle();
		cs.setAlignment(HorizontalAlignment.CENTER);
		Font font = workbook.createFont();
		font.setBold(true);
		cs.setFont(font);

//		Cell headerCell = headerRow.createCell(3);
//		headerCell.setCellValue("On Call");
//		headerCell.setCellStyle(cs);	
//
//		headerCell = headerRow.createCell(8);
//		headerCell.setCellValue("Overtime");
//		headerCell.setCellStyle(cs);

		sheet.addMergedRegion(new CellRangeAddress(2, 2, 3, 5));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 7, 12));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 14, 19));
		sheet.addMergedRegion(new CellRangeAddress(2, 2, 21, 23));	
	}

	protected static void writeDataLines(ArrayList<ApprovalSheets> result, XSSFWorkbook workbook,
			XSSFSheet sheet) throws SQLException {
		CellStyle cs1 = workbook.createCellStyle();
		cs1.setAlignment(HorizontalAlignment.CENTER);
		Font font1 = workbook.createFont();
		font1.setBold(true);
		cs1.setFont(font1);

		CellStyle cs2 = workbook.createCellStyle();
		cs2.setAlignment(HorizontalAlignment.CENTER);
		Font font2 = workbook.createFont();
		font2.setBold(true);
		cs2.setFont(font2);
		cs2.setBorderBottom(BorderStyle.MEDIUM);
		cs2.setBorderLeft(BorderStyle.MEDIUM);
		cs2.setBorderRight(BorderStyle.MEDIUM);
		cs2.setBorderTop(BorderStyle.MEDIUM);

		String [] headings = new String [] {"on-Call (£.p)", "Overtime (Hours)", "Standby (Hours)", "£32 Call Out(Count)"};

		String [] subheadings = new String[] {"name", "no", "", "Standby", "Callout", "Total","" , "Weekday", "Saturday", "Sunday", "Privilege Day", "Bank Holiday", "Total",
				"" , "Weekday", "Saturday", "Sunday", "Privilege Day", "Bank Holiday", "Total", "", "", "Count"};

		int headingcolumnCount = 4;
		Row headingRow = sheet.createRow(2);
		Cell heading = headingRow.createCell(headingcolumnCount);
		heading = headingRow.createCell(headingcolumnCount-1);heading.setCellValue(headings[0]);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellValue(headings[1]);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellValue(headings[2]);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellValue(headings[3]);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);
		heading = headingRow.createCell(headingcolumnCount++);heading.setCellStyle(cs2);

		int subheadingcolumnCount = 0;
		Row subheadingRow = sheet.createRow(3);
		Cell subheading = subheadingRow.createCell(subheadingcolumnCount);
		for (int i = 0; i < subheadings.length; i++) {
			subheading = subheadingRow.createCell(subheadingcolumnCount++);
			subheading.setCellValue(subheadings[i]);subheading.setCellStyle(cs1);

		}

		int rowCount = 4;
		for (int i = 0; i < result.size(); i++) {

			String StaffID = result.get(i).getSheet_ID();
			String UserName = result.get(i).getName();
			String UserEmail = result.get(i).getName();
			String UserWage = result.get(i).getName();
			String UserManager = result.get(i).getName();
			String DateFrom = result.get(i).getFrom();
			String DateTo = result.get(i).getTo();
			String QuarterHours = result.get(i).getHours();
			String Activity = result.get(i).getActivity();
			String Reason = result.get(i).getReason();
			String Itask = result.get(i).getName();

			Row row = sheet.createRow(rowCount++);

			int columnCount = 0;
			Cell cell = row.createCell(columnCount++);
			cell.setCellValue(StaffID);

			cell = row.createCell(columnCount++);
			cell.setCellValue(UserName);

			cell = row.createCell(columnCount++);

			cell = row.createCell(columnCount++);
			cell.setCellValue(UserWage);

			cell = row.createCell(columnCount++);
			cell.setCellValue(UserManager);

			cell = row.createCell(columnCount++);
			cell.setCellValue(DateFrom);

			cell = row.createCell(columnCount++);

			cell = row.createCell(columnCount++);
			cell.setCellValue(QuarterHours);

			cell = row.createCell(columnCount++);
			cell.setCellValue(Activity);

			cell = row.createCell(columnCount++);
			cell.setCellValue(Reason);

			cell = row.createCell(columnCount++);
			cell.setCellValue(Itask);

			CellStyle cellStyle = workbook.createCellStyle();
			CreationHelper creationHelper = workbook.getCreationHelper();
			cellStyle.setDataFormat(creationHelper.createDataFormat().getFormat("yyyy-MM-dd HH:mm:ss"));
			cell.setCellStyle(cellStyle);
		}
		CellRangeAddress region1 = CellRangeAddress.valueOf("A4:B20");
		RegionUtil.setBorderLeft(BorderStyle.MEDIUM, region1, sheet);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, region1, sheet);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM, region1, sheet);
		RegionUtil.setBorderRight(BorderStyle.MEDIUM, region1, sheet);
		
		CellRangeAddress region2 = CellRangeAddress.valueOf("D4:F20");
		RegionUtil.setBorderLeft(BorderStyle.MEDIUM, region2, sheet);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, region2, sheet);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM, region2, sheet);
		RegionUtil.setBorderRight(BorderStyle.MEDIUM, region2, sheet);
		
		CellRangeAddress region3 = CellRangeAddress.valueOf("H4:M20");
		RegionUtil.setBorderLeft(BorderStyle.MEDIUM, region3, sheet);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, region3, sheet);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM, region3, sheet);
		RegionUtil.setBorderRight(BorderStyle.MEDIUM, region3, sheet);
		
		CellRangeAddress region4 = CellRangeAddress.valueOf("O4:T20");
		RegionUtil.setBorderLeft(BorderStyle.MEDIUM, region4, sheet);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, region4, sheet);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM, region4, sheet);
		RegionUtil.setBorderRight(BorderStyle.MEDIUM, region4, sheet);
		
		CellRangeAddress region5 = CellRangeAddress.valueOf("V4:X20");
		RegionUtil.setBorderLeft(BorderStyle.MEDIUM, region5, sheet);
		RegionUtil.setBorderBottom(BorderStyle.MEDIUM, region5, sheet);
		RegionUtil.setBorderTop(BorderStyle.MEDIUM, region5, sheet);
		RegionUtil.setBorderRight(BorderStyle.MEDIUM, region5, sheet);
	}

}
