package Model;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteDB extends SQLiteOpenHelper {
    private final static String DB_INFO = "userInfo.db";
    private final static int DB_VERSION = 1;

    public SqliteDB(Activity context) {
        super(context, DB_INFO, null, DB_VERSION);
    }

    // table column
    public static final String DB_INFO_TABLE_INFO = "info";
    public static final String DB_TABLE_INFO_FIRSTNAME = "firstName";
    public static final String DB_TABLE_INFO_LASTNAME = "lastName";
    public static final String DB_TABLE_INFO_PHONE_NUMBER = "phoneNumber";
    public static final String DB_TABLE_INFO_EMAIL = "email";
    public static final String DB_TABLE_INFO_AGE = "age";

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sqlite = "CREATE TABLE IF NOT EXISTS " + DB_INFO_TABLE_INFO + "("
                + DB_TABLE_INFO_FIRSTNAME + " TEXT ,"
                + DB_TABLE_INFO_LASTNAME + " TEXT ,"
                + DB_TABLE_INFO_PHONE_NUMBER + " TEXT ,"
                + DB_TABLE_INFO_EMAIL + " TEXT , "
                + DB_TABLE_INFO_AGE + " INTEGER )";
        sqLiteDatabase.execSQL(sqlite);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DB_INFO_TABLE_INFO);

        onCreate(sqLiteDatabase);
    }
}
