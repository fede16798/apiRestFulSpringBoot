package com.example.SpringMVC;

import com.example.SpringMVC.entities.Profesor;
import com.example.SpringMVC.repositories.CursoRepository;
import com.example.SpringMVC.services.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.repository.CrudRepository;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMvcApplication.class, args);
	}


}
