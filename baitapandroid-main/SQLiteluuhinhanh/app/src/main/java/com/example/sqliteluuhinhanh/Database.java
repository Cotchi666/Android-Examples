package com.example.sqliteluuhinhanh;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    //Khong tra ve
    public void queryData(String str) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        sqLiteDatabase.execSQL(str);
    }

    public void insert_dovat(String ten, String moTa, byte[] hinhanh) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        String sqlSTR = "INSERT INTO DoVat VALUES (null,?,?,?) ";
        SQLiteStatement sqLiteStatement = sqLiteDatabase.compileStatement(sqlSTR);
        sqLiteStatement.clearBindings();
        sqLiteStatement.bindString(1, ten);
        sqLiteStatement.bindString(2, moTa);
        sqLiteStatement.bindBlob(3, hinhanh);

        sqLiteStatement.executeInsert();
    }

    //tra ve ket qua
    public Cursor getData(String str) {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery(str, null);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
