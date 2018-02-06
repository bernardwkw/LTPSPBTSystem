package com.example;


import org.greenrobot.greendao.generator.DaoGenerator;
import org.greenrobot.greendao.generator.Entity;
import org.greenrobot.greendao.generator.Schema;

public class SPBTGenerator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "hua.tung.spbt.ltp.ltpspbtsystem.db2"); // Your app package name and the (.db) is the folder where the DAO files will be generated into.
        schema.enableKeepSectionsByDefault();

        addTables(schema);

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void addTables(final Schema schema) {
        addUserEntities(schema);
//         addPhonesEntities(schema);
    }

    // This is use to describe the colums of your table
    private static Entity addUserEntities(final Schema schema) {

        Entity studentInfo = schema.addEntity("StudentInfo");
        studentInfo.addLongProperty("student_id").primaryKey().autoincrement();
        studentInfo.addStringProperty("student_name");
        studentInfo.addStringProperty("student_no");
        studentInfo.addStringProperty("student_class");

        Entity borrowReturn = schema.addEntity("BorrowReturn");
        borrowReturn.addLongProperty("borrow_return_id").primaryKey().autoincrement();
        borrowReturn.addLongProperty("student_info_id");
        borrowReturn.addLongProperty("book_info_id");
        borrowReturn.addStringProperty("barcode");
        borrowReturn.addStringProperty("borrow_issue_by");
        borrowReturn.addStringProperty("return_issue_by");
        borrowReturn.addStringProperty("borrow_date");
        borrowReturn.addStringProperty("return_date");

        Entity bookInfo = schema.addEntity("BookInfo");
        bookInfo.addLongProperty("book_info_id").primaryKey().autoincrement();
        bookInfo.addStringProperty("book_name");
        bookInfo.addStringProperty("book_code");
        bookInfo.addStringProperty("book_type");//A= art, S=science, G= general, O=other
        bookInfo.addStringProperty("form");
        bookInfo.addStringProperty("book_publisher");
        bookInfo.addStringProperty("book_price");
        bookInfo.addStringProperty("book_symbol");

        return studentInfo;
    }
}
