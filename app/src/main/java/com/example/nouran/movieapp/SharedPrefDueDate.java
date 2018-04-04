package com.example.nouran.movieapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class SharedPrefDueDate {
    // LogCat tag
    private static String TAG = SharedPrefDueDate.class.getSimpleName();

    // Shared Preferences
    SharedPreferences pref;

    Editor editor;
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "MovieAPp";

    private static final String PERSON_ID_CODE = "PERSON_ID";

    public SharedPrefDueDate(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }



    public void setPersonId(String  numSub) {

        editor.putString(PERSON_ID_CODE, numSub);
        // commit changes
        editor.commit();

    }

    public String getpersonID() {
        return pref.getString(PERSON_ID_CODE , "null");
    }
}
