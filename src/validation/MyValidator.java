package validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidator implements
ConstraintValidator<FirstCharacterBig, String>{
	
	private FirstCharacterBig annotation;

	@Override
	public void initialize(FirstCharacterBig constraintAnnotation) {
		annotation = constraintAnnotation;
		
	}

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		boolean check = true;
		if (annotation.firstcharacterbig()) {
			if (Character.isLowerCase(value.charAt(0)))
				check = false;
		}
		return check;
	}
	
	public boolean isValid(String value) {
		boolean check = true;
			if (Character.isLowerCase(value.charAt(0))) check = false;
		return check;
	}

}
