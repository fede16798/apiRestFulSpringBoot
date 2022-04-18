package com.example.SpringMVC.controllers;

import com.example.SpringMVC.entities.Estudiante;
import com.example.SpringMVC.entities.Inscripcion;
import com.example.SpringMVC.services.EstudianteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/estudiantes")
public class EstudianteController {
    @Autowired
    private EstudianteService  estudianteService;

    public EstudianteController(EstudianteService estudianteService) {
        this.estudianteService = estudianteService;
    }

    @GetMapping
    public List<Estudiante> getEstudiantes() {
        return estudianteService.getEstudiantes();
    }

    @GetMapping(path = "{id}")
    public Estudiante getEstudianteById(@PathVariable Long id){
        return estudianteService.getEstudianteById(id);
    }
    @PostMapping
    public Optional<Estudiante> addEstudiante(@Valid @RequestBody Estudiante estudiante){
        return estudianteService.addNewEstudiante(estudiante);
    }

    @DeleteMapping(path = "{id}")
    public void deleteEstudiante (@PathVariable Long id){
        estudianteService.deleteEstudiante(id);
    }

    @PutMapping(path = "{id}")
    public void updateEstudiante(@PathVariable Long id, @RequestParam(required = false) String nombre , @RequestParam(required = false) String dob) {
        estudianteService.updateEstudiante(id, nombre, dob);
    }
}
