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
    public static String getName(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_NAME, null);
    }
    public static boolean saveFirstName(String firstName, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_FIRST_NAME,firstName);
        prefsEditor.apply();
        return true;
    }
    public static String getFirstName(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_FIRST_NAME, null);
    }
    public static boolean saveLastName(String lastName, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_LAST_NAME,lastName);
        prefsEditor.apply();
        return true;
    }
    public static String getLastName(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_LAST_NAME, null);
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
    public static boolean saveNumber(String number, Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        SharedPreferences.Editor prefsEditor = prefs.edit();
        prefsEditor.putString(Constants.KEY_NUMBER,number);
        prefsEditor.apply();
        return true;
    }
    public static String getNumber(Context ctx){
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(ctx);
        return prefs.getString(Constants.KEY_NUMBER, null);
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
}
