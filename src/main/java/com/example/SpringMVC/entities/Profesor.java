package com.example.SpringMVC.entities;


import com.example.SpringMVC.annotations.DateOfBirthValidation;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;

@Entity
@Table (name = "profesor")
@DateOfBirthValidation
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "name must not be null")
    private String nombre;
    @NotBlank(message = "last name must not be null")
    private String apellido;
    private LocalDate fechaDeNacimiento;
    @NotBlank(message = "salary must not be null")
    private double salario;
    @Transient
    private Integer edad;

    @OneToMany (mappedBy = "profesor")
    @JsonIgnore
    private List<Curso> cursos;

    public Profesor (){};

    public Profesor(Long id, String nombre, String apellido, LocalDate fechaDeNacimiento, double salario) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.salario = salario;
    }

    public Profesor(String nombre, String apellido, LocalDate fechaDeNacimiento, double salario) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Integer getEdad() {
        return Period.between(this.fechaDeNacimiento, LocalDate.now()).getYears();
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(List<Curso> cursos) {
        this.cursos = cursos;
    }

    @Override
    public String toString() {
        return "Profesor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaDeNacimiento=" + fechaDeNacimiento +
                ", salario=" + salario + '\'' + ", edad= " + getEdad() +
                '}';
    }
}
