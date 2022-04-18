package com.example.SpringMVC.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idInscripcion;
    @ManyToOne
    @JoinColumn(name = "curso", nullable = true)
    @JsonIgnoreProperties(value={"nombre", "descripcion", "cupo","turno","profesor","cursoInscripciones"})
    private Curso curso;
    @ManyToOne
    @JoinColumn(name = "estudiante", nullable = true)
    @JsonIgnoreProperties(value={"nombre", "apellido", "fechaDeNacimiento", "carrera","estudianteInscripciones", "edad"})
    private Estudiante estudiante;

    private LocalDate fecha;

    public Inscripcion(){}
    public Inscripcion(Long idInscripcion, Curso curso, Estudiante estudiante, LocalDate fecha) {
        this.idInscripcion = idInscripcion;
        this.curso = curso;
        this.estudiante = estudiante;
        this.fecha = fecha;
    }
    public Inscripcion(Curso curso, Estudiante estudiante, LocalDate fecha) {
        this.curso = curso;
        this.estudiante = estudiante;
        this.fecha = fecha;
    }
    public Long getIdInscripcion() {
        return idInscripcion;
    }

    public void setIdInscripcion(Long idInscripcion) {
        this.idInscripcion = idInscripcion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "idInscripcion=" + idInscripcion +
                ", Curso=" + curso.getCursoId() +
                ", Estudiante=" + estudiante.getLegajo() +
                ", fecha=" + fecha +
                '}';
    }
}
