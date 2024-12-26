package UtilityObjects;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class ReadXLS {

    public static Object[][] getData(Object curr) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "//TestData//TestData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        Sheet sheet = workbook.getSheet(curr.getClass().getSimpleName());

        int row = sheet.getLastRowNum();

        Object[][] data = new  Object[row][2];

        String caseID = "";

        for(int i=1;i<=row;i++){
            Hashtable<String,String > sheetData = new Hashtable<>();
            int col = sheet.getRow(0).getLastCellNum();
            for(int j=0;j<col;j++){
                sheetData.put(sheet.getRow(0).getCell(j).getStringCellValue(),sheet.getRow(i).getCell(j).getStringCellValue());

            }
            if(sheetData.get("Case_ID").isEmpty()){
                sheetData.put("Case_ID",caseID);
            }
            else{
                caseID = sheetData.get("Case_ID");
            }
            data[i-1][0] = i;
            data[i-1][1] = sheetData;
        }
        workbook.close();

        return data;

    }
}
