package com.example.futureplan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.contentcapture.DataRemovalRequest;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "USER_TABLE";
    public static final String COLUMN_USER_FIRST_NAME = "USER_FIRST_NAME";
    public static final String COLUMN_USER_SECOND_NAME = "USER_SECOND_NAME";
    public static final String COLUMN_USER_NAME = "USER_NAME";
    public static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    public static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";
    public static final String COLUMN_USER_NUMBER = "USER_NUMBER";
    public static final String COLUMN_USER_DATE = "USER_DATE";
    public static final String COLUMN_ID = "ID";
    //public static final String COLUMN_USER_AVATAR = "USER_AVATAR";

    public DataBaseHelper(@Nullable Context context) {
            super(context, "users.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_USER_FIRST_NAME + " TEXT, " + COLUMN_USER_SECOND_NAME + " TEXT, " + COLUMN_USER_NAME + " TEXT, " + COLUMN_USER_EMAIL + " TEXT, "  + COLUMN_USER_PASSWORD + " TEXT, "  + COLUMN_USER_NUMBER + " TEXT, "  + COLUMN_USER_DATE + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_FIRST_NAME, userModel.getFirstName());
        contentValues.put(COLUMN_USER_SECOND_NAME, userModel.getSecondName());
        contentValues.put(COLUMN_USER_NAME, userModel.getName());
        contentValues.put(COLUMN_USER_EMAIL, userModel.getEmail());
        contentValues.put(COLUMN_USER_PASSWORD, userModel.getPassword());
        contentValues.put(COLUMN_USER_NUMBER, userModel.getNumber());
        contentValues.put(COLUMN_USER_DATE, userModel.getDate());
        //contentValues.put(COLUMN_USER_AVATAR, userModel.getAvatarID());

        long insert = db.insert(TABLE_NAME, null, contentValues);
        if(insert == -1){
            return false;
        }else{
            return true;
        }

    }

    public boolean updateData(UserModel userModel, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_USER_FIRST_NAME, userModel.getFirstName());
        contentValues.put(COLUMN_USER_SECOND_NAME, userModel.getSecondName());
        contentValues.put(COLUMN_USER_NAME, userModel.getName());
        contentValues.put(COLUMN_USER_EMAIL, userModel.getEmail());
        contentValues.put(COLUMN_USER_NUMBER, userModel.getNumber());
        contentValues.put(COLUMN_USER_DATE, userModel.getDate());
        //contentValues.put(COLUMN_USER_AVATAR, userModel.getAvatarID());


        long insert = db.update(TABLE_NAME, contentValues,COLUMN_USER_EMAIL + " = ?", new String[] {email});
        if(insert == -1){
            return false;
        }else{
            return true;
        }

    }

    public Boolean checkemail(String email){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_USER_EMAIL + " = ?", new String[] {email});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Cursor fetch() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(DataBaseHelper.TABLE_NAME, new String[]{DataBaseHelper.COLUMN_USER_FIRST_NAME, DataBaseHelper.COLUMN_USER_SECOND_NAME, DataBaseHelper.COLUMN_USER_NAME , DataBaseHelper.COLUMN_USER_EMAIL,DataBaseHelper.COLUMN_USER_NUMBER, DataBaseHelper.COLUMN_USER_DATE}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public Boolean checkpassword(String username, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COLUMN_USER_EMAIL + " = ? and " + COLUMN_USER_PASSWORD + " = ?", new String[] {username,password});
        if(cursor.getCount() > 0)
            return true;
        else
            return false;
    }

}
