package com.Login;
import org.apache.log4j.Logger;

import beans.UserBean;
import generalHelper.CommonHelper;
public class LoginHelper {
	
	static final Logger log = Logger.getLogger(LoginHelper.class);
	/**
	 * Metoda ce executa flow-ul logic din pagina 1 (Principala).
	 * @param currentUser Obiect de tipul UserBean trimis ca parametru pentru verificarea utilizatorului 
	 * curent in pagina si crearea flowlui logic al acestuia.
	 */
	public static void executeFlow(UserBean currentUser) {
		log.debug("<<< IN executeFlow() >>>");
		log.debug("currentUser: "+CommonHelper.trsfOut(currentUser));
		
		log.debug("<<< OUT executeFlow() >>>");
	}
	


}
