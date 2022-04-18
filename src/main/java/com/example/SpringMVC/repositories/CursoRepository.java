package com.example.SpringMVC.repositories;

import com.example.SpringMVC.entities.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface CursoRepository extends CrudRepository<Curso,Long> {

    List<Curso> findByTurno(String turno);


}

