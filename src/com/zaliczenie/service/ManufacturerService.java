package com.zaliczenie.service;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import com.zaliczenie.dao.ManufacturerDAO;

import domain.Manufacturer;
import events.SaveEvent;

public class ManufacturerService {
	
	@Autowired
	private ManufacturerDAO manufacturerDAO;
	@Autowired
	private Validator validator;
	@Autowired
	private ApplicationEventPublisher applicationEventPublisher;

	public Set<ConstraintViolation<Manufacturer>> save(Manufacturer m) throws Exception {
		manufacturerDAO.save(m);
		SaveEvent saveEvent = new SaveEvent(this);
		saveEvent.setObject(m);
		applicationEventPublisher.publishEvent(saveEvent);
		return null;
	}

	public Manufacturer load(int id) throws Exception {
		return manufacturerDAO.load(id);
	}

	public ManufacturerDAO getManufacturerDAO() {
		return manufacturerDAO;
	}

	public void setManufacturerDAO(ManufacturerDAO manufacturerDAO) {
		this.manufacturerDAO = manufacturerDAO;
	}

	public Set<ConstraintViolation<Manufacturer>> validate(Manufacturer m) {
		Set<ConstraintViolation<Manufacturer>> bledy = validator.validate(m);
		return bledy;
	}
}
