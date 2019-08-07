package com.cafe24.cat24frontend.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.cat24frontend.validator.constraints.ValidGender;

public class GenderValidator implements ConstraintValidator<ValidGender, String>
{
	private Pattern pattern = Pattern.compile("M|F|N"); 
	
	public void initialize(ValidGender constraintAnnotation) 
	{
	}

	public boolean isValid(String value, ConstraintValidatorContext context) {
		if(value == null || value.length() == 0 || "".contentEquals(value)) 
		{
			return false;
		}
		
		return pattern.matcher( value ).matches();
	}
	
}
