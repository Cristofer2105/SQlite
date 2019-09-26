package com.example.myapplication.controllers;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.myapplication.modelos.AyudanteBaseDeDatos;
import com.example.myapplication.modelos.Estudiante;

import java.security.Key;

public class EstudianteController {
    private AyudanteBaseDeDatos ayudanteBaseDeDatos;
    private  String NOMBRE_TABLA="estudiantes";
    public  EstudianteController(Context context)
    {
            ayudanteBaseDeDatos=new AyudanteBaseDeDatos(context);
    }
    public long nuevoEstudiante(Estudiante estudiante)
    {
        //Para escribir un write
        SQLiteDatabase baseDeDatos=ayudanteBaseDeDatos.getWritableDatabase();
        ContentValues valoresInsertar=new ContentValues();
        valoresInsertar.put("nombre",estudiante.getNombre());
        valoresInsertar.put("carrera",estudiante.getCarrera());
        valoresInsertar.put("semestre",estudiante.getSemestre());
        return baseDeDatos.insert(NOMBRE_TABLA,null,valoresInsertar);
    }

}
