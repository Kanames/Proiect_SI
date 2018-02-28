package com.Login;
import org.apache.log4j.Logger;

import com.beans.T_User;

import generalHelper.CommonHelper;
public class LoginHelper {
	
	static final Logger log = Logger.getLogger(LoginHelper.class);
	/**
	 * Metoda ce executa flow-ul logic din pagina 1 (Principala).
	 * @param currentUser Obiect de tipul UserBean trimis ca parametru pentru verificarea utilizatorului 
	 * curent in pagina si crearea flowlui logic al acestuia.
	 * @throws Exception 
	 */
	public static void executeFlow(T_User currentUser){
		log.debug("<<< IN executeFlow() >>>");
		log.debug("currentUser: "+CommonHelper.trsfOut(currentUser));
		checkUserName(currentUser.getNume());
		LoginHelperDB.checkRegisterUser(currentUser);
		log.debug("<<< OUT executeFlow() >>>");
	}
	
	private static void checkUserName(String currentUser) {
		log.debug("<<< IN checkUserName() >>>");
		String userNameTrimmed = currentUser.trim(); //curatare de spatiu din dreapta si stanga
		log.debug("userNameTrimmed: "+userNameTrimmed);
		
		log.debug("<<< OUT checkUserName() >>>");
	}

	


}
