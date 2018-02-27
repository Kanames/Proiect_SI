package com.Register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class Register extends HttpServlet {
	static final Logger log = Logger.getLogger(Register.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("<<< In doPost >>>");
		String nextJSP;
		try {
			RegisterHelper.executeFlow(request);
			
			nextJSP = "/BackPagina01.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
		}catch(Exception e){
			
			request.setAttribute("msgErr", e.getMessage());
			nextJSP = "/BackPagina05.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
		}
		log.debug("<<< Out doPost >>>");
	}

	public void destroy() {
		// Finalization code...
	}
}
