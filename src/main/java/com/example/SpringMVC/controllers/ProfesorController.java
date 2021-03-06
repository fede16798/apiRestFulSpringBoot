package com.example.SpringMVC.controllers;

import com.example.SpringMVC.dto.ProfesorDTO;
import com.example.SpringMVC.entities.Profesor;
import com.example.SpringMVC.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "api/profesores")
public class ProfesorController {
    @Autowired
    private ProfesorService profesorService;

    public ProfesorController (ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public List<ProfesorDTO> getProfesores() {
        return profesorService.getProfesores();
     }

    @GetMapping (path = "{id}")
    public ProfesorDTO getProfesorById(@PathVariable Long id) {
        return profesorService.getProfesorById(id);
    }

    @PostMapping
    public Profesor addNewProfesor(@RequestBody Profesor profesor) {
       return profesorService.addNewProfesor(profesor);
    }

    @DeleteMapping(path = "{id}")
    public void deleteProfesor(@PathVariable Long id){
        profesorService.deleteProfesor(id);
    }

    @PutMapping(path = "{id}")
    public void updateProfesor(@PathVariable("id") Long id, @RequestParam(required = false) String nombre,
                               @RequestParam(required = false) String apellido){
        profesorService.updateProfesor(id, nombre, apellido);
    }

}
