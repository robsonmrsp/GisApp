package com.gis.server;

import java.util.Date;

import org.apache.log4j.Logger;

import javax.inject.Inject;
import javax.inject.Named;

import com.gis.client.GreetingService;
import com.gis.server.dao.DaoGeometricShape;
import com.gis.server.dao.DaoUser;
import com.gis.server.dao.GeometricShapeType;
import com.gis.server.entities.Endereco;
import com.gis.server.entities.GeometricShape;
import com.gis.server.entities.User;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.PrecisionModel;

/**
 * A intenção inicial é que qualquer classe possa atender a uma requisição GWT, mas para o 
 * caso daqueles que querem acessar os objetos de uma aplicação servlet, HttpServletRequest, 
 * ServletConfig, ServletContext e mais algum, deve herdar a classe HttpServletObject caso não queira, 
 * simplesmente    public class GreetingServiceImpl  implements  GreetingService funcionará
 */
@Named("greetingService")
public class GreetingServiceImpl extends HttpServletObject implements  GreetingService{

	@Inject
	DaoGeometricShape daoGeometricShape;
	@Inject
	DaoUser daoUser;
	
	Logger  logger = Logger.getLogger(GreetingServiceImpl.class);

//	Logger logger = Logger
//	@Transactional
	public String greetServer(String input) throws IllegalArgumentException {
		try{
			logger.info("passou por aki");
		GeometricShape geometricShape = new GeometricShape();
		geometricShape.setName("Quadrado_1");
		
		geometricShape.setCreationDate(new Date());
		geometricShape.setVertices(getGeometric());
		geometricShape.setType(GeometricShapeType.SQUARE);
		
		daoGeometricShape.save(geometricShape);
		}catch (Exception e) {
			e.printStackTrace();
			return "Erro ao criar/salvar objeto!";
		}
		User us = daoUser.find(1);
		for(Endereco e : us.getEnderecos()){
			System.out.println(e.getLogradouro());
		}

		//As linhas abaixo funcionaram pois herdamos da classe HttpServletObject
		String serverInfo = getServletContext().getServerInfo();
		String userAgent  = getServletRequest().getHeader("User-Agent");

		input = escapeHtml(input);
		userAgent = escapeHtml(userAgent);
		return "Objeto criado/salvo com sucesso!" + serverInfo + " " + userAgent;
	}

	private Geometry getGeometric() {
		GeometryFactory geoFactory = new GeometryFactory(new PrecisionModel(PrecisionModel.FLOATING), 4326);
		Coordinate[]  coordinates = new Coordinate[]{new Coordinate(0,0), new Coordinate(1,1), new Coordinate(2,2), new Coordinate(-1,-1)};
		Geometry geo = geoFactory.createLineString(coordinates);
		return geo;
	}

	/**
	 * Escape an html string. Escaping data received from the client helps to
	 * prevent cross-site script vulnerabilities.
	 * 
	 * @param html the html string to escape
	 * @return the escaped string
	 */
	private String escapeHtml(String html) {
		if (html == null) {
			return null;
		}
		return html.replaceAll("&", "&amp;").replaceAll("<", "&lt;").replaceAll(
				">", "&gt;");
	}
	
}
