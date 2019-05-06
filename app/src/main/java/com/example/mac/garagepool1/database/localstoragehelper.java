package com.example.mac.garagepool1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by mac on 05/02/2018.
 */

public class localstoragehelper extends SQLiteOpenHelper {
    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "GPool.db";

    public localstoragehelper(Context context){
        super(context, DATABASE_NAME,null,VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("create table Mechanics("
                +"Mid integer PRIMARY KEY autoincrement, "
                +"Name text, "
                +"Email text, "
                +"Password password, "
                +"Phone text);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,int oldVersion, int newVersion)
    {

    }

}
