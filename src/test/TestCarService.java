package test;

import static org.junit.Assert.*;

import java.awt.font.TextLayout.CaretPolicy;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.junit.Test;

import com.zaliczenie.service.CarService;

import domain.Car;
import domain.Manufacturer;

public class TestCarService {

	@Test
	public void testGetCarDAO() {
		CarService carService = new CarService();
		assertTrue(carService.getCarDAO() == null) ;
	}
	
	@Test
	public void testGetValidator() {
		CarService carService2 = new CarService();
		assertTrue(carService2.getValidator() == null) ;
	}
	
	@Test
	public void testSave() throws Exception{
		CarService carService3 = new CarService();
		Manufacturer m = new Manufacturer("Renault");
		Car c = new Car(m, "Clio");
		Set<ConstraintViolation<Car>> bledy = carService3.save(c);
		assertTrue(bledy.isEmpty());
	}

}
