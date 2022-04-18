package com.example.SpringMVC.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DateOfBirthValidator.class)
public @interface DateOfBirthValidation {
    //mensaje de error
    public String message() default "Invalid date of birth, the age must be older than 18";
    //represents group of constraints
    public Class<?>[] groups() default {};
    //represents additional information about annotation
    public Class<? extends Payload>[] payload() default {};

}
