package com.example.SpringMVC.mapper;

import com.example.SpringMVC.dto.EstudianteDTO;
import com.example.SpringMVC.entities.Estudiante;

public class EstudianteMapper {
    public static EstudianteDTO toDTO(Estudiante est) {
        if (est == null){return null;}

        EstudianteDTO estDTO = new EstudianteDTO();
        estDTO.setLegajo(est.getLegajo());
        estDTO.setNombre(est.getNombre());
        estDTO.setApellido(est.getApellido());
        estDTO.setFechaDeNacimiento(est.getFechaDeNacimiento());
        est.setCarrera(est.getCarrera());

        return estDTO;
    }
}
