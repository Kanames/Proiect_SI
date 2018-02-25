

package com.Login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.util.StringUtils;

import beans.UserBean;

public class Login extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		String name = request.getParameter("tmp_username");
		String pass = request.getParameter("tmp_password");
		UserBean currentUser = new UserBean();
		
		currentUser.setName(name);
		currentUser.setPassword(pass);
		
		System.out.println(currentUser.toString());
		//http://localhost:8080/Proiect_SI/servletPage01Login
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}



}
