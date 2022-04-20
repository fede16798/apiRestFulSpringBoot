package com.example.SpringMVC.mapper;

import com.example.SpringMVC.dto.CursoDTO;
import com.example.SpringMVC.entities.Curso;

public class CursoMapper {
    public static CursoDTO toDTO(Curso curso) {
        if (curso == null) {
            return null;
        }
        CursoDTO cursoDTO = new CursoDTO();
        cursoDTO.setCursoId(curso.getCursoId());
        cursoDTO.setNombre(curso.getNombre());
        cursoDTO.setDescripcion(curso.getDescripcion());
        cursoDTO.setTurno(curso.getTurno());
        cursoDTO.setProfesor((curso.getProfesor() != null) ? curso.getProfesor().getNombre() + " " + curso.getProfesor().getApellido() : "No tiene profesor asignado");

        return cursoDTO;
    }


}
