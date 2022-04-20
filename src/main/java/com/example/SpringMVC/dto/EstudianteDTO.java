package com.example.SpringMVC.dto;

import java.io.Serializable;
import java.time.LocalDate;

public class EstudianteDTO implements Serializable {
    private Long legajo;
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;
    private String carrera;
    public EstudianteDTO(){};
    public Long getLegajo() {
        return legajo;
    }
    public void setLegajo(Long legajo) {
        this.legajo = legajo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }
    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }
    public String getCarrera() {
        return carrera;
    }
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }
}
