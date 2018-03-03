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
		String parolaFirst = request.getParameter("reg_password");
		String parolaSecond = request.getParameter("reg_password_confirm");
		String email = request.getParameter("reg_email");
		String numeSiPrenumeStr = request.getParameter("reg_fullname");
		String sex = request.getParameter("reg_gender"); 		// intoarce M sau F
		String deAccord = request.getParameter("reg_agree");    // intoarce ON daca este acceptat

		log.debug("nickname: " + nickname);
		log.debug("parolaFirst: " + parolaFirst);
		log.debug("parolaSecond: " + parolaSecond);
		log.debug("email: " + email);
		log.debug("numeSiPrenumeStr: " + numeSiPrenumeStr);
		log.debug("sex: " + sex);
		log.debug("deAccord: " + deAccord);
		
		//RegisterHelperDB.checkNicknameExists(nickname);
		
		if ("on".equalsIgnoreCase(deAccord)) {
			log.debug("Agreement is ON");
			String parolaVerificataSiCriptata = RegisterHelper.verificareParole(parolaFirst, parolaSecond);
			HashMap<String, String> numeSiPrenume = RegisterHelper.splitNumeSiPrenume(numeSiPrenumeStr);

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

			RegisterHelperDB.saveProfilUser(userProfil);
			RegisterHelperDB.saveUser(userInregistrare);

			log.debug(CommonHelper.trsfOut(userProfil));

		} else {
			throw new Exception("Trebuie sa fi deaccord cu termeni si conditile noastre");
		}

		log.debug("<<< OUT executeFlow() >>>");
	}

	public static String verificareParole(String parolaFirst, String parolaSecond) throws Exception {
		log.debug("<<< OUT verificareParole() >>>");
		if (!parolaFirst.equals(parolaSecond)) {
			throw new Exception("Prima si a doua parola trebuie sa fie la fel");
		}
		String parolaCriptata = CommonHelper.criptareParola(parolaFirst);
		log.debug("<<< OUT verificareParole() >>>");
		return parolaCriptata;
	}

	

	public static HashMap<String, String> splitNumeSiPrenume(String numeSiPrenumeStr) {
		log.debug("<<< OUT splitNumeSiPrenume() >>>");
		HashMap<String, String> map = new HashMap<String, String>();
		String numeSiPrenumeTrimmed = numeSiPrenumeStr.trim();
		String[] numeSiPrenumeSplited = numeSiPrenumeTrimmed.split(" ");
		if (numeSiPrenumeSplited.length == 2) {
			map.put("nume", numeSiPrenumeSplited[0]);
			map.put("prenume", numeSiPrenumeSplited[1]);
		} else {
			map.put("nume", numeSiPrenumeSplited[0]);
			String prenumeLung = "";
			for (int i = 1; i < numeSiPrenumeSplited.length; i++) {
				prenumeLung = prenumeLung.concat(numeSiPrenumeSplited[i] + " ");
			}
			prenumeLung = prenumeLung.trim();
			map.put("prenume", prenumeLung);
		}
		log.debug("<<< OUT splitNumeSiPrenume() >>>");
		return map;
	}

}
