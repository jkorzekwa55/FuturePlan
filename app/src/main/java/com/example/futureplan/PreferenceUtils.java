package com.example.futureplan;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PreferenceUtils {
    public PreferenceUtils(){

    }
    public static boolean saveEmail(String email, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_EMAIl,email);
        prefsEditor.apply();
        return true;
    }
    public static String getEmail(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_EMAIl, null);
    }
    public static boolean saveName(String name, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_NAME,name);
        prefsEditor.apply();
        return true;
    }

    public static boolean saveAvatar(String avatar, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_AVATAR,avatar);
        prefsEditor.apply();
        return true;
    }
    public static String getAvatar(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_AVATAR,null);
    }
    public static boolean saveNote(String note, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_NOTE,note);
        prefsEditor.apply();
        return true;
    }
    public static String getNote(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_NOTE, null);
    }
    public static boolean saveTitleNote(String titleNote, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_TITLE_NOTE,titleNote);
        prefsEditor.apply();
        return true;
    }
    public static String getTitleNote(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_TITLE_NOTE, null);
    }

    public static boolean saveDay(String day, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_DAY,day);
        prefsEditor.apply();
        return true;
    }
    public static String getDay(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_DAY, null);
    }
    public static boolean saveSubject(String subject, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_SUBJECT,subject);
        prefsEditor.apply();
        return true;
    }
    public static String getSubject(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_SUBJECT, null);
    }

    public static boolean saveSubjectID(int subject_id, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt(Constants.KEY_ID_SUBJECT_POMOCE,subject_id);
        prefsEditor.apply();
        return true;
    }
    public static int getSubjectID(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getInt(Constants.KEY_ID_SUBJECT_POMOCE,0);
    }
    public static boolean saveSubjectIDtext(int subject_id_text, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putInt(Constants.KEY_ID_SUBJECT_POMOCE_TEXT,subject_id_text);
        prefsEditor.apply();
        return true;
    }
    public static int getSubjectIDtext(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getInt(Constants.KEY_ID_SUBJECT_POMOCE_TEXT,0);
    }
}
