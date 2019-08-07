package com.cafe24.cat24frontend.validator;

import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.cafe24.cat24frontend.validator.constraints.ValidYN;


public class YNValidator  implements ConstraintValidator<ValidYN, String>
{
	private Pattern pattern = Pattern.compile("Y|N"); 
	
	public void initialize(ValidYN constraintAnnotation) 
	{
	}

	public boolean isValid(String value, ConstraintValidatorContext context) 
	{
		if(value == null || value.length() == 0 || "".contentEquals(value)) 
		{
			return false;
		}
		
		return pattern.matcher( value ).matches();
	}
}
