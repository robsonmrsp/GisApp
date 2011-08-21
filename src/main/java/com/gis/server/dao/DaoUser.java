package com.gis.server.dao;

import javax.inject.Named;

import com.gis.server.entities.User;

@Named("daoUser")
public class DaoUser extends Dao<User>{

	public DaoUser() {
		super(User.class);
	}
}
