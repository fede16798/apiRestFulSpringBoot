package com.example.SpringMVC.services;

import com.example.SpringMVC.dto.ProfesorDTO;
import com.example.SpringMVC.entities.Profesor;
import com.example.SpringMVC.exception.ApiRequestException;
import com.example.SpringMVC.mapper.ProfesorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringMVC.repositories.ProfesorRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProfesorService {
    @Autowired
    ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<ProfesorDTO> getProfesores(){
        List<Profesor> profesores = (List<Profesor>) profesorRepository.findAll();
        List<ProfesorDTO> profesoresDTO = new ArrayList<>();
        for (Profesor profesor:profesores) {
            profesoresDTO.add(ProfesorMapper.toDTO(profesor));
        }
        return profesoresDTO;
    }

    public ProfesorDTO getProfesorById(Long id){
       return ProfesorMapper.toDTO(profesorRepository.findById(id).orElseThrow());
    }

    public void deleteProfesor (Long id){
        profesorRepository.deleteById(id);
    }

    public Profesor addNewProfesor(Profesor profesor) {
        Optional<Profesor> prof = profesorRepository.findProfesorByApellido(profesor.getApellido());
        if(prof.isPresent()) {
            throw new ApiRequestException("El apellido del profesor ya existe");
        }
        return profesorRepository.save(profesor);
    }
    @Transactional
    public void updateProfesor(Long id, String nombre, String apellido){
        Profesor prof = profesorRepository.findById(id).
                orElseThrow(() -> new IllegalStateException("No existe el profesor con el id " + id));
        if (nombre != null && nombre.length() > 0 && !Objects.equals(prof.getNombre(), nombre)) {
            System.out.println(!Objects.equals(prof.getNombre(), nombre));

            prof.setNombre(nombre);
        }
        if (apellido != null && apellido.length() > 0 && !Objects.equals(prof.getApellido(), apellido)){
            Optional<Profesor> prof2 = profesorRepository.findProfesorByApellido(apellido);
            if(prof2.isPresent()){
                throw new IllegalStateException("El apellido ya existe");
            }
            prof.setApellido(apellido);
        }
    }
}
