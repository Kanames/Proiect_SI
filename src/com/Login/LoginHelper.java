package com.Login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.beans.T_User;

import generalHelper.CommonHelper;
public class LoginHelper {
	
	static final Logger log = Logger.getLogger(LoginHelper.class);
	/**
	 * Metoda ce executa flow-ul logic din pagina 1 (Principala).
	 * @param request Obiect de tipul UserBean trimis ca parametru pentru verificarea utilizatorului 
	 * curent in pagina si crearea flowlui logic al acestuia.
	 * @throws Exception 
	 */
	public static void executeFlow(HttpServletRequest request) throws Exception{
		log.debug("<<< IN executeFlow() >>>");
		
		String name = request.getParameter("tmp_username");
		String pass = request.getParameter("tmp_password");

		T_User currentUser = new T_User();
		currentUser.setNume(name);
		currentUser.setPassword(pass);
		
		log.debug("currentUser: "+CommonHelper.trsfOut(currentUser));
		checkUserName(currentUser.getNume());
		LoginHelperDB.checkRegisterUser(currentUser);
		HttpSession sesionReq = request.getSession();
		sesionReq.setAttribute("numeUserCurrent", currentUser.getNume());
		log.debug("<<< OUT executeFlow() >>>");
	}
	
	private static void checkUserName(String currentUser) {
		log.debug("<<< IN checkUserName() >>>");
		String userNameTrimmed = currentUser.trim(); //curatare de spatiu din dreapta si stanga
		log.debug("userNameTrimmed: "+userNameTrimmed);
		
		log.debug("<<< OUT checkUserName() >>>");
	}

	


}
