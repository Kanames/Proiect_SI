

package com.Login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;

import com.beans.T_VisitLog;
import com.beans.UserBean;

public class Login extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	static final Logger log = Logger.getLogger(Login.class);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("<<< In doPost >>>");
		String name = request.getParameter("tmp_username");
		String pass = request.getParameter("tmp_password");
		
		UserBean currentUser = new UserBean();
		currentUser.setName(name);
		currentUser.setPassword(pass);
		
		T_VisitLog visitLog = new T_VisitLog();
		visitLog.setBrowserName("test");
		visitLog.setBrowerVersion("test");
		visitLog.setIp(request.getHeader("X-Forwarded-For"));
		visitLog.setOs("test");
		
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
