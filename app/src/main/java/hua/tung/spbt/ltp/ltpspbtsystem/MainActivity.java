package hua.tung.spbt.ltp.ltpspbtsystem;

import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BluetoothAdapter myDevice = BluetoothAdapter.getDefaultAdapter();
        String deviceName = myDevice.getName();
//        WriteExcel writeExcel = new WriteExcel();
//        try {
//            writeExcel.createFileDir();
//            //String deviceName = android.os.Build.MODEL;
////            File[] files = writeExcel.getFolderFiles(Environment.getExternalStorageDirectory()+"/LTPSPBT/Send");
//            writeExcel.setOutputFile(Environment.getExternalStorageDirectory()+"/LTPSPBT/Send/"+
//                    deviceName + "_" + getTime() + ".xls");
//
//            writeExcel.write();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (WriteException e) {
//            e.printStackTrace();
//        }



        ReadExcel readExcel = new ReadExcel();
//        readExcel.setReadLocation();
        readExcel.read();
//        saveExcelFile();

    }

//    private boolean saveExcelFile(){
//        // check if available and not read only
//        if (!isExternalStorageAvailable() || isExternalStorageReadOnly()) {
//            Log.e("no", "Storage not available or read only");
//            return false;
//        }
//
//        boolean success = false;
//
//        //New Workbook
//        Workbook wb = new HSSFWorkbook();
//
//        Cell c = null;
//
//        //Cell style for header row
//        CellStyle cs = wb.createCellStyle();
//        cs.setFillForegroundColor(HSSFColor.LIME.index);
//        cs.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
//
//        //New Sheet
//        Sheet sheet1 = null;
//        sheet1 = wb.createSheet("myOrder");
//
//        // Generate column headings
//        Row row = sheet1.createRow(0);
//
//        c = row.createCell(0);
//        c.setCellValue("Item Number");
//        c.setCellStyle(cs);
//
//        c = row.createCell(1);
//        c.setCellValue("Quantity");
//        c.setCellStyle(cs);
//
//        c = row.createCell(2);
//        c.setCellValue("Price");
//        c.setCellStyle(cs);
//
//        Row row1 = sheet1.createRow(1);
//        c = row1.createCell(0);
//        c.setCellValue("Item Number");
//        c.setCellStyle(cs);
//
//        c = row1.createCell(1);
//        c.setCellValue("Quantity");
//        c.setCellStyle(cs);
//
//        c = row1.createCell(2);
//        c.setCellValue("Price");
//        c.setCellStyle(cs);
//
//        sheet1.setColumnWidth(0, (15 * 500));
//        sheet1.setColumnWidth(1, (15 * 500));
//        sheet1.setColumnWidth(2, (15 * 500));
//
//        // Create a path where we will place our List of objects on external storage
//        File file = new File(this.getExternalFilesDir(null), "myExcel.xls");
//        FileOutputStream os = null;
//
//        try {
//            os = new FileOutputStream(file);
//            wb.write(os);
//            Log.w("FileUtils", "Writing file" + file);
//            success = true;
//        } catch (IOException e) {
//            Log.w("FileUtils", "Error writing " + file, e);
//        } catch (Exception e) {
//            Log.w("FileUtils", "Failed to save file", e);
//        } finally {
//            try {
//                if (null != os)
//                    os.close();
//            } catch (Exception ex) {
//            }
//        }
//        return success;
//    }

    public static boolean isExternalStorageReadOnly() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    public static boolean isExternalStorageAvailable() {
        String extStorageState = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(extStorageState)) {
            return true;
        }
        return false;
    }

    private static String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "HH-mm-ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
