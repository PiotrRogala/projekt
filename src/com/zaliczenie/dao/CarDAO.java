package com.zaliczenie.dao;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import domain.Car;

@Component
@Transactional
public class CarDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void save(Car c){
		sessionFactory.getCurrentSession().save(c);
	}
	
	public Car load(int id){
		Car c = (Car) sessionFactory.getCurrentSession().get(Car.class, id);
		return c;
	}

}
