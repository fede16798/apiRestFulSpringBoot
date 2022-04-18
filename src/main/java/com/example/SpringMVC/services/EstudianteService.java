package com.example.SpringMVC.services;

import com.example.SpringMVC.entities.Curso;
import com.example.SpringMVC.entities.Estudiante;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringMVC.repositories.EstudianteRepository;
import org.springframework.web.bind.annotation.PathVariable;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<Estudiante> getEstudiantes(){
        return (List<Estudiante>) estudianteRepository.findAll();
    }

    public Estudiante getEstudianteById(Long id) {
        return estudianteRepository.findById(id).orElseThrow(() -> new IllegalStateException("no existe el estudiante con el id " + id));
    }

    public Optional<Estudiante> addNewEstudiante(Estudiante estudiante) {
        Optional<Estudiante> estudianteOpcional = estudianteRepository.findByApellido(estudiante.getApellido());
        if (estudianteOpcional.isPresent()) {
            throw new IllegalStateException("El estudiante con el apellido " + estudiante.getApellido() + " ya existe");
        }
        estudianteRepository.save(estudiante);
        return estudianteRepository.findByApellido(estudiante.getApellido());
    }

    public void deleteEstudiante(Long id) {
        boolean existe = estudianteRepository.existsById(id);
        if(!existe) { throw new IllegalStateException("El estudiante con id " + id + " no existe");}
        estudianteRepository.deleteById(id);
    }

    @Transactional
    public void updateEstudiante(Long id, String nombre, String dob) {
        Estudiante est = estudianteRepository.findById(id).orElseThrow(() -> new IllegalStateException("El estudiante no existe"));
        if(nombre != null && nombre.length() > 0){
            est.setNombre(nombre);
        }
        if(dob != null) {
            LocalDate newDob= LocalDate.parse(dob);
            if(!newDob.isEqual(est.getFechaDeNacimiento())) {
                System.out.println(newDob.isEqual(est.getFechaDeNacimiento()));
                est.setFechaDeNacimiento(newDob);
            } else {
                System.out.println("las fechas son iguales");
            }
        }
    }
}
