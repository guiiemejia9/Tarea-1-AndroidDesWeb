package com.example.tarea1androidstudio;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tarea1androidstudio.utilidades.Assets;

public class Connection extends SQLiteOpenHelper {

    public Connection(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Assets.CREAR_TABLA_PRODUCTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS PRODUCTO");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(sqLiteDatabase);
    }
}
