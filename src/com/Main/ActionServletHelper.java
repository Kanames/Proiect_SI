package com.Main;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.beans.T_Chat;

public class ActionServletHelper {
	static final Logger log = Logger.getLogger(ActionServletHelper.class);

	public static void executeFlow(HttpServletRequest request, HttpServletResponse response) throws IOException {
		log.debug("<<< In executeFlow >>>");
		String mesajScris = request.getParameter("user");
		System.out.println("mesajScris: "+mesajScris);
		
		String numeUser = (String) request.getSession().getAttribute("numeUserCurrent");
		
		List rezultateMesajeDB = ActionServletHelperDB.selectMessages(new Date(),numeUser);
		if(mesajScris != null && !mesajScris.equals("")) {	
			log.debug(">>>>>>>>>>>>>>>>>>>>>>>> INREGISTRARE MESAJ !!! ");
			log.debug("numeUser: "+numeUser);
			ActionServletHelperDB.saveMessage(mesajScris,numeUser);
		}
		log.debug("rezultateMesajeDB.size() hql2: "+rezultateMesajeDB.size());
		if(rezultateMesajeDB.size() > 0) {
			for(int i = 0  ; i <rezultateMesajeDB.size() ; i++) {
				T_Chat profil = (T_Chat) rezultateMesajeDB.get(i);
				response.getWriter().write("<div class='chat friend'><div class='user-photo'></div><p class='chat-msg'>("+profil.getUsername()+") "+profil.getText()+"</p></div>");
				HttpSession sesiune = request.getSession();
				sesiune.setAttribute("ultimulIdMesaj", profil.getId());
			}
		}
		log.debug("<<< In executeFlow >>>");	
	}
	
}
