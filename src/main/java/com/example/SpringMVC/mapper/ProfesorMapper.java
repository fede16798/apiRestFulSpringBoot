package com.example.SpringMVC.mapper;

import com.example.SpringMVC.dto.ProfesorDTO;
import com.example.SpringMVC.entities.Profesor;

import java.util.Optional;

public class ProfesorMapper {
    public static ProfesorDTO toDTO(Profesor profesor) {
        if (profesor == null) {
            return null;
        }

        ProfesorDTO profesorDTO = new ProfesorDTO();
        profesorDTO.setId(profesor.getId());
        profesorDTO.setFullname(profesor.getNombre() + " " + profesor.getApellido());
        profesorDTO.setName(profesor.getNombre());
        profesorDTO.setLastname(profesor.getApellido());
        return profesorDTO;
    }

    public Profesor toEntity(ProfesorDTO profesorDTO) {
        if (profesorDTO == null) {
            return null;
        }
        Profesor profesor = new Profesor();
        profesor.setId(profesorDTO.getId());
        profesor.setNombre(profesorDTO.getName());
        profesor.setApellido(profesorDTO.getLastname());
        return profesor;
    }
}
