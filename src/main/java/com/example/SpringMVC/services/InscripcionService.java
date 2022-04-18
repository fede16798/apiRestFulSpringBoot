package com.example.SpringMVC.services;

import com.example.SpringMVC.entities.Curso;
import com.example.SpringMVC.entities.Estudiante;
import com.example.SpringMVC.entities.Inscripcion;
import com.example.SpringMVC.repositories.CursoRepository;
import com.example.SpringMVC.repositories.EstudianteRepository;
import com.example.SpringMVC.repositories.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class InscripcionService {
    @Autowired
    private final InscripcionRepository inscripcionRepository;

    @Autowired
    private final EstudianteRepository estudianteRepository;

    @Autowired
    private final CursoRepository cursoRepository;

    public InscripcionService(InscripcionRepository inscripcionRepository, EstudianteRepository estudianteRepository, CursoRepository cursoRepository) {
        this.inscripcionRepository = inscripcionRepository;
        this.estudianteRepository = estudianteRepository;
        this.cursoRepository = cursoRepository;
    }

    public List<Inscripcion> getInscripciones(){
        return (List<Inscripcion>) inscripcionRepository.findAll();
    }

    public Inscripcion getInscripcionesById(Long id) {
        return inscripcionRepository.findById(id).orElseThrow(() -> new IllegalStateException("no existe la inscripcion con el id " + id));
    }

    public void deleteInscripcion(Long id){
        boolean existe = inscripcionRepository.existsById(id);
        if(!existe) { throw new IllegalStateException("no existe la inscripcion con el id " + id);}
        inscripcionRepository.deleteById(id);
    }

    public Inscripcion addInscripcion(Long idEstudiante, Long idCurso) {

        Estudiante est = estudianteRepository.findById(idEstudiante).orElseThrow(()-> new IllegalStateException("No existe el estudiante con el id " + idEstudiante));
        Curso curso  = cursoRepository.findById(idCurso).orElseThrow(()-> new IllegalStateException("No existe el curso con el id " + idCurso));

        return inscripcionRepository.save(new Inscripcion(curso, est,  java.time.LocalDate.now()));
    }

    @Transactional
    public Inscripcion updateInscripcion(Long id, Long idCurso, Long idEstudiante){
        Inscripcion ins = inscripcionRepository.findById(id).orElseThrow(() -> new IllegalStateException("no existe la inscripcion con el id " + id));

        if(idCurso != null && idCurso > 0) {
            Curso curso = cursoRepository.findById(idCurso).orElseThrow(() -> new IllegalStateException("no existe el curso con el id " + idCurso));
            ins.setCurso(curso);
        }
        if(idEstudiante != null && idEstudiante > 0) {
            Estudiante est = estudianteRepository.findById(idEstudiante).orElseThrow(() -> new IllegalStateException("no existe el curso con el id " + idEstudiante));
            ins.setEstudiante(est);
        }
        return ins;
    }

}
