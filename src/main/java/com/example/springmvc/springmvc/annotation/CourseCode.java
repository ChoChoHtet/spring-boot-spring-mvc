package com.example.springmvc.springmvc.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {
    // define default code
    public String value() default "PROMO";

    //define default error message
    public String message() default "must start with PROMO";

    //define default groups
    public Class<?>[] groups() default {}; // can group related constraints

    //define default payloads
    //provide custom details about validation failure ( severity level , error code ,etc)
    public Class<? extends Payload>[] payload() default {};
}
