package hua.tung.spbt.ltp.ltpspbtsystem.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USER".
*/
public class UserDao extends AbstractDao<User, String> {

    public static final String TABLENAME = "USER";

    /**
     * Properties of entity User.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Security_user_login_id = new Property(0, String.class, "security_user_login_id", true, "SECURITY_USER_LOGIN_ID");
        public final static Property Security_user_name = new Property(1, String.class, "security_user_name", false, "SECURITY_USER_NAME");
        public final static Property Security_user_status = new Property(2, String.class, "security_user_status", false, "SECURITY_USER_STATUS");
        public final static Property Security_user_password = new Property(3, String.class, "security_user_password", false, "SECURITY_USER_PASSWORD");
        public final static Property Modified_by = new Property(4, String.class, "modified_by", false, "MODIFIED_BY");
        public final static Property Modified_date = new Property(5, String.class, "modified_date", false, "MODIFIED_DATE");
        public final static Property Modified_src = new Property(6, String.class, "modified_src", false, "MODIFIED_SRC");
    }


    public UserDao(DaoConfig config) {
        super(config);
    }
    
    public UserDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USER\" (" + //
                "\"SECURITY_USER_LOGIN_ID\" TEXT PRIMARY KEY NOT NULL ," + // 0: security_user_login_id
                "\"SECURITY_USER_NAME\" TEXT," + // 1: security_user_name
                "\"SECURITY_USER_STATUS\" TEXT," + // 2: security_user_status
                "\"SECURITY_USER_PASSWORD\" TEXT," + // 3: security_user_password
                "\"MODIFIED_BY\" TEXT," + // 4: modified_by
                "\"MODIFIED_DATE\" TEXT," + // 5: modified_date
                "\"MODIFIED_SRC\" TEXT);"); // 6: modified_src
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USER\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, User entity) {
        stmt.clearBindings();
 
        String security_user_login_id = entity.getSecurity_user_login_id();
        if (security_user_login_id != null) {
            stmt.bindString(1, security_user_login_id);
        }
 
        String security_user_name = entity.getSecurity_user_name();
        if (security_user_name != null) {
            stmt.bindString(2, security_user_name);
        }
 
        String security_user_status = entity.getSecurity_user_status();
        if (security_user_status != null) {
            stmt.bindString(3, security_user_status);
        }
 
        String security_user_password = entity.getSecurity_user_password();
        if (security_user_password != null) {
            stmt.bindString(4, security_user_password);
        }
 
        String modified_by = entity.getModified_by();
        if (modified_by != null) {
            stmt.bindString(5, modified_by);
        }
 
        String modified_date = entity.getModified_date();
        if (modified_date != null) {
            stmt.bindString(6, modified_date);
        }
 
        String modified_src = entity.getModified_src();
        if (modified_src != null) {
            stmt.bindString(7, modified_src);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, User entity) {
        stmt.clearBindings();
 
        String security_user_login_id = entity.getSecurity_user_login_id();
        if (security_user_login_id != null) {
            stmt.bindString(1, security_user_login_id);
        }
 
        String security_user_name = entity.getSecurity_user_name();
        if (security_user_name != null) {
            stmt.bindString(2, security_user_name);
        }
 
        String security_user_status = entity.getSecurity_user_status();
        if (security_user_status != null) {
            stmt.bindString(3, security_user_status);
        }
 
        String security_user_password = entity.getSecurity_user_password();
        if (security_user_password != null) {
            stmt.bindString(4, security_user_password);
        }
 
        String modified_by = entity.getModified_by();
        if (modified_by != null) {
            stmt.bindString(5, modified_by);
        }
 
        String modified_date = entity.getModified_date();
        if (modified_date != null) {
            stmt.bindString(6, modified_date);
        }
 
        String modified_src = entity.getModified_src();
        if (modified_src != null) {
            stmt.bindString(7, modified_src);
        }
    }

    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    @Override
    public User readEntity(Cursor cursor, int offset) {
        User entity = new User( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // security_user_login_id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // security_user_name
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // security_user_status
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // security_user_password
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // modified_by
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // modified_date
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6) // modified_src
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, User entity, int offset) {
        entity.setSecurity_user_login_id(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setSecurity_user_name(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setSecurity_user_status(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setSecurity_user_password(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setModified_by(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setModified_date(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setModified_src(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
     }
    
    @Override
    protected final String updateKeyAfterInsert(User entity, long rowId) {
        return entity.getSecurity_user_login_id();
    }
    
    @Override
    public String getKey(User entity) {
        if(entity != null) {
            return entity.getSecurity_user_login_id();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(User entity) {
        return entity.getSecurity_user_login_id() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}