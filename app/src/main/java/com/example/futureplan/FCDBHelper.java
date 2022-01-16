package com.example.futureplan;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class FCDBHelper extends SQLiteOpenHelper {


    public FCDBHelper(Context context){
        super(context, "flashcardsdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table flashcards(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, nazwa TEXT NOT NULL, opis1 TEXT, notatka1 TEXT, opis2 TEXT, notatka2 TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
       // DB.execSQL("drop Table if exists flashcards");
    }

    public Boolean insertFlashcardsData(String nazwa, String opis1, String notatka1, String opis2, String notatka2){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nazwa", nazwa);
        contentValues.put("opis1", opis1);
        contentValues.put("notatka1", notatka1);
        contentValues.put("opis2", opis2);
        contentValues.put("notatka2", notatka2);

        long result = DB.insert("flashcards", null, contentValues);

        if (result == -1)
            return false;
        else
            return true;
    }

    public Cursor getFlashcardsData(){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from flashcards", null);
        return cursor;
    }

    public Cursor getFlashKit(String nazwa){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from flashcards where nazwa = ?", new String[] {nazwa});
        return cursor;
    }

    public Boolean deleteData (String name){
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("Select * from flashcards where name = ?", new String[] {name});
        if(cursor.getCount() > 0){
            long result = DB.delete("flashcards", "name=?", new String[]{name});
            if(result == -1) {
                return false;
            }else{
                return true;
            }
        } else {
            return false;
        }
    }
}
