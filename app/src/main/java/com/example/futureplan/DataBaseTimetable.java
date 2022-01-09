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

public class DataBaseTimetable extends SQLiteOpenHelper {

    public static final String TABLE_NAME = "TIMETABLE_TABLE";
    public static final String COLUMN_DAY_OF_WEEK = "DAY_OF_WEEK";
    public static final String COLUMN_SUBJECT_NAME = "SUBJECT_NAME";
    public static final String COLUMN_TIME = "TIME";
    public static final String COLUMN_CLASSROOM = "CLASSROOM";
    public static final String COLUMN_ID = "ID";

    public DataBaseTimetable(@Nullable Context context) {
        super(context, "timetable.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + TABLE_NAME + " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_DAY_OF_WEEK + " TEXT, " + COLUMN_SUBJECT_NAME + " TEXT, " + COLUMN_TIME + " TEXT, "  + COLUMN_CLASSROOM + " TEXT)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE " + TABLE_NAME);
        onCreate(db);

    }

    public boolean insertData(TimetableModel timetableModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_DAY_OF_WEEK, timetableModel.getDayOfWeek());
        contentValues.put(COLUMN_SUBJECT_NAME, timetableModel.getSubject());
        contentValues.put(COLUMN_TIME, timetableModel.getTime());
        contentValues.put(COLUMN_CLASSROOM, timetableModel.getClassroom());

        long insert = db.insert(TABLE_NAME, null, contentValues);
        if(insert == -1){
            return false;
        }else{
            return true;
        }

    }

    public Cursor fetch() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(DataBaseTimetable.TABLE_NAME, new String[]{DataBaseTimetable.COLUMN_DAY_OF_WEEK,DataBaseTimetable.COLUMN_SUBJECT_NAME, DataBaseTimetable.COLUMN_TIME,DataBaseTimetable.COLUMN_CLASSROOM}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }
    private String[][] TimetableTable = {
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""},
            {"","",""}
    };



    public ArrayList<HashMap<String, String>> getAdapterList(Context ctx, String nameOfDay){
        SimpleAdapter sa;
        DataBaseTimetable dataBaseTimetable = new DataBaseTimetable(ctx);

        Cursor cursor = dataBaseTimetable.fetch();
        cursor.moveToFirst();

        for(int i = 0 ; i < cursor.getCount(); i++) {
            if (cursor.getString(0).equals(nameOfDay)) {
                for (int j = 0; j < TimetableTable.length; j++) {
                    if(TimetableTable[j][0].equals("")) {
                        if (cursor.getString(1) != null) {
                            TimetableTable[j][0] = cursor.getString(1);
                            TimetableTable[j][1] = cursor.getString(2);
                            TimetableTable[j][2] = cursor.getString(3);
                        }
                        break;
                    }
                }
            }
            cursor.moveToNext();
        }
        int numberOfFields = 0;
        for (int j = 0; j < TimetableTable.length; j++) {
            if(!TimetableTable[j][0].equals("")) {
                numberOfFields++;
            }else{
                break;
            }
        }


        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        HashMap<String,String> item;
        for(int i=0;i<numberOfFields;i++){
            item = new HashMap<String,String>();
            item.put( "line1", TimetableTable[i][0]);
            item.put( "line2", TimetableTable[i][1]);
            item.put( "line3", TimetableTable[i][2]);
            list.add( item );
        }




        return list;
    }

    public ArrayList<HashMap<String, String>> getListTerminarz(Context ctx, String nameOfDay){
        DataBaseTimetable dataBaseTimetable = new DataBaseTimetable(ctx);

        Cursor cursor = dataBaseTimetable.fetch();
        cursor.moveToFirst();

        for(int i = 0 ; i < cursor.getCount(); i++) {
            if (cursor.getString(0).equals(nameOfDay)) {
                for (int j = 0; j < TimetableTable.length; j++) {
                    if(TimetableTable[j][0].equals("")) {
                        if (cursor.getString(1) != null) {
                            TimetableTable[j][0] = cursor.getString(1);
                            TimetableTable[j][1] = cursor.getString(2);
                        }
                        break;
                    }
                }
            }
            cursor.moveToNext();
        }
        int numberOfFields = 0;
        for (int j = 0; j < TimetableTable.length; j++) {
            if(!TimetableTable[j][0].equals("")) {
                numberOfFields++;
            }else{
                break;
            }
        }


        ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();

        HashMap<String,String> item;
        for(int i=0;i<numberOfFields;i++){
            item = new HashMap<String,String>();
            item.put( "line1", TimetableTable[i][0]);
            item.put( "line2", TimetableTable[i][1]);
            list.add( item );
        }




        return list;
    }



}
