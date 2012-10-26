package com.fjbelchi.androidtestsexample;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Class responsible to manage shared preferences in the test application
 * 
 * @author fjbelchi
 * 
 */

public class AppPreferences {

    private static final String APP_PREFERENCES = "TestPreferences";

    /**
     * Example Strings for preferences
     */
    private static final String UPDATE = "update";
    private static final String VERSION = "version";
    private static final String STATUS = "status";

    private static AppPreferences instance;
    private SharedPreferences preferences;

    private AppPreferences(Context context) {
        preferences = context.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE);

    }

    public AppPreferences getInstance(Context context) {
        if (AppPreferences.instance == null) {
            AppPreferences.instance = new AppPreferences(context);
        }
        return AppPreferences.instance;
    }

    public boolean isUpdateMode() {
        return preferences.getBoolean(AppPreferences.UPDATE, false);
    }

    public void startUpdateMode() {
        preferences.edit().putBoolean(AppPreferences.UPDATE, true);
    }

    public void cancelUpdateMode() {
        preferences.edit().putBoolean(AppPreferences.UPDATE, false);
    }

    public void setVersion(int version) {
        preferences.edit().putInt(AppPreferences.VERSION, version);
    }

    public int getVersion() {
        return preferences.getInt(AppPreferences.VERSION, 0);
    }

    public void setStatus(Status status) {
        preferences.edit().putString(AppPreferences.STATUS, status.getStatus());
    }
}
