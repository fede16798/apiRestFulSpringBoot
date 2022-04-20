package com.example.SpringMVC.annotations;

import com.example.SpringMVC.exception.ApiRequestException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class CarreraValidator implements ConstraintValidator<CarreraValidation, String> {

    @Override
    public void initialize(CarreraValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List list = Arrays.asList(new String[]{"arquero", "defensor", "mediocampista", "delantero"});
        if(!list.contains(s.toLowerCase())){
            throw new ApiRequestException("The career must be: arquero, defensor, mediocampista or delantero");
        };
        return true;
    }
}
