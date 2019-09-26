package com.example.myapplication.modelos;

public class Estudiante {
    private String nombre;
    private String carrera;
    private int semestre;
    private int id;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Estudiante(String nombre, String carrera, int semestre) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
    }

    public Estudiante(String nombre, String carrera, int semestre, int id) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.semestre = semestre;
        this.id = id;
    }

    public Estudiante() {
    }
}
