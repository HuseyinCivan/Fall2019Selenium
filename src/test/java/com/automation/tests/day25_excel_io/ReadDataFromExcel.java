package com.automation.tests.day25_excel_io;
import com.automation.utilities.ExcelUtil;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;
import java.io.File;
import java.util.Map;

public class ReadDataFromExcel {
    @Test
    public void readExcelFileTest() throws Exception{
        //we need to get a file as an object
        File file = new File("VytrackTestUsers.xlsx");
        //object that represents excel file
        Workbook workbook = WorkbookFactory.create(file);
        //get QA1-short
        Sheet workSheet = workbook.getSheet("QA1-short");
        //get 1st row
        Row firstRow = workSheet.getRow(0);
        //get 1st cell
        Cell firstCell = firstRow.getCell(0);
        //get string value
        String value = firstCell.getStringCellValue();

        String secondCellValue = firstRow.getCell(1).getStringCellValue();


        System.out.println(value);
        System.out.println(secondCellValue);


        int lastCell=firstRow.getLastCellNum();

        System.out.println("#########################");
        for (int x = 0; x < lastCell ; x++) {
            System.out.printf("%-20s",firstRow.getCell(x)+" |  ");


        }

        System.out.println("#########################");

        //last row is 16 --->  index is 15
        int mubnerOfRows = workSheet.getLastRowNum() +1;

        //returns how many rows at all
        int numberOfRows2=workSheet.getPhysicalNumberOfRows();
        System.out.println("mubnerOfRows = " + mubnerOfRows);
        System.out.println("numberOfRows2 = " + numberOfRows2);


        System.out.println("#########################");


        for (int row = 0 ; row<workSheet.getPhysicalNumberOfRows();row++){
            for (int cell=0 ; cell<workSheet.getRow(row).getLastCellNum();cell++){
                String cellValue=workSheet.getRow(row).getCell(cell).getStringCellValue();
                System.out.print(cellValue+" | ");

            }
            System.out.println();
        }
    }
    @Test
    public void excelUtilityTest(){
        String path ="VytrackTestUsers.xlsx";
        String spereaSheetName ="QA1-all";
        ExcelUtil excelUtil=new ExcelUtil(path,spereaSheetName);

//        excelUtil.getDataList().forEach(System.out::println);

        for (Map<String ,String > record : excelUtil.getDataList()){
            System.out.println(record);
        }

    }

    @Test
    public void getColumnNamesTest(){
        String path ="VytrackTestUsers.xlsx";
        String spereaSheetName ="QA1-short";
        ExcelUtil excelUtil=new ExcelUtil(path,spereaSheetName);

        System.out.println(excelUtil.getColumnsNames());




    }
}