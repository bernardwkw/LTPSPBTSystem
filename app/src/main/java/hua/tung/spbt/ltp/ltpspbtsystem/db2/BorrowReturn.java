package hua.tung.spbt.ltp.ltpspbtsystem.db2;

import org.greenrobot.greendao.annotation.*;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "BORROW_RETURN".
 */
@Entity
public class BorrowReturn {

    @Id(autoincrement = true)
    private Long borrow_return_id;
    private Long student_info_id;
    private Long book_info_id;
    private String barcode;
    private String borrow_issue_by;
    private String return_issue_by;
    private String borrow_date;
    private String return_date;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    @Generated
    public BorrowReturn() {
    }

    public BorrowReturn(Long borrow_return_id) {
        this.borrow_return_id = borrow_return_id;
    }

    @Generated
    public BorrowReturn(Long borrow_return_id, Long student_info_id, Long book_info_id, String barcode, String borrow_issue_by, String return_issue_by, String borrow_date, String return_date) {
        this.borrow_return_id = borrow_return_id;
        this.student_info_id = student_info_id;
        this.book_info_id = book_info_id;
        this.barcode = barcode;
        this.borrow_issue_by = borrow_issue_by;
        this.return_issue_by = return_issue_by;
        this.borrow_date = borrow_date;
        this.return_date = return_date;
    }

    public Long getBorrow_return_id() {
        return borrow_return_id;
    }

    public void setBorrow_return_id(Long borrow_return_id) {
        this.borrow_return_id = borrow_return_id;
    }

    public Long getStudent_info_id() {
        return student_info_id;
    }

    public void setStudent_info_id(Long student_info_id) {
        this.student_info_id = student_info_id;
    }

    public Long getBook_info_id() {
        return book_info_id;
    }

    public void setBook_info_id(Long book_info_id) {
        this.book_info_id = book_info_id;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getBorrow_issue_by() {
        return borrow_issue_by;
    }

    public void setBorrow_issue_by(String borrow_issue_by) {
        this.borrow_issue_by = borrow_issue_by;
    }

    public String getReturn_issue_by() {
        return return_issue_by;
    }

    public void setReturn_issue_by(String return_issue_by) {
        this.return_issue_by = return_issue_by;
    }

    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
