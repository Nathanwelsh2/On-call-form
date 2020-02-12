package com.sample.model;
import java.io.*;
import java.sql.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

public class ExcelExporter {

    public static void main(String[] args) {
        new ExcelExporter().export();
    }

    public void export() {
        String jdbcURL = "jdbc:mypostgres://localhost:8080/OnCallApp/";
        String username = "root";
        String password = "password";

        String excelFilePath = "OnCall.xls";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
            String sql = "select e.staff_id, e.name, e.email, e.wage, e.manager, a.date_from, a.date_to, a.quarter_hours," +
                    " a.activity, a.reason, a.itask from employees e left join approved_timesheets a on e.staff_id = a.staff_id ";

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(sql);

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("On Call");

            writeHeaderLine(sheet);

            writeDataLines(result, workbook, sheet);

            FileOutputStream outputStream = new FileOutputStream(excelFilePath);
            workbook.write(outputStream);
            workbook.close();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Database error:");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("File IO error:");
            e.printStackTrace();
        }
    }

    private void writeHeaderLine(XSSFSheet sheet) {

        Row headerRow = sheet.createRow(0);

        Cell headerCell = headerRow.createCell(0);
        headerCell.setCellValue("Staff ID");

        headerCell = headerRow.createCell(1);
        headerCell.setCellValue("Name");

        headerCell = headerRow.createCell(2);
        headerCell.setCellValue("Email");

        headerCell = headerRow.createCell(3);
        headerCell.setCellValue("Wage");

        headerCell = headerRow.createCell(4);
        headerCell.setCellValue("Manager");

        headerCell = headerRow.createCell(5);
        headerCell.setCellValue("Date from");

        headerCell = headerRow.createCell(6);
        headerCell.setCellValue("Date to");

        headerCell = headerRow.createCell(7);
        headerCell.setCellValue("Quarter Hours");

        headerCell = headerRow.createCell(8);
        headerCell.setCellValue("Activity");

        headerCell = headerRow.createCell(9);
        headerCell.setCellValue("Reason");

        headerCell = headerRow.createCell(10);
        headerCell.setCellValue("Itask");
    }

    private void writeDataLines(ResultSet result, XSSFWorkbook workbook,
                                XSSFSheet sheet) throws SQLException {
        int rowCount = 1;

        while (result.next()) {
            String StaffID = result.getString("Staff ID");
            String UserName = result.getString("Name");
            String UserEmail = result.getString("Email");
            String UserWage = result.getString("Wage");
            String UserManager = result.getString("Manager");
            String DateFrom = result.getString("Date From");
            String DateTo = result.getString("Date To");
            String QuarterHours = result.getString("Quarter Hours");
            String Activity = result.getString("Activity");
            String Reason = result.getString("Reason");
            String Itask = result.getString("Itask");

            Row row = sheet.createRow(rowCount++);

            int columnCount = 0;
            Cell cell = row.createCell(columnCount++);
            cell.setCellValue(StaffID);

            cell = row.createCell(columnCount++);
            cell.setCellValue(UserName);

            cell = row.createCell(columnCount++);
            cell.setCellValue(UserEmail);

            cell = row.createCell(columnCount++);
            cell.setCellValue(UserWage);

            cell = row.createCell(columnCount++);
            cell.setCellValue(UserManager);

            cell = row.createCell(columnCount++);
            cell.setCellValue(DateFrom);

            cell = row.createCell(columnCount++);
            cell.setCellValue(DateTo);

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
    }

}
}
