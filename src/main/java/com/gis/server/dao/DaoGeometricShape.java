package com.gis.server.dao;

import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.gis.server.entities.GeometricShape;

@Named("daoGeometricShape")
public class DaoGeometricShape extends Dao<GeometricShape>{

	public DaoGeometricShape() {
		super(GeometricShape.class);
	}	
}
