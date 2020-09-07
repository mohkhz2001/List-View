package Model;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static Model.SqliteDB.DB_INFO_TABLE_INFO;

public class PersonDA {
    private SqliteDB sqliteDB;
    private SQLiteDatabase database;

    public PersonDA(Activity context) {
        sqliteDB = new SqliteDB(context);
    }

    public void openDB() {
        database = sqliteDB.getWritableDatabase();
    }

    public void closeDB() {
        database.close();
    }

    public boolean addNewData(Person person) {

        try {

            database.execSQL("INSERT INTO " + DB_INFO_TABLE_INFO + " (" + SqliteDB.DB_TABLE_INFO_FIRSTNAME + " , "
                    + SqliteDB.DB_TABLE_INFO_LASTNAME + " , "
                    + SqliteDB.DB_TABLE_INFO_PHONE_NUMBER + " , "
                    + SqliteDB.DB_TABLE_INFO_EMAIL + " , "
                    + SqliteDB.DB_TABLE_INFO_AGE + ") "
                    + "VALUES (" + "'" + person.getFirstName() + "'" + " , "
                    + "'" + person.getLastName() + "'" + " , "
                    + "'" + person.getPhoneNumber() + "'" + " , "
                    + "'" + person.getEmail() + "'" + " , "
                    + "'" + person.getAge() + "'" + ")");

            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }

    }

    public List<Person> personList() {
        openDB();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DB_INFO_TABLE_INFO, null);

        ArrayList<Person> personArrayList = new ArrayList<>();

        if (cursor.moveToFirst()) {
            do {
                String firstName = cursor.getString(cursor.getColumnIndex(SqliteDB.DB_TABLE_INFO_FIRSTNAME));
                String lastName = cursor.getString(cursor.getColumnIndex(SqliteDB.DB_TABLE_INFO_LASTNAME));
//                String phoneNumber = cursor.getString(cursor.getColumnIndex(SqliteDB.DB_TABLE_INFO_PHONE_NUMBER));
                String email = cursor.getString(cursor.getColumnIndex(SqliteDB.DB_TABLE_INFO_EMAIL));
                int age = cursor.getInt(cursor.getColumnIndex(SqliteDB.DB_TABLE_INFO_AGE));

                personArrayList.add(new Person(firstName, lastName, email, age, 0));
            } while (cursor.moveToNext());
        }
        closeDB();
        return personArrayList;

    }
}
