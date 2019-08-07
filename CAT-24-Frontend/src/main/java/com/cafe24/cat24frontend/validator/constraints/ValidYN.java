package com.cafe24.cat24frontend.validator.constraints;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.cafe24.cat24frontend.validator.YNValidator;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy=YNValidator.class)
public @interface ValidYN 
{
	String message() default "Invalid YN";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
}
