package com.Register;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.beans.T_Profile;
import com.beans.T_User;

import generalHelper.CommonHelper;

public class RegisterHelper {
	static final Logger log = Logger.getLogger(RegisterHelper.class);
	public static void executeFlow(HttpServletRequest request) throws Exception {
		log.debug("<<< IN executeFlow() >>>");
		String nickname = request.getParameter("reg_username");
		String parolaFirst   = request.getParameter("reg_password");
		String parolaSecond  = request.getParameter("reg_password_confirm");
		String email  		= request.getParameter("reg_email");
		String numeSiPrenumeStr  = request.getParameter("reg_fullname");
		String sex  			 = request.getParameter("reg_gender");
		String deAccord 		 = request.getParameter("reg_agree");

		log.debug("nickname: "+nickname);
		log.debug("parolaFirst: "+parolaFirst);
		log.debug("parolaSecond: "+parolaSecond);
		log.debug("email: "+email);
		log.debug("numeSiPrenumeStr: "+numeSiPrenumeStr);
		log.debug("sex: "+sex);
		log.debug("deAccord: "+deAccord);
		
//		DEBUG   2018-02-27 19:01:10,969 ~ com.Register.RegisterHelper  - nickname: stefan
//		DEBUG   2018-02-27 19:01:10,969 ~ com.Register.RegisterHelper  - parolaFirst: parola 1
//		DEBUG   2018-02-27 19:01:10,969 ~ com.Register.RegisterHelper  - parolaSecond: nickname
//		DEBUG   2018-02-27 19:01:10,969 ~ com.Register.RegisterHelper  - email: gamail.com
//		DEBUG   2018-02-27 19:01:10,969 ~ com.Register.RegisterHelper  - numeSiPrenumeStr: paladuta stefan toade
//		DEBUG   2018-02-27 19:01:10,969 ~ com.Register.RegisterHelper  - sex: M
//		DEBUG   2018-02-27 19:01:10,969 ~ com.Register.RegisterHelper  - deAccord: on
		
		if("on".equalsIgnoreCase(deAccord)) {
			log.debug("Agreement is ON");
			String parolaVerificataSiCriptata 	 = RegisterHelper.verificareParole(parolaFirst,parolaSecond);
			HashMap<String,String> numeSiPrenume = RegisterHelper.splitNumeSiPrenume(numeSiPrenumeStr);
			
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
			
			RegisterBH.saveProfilUser(userProfil);
			RegisterBH.saveUser(userInregistrare);
			
			log.debug(CommonHelper.trsfOut(userProfil));
			
		}else{
			throw new Exception("Trebuie sa fi deaccord cu termeni si conditile noastre");
		}

		log.debug("<<< OUT executeFlow() >>>");
	}
	
	public static String verificareParole(String parolaFirst, String parolaSecond) throws Exception {
		if(!parolaFirst.equals(parolaSecond)) {
			throw new Exception("Prima si a doua parola trebuie sa fie la fel");
		}
		String parolaCriptata = criptareParola(parolaFirst);
		return parolaCriptata;
	}

	private static String criptareParola(String parolaSecond) {
		// TODO Metoda ce sa cripteze parola , Cat de simpla se poate 
		return parolaSecond;
	}
	
	private static String decriptareParola(String parolaCriptata) {
		// TODO Metoda ce sa decripteze parola , Cat de simpla se poate 
		String parolaDecriptata = null;
		return parolaDecriptata;
	}

	public static HashMap<String, String> splitNumeSiPrenume(String numeSiPrenumeStr) {
		   HashMap<String,String> map = new HashMap<String,String>();
	         String numeSiPrenumeTrimmed = numeSiPrenumeStr.trim();
	         String[] numeSiPrenumeSplited= numeSiPrenumeTrimmed.split(" ");
	         if(numeSiPrenumeSplited.length == 2){
	            map.put("nume",numeSiPrenumeSplited[0]);
	            map.put("prenume",numeSiPrenumeSplited[1]);
	         }else{
	                map.put("nume",numeSiPrenumeSplited[0]);
	                String prenumeLung = "";
	             for(int i = 1 ; i < numeSiPrenumeSplited.length ; i++ ){
	                 prenumeLung = prenumeLung.concat(numeSiPrenumeSplited[i]+" ");
	             }
	             	prenumeLung = prenumeLung.trim();
	                map.put("prenume",prenumeLung);
	         }
	        
	         return map;
	}

}
