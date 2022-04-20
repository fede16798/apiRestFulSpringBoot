package com.example.SpringMVC.controllers;

import com.example.SpringMVC.dto.CursoDTO;
import com.example.SpringMVC.entities.Curso;
import com.example.SpringMVC.services.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    public CursoController (CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public List<CursoDTO> getCursos() {
        return cursoService.getCursos();
    }

    @GetMapping(path = "{id}")
    public CursoDTO getCursoById(@PathVariable Long id){
        return cursoService.getCursoById(id);
    }

    @PostMapping
    public Curso addCurso (@RequestBody Curso curso) {
        return cursoService.addCurso(curso);
    }

    @PutMapping(path = "{id}")
    public Optional<Curso> upadteCurso(@PathVariable Long id, @RequestParam(required = false) String nombre, @RequestParam(required = false) Integer cupo){
        return cursoService.updateCurso(id, nombre, cupo);
    }

    @DeleteMapping(path = "{id}")
    public void deleteCurso(@PathVariable Long id){
        cursoService.deleteCurso(id);
    }
}
