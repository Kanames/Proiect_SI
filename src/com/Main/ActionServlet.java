package com.Main;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ActionServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static final Logger log = Logger.getLogger(ActionServlet.class);
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.debug("<<< In doPost >>>");
		String mesajScris = request.getParameter("#mesajScris");
		System.out.println("#mesajScris: "+mesajScris);
//		Date date = new Date();
//		String hql2 = "FROM T_Message WHERE ch_mess_time  > '"+currentUser.getNume()+"'";
//		Query queryNickname = session.createQuery(hql2);
//		List resultsNickname = queryNickname.getResultList();
//		log.debug("resultsNickname.size(): "+resultsNickname.size());
//		if( resultsNickname.size() != 1) {
//			throw new Exception("User neinregistrat cu acest email sau nickname");
//		}
		
		
		response.getWriter().write("<div class='chat friend'><div class='user-photo'></div><p class='chat-msg'>($row[Username]) $row[Text]</p></div>");
		log.debug("<<< Out doPost >>>");
	}

	public void destroy() {
		// Finalization code...
	}
}
