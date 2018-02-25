

package com.Login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import beans.UserBean;

public class Login extends HttpServlet {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	
	static final Logger log = Logger.getLogger(Login.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("<<< In doPost >>>");
		String name = request.getParameter("tmp_username");
		String pass = request.getParameter("tmp_password");
		UserBean currentUser = new UserBean();
		currentUser.setName(name);
		currentUser.setPassword(pass);
		LoginHelper.executeFlow(currentUser);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		log.debug("<<< Out doPost >>>");
	}



}
