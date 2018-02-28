package com.Register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.beans.T_VisitLog;

import generalHelper.CommonHelper;
import generalHelper.CommonHelperDB;
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(Register.class);

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("<<< In doPost >>>");
		RequestDispatcher dispatcher;
		T_VisitLog visitLog;
		String nextJSP;
		try {
			RegisterHelper.executeFlow(request);
			visitLog = CommonHelper.creatVisitLog(request, "Pagina 05 Register", "");
			CommonHelperDB.saveVisitLog(visitLog);
			nextJSP = "/BackPagina01.jsp";

		}catch(Exception e){
			visitLog = CommonHelper.creatVisitLog(request, "Pagina 05 Register", e.getMessage());
			CommonHelperDB.saveVisitLog(visitLog);
			request.setAttribute("msgErr", e.getMessage());
			nextJSP = "/BackPagina05.jsp";
		}
		
		dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(request, response);
		log.debug("<<< Out doPost >>>");
	}

	public void destroy() {
		// Finalization code...
	}
}
