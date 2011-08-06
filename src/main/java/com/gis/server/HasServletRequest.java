package com.gis.server;

import javax.servlet.http.HttpServletRequest;

public interface HasServletRequest {

	HttpServletRequest getServletRequest();
	void setServletRequest(HttpServletRequest servletRequest);
}
