package com.example.driveit;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Gallery;

public class Permissions_Settings {
    private Context context;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    public Permissions_Settings(Context context) {
        this.context = context;
        this.sp = context.getSharedPreferences(context.getString(R.string.permissions_setting), Context.MODE_PRIVATE);
        editor = sp.edit();
    }

}
