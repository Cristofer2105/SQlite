package com.example.myapplication.modelos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AyudanteBaseDeDatos extends SQLiteOpenHelper {
    private  static final String NOMBRE_BASE_DATOS="universidad",
            NOMBRE_TABLA_ESTUDIANTES="estudiantes";
    private static  final  int VERSION_BASE_DE_DATOS=1;

    public AyudanteBaseDeDatos(Context context) {
        super(context, NOMBRE_BASE_DATOS,null,VERSION_BASE_DE_DATOS);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //CREAR LA TABLA:
        sqLiteDatabase.execSQL(String.format("CREATE TABLE IF NOT EXISTS %s(id integer primary key autoincrement, nombre text,carrera text,semestre integer)",NOMBRE_TABLA_ESTUDIANTES));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
