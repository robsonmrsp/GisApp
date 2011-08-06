package com.gis.server;

import com.vividsolutions.jts.algorithm.distance.DiscreteHausdorffDistance;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;
import com.vividsolutions.jts.operation.distance.DistanceOp;

public class Main {

	private static final double RAIO_MEDIO = 6371000d;
	public static void main(String[] args) {
		GeometryFactory geoFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);

		Geometry geo = geoFactory.createPoint(new Coordinate(-3.738152, -38.499058));
		Geometry geo2 = geoFactory.createPoint(new Coordinate(-3.737895, -38.499943));
		
		DistanceOp distance = new DistanceOp(geo, geo2);
		System.out.println(DiscreteHausdorffDistance.distance(geo, geo2));
		
		System.out.println(distance.distance());
		System.out.println(distance.distance() * Math.PI * RAIO_MEDIO / 180);
		
		Coordinate c1 = new Coordinate(-3.738152, -38.499058);
		Coordinate c2 = new Coordinate(-3.737895, -38.499943);
		
		System.out.println(c2.distance(c1));
		
	}
}
