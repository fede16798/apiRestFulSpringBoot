package com.example.SpringMVC.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table(name="curso")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cursoId;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "cupo", nullable = false)
    private Integer cupo;
    @Column(name = "turno", nullable = false)
    private String turno;

    @ManyToOne
    @JoinColumn(name = "PROFESOR_ID", nullable = true)
    private Profesor profesor;

    @OneToMany (mappedBy = "curso", cascade = CascadeType.REMOVE)
    private List<Inscripcion> cursoInscripciones;

    public Curso (){};
    public Curso(Long id, String nombre, String descripcion, Integer cupo, String turno) {
        this.cursoId = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.turno = turno;
    }
    public Curso(String nombre, String descripcion, Integer cupo, String turno) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cupo = cupo;
        this.turno = turno;
    }


    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCupo() {
        return cupo;
    }

    public void setCupo(Integer cupo) {
        this.cupo = cupo;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "cursoId=" + cursoId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", cupo=" + cupo +
                ", turno='" + turno + '\'' +
                ", profesor=" + ((chequearProfesorActivado())? profesor.getId() : "No hay profesor desginado") +
                '}';
    }

    private boolean chequearProfesorActivado() {
        if (profesor == null){
            return false;
        } else {
            return true;
        }
    }
    public void modificarTurno(Curso c, String turno) {
        c.setTurno(turno);
    }
}
