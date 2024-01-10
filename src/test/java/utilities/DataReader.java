package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReader {

    private String filePath;

    public DataReader(String filePath) {
        this.filePath = filePath;
    }

    public Object[][] readTestData() {
        // Create an empty array to store test data
        Object[][] data = new Object[0][];

        try {
            // Open the Google Sheet using Apache POI
            FileInputStream file = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(file);
            Sheet sheet = workbook.getSheetAt(0); // Assuming test data is on the first sheet

            // Iterate through rows and columns to extract test data
            int rowCount = sheet.getLastRowNum();
            data = new Object[rowCount][];
            for (int i = 1; i <= rowCount; i++) { // Skip header row
                Row row = sheet.getRow(i);
                int columnCount = row.getLastCellNum();
                Object[] rowData = new Object[columnCount];
                for (int j = 0; j < columnCount; j++) {
                    Cell cell = row.getCell(j);
                    rowData[j] = cell.toString();
                }
                data[i - 1] = rowData;
            }

            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}