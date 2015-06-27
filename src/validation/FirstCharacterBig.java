package validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Constraint(validatedBy=MyValidator.class)
public @interface FirstCharacterBig {
	String message() default "Musi byc nazwa z duzej litery"; 
	  
    Class[] groups() default {};  
      
    Class[] payload() default {}; 
    
    boolean firstcharacterbig() default true;
}
