package test;

import static org.junit.Assert.*;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.validation.executable.ExecutableValidator;
import javax.validation.metadata.BeanDescriptor;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import domain.Car;

public class TestValidatora {
	
	@Autowired
	private Validator validator;

	@Test
	public void testIsValidBig() {
		Car c = new Car(null, "Renault");
		Set<ConstraintViolation<Object>> bledy = validator.validate(c);
		assertTrue(bledy.isEmpty());
	}
	
	@Test
	public void testIsValidSmall() {
		Car c = new Car(null, "renault");
		Set<ConstraintViolation<Object>> bledy = validator.validate(c);
		assertTrue(bledy.isEmpty());
	}

}
