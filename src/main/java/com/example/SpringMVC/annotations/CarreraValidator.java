package com.example.SpringMVC.annotations;

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
        return list.contains(s.toLowerCase());
    }
}
