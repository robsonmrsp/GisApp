package com.gis.server;

import javax.servlet.ServletContext;

public interface HasServletContext {
	ServletContext getServletContext();
	void setServletContext (ServletContext  servletContext);
}
