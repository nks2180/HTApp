package com.app.ht;

import android.content.Context;

/**
 * Created by niranjan on 03/11/16.
 */
public class DBAdapter {

    private final Context context;
    private final DatabaseHelper databaseHelper;

    public DBAdapter(Context context, DatabaseHelper databaseHelper) {
        this.context = context;
        this.databaseHelper = databaseHelper;
    }

    public static class DatabaseHelper {
        public DatabaseHelper(Context context) {

        }
    }

}
