package com.example.console2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {


    public DBHelper(Context context) {
        super(context, "Registerdata.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create Table userdetails(id TEXT primary key, problem TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase DB, int  i, int i1) {
        DB.execSQL("drop Table if exists userdetails");

    }

    public boolean insertuserdata(String id,String selected_item) {


        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", id);
        long result = DB.insert("userdetails", null, contentValues);
        if(result==-1){
            return  false;
        }
        else{
            return  true;
        }
    }
    public Cursor getdata(){
        SQLiteDatabase DB=this.getWritableDatabase();
        Cursor cursor=DB.rawQuery("Select * from userdetails",null);
        return cursor;
    }



}

