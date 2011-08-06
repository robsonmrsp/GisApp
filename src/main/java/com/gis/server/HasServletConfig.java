package com.gis.server;

import javax.servlet.ServletConfig;

public interface HasServletConfig {
	ServletConfig getServletConfig();
	void setServletConfig(ServletConfig servletConfig);
}
