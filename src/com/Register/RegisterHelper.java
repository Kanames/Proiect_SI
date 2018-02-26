package com.Register;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.beans.T_Profile;
import com.beans.T_User;

import generalHelper.CommonHelper;

public class RegisterHelper {
	static final Logger log = Logger.getLogger(RegisterHelper.class);
	public static void executeFlow(HttpServletRequest request) {
		log.debug("<<< IN executeFlow() >>>");
		String nickname = request.getParameter("reg_username");
		String parolaFirst   = request.getParameter("reg_password");
		String parolaSecond  = request.getParameter("reg_password_confirm");
		String email  		= request.getParameter("reg_email");
		String numeSiPrenumeStr  = request.getParameter("reg_fullname");
		String sex  			 = request.getParameter("reg_gender");
		String deAccord  		 = request.getParameter("reg_agree");
		
//		if(deAccord != null) {
//			throw new Exception("Nu ati fost de acord cu termeni si conditile noastre");
//		}
		
		String parolaVerificataSiCriptata 	 = RegisterBH.verificareParole(parolaFirst,parolaSecond);
		HashMap<String,String> numeSiPrenume = RegisterBH.splitNumeSiPrenume(numeSiPrenumeStr);
		
		T_User userInregistrare = new T_User();
		T_Profile userProfil = new T_Profile();
		
		
		userInregistrare.setNume(numeSiPrenume.get("nume"));
		userInregistrare.setPrenume(numeSiPrenume.get("prenume"));
		userInregistrare.setPassword(parolaVerificataSiCriptata);
		userInregistrare.setSex(sex);
		userInregistrare.setIp(CommonHelper.getIp(request));
		userInregistrare.setEmail(email);
		log.debug(CommonHelper.trsfOut(userInregistrare));
		
		userProfil.setNickname(nickname);
		
		
		log.debug(CommonHelper.trsfOut(userProfil));
		
		log.debug("<<< OUT executeFlow() >>>");
	}

}
