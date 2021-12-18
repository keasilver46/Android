package com.cookandroid.project12_2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(Context context) {
        super(context, "groupDB", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.i("데이터베이스실습앱", "MyDBHelper: onCreate() called");
        sqLiteDatabase.execSQL("CREATE TABLE groupTBL ( gName CHAR(20) PRIMARY KEY, gNumber INTEGER );");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        Log.i("데이터베이스실습앱", "MyDBHelper: onUpgrade() called");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS groupTBL;");
        onCreate(sqLiteDatabase);
    }
}