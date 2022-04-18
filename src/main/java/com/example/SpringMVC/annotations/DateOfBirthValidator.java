package com.example.SpringMVC.annotations;

import com.example.SpringMVC.entities.Profesor;
import org.apache.tomcat.jni.Local;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.Period;

public class DateOfBirthValidator implements ConstraintValidator<DateOfBirthValidation, Profesor> {
    @Override
    public void initialize(DateOfBirthValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Profesor profesor, ConstraintValidatorContext constraintValidatorContext) {
        Period p = Period.between(profesor.getFechaDeNacimiento(), LocalDate.now());
        return p.getYears() > 17;
    }

}
