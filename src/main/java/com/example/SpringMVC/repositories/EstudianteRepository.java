package com.example.SpringMVC.repositories;

import com.example.SpringMVC.entities.Estudiante;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface EstudianteRepository extends CrudRepository<Estudiante,Long> {

    Optional<Estudiante> findByApellido(String apellido);
    List<Estudiante> findAllByOrderByApellidoAsc();

}
