package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.controllers.EstudianteController;
import com.example.myapplication.modelos.AyudanteBaseDeDatos;
import com.example.myapplication.modelos.Estudiante;

public class MainActivity extends AppCompatActivity {
    EditText etNombre;
    EditText estCarrera;
    EditText etSemestre;
    TextView tvNombreRec;
    TextView tvCarreraRec;
    Button btnCrear,btnCargar;
    EstudianteController estudianteController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etNombre=findViewById(R.id.etNombres);
        estCarrera=findViewById(R.id.etCarrera);
        etSemestre=findViewById(R.id.etSemestre);
        btnCrear=findViewById(R.id.btnRegistrar);
        btnCargar=findViewById(R.id.btnCargar);
        tvNombreRec=findViewById(R.id.tvNombreRec);
        tvCarreraRec=findViewById(R.id.tvCarreraRec);
        estudianteController=new EstudianteController(MainActivity.this);
        //onclick boton
        btnCargar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    AyudanteBaseDeDatos abd=new AyudanteBaseDeDatos(MainActivity.this);
                    SQLiteDatabase bd = abd.getReadableDatabase();
                    Cursor c = bd.rawQuery("select nombre,carrera from estudiantes",null);
                    if(c.moveToFirst())
                    {
                        do {
                            String nombreObtenido=c.getString(0);
                            String carreraObtenida = c.getString(1);
                            tvNombreRec.append(nombreObtenido+"\t");
                            tvCarreraRec.append(carreraObtenida+"\t");
                        }while (c.moveToNext());
                    }
                }catch (Exception ex){
                    Log.println(Log.ERROR,"error","Error al leer la bd"+ex.getMessage());
                }
            }
        });
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //recuperar los textos
                String nombre = etNombre.getText().toString();
                String carrera = estCarrera.getText().toString();
                String semestreCad=etSemestre.getText().toString();
                //Validar que no queden vacios
                if ("".equals(nombre))
                {
                    etNombre.setError("debes ingresar el nombre");
                    etNombre.requestFocus();
                    return;
                }
                if ("".equals(carrera))
                {
                    estCarrera.setError("debes ingresar la carrera");
                    estCarrera.requestFocus();
                    return;
                }
                if ("".equals(semestreCad))
                {
                    etSemestre.setError("debes ingresar el semestre");
                    etSemestre.requestFocus();
                    return;
                }
                //Validadndo que sea numero mediante inputType
                int semestre = Integer.parseInt(etSemestre.getText().toString());
                Estudiante estudiante=new Estudiante(nombre,carrera,semestre);
                long creado = estudianteController.nuevoEstudiante(estudiante);
                if (creado==-1)
                {
                    //error en la insercion
                    Toast.makeText(MainActivity.this,"error al insertar",Toast.LENGTH_LONG).show();
                }
                else
                    {
                        //Si esta ok finaizar
                        //finish();
                        Toast.makeText(MainActivity.this,"insertado",Toast.LENGTH_LONG).show();
                    }
            }
        });
    }
}
