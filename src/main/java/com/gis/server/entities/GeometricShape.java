package com.gis.server.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

import com.vividsolutions.jts.geom.Geometry;

@Entity
@Table(name="tb_geometric_shape")
public class GeometricShape {

	@Id
	@GeneratedValue(generator="geometricshape_seq_id")
	@SequenceGenerator(name="geometricshape_seq_id", sequenceName="geometricshape_seq_id")
	public Integer id;
	
	@Column(name="name")
	public String  name;
	
	@Column(name="creation_date")
	@Temporal(TemporalType.TIMESTAMP)
	public Date  creationDate;
	
	@Column(name="type")
	@Enumerated(EnumType.STRING)
	public GeometricShapeType type;

	@Column(name = "vertex")
	@Type(type = "org.hibernatespatial.GeometryUserType")
	public Geometry vertices;
	
	public GeometricShape() {}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public GeometricShapeType getType() {
		return type;
	}

	public void setType(GeometricShapeType type) {
		this.type = type;
	}

	public Geometry getVertices() {
		return vertices;
	}

	public void setVertices(Geometry vertices) {
		this.vertices = vertices;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeometricShape other = (GeometricShape) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
