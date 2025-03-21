package utils;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWriter {
    public static void main(String[] args) {
        String filePath = "src/test/resources/Excel/Books.xlsx";  

        // Create a new workbook and sheet
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("ProductNameData");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Search Inputs");
      //  headerRow.createCell(1).setCellValue("Book Name");
      //  headerRow.createCell(2).setCellValue("Author");

        // Adding sample book data
        Object[][] bookData = {
            {"macbook"},
            {"iphone"},
            {"samsung"},
            {"hp"}
        };

        // Write data to the sheet
        int rowNum = 1;
        for (Object[] rowData : bookData) {
            Row row = sheet.createRow(rowNum++);
            for (int colNum = 0; colNum < rowData.length; colNum++) {
                row.createCell(colNum).setCellValue(rowData[colNum].toString());
            }
        }

        // Save the file
        try (FileOutputStream fileOut = new FileOutputStream(new File(filePath))) {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Close the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
