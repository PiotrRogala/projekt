package Main;

import java.util.Set;

import javax.validation.ConstraintViolation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.zaliczenie.service.CarService;
import com.zaliczenie.service.ManufacturerService;

import domain.Car;
import domain.Manufacturer;

public class Main {

	public static void main(String[] args) throws Exception {

		ApplicationContext kontekst = new ClassPathXmlApplicationContext(
				"config.xml");
		Manufacturer m = new Manufacturer("Renault");
		ManufacturerService manufacturerService = (ManufacturerService) kontekst
				.getBean("5");

		Set<ConstraintViolation<Manufacturer>> bledy = manufacturerService
				.save(m);
		System.out.println(bledy);
		for (ConstraintViolation<Manufacturer> blad : bledy) {
			System.out.println("blad: " + blad.getMessage() + "\tnazwa pola: "
					+ blad.getPropertyPath());
		}

		Car c = new Car(m, "Clio");
		Car c2 = new Car(m, "Megane");
		CarService carService = (CarService) kontekst.getBean("4");
		Set<ConstraintViolation<Car>> bledy2 = carService.save(c);
		for (ConstraintViolation<Car> blad : bledy2) {
			System.out.println("blad: " + blad.getMessage() + "\tnazwa pola: "
					+ blad.getPropertyPath());
		}
		Set<ConstraintViolation<Car>> bledy3 = carService.save(c2);
		for (ConstraintViolation<Car> blad : bledy3) {
			System.out.println("blad: " + blad.getMessage() + "\tnazwa pola: "
					+ blad.getPropertyPath());
		}
	}

}
