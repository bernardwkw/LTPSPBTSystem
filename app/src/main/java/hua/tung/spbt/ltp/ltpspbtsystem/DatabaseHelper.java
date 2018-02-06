package hua.tung.spbt.ltp.ltpspbtsystem;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by User on 24/10/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "text_books_db";
    private static final String TABLE_STUDENTS_INFO = "students_info_tbl";
    private static final String TABLE_BORROW_RETURN = "borrow_return_tbl";
    private static final String TABLE_BOOK_INFO = "book_info";

    private static final int DB_Version = 1;

    private static final String KEY_ID = "pk";

    private static final String STUDENT_INFO_ID = "stu_info_id";

    private static final String STUDENT_NAME = "stu_name";

    private static final String STUDENT_CLASS = "stu_class";

    private static final String STUDENT_ID = "stu_id"; // class id

    private static final String CREATED_AT = "created_at";

    private static final String RETURNED_AT = "returned_at";

    private static final String BORROWED_AT = "borrowed_at";

    private static final String BOOK_NAME = "book_name";

    private static final String BOOK_CODE = "book_code"; // 11, 12, 13

    private static final String BOOK_CATEGORY = "book_category"; // form3_math,

    private static final String BARCODE_NO = "barcode_no";


    private static final String CREATE_TABLE_STUDENTS_INFO = "CREATE TABLE "
            + TABLE_STUDENTS_INFO + "(" + KEY_ID + " INTEGER PRIMARY KEY, " +
            STUDENT_ID + " INTEGER, " + STUDENT_NAME + " TEXT, " + STUDENT_CLASS + " TEXT, " +
            CREATED_AT + " DATETIME " + ")";

    private static final String CREATE_TABLE_BORROW_RETURN = "CREATE TABLE "
            + TABLE_BORROW_RETURN + "(" + KEY_ID + " INTEGER PRIMARY KEY, " +
            BARCODE_NO + " TEXT, " + STUDENT_INFO_ID + " INTEGER, " +
            BORROWED_AT + " DATETIME, " + RETURNED_AT + " DATETIME "+ ")";

    private static final String CREATE_TABLE_BOOK_INFO = "CREATE TABLE "
            + TABLE_BOOK_INFO + "(" + KEY_ID + " INTEGER PRIMARY KEY, " +
            BOOK_NAME + " TEXT, " + BOOK_CODE + " TEXT, " + BOOK_CATEGORY + " TEXT, " +
            CREATED_AT + " DATETIME " + ")";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE_BOOK_INFO);
        sqLiteDatabase.execSQL(CREATE_TABLE_BORROW_RETURN);
        sqLiteDatabase.execSQL(CREATE_TABLE_STUDENTS_INFO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK_INFO);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_BORROW_RETURN);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_STUDENTS_INFO);

        onCreate(sqLiteDatabase);
    }

    /*-------------------------------------Book Info---------------------------------------------*/

    public long createBookInfo(BookInfoModal info){
        long result = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOOK_NAME, info.getBookName());
        values.put(BOOK_CODE, info.getBookCode());
        values.put(BOOK_CATEGORY, info.getBookCategory());
        values.put(CREATED_AT, getDateTime());
        result = db.insert(TABLE_BOOK_INFO, null, values);
        db.close();

        return result;
    }

    public long updateBookInfo(BookInfoModal info){
        long result = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BOOK_NAME, info.getBookName());
        values.put(BOOK_CODE, info.getBookCode());
        values.put(BOOK_CATEGORY, info.getBookCategory());
        result = db.update(TABLE_BOOK_INFO, values, KEY_ID + " = ? ",
                new String[]{String.valueOf(info.getId())});

        return result;
    }

    public ArrayList<BookInfoModal> getAllBookInfo(){
        ArrayList<BookInfoModal> infoArray = new ArrayList<>();
        String selectQuery = "SELECT * from " + TABLE_BOOK_INFO + " ORDER BY "+
                CREATED_AT + " DESC ";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c =  db.rawQuery(selectQuery, null);

        if (c.moveToFirst()){
            do{
                BookInfoModal info = new BookInfoModal();
                info.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                info.setBookCode(c.getString(c.getColumnIndex(BOOK_CODE)));
                info.setBookName(c.getString(c.getColumnIndex(BOOK_NAME)));
                info.setBookCategory(c.getString(c.getColumnIndex(BOOK_CATEGORY)));

                infoArray.add(info);
            }while (c.moveToNext());
        }

        c.close();
        db.close();
        return infoArray;
    }

    /*-------------------------------------Borrow Return--------------------------------------*/

    public long borrowBook (BorrowReturnModal info){ // used while text book borrowed

        long result = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BARCODE_NO, info.getBarcode());
        values.put(STUDENT_INFO_ID, info.getStudentInfoId());
        values.put(BORROWED_AT, getDateTime());

        result = db.insert(TABLE_BORROW_RETURN, null, values);

        return result; // return created id
    }

    public long returnBook(BorrowReturnModal info){ // used while text book returned

        long result = 0;

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RETURNED_AT, getDateTime());

        db.update(TABLE_BORROW_RETURN, values, STUDENT_INFO_ID + " = ? ",
                new String[]{String.valueOf(info.getStudentInfoId())});

        return  result;
    }

    public ArrayList<BorrowReturnModal> getBorrowedBooksByStudentInfoId(int studentInfoId){

        ArrayList<BorrowReturnModal> infoArray = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_BORROW_RETURN + " WHERE " + STUDENT_INFO_ID +
                " = ? " ;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, new String[]{String.valueOf(studentInfoId)});

        if (c.moveToFirst()){
            do{
                BorrowReturnModal info = new BorrowReturnModal();
                info.setId(c.getInt(c.getColumnIndex(KEY_ID)));
                info.setBarcode(c.getString(c.getColumnIndex(BARCODE_NO)));
                info.setStudentInfoId(c.getInt(c.getColumnIndex(STUDENT_INFO_ID)));
                infoArray.add(info);
            }while (c.moveToNext());
        }
        c.close();
        db.close();

        return infoArray;
    }

    public StudentInfoModal getStudentInfoByBarcode(String barcode){

        String idSelectQuery = "SELECT * FROM " + TABLE_BORROW_RETURN +
                " WHERE " + BARCODE_NO + " = ? ";
        SQLiteDatabase brDB = this.getReadableDatabase();
        int studentInfoId = 0;
        Cursor brCursor = brDB.rawQuery(idSelectQuery, new String[]{barcode});
        studentInfoId = brCursor.getInt(brCursor.getColumnIndex(STUDENT_INFO_ID));
        brCursor.close();
        brDB. close();

        StudentInfoModal info = new StudentInfoModal();

        if (studentInfoId != 0){

            String infosSelectQuery = "SELECT * FROM " + TABLE_STUDENTS_INFO + " WHERE " +
                    KEY_ID + "  = ?";
            SQLiteDatabase stuDB = this.getReadableDatabase();
            Cursor stuCursor = stuDB.rawQuery(infosSelectQuery,
                    new String[]{String.valueOf(studentInfoId)});

            info.setId(stuCursor.getInt(stuCursor.getColumnIndex(KEY_ID)));
            info.setStudentName(stuCursor.getString(stuCursor.getColumnIndex(STUDENT_NAME)));
            info.setStudentClass(stuCursor.getString(stuCursor.getColumnIndex(STUDENT_CLASS)));
            info.setStudentId(stuCursor.getInt(stuCursor.getColumnIndex(STUDENT_ID)));
            stuCursor.close();
            stuDB.close();
        }

        return info;
    }

    /*------------------------------------student info-------------------------------------*/

    public long createStudentInfo(StudentInfoModal info){

        long result = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(STUDENT_CLASS, info.getStudentClass());
        values.put(STUDENT_NAME, info.getStudentName());
        values.put(STUDENT_ID, info.getStudentId());
        values.put(CREATED_AT, getDateTime());
        result = db.insert(TABLE_STUDENTS_INFO, null, values);

        return result;
    }

    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
