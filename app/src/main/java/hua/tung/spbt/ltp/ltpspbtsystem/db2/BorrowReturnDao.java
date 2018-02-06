package hua.tung.spbt.ltp.ltpspbtsystem.db2;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "BORROW_RETURN".
*/
public class BorrowReturnDao extends AbstractDao<BorrowReturn, Long> {

    public static final String TABLENAME = "BORROW_RETURN";

    /**
     * Properties of entity BorrowReturn.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Borrow_return_id = new Property(0, Long.class, "borrow_return_id", true, "BORROW_RETURN_ID");
        public final static Property Student_info_id = new Property(1, Long.class, "student_info_id", false, "STUDENT_INFO_ID");
        public final static Property Book_info_id = new Property(2, Long.class, "book_info_id", false, "BOOK_INFO_ID");
        public final static Property Barcode = new Property(3, String.class, "barcode", false, "BARCODE");
        public final static Property Borrow_issue_by = new Property(4, String.class, "borrow_issue_by", false, "BORROW_ISSUE_BY");
        public final static Property Return_issue_by = new Property(5, String.class, "return_issue_by", false, "RETURN_ISSUE_BY");
        public final static Property Borrow_date = new Property(6, String.class, "borrow_date", false, "BORROW_DATE");
        public final static Property Return_date = new Property(7, String.class, "return_date", false, "RETURN_DATE");
    }


    public BorrowReturnDao(DaoConfig config) {
        super(config);
    }
    
    public BorrowReturnDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"BORROW_RETURN\" (" + //
                "\"BORROW_RETURN_ID\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: borrow_return_id
                "\"STUDENT_INFO_ID\" INTEGER," + // 1: student_info_id
                "\"BOOK_INFO_ID\" INTEGER," + // 2: book_info_id
                "\"BARCODE\" TEXT," + // 3: barcode
                "\"BORROW_ISSUE_BY\" TEXT," + // 4: borrow_issue_by
                "\"RETURN_ISSUE_BY\" TEXT," + // 5: return_issue_by
                "\"BORROW_DATE\" TEXT," + // 6: borrow_date
                "\"RETURN_DATE\" TEXT);"); // 7: return_date
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"BORROW_RETURN\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, BorrowReturn entity) {
        stmt.clearBindings();
 
        Long borrow_return_id = entity.getBorrow_return_id();
        if (borrow_return_id != null) {
            stmt.bindLong(1, borrow_return_id);
        }
 
        Long student_info_id = entity.getStudent_info_id();
        if (student_info_id != null) {
            stmt.bindLong(2, student_info_id);
        }
 
        Long book_info_id = entity.getBook_info_id();
        if (book_info_id != null) {
            stmt.bindLong(3, book_info_id);
        }
 
        String barcode = entity.getBarcode();
        if (barcode != null) {
            stmt.bindString(4, barcode);
        }
 
        String borrow_issue_by = entity.getBorrow_issue_by();
        if (borrow_issue_by != null) {
            stmt.bindString(5, borrow_issue_by);
        }
 
        String return_issue_by = entity.getReturn_issue_by();
        if (return_issue_by != null) {
            stmt.bindString(6, return_issue_by);
        }
 
        String borrow_date = entity.getBorrow_date();
        if (borrow_date != null) {
            stmt.bindString(7, borrow_date);
        }
 
        String return_date = entity.getReturn_date();
        if (return_date != null) {
            stmt.bindString(8, return_date);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, BorrowReturn entity) {
        stmt.clearBindings();
 
        Long borrow_return_id = entity.getBorrow_return_id();
        if (borrow_return_id != null) {
            stmt.bindLong(1, borrow_return_id);
        }
 
        Long student_info_id = entity.getStudent_info_id();
        if (student_info_id != null) {
            stmt.bindLong(2, student_info_id);
        }
 
        Long book_info_id = entity.getBook_info_id();
        if (book_info_id != null) {
            stmt.bindLong(3, book_info_id);
        }
 
        String barcode = entity.getBarcode();
        if (barcode != null) {
            stmt.bindString(4, barcode);
        }
 
        String borrow_issue_by = entity.getBorrow_issue_by();
        if (borrow_issue_by != null) {
            stmt.bindString(5, borrow_issue_by);
        }
 
        String return_issue_by = entity.getReturn_issue_by();
        if (return_issue_by != null) {
            stmt.bindString(6, return_issue_by);
        }
 
        String borrow_date = entity.getBorrow_date();
        if (borrow_date != null) {
            stmt.bindString(7, borrow_date);
        }
 
        String return_date = entity.getReturn_date();
        if (return_date != null) {
            stmt.bindString(8, return_date);
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public BorrowReturn readEntity(Cursor cursor, int offset) {
        BorrowReturn entity = new BorrowReturn( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // borrow_return_id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // student_info_id
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // book_info_id
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // barcode
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // borrow_issue_by
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // return_issue_by
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // borrow_date
            cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7) // return_date
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, BorrowReturn entity, int offset) {
        entity.setBorrow_return_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setStudent_info_id(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setBook_info_id(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setBarcode(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setBorrow_issue_by(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setReturn_issue_by(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setBorrow_date(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setReturn_date(cursor.isNull(offset + 7) ? null : cursor.getString(offset + 7));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(BorrowReturn entity, long rowId) {
        entity.setBorrow_return_id(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(BorrowReturn entity) {
        if(entity != null) {
            return entity.getBorrow_return_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(BorrowReturn entity) {
        return entity.getBorrow_return_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
