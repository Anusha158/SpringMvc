package org.springcrud.springcrudDemo.Validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy=AgeValidatorClass.class)
public @interface AgeValidator {
	
	String message() default "should be between 18-60";

	int lower() default 18;

	int upper() default 60;

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}