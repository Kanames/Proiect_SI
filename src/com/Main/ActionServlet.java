package com.Main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ActionServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(ActionServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("<<< In doPost >>>");
		ActionServletHelper.executeFlow(request,response);
		log.debug("<<< Out doPost >>>");
	}

	public void destroy() {
		// Finalization code...
	}
}
