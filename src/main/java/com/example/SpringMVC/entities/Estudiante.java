package com.example.SpringMVC.entities;

import com.example.SpringMVC.annotations.CarreraValidation;
import com.example.SpringMVC.annotations.DateOfBirthValidation;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long legajo;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "apellido", nullable = false)
    private String apellido;
    @Column(name = "fecha_de_nacimiento", nullable = false)
    private LocalDate fechaDeNacimiento;
    @CarreraValidation()
    @Column(name = "carrera", nullable = false)
    private String carrera;
    @Transient
    private Integer edad;

    @OneToMany(mappedBy = "estudiante", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    private List<Inscripcion> estudianteInscripciones;

    public Estudiante() {
    }

    public Estudiante(Long legajo, String nombre, String apellido, LocalDate fechaDeNacimiento, String carrera) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.carrera = carrera;
    }

    public Estudiante(String nombre, String apellido, LocalDate fechaDeNacimiento, String carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.carrera = carrera;
    }

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

    public Integer getEdad() {
        return Period.between(this.fechaDeNacimiento, LocalDate.now()).getYears();
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public List<Inscripcion> getEstudianteInscripciones() {
        return estudianteInscripciones;
    }

    public void setEstudianteInscripciones(List<Inscripcion> estudianteInscripciones) {
        this.estudianteInscripciones = estudianteInscripciones;
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "legajo=" + legajo +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento + "edad= " + getEdad() +
                ", carrera='" + carrera + "}";
    }
}
