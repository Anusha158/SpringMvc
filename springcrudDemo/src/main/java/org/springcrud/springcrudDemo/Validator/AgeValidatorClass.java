package org.springcrud.springcrudDemo.Validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidatorClass implements ConstraintValidator<AgeValidator,Integer>{
	private int lower;//30
	private int upper;//75
	public void intialize(AgeValidator age) {
		this.lower=age.lower();
		this.upper=age.upper();
	}
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		if(age==null) {
			return false;
		}
		
		if(age<lower||age>upper) {
		return false;
	}
		return true;
	}

	

}
