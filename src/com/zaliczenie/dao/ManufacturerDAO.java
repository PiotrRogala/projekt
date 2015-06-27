package com.zaliczenie.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.Manufacturer;

@Component
@Transactional
public class ManufacturerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Manufacturer m){
		sessionFactory.getCurrentSession().save(m);
	}
	
	public Manufacturer load(int id){
		Manufacturer m = (Manufacturer) sessionFactory.getCurrentSession().get(Manufacturer.class, id);
		return m;
	}
}
