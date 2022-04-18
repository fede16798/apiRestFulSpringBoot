package com.example.SpringMVC.controllers;

import com.example.SpringMVC.entities.Inscripcion;
import com.example.SpringMVC.services.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping(path = "api/inscripciones")
public class InscripcionController {
    @Autowired
    private InscripcionService inscripcionService;

    public InscripcionController (InscripcionService inscripcionService) {
        this.inscripcionService = inscripcionService;
    }

    @GetMapping
    public List<Inscripcion> getInscripciones(){
        return inscripcionService.getInscripciones();
    }

    @GetMapping(path = "{id}")
    public Inscripcion getInscripcionesById(@PathVariable Long id){
        return inscripcionService.getInscripcionesById(id);
    }

    @DeleteMapping (path = "{id}")
    public void deleteInscripcion(@PathVariable Long id){
        inscripcionService.deleteInscripcion(id);
    }

    @PostMapping
    public Inscripcion addInscripcion(@RequestParam(required = true) Long idEst, @RequestParam Long idCurso){
        return inscripcionService.addInscripcion(idEst, idCurso);
    }

    @PutMapping(path = "{id}")
    public Inscripcion updateInscripcion (@PathVariable Long id, @RequestParam (required = false) Long idCurso, @RequestParam(required = false) Long idEstudiante){
        return inscripcionService.updateInscripcion(id,idCurso, idEstudiante);
    }
}

