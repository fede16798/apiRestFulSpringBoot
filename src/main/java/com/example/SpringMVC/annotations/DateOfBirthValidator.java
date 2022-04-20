package com.example.SpringMVC.annotations;

import com.example.SpringMVC.entities.Profesor;
import com.example.SpringMVC.exception.ApiRequestException;

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
        if(!(p.getYears() > 17)) {
          throw new ApiRequestException("The professor must be older than 18 years old");
        }
        return true;
    }

}
