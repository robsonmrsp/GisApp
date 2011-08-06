package com.gis.server;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.transaction.annotation.Transactional;

import com.gis.client.GreetingService;
import com.gis.server.dao.DaoGeometricShape;
import com.gis.server.dao.GeometricShapeType;
import com.gis.server.entities.GeometricShape;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
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
public class GreetingServiceImpl  extends HttpServletObject  implements  GreetingService{

	@Inject
	DaoGeometricShape daoGeometricShape;

	@Transactional
	public String greetServer(String input) throws IllegalArgumentException {
////		// Verify that the input is valid. 
////		if (!FieldVerifier.isValidName(input)) {
////			// If the input is not valid, throw an IllegalArgumentException back to
////			// the client.
////			throw new IllegalArgumentException(
////			"Name must be at least 4 characters long");
////		}
//		
		try{
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
