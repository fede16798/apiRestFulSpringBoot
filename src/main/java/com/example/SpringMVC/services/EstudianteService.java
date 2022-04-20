package com.example.SpringMVC.services;

import com.example.SpringMVC.dto.EstudianteDTO;
import com.example.SpringMVC.entities.Estudiante;
import com.example.SpringMVC.mapper.EstudianteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.SpringMVC.repositories.EstudianteRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {

    @Autowired
    private final EstudianteRepository estudianteRepository;

    public EstudianteService(EstudianteRepository estudianteRepository) {
        this.estudianteRepository = estudianteRepository;
    }

    public List<EstudianteDTO> getEstudiantes(){
        List<Estudiante> estudiantes = (List<Estudiante>) estudianteRepository.findAll();
        List<EstudianteDTO> estudianteDTOS = new ArrayList<>();
        for (Estudiante est:estudiantes) {
            estudianteDTOS.add(EstudianteMapper.toDTO(est));
        }
        return estudianteDTOS;
    }

    public EstudianteDTO getEstudianteById(Long id) {
        Estudiante est = estudianteRepository.findById(id).orElseThrow();
        return EstudianteMapper.toDTO(est);
    }

    public void deleteEstudiante(Long id) {
        estudianteRepository.deleteById(id);
    }

    public Estudiante addNewEstudiante(Estudiante estudiante) {
        Optional<Estudiante> estudianteOpcional = estudianteRepository.findByApellido(estudiante.getApellido());
        if (estudianteOpcional.isPresent()) {
            throw new IllegalStateException("El estudiante con el apellido " + estudiante.getApellido() + " ya existe");
        }
        return estudianteRepository.save(estudiante);
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
