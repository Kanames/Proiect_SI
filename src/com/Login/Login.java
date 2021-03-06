
package com.Login;

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

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(Login.class);
	/**
	 * Metoda doPost care orice Servlet o poate avea
	 * @author Stefan
	 * @category doPost actions
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("<<< In doPost >>>");
		RequestDispatcher dispatcher;
		T_VisitLog visitLog;
		String nextJSP;
		try { 
			visitLog = CommonHelper.creatVisitLog(request, "Pagina 01 Login", "");
			CommonHelperDB.saveVisitLog(visitLog);
			LoginHelper.executeFlow(request);
			// New location to be redirected
			nextJSP = "/BackPagina04.jsp";
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			visitLog = CommonHelper.creatVisitLog(request, "Pagina 01 Login", e.getMessage());
			request.setAttribute("msgErr", e.getMessage());
			nextJSP = "/BackPagina01.jsp";
			dispatcher = getServletContext().getRequestDispatcher(nextJSP);
			dispatcher.forward(request, response);
		}
		log.debug("<<< Out doPost >>>");
	}

	public void destroy() {
		// Finalization code...
	}

}
