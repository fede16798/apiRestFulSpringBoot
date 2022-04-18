package com.example.SpringMVC.services;

import com.example.SpringMVC.entities.Profesor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringMVC.repositories.ProfesorRepository;

import javax.transaction.Transactional;
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

    public List<Profesor> getProfesores(){
        return (List<Profesor>) profesorRepository.findAll();
    }

    public Profesor getProfesorById(Long id){
        return profesorRepository.findById(id).orElseThrow(() -> new IllegalStateException("no existe el profesor con el id " + id));
    }

    public void addNewProfesor(Profesor profesor) {
        Optional<Profesor> prof = profesorRepository.findProfesorByApellido(profesor.getApellido());
        if(prof.isPresent()) {
            throw new IllegalStateException("El apellido ya existe");
        }
        profesorRepository.save(profesor);
    }

    public void deleteProfesor (Long id){
        boolean existe = profesorRepository.existsById(id);
        if(!existe) {
            throw new IllegalStateException("El profesor con el id " + id + " no existe");
        }
        profesorRepository.deleteById(id);
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
