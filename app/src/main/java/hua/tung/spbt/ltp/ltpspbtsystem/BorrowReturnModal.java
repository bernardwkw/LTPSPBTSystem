package hua.tung.spbt.ltp.ltpspbtsystem;

/**
 * Created by User on 26/10/2017.
 */

public class BorrowReturnModal {

    private int id;
    private String barcode;
    private int studentInfoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public int getStudentInfoId() {
        return studentInfoId;
    }

    public void setStudentInfoId(int studentInfoId) {
        this.studentInfoId = studentInfoId;
    }
}
