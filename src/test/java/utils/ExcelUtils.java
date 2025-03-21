package utils;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtils {
    private static Workbook workbook;
    private static Sheet sheet;

    // Load Excel file
    public static void setExcelFile(String filePath, String sheetName) throws IOException {
        FileInputStream file = new FileInputStream(filePath);
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheet(sheetName);
    }

    // Read data from Excel
    public static String getCellData(int row, int col) {
        DataFormatter formatter = new DataFormatter();
        Cell cell = sheet.getRow(row).getCell(col);
        return formatter.formatCellValue(cell); // Returns cell data as String
    }
}
