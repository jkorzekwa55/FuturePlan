package com.example.futureplan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

public class DataBaseHomework extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "HOMEWORK_TABLE";
    public static final String COLUMN_SUBJECT_NAME = "SUBJECT_NAME";
    public static final String COLUMN_DATE = "DATE";
    public static final String COLUMN_TITLE = "TITLE";
    public static final String COLUMN_ID = "ID";

    public DataBaseHomework(@Nullable Context context) {
        super(context, "homework.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_SUBJECT_NAME + " TEXT, " + COLUMN_DATE + " TEXT, " + COLUMN_TITLE + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);

    }

    public void deleteRow(String title)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_NAME+ " WHERE "+COLUMN_TITLE+"='"+title+"'");
        db.close();
    }

    public boolean insertData(HomeworkModel homeworkModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_SUBJECT_NAME, homeworkModel.getSubject());
        contentValues.put(COLUMN_DATE, homeworkModel.getDate());
        contentValues.put(COLUMN_TITLE, homeworkModel.getTitle());

        long insert = db.insert(TABLE_NAME, null, contentValues);
        if(insert == -1){
            return false;
        }else{
            return true;
        }

    }

    public Cursor fetch() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(DataBaseHomework.TABLE_NAME, new String[]{DataBaseHomework.COLUMN_SUBJECT_NAME,DataBaseHomework.COLUMN_DATE, DataBaseHomework.COLUMN_TITLE}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    private String[][] HomeworkTable = {
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""}
    };

    public ArrayList<HashMap<String, String>> getAdapterList(Context ctx){
        DataBaseHomework dataBaseHomework = new DataBaseHomework(ctx);
        Cursor cursor = dataBaseHomework.fetch();
        cursor.moveToFirst();

        for(int i = 0 ; i < cursor.getCount(); i++) {
                for (int j = 0; j < HomeworkTable.length; j++) {
                    if(HomeworkTable[j][0].equals("")) {
                        if (cursor.getString(1) != null) {
                            HomeworkTable[j][0] = cursor.getString(2);
                            HomeworkTable[j][1] = cursor.getString(0);
                            HomeworkTable[j][2] = cursor.getString(1);
                        }
                        break;
                    }
            }
            cursor.moveToNext();
        }
        int numberOfFields = 0;
        for (int j = 0; j < HomeworkTable.length; j++) {
            if(!HomeworkTable[j][0].equals("")) {
                numberOfFields++;
            }else{
                break;
            }
        }
        String date = null;

        for (int j = 0; j < HomeworkTable.length; j++) {
            date = HomeworkTable[j][2];
            char[] ca = date.toCharArray();
            String[] parts = date.split(".");

        }



        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        HashMap<String,String> item;
        for(int i=0;i<numberOfFields;i++){
            item = new HashMap<String,String>();
            item.put( "line1", HomeworkTable[i][0]);
            item.put( "line2", HomeworkTable[i][1]);
            item.put( "line3", HomeworkTable[i][2]);
            list.add( item );
        }
        return list;
    }
    public ArrayList<HashMap<String, String>> getListHomework(Context ctx, String date){
        DataBaseHomework dataBaseHomework = new DataBaseHomework(ctx);
        Cursor cursor = dataBaseHomework.fetch();
        cursor.moveToFirst();

        for(int i = 0 ; i < cursor.getCount(); i++) {
            if (cursor.getString(1).equals(date)) {
                for (int j = 0; j < HomeworkTable.length; j++) {
                    if(HomeworkTable[j][0].equals("")) {
                        if (cursor.getString(1) != null) {
                            HomeworkTable[j][0] = cursor.getString(0);
                            HomeworkTable[j][1] = cursor.getString(2);
                        }
                        break;
                    }
                }
            }
            cursor.moveToNext();
        }
        int numberOfFields = 0;
        for (int j = 0; j < HomeworkTable.length; j++) {
            if(!HomeworkTable[j][0].equals("")) {
                numberOfFields++;
            }else{
                break;
            }
        }

        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        HashMap<String,String> item;
        for(int i=0;i<numberOfFields;i++){
            item = new HashMap<String,String>();
            item.put( "line1", HomeworkTable[i][0]);
            item.put( "line2", HomeworkTable[i][1]);
            list.add( item );
        }

        return list;
    }
    
}
