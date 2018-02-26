

package com.Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beans.T_User;
import com.beans.T_VisitLog;

import generalHelper.CommonHelper;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	static final Logger log = Logger.getLogger(Login.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("<<< In doPost >>>");
			String name = request.getParameter("tmp_username");
			String pass = request.getParameter("tmp_password");
			
			T_User currentUser = new T_User();
			currentUser.setNume(name);
			currentUser.setPassword(pass);
		
			T_VisitLog visitLog = CommonHelper.creatVisitLog(request,"Pagina 01 Login","");
			LoginBH.saveVisitLog(visitLog);
			
			LoginHelper.executeFlow(currentUser);
		
			// New location to be redirected
			String nextJSP = "/BackPagina04.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request,response);
	      
		log.debug("<<< Out doPost >>>");
	}

	public void destroy() {
		   // Finalization code...
	}

}
