package test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.zaliczenie.aspects.ConfigureAspect;
import com.zaliczenie.service.CarService;

public class TestConfigureAspect {

	@Test
	public void testGetValidator() {
		ConfigureAspect configureAspect = new ConfigureAspect();
		assertTrue(configureAspect.getValidator() == null) ;
	}

}
