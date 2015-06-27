package com.zaliczenie.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.zaliczenie.dao.CarDAO;

import domain.Car;
import events.SaveEvent;

public class CarService {
	@Autowired
	private CarDAO carDAO;
	@Autowired
	private Validator validator;
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;
	
	public Set<ConstraintViolation<Car>> save(Car c) throws Exception {
			carDAO.save(c);
			SaveEvent saveEvent = new SaveEvent(this);
			saveEvent.setObject(c);
			applicationEventPublisher.publishEvent(saveEvent);
		return null;
	}
	
	public Car load(int id) throws Exception {
		return carDAO.load(id);
	}

	public CarDAO getCarDAO() {
		return carDAO;
	}

	public void setCarDAO(CarDAO carDAO) {
		this.carDAO = carDAO;
	}
	
	
	
	public Validator getValidator() {
		return validator;
	}

	public void setValidator(Validator validator) {
		this.validator = validator;
	}

	public Set<ConstraintViolation<Car>> validate(Car c) {
		Set<ConstraintViolation<Car>> bledy = validator.validate(c);
		return bledy;
	}
}
