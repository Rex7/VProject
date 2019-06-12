/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scheduler;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author kamal
 */ 

public class Writexl {
    String [][][]ary=new String[11][25][15];
    public void wpass(String [][][]pary)
    {
        ary=pary;
        XSSFWorkbook workbook = new XSSFWorkbook();
         
        //Create a blank sheet
        XSSFSheet sheet = workbook.createSheet("Timetable");
          
        //This data needs to be written (Object[])
        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[] {"SUB", "TEACHER", "ROOMNO"});
        int r=2;
        for(int k=0;k<11;k++)
        {
        for(int i=0;i<24;i++)
        {
            for(int j=0;j<15;j++)
            {
            data.put( Integer.toString(r),new Object[] {i,ary[0][i][j],ary[0][i][j+1],ary[0][i][j+2],ary[0][i][j+3],ary[0][i][j+4],ary[0][i][j+5],ary[0][i][j+6],ary[0][i][j+7],ary[0][i][j+8],ary[0][i][j+9],ary[0][i][j+10],ary[0][i][j+11],ary[0][i][j+12],ary[0][i][j+13],ary[0][i][j+14]});
            r++;
            }
        }
        }
        /*data.put("2", new Object[] {1, "Amit", "Shukla"});
        data.put("3", new Object[] {2, "Lokesh", "Gupta"});
        data.put("4", new Object[] {3, "John", "Adwards"});
        data.put("5", new Object[] {4, "Brian", "Schultz"});
          */
        //Iterate over data and write to sheet
        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset)
        {
            Row row = sheet.createRow(rownum++);
            Object [] objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
        }
        try
        {
            //Write the workbook in file system
            FileOutputStream out = new FileOutputStream(new File("Timetable.xlsx"));
            workbook.write(out);
            out.close();
            System.out.println("Success");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    
    }
}
