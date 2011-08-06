package com.gis.server;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
/**Classe criada para aqueles que desejarem que seus serviços sejam um httpServlet. 
 * possue basicamente todos os objetos que um serlet possui.
 * 
 * @author Robson
 */
public class HttpServletObject implements HasServletConfig, HasServletRequest, HasServletContext{

	private ServletContext servletContext;
	private HttpServletRequest servletRequest;
	private ServletConfig servletConfig;
	
	@Override
	public ServletContext getServletContext() {
		return servletContext;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;

	}

	@Override
	public HttpServletRequest getServletRequest() {

		return servletRequest;
	}

	@Override
	public void setServletRequest(HttpServletRequest servletRequest) {
		this.servletRequest = servletRequest;

	}

	@Override
	public ServletConfig getServletConfig() {

		return servletConfig;
	}

	@Override
	public void setServletConfig(ServletConfig servletConfig) {
		this.servletConfig = servletConfig;

	}

}
