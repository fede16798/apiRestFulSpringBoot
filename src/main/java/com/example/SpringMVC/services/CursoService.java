package com.example.SpringMVC.services;

import com.example.SpringMVC.dto.CursoDTO;
import com.example.SpringMVC.entities.Curso;
import com.example.SpringMVC.mapper.CursoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringMVC.repositories.CursoRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    public List<CursoDTO> getCursos(){
        List<CursoDTO> cursosDTO = new ArrayList<>();
        List<Curso> cursos = (List<Curso>) cursoRepository.findAll();

        for (Curso curso:cursos) {
            cursosDTO.add(CursoMapper.toDTO(curso));
        }

        return cursosDTO;
    }

    public void modificarTurno(Long id, String turno) {
        Curso c = cursoRepository.findById(id).get();
        c.setTurno(turno);
        cursoRepository.save(c);
    }

    public CursoDTO getCursoById(Long id) {
        Curso curso = cursoRepository.findById(id).orElseThrow();
        return CursoMapper.toDTO(curso);
    }

    public void deleteCurso (Long id){
        cursoRepository.deleteById(id);
    }

    public Curso addCurso(Curso curso) {
        return cursoRepository.save(curso);
    }

    @Transactional
    public Optional<Curso> updateCurso(Long id, String nombre, Integer cupo) {
        Curso curso = cursoRepository.findById(id).orElseThrow(()-> new IllegalStateException("No existe el curso con el id " + id));
        if(cursoRepository.count() < cupo && cupo != null) {
            curso.setCupo(cupo);
        } else {
            throw new IllegalStateException("El cupo no puede ser menor a la cantidad de estudiantes inscriptos");
        }
        if(nombre.length()>0 && nombre != null) {
            curso.setNombre(nombre);
        }
        return cursoRepository.findById(id);
    }


}

