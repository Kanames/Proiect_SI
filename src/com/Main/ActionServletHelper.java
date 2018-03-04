package com.Main;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class ActionServletHelper {
	static final Logger log = Logger.getLogger(ActionServletHelper.class);

	public static void executeFlow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.debug("<<< In executeFlow >>>");
		String mesajScris = request.getParameter("user");
		System.out.println("mesajScris: "+mesajScris);
		List rezultateMesajeDB = ActionServletHelperDB.selectMessages(new Date());
		if(mesajScris != null && !mesajScris.equals("")) {	
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>> INREGISTRARE MESAJ !!! ");
			ActionServletHelperDB.saveMessage(mesajScris,1);
		}
		log.debug("rezultateMesajeDB.toArray() hql2: "+rezultateMesajeDB.toArray());
		log.debug("rezultateMesajeDB.size() hql2: "+rezultateMesajeDB.size());
		if(rezultateMesajeDB.size() > 0) {
			response.getWriter().write("<div class='chat friend'><div class='user-photo'></div><p class='chat-msg'>($row[Username]) "+"TEXT"+"</p></div>");
		}
		log.debug("<<< In executeFlow >>>");	
	}
	
}
