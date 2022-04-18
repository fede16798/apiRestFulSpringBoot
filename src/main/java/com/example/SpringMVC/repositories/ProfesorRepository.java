package com.example.SpringMVC.repositories;

import com.example.SpringMVC.entities.Profesor;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface ProfesorRepository extends CrudRepository<Profesor, Long> {

    Optional<Profesor> findProfesorByApellido(String apellido);
}
