package com.cafe24.cat24.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.cat24.validator.constraints.ValidGender;

public class GenderValidator implements ConstraintValidator<ValidGender, String>
{
	private Pattern pattern = Pattern.compile("MALE|FEMALE|NONE"); 
	
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
