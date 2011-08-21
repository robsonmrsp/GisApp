package com.gis.server.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
//
@Entity
@Table(name="tb_user")
public class User {

	@Id
	@Column(name="user_id")
	private Integer id;

	@Column(name="name")
	private String name;

	@OneToMany(mappedBy="user")
	private List<Endereco> enderecos ;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public List<Endereco> getEnderecos() {
		return enderecos;
	}


	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
