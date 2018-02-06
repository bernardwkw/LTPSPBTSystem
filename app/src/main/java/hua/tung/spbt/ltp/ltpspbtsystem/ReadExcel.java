package hua.tung.spbt.ltp.ltpspbtsystem;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

/**
 * Created by User on 31/10/2017.
 */

public class ReadExcel {
    private static final String EXCEL_FILE_LOCATION = Environment.getExternalStorageDirectory()+"/LTPSPBT/lars.xls";

    private String dir;

    public void setReadLocation(String dir){
        this.dir = dir;
    }

    public void read() {

        Workbook workbook = null;
        try {

            workbook = Workbook.getWorkbook(new File(this.dir));

            Sheet sheet = workbook.getSheet(0);

            boolean isLast = true;
            int cellNumber = 0;
            boolean afterStudentData = false;

            do {
                Cell cell1 = sheet.getCell(0, cellNumber);
                System.out.print(cell1.getContents() + ":");    // Test Count + :
                Cell cell2 = sheet.getCell(1, cellNumber);
                System.out.println(cell2.getContents());
                Cell cell3 = sheet.getCell(2, cellNumber);
                System.out.println(cell3.getContents());

                if(cell1.getContents().contains("No"))
                    afterStudentData = true;

                if(afterStudentData){
                    if (cell1.getContents().equals("") ){
                        Log.e("nothing", "here");
                        isLast = false;
                    }

                }
                cellNumber++;
            }while (isLast);
     // 1
//            Cell cell3 = sheet.getCell(2, 13);
//            System.out.println(cell3.getContents());
//            Cell cell4 = sheet.getCell(3, 13);
//            System.out.println(cell4.getContents());

//            Cell cell3 = sheet.getCell(1, 0);
//            System.out.print(cell3.getContents() + ":");    // Result + :
//            Cell cell4 = sheet.getCell(1, 1);
//            System.out.println(cell4.getContents());        // Passed
//
//            System.out.print(cell1.getContents() + ":");    // Test Count + :
//            cell2 = sheet.getCell(0, 2);
//            System.out.println(cell2.getContents());        // 2
//
//            System.out.print(cell3.getContents() + ":");    // Result + :
//            cell4 = sheet.getCell(1, 2);
//            System.out.println(cell4.getContents());        // Passed 2

        } catch (IOException e) {
            e.printStackTrace();
        } catch (BiffException e) {
            e.printStackTrace();
        } finally {

            if (workbook != null) {
                workbook.close();
            }

        }

    }

    public File[] getFolderFiles(String directory){
//        ArrayList<String> files = new ArrayList<>();
//        files.add();

        File f = new File(directory);
        File files[] = f.listFiles();

        return files;
    }

}
