package com.gis.server.dao;

import java.io.Serializable;

import javax.inject.Inject;

import org.hibernate.SessionFactory;

public abstract class Dao<A> {

	Class<A> clazz;
	
	public Dao(Class<A> clazz) {
		this.clazz = clazz;
	}

	@Inject
	SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public A find(Serializable key){
		return (A)sessionFactory.getCurrentSession().get(clazz, key);
	}
	public void save(A a){
		sessionFactory.getCurrentSession().saveOrUpdate(a);
	}	
	public void delete(A a){
		sessionFactory.getCurrentSession().saveOrUpdate(a);
	}
}
