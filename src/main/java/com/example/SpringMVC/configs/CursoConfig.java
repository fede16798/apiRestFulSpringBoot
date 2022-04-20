package com.example.SpringMVC.configs;

import com.example.SpringMVC.entities.Curso;
import com.example.SpringMVC.entities.Estudiante;
import com.example.SpringMVC.entities.Inscripcion;
import com.example.SpringMVC.entities.Profesor;
import com.example.SpringMVC.repositories.CursoRepository;
import com.example.SpringMVC.repositories.EstudianteRepository;
import com.example.SpringMVC.repositories.InscripcionRepository;
import com.example.SpringMVC.repositories.ProfesorRepository;
import com.example.SpringMVC.services.CursoService;
import com.example.SpringMVC.services.EstudianteService;
import com.example.SpringMVC.services.InscripcionService;
import com.example.SpringMVC.services.ProfesorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Configuration
public class CursoConfig {

    @Bean
    CommandLineRunner commandLineRunner(InscripcionService inscripcionService, EstudianteService estudianteService, InscripcionRepository inscripcionR, EstudianteRepository estudianteR, CursoRepository cursoR, ProfesorRepository professorR, ProfesorService profesorService, CursoService cursoService) {
        return args -> {
/*
            Profesor p1 = new Profesor("Marcelo", "Gallardo", LocalDate.of(1976, 1, 18), 180000.0);
            Profesor p2 = new Profesor("Matias", "Biscay", LocalDate.of(1974, 3, 5), 130000.0);
            Profesor p3 = new Profesor("Hernan", "Bujan", LocalDate.of(1974, 12, 5), 130000.0);
            professorR.saveAll(List.of(p1,p2,p3));

            Curso c1 = new Curso("Defensa", "Defensa posisional", 20, "Noche");
            Curso c2 = new Curso("Ataque", "Jugadas de ataque avanzadas", 15, "Mañana");
            Curso c3 = new Curso("Posesion", "Posesion bajo presion", 15, "Mañana");
            Curso c4 = new Curso("Contraataque", "Jugadas varias de contraataque", 15, "Tarde");
            Curso c5 = new Curso("Penales", "Penales", 15, "Tarde");
            Curso c6 = new Curso("Pelota parada", "Pelota paradas variadas", 15, "Mañana");
            Curso c7 = new Curso("Gimanasio", "Trabajos de fuerza", 15, "Tarde");
            Curso c8 = new Curso("Pasadas", "Pasadas de 100m", 10, "Mañnaa");


            c1.setProfesor(p1);
            c2.setProfesor(p1);
            c3.setProfesor(p1);
            c4.setProfesor(p2);
            c5.setProfesor(p2);
            c6.setProfesor(p3);
            c7.setProfesor(p3);
            cursoR.saveAll(List.of(c1,c2,c3,c4,c5,c6,c7,c8));

            p1.setCursos(List.of(c1,c2,c3));
            p2.setCursos(List.of(c4,c5));
            p3.setCursos(List.of(c6,c7));

            Estudiante e1 = new Estudiante("Franco", "Armani", LocalDate.of(1986, 10,16), "Arquero");
            Estudiante e2 = new Estudiante("Paulo", "Diaz", LocalDate.of(1994, 8,25), "Defensor");
            Estudiante e3 = new Estudiante("Enzo", "Fernandez", LocalDate.of(2002, 1,17), "Mediocampista");
            Estudiante e4 = new Estudiante("Julian", "Alvarez", LocalDate.of(2000, 1,31), "Delantero");
            Estudiante e5 = new Estudiante("Juan Fernando", "Quintero", LocalDate.of(1993, 1,18), "Mediocampista");
            Estudiante e6 = new Estudiante("Milton", "Casco", LocalDate.of(1988, 4,11), "Defensor");
            Estudiante e7 = new Estudiante("Bruno", "Zuculini", LocalDate.of(1993, 4,2), "Mediocampista");
            Estudiante e8 = new Estudiante("Matias", "Suarez", LocalDate.of(1988, 5,9), "Delantero");
            Estudiante e9 = new Estudiante("Nicolas", "De La Cruz", LocalDate.of(1997, 6,1), "Mediocampista");
            Estudiante e10 = new Estudiante("Braian", "Romero", LocalDate.of(1991, 6,15), "Delantero");

            estudianteR.saveAll(List.of(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10));

            Inscripcion i1 = new Inscripcion(c5,e1,LocalDate.of(2018,1,8));
            Inscripcion i2 = new Inscripcion(c6,e2,LocalDate.of(2020,7,10));
            Inscripcion i3 = new Inscripcion(c3,e3,LocalDate.of(2021,7,8));
            Inscripcion i4 = new Inscripcion(c2,e4,LocalDate.of(2017,1,17));
            Inscripcion i5 = new Inscripcion(c6,e5,LocalDate.of(2017,1,4));
            Inscripcion i6 = new Inscripcion(c3,e7,LocalDate.of(2020,6,12));
            Inscripcion i7 = new Inscripcion(c5,e8,LocalDate.of(2019,7,9));
            Inscripcion i8 = new Inscripcion(c2,e1,LocalDate.of(2021,7,8));
            Inscripcion i9 = new Inscripcion(c2,e3,LocalDate.of(2021,7,8));
            Inscripcion i10 = new Inscripcion(c1,e2,LocalDate.of(2021,7,8));
            Inscripcion i11 = new Inscripcion(c2,e9,LocalDate.of(2021,7,8));
            Inscripcion i12 = new Inscripcion(c4,e9,LocalDate.of(2021,7,8));
            Inscripcion i13 = new Inscripcion(c4,e1,LocalDate.of(2021,7,8));
            Inscripcion i14 = new Inscripcion(c5,e2,LocalDate.of(2021,7,8));
            Inscripcion i15 = new Inscripcion(c5,e5,LocalDate.of(2021,7,8));
            Inscripcion i16 = new Inscripcion(c6,e4,LocalDate.of(2021,7,8));
            Inscripcion i17 = new Inscripcion(c3,e4,LocalDate.of(2021,7,8));
            Inscripcion i18 = new Inscripcion(c1,e7,LocalDate.of(2021,7,8));
            Inscripcion i19 = new Inscripcion(c4,e2,LocalDate.of(2021,7,8));

            inscripcionR.saveAll(List.of(i1,i2,i3,i4,i5,i6,i7,i8,i9,i10,i11,i12,i13,i14,i15,i16,i17,i18,i19));


            System.out.println("Busqueda de profesores: -------------------------------------------------------------------------------");
            System.out.println(profesorService.getProfesores());

            System.out.println("Busqueda de cursos: -----------------------------------------------------------------------------------");
            System.out.println(cursoService.getCursos());

            System.out.println("Busqueda de Estudiantes: ------------------------------------------------------------------------------");
            System.out.println(estudianteService.getEstudiantes());

            System.out.println("Busqueda de Inscripciones: ----------------------------------------------------------------------------");
            System.out.println(inscripcionService.getInscripciones());

            cursoService.modificarTurno(8L, "Mañana");
            System.out.println(estudianteR.findByApellido("Armani"));
            System.out.println(cursoR.findByTurno("Mañana"));
            System.out.println(estudianteR.findAllByOrderByApellidoAsc());

            System.out.println("Busqueda de profesores: -------------------------------------------------------------------------------");
            System.out.println(profesorService.getProfesores());

            Optional<Estudiante> estudiante = estudianteR.findById(1L);
            List<Inscripcion> insc = estudiante.get().getEstudianteInscripciones();
            System.out.println(insc.size());
            inscripcionService.deleteInscripcion(8L);
            Optional<Estudiante> estudiante2 = estudianteR.findById(1L);
            List<Inscripcion> insc2 = estudiante2.get().getEstudianteInscripciones();
            System.out.println(insc2.size());

*/
        };
    }
}