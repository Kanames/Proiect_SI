package generalHelper;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.beans.T_VisitLog;

/**
 * Aceasta clasa este un helper general de folosit in toata aplicatia.Rolul lui
 * este de a mentine diferite metode refolosibile in aplicatie intr-un singur
 * loc.
 * 
 * @author Stefan
 * @category Helper
 * @version 0.1
 * @since 25/02/2018
 */
public class CommonHelper {
	static final Logger log = Logger.getLogger(CommonHelper.class);

	/**
	 * Metoda ce returneaza reprezentarea clara (human readable) sub forma de String
	 * a oricarui obiect pasat.
	 * @param object Obiectul pe care il dorim afisat un forma "Human readable"
	 * @return Obiectul reprezentat ca string. String-ul contine detali despre obiect *atribut obiect* - *valoare atribut obiect*;
	 * @since 25/02/2018
	 * @author Stefan
	 * @category Helper
	 */
	public static String trsfOut(Object object) {
		log.debug("<<< IN trsfOut() >>>");
		StringBuffer representation = new StringBuffer();
		representation.append(object.getClass().getName());
		for (Field field : object.getClass().getDeclaredFields()) {
			try {
				field.setAccessible(true);
				String name = field.getName();
				Object value;
				value = field.get(object);
				representation.append(" [" + name + ":" + value + "] ");
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}

		}
		log.debug("<<< OUT trsfOut() >>>");
		return representation.toString();
	}

	/**
	 * Metoda de creare a obiectului de top T_Visitlog pe baza requestului , pagini
	 * vizitate [ si optional erroarea primita in pagina curenta ].
	 * @param request Reprezinta requestul de tip HttpServletRequest pe care pagina jsp o transmite servlet-ului.
	 * @param visitLogPage Pagina in care se afla utilizatorul
	 * @param visitLogPageErr Posibila eroarea pe care acesta o poate primi in pagina curenta.
	 * @return Obiect de tip T_Visitlog
	 * @throws IOException
	 * @author Stefan
	 * @since 10/03/2018
	 * @category Helper
	 */
	public static T_VisitLog creatVisitLog(HttpServletRequest request, String visitLogPage, String visitLogPageErr)throws IOException {
		log.debug("<<< IN creatVisitLog() >>>");
		log.debug("request: " + trsfOut(request));
		T_VisitLog visitLog = new T_VisitLog();
		log.debug("User-Agent [header]: " + trsfOut(request.getHeader("User-Agent")));
		afisareaHeadRequest(request);
		String browserDetails = request.getHeader("User-Agent");
		String userAgent = browserDetails;
		String user = userAgent.toLowerCase();
		String os = gettingSystemOSfromRequest(userAgent);
		String browser = gettingBrowerfromRequest(userAgent, user);
		visitLog.setVisitLogPage(visitLogPage);
		visitLog.setVisitLogPageErr(visitLogPageErr);
		visitLog.setIp(request.getRemoteAddr());
		visitLog.setBrowserName(browser);
		visitLog.setOs(os);
		log.debug("<<< OUT creatVisitLog() >>>");
		return visitLog;
	}
	/**
	 * 	Metoda ce returneaza un String care reprezinta numele Brower-ului pe care utilizatorul il foloseste.
	 * @param userAgent
	 * @param user
	 * @return numele Brower-ului folosit inregistrat in sistem
	 * @author Stefan
	 * @since 10/03/2018
	 * @category Helper
	 */
	private static String gettingBrowerfromRequest(String userAgent, String user) {
		log.debug("<<< IN gettingBrowerfromRequest() >>>");
		String browser = null;
		// ===============Browser===========================
		if (user.contains("msie")) {
			String substring = userAgent.substring(userAgent.indexOf("MSIE")).split(";")[0];
			browser = substring.split(" ")[0].replace("MSIE", "IE") + "-" + substring.split(" ")[1];
		} else if (user.contains("safari") && user.contains("version")) {
			browser = (userAgent.substring(userAgent.indexOf("Safari")).split(" ")[0]).split("/")[0] + "-"
					+ (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
		} else if (user.contains("opr") || user.contains("opera")) {
			if (user.contains("opera"))
				browser = (userAgent.substring(userAgent.indexOf("Opera")).split(" ")[0]).split("/")[0] + "-"
						+ (userAgent.substring(userAgent.indexOf("Version")).split(" ")[0]).split("/")[1];
			else if (user.contains("opr"))
				browser = ((userAgent.substring(userAgent.indexOf("OPR")).split(" ")[0]).replace("/", "-"))
						.replace("OPR", "Opera");
		} else if (user.contains("chrome")) {
			browser = (userAgent.substring(userAgent.indexOf("Chrome")).split(" ")[0]).replace("/", "-");
		} else if ((user.indexOf("mozilla/7.0") > -1) || (user.indexOf("netscape6") != -1)
				|| (user.indexOf("mozilla/4.7") != -1) || (user.indexOf("mozilla/4.78") != -1)
				|| (user.indexOf("mozilla/4.08") != -1) || (user.indexOf("mozilla/3") != -1)) {
			// browser=(userAgent.substring(userAgent.indexOf("MSIE")).split("
			// ")[0]).replace("/", "-");
			browser = "Netscape-?";

		} else if (user.contains("firefox")) {
			browser = (userAgent.substring(userAgent.indexOf("Firefox")).split(" ")[0]).replace("/", "-");
		} else if (user.contains("rv")) {
			browser = "IE-" + user.substring(user.indexOf("rv") + 3, user.indexOf(")"));
		} else {
			browser = "UnKnown, More-Info: " + userAgent;
		}
		log.debug("<<< OUT gettingBrowerfromRequest() >>>");
		return browser;
	}
	/**
	 *  Metoda ce returneaza Sistem de Operare (OS) folosit de utilizator
	 * @param userAgent 
	 * @return numele OS-ului folosit de utilizator
	 * @author Stefan
	 * @since 10/03/2018
	 * @category Helper
	 */
	private static String gettingSystemOSfromRequest(String userAgent) {
		log.debug("<<< IN gettingSystemOSfromRequest() >>>");
		String os;
		if (userAgent.toLowerCase().indexOf("windows") >= 0) {
			os = "Windows";
		} else if (userAgent.toLowerCase().indexOf("mac") >= 0) {
			os = "Mac";
		} else if (userAgent.toLowerCase().indexOf("x11") >= 0) {
			os = "Unix";
		} else if (userAgent.toLowerCase().indexOf("android") >= 0) {
			os = "Android";
		} else if (userAgent.toLowerCase().indexOf("iphone") >= 0) {
			os = "IPhone";
		} else {
			os = "UnKnown, More-Info: " + userAgent;
		}
		log.debug("<<< IN gettingSystemOSfromRequest() >>>");
		return os;
	}

	/**
	 * Metoda pentru afisarea in log unui request de tip HttpServletRequest
	 * 
	 * @param request Obiectul de tip HttpServletRequest ce vine din pagina jsp.
	 * @category Helper
	 * @author Stefan
	 * @since 10/03/2018
	 */
	private static void afisareaHeadRequest(HttpServletRequest request) {
		log.debug("<<< IN afisareaHeadRequest() >>>");
		Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				log.debug("Header: " + request.getHeader(headerNames.nextElement()));
			}
		}
		log.debug("<<< OUT afisareaHeadRequest() >>>");
	}

	/**
	 * Metoda pentru returnarea IP-ului pe baza unui obiect de tip HttpServletRequest.
	 * @param request obiect de tip HttpServletRequest.
	 * @return IP-ului userului.
	 * @author Stefan
	 * @since 10/03/2018
	 * @category Helper
	 */
	public static String getIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

	/**
	 * Metoda pentru criptarea parolei inainte de a fi adaugata in BD.
	 * @param String ce contine parola initiala.
	 * @return String ce contine parola criptata.
	 * @author Cosmin
	 * @since 02/03/2018
	 * @category Helper
	 */
	public static String criptareParola(String parolaSecond) {
		log.debug("<<< OUT criptareParola() >>>");
		String parolaCriptata = "";

		for (int i = 0; i < parolaSecond.length(); i++) {
			int c = (int) parolaSecond.charAt(i);
			c++;
			parolaCriptata += Character.toString((char) c);
		}
		log.debug("<<< OUT criptareParola() >>>");
		return parolaCriptata;
	}

	/**
	 * Metoda pentru decriptarea parolei la verificarea de login dupa ce a fost
	 * scoasa din BD.
	 * @param String ce contine parola criptata.
	 * @return String ce contine parola initiala.
	 * @author Cosmin
	 * @since 02/03/2018
	 * @category Helper
	 */
	public static String decriptareParola(String parolaCriptata) {
		log.debug("<<< OUT decriptareParola() >>>");
		String parolaDecriptata = "";

		for (int i = 0; i < parolaCriptata.length(); i++) {
			int c = (int) parolaCriptata.charAt(i);
			c--;
			parolaDecriptata += Character.toString((char) c);
		}
		log.debug("<<< OUT decriptareParola() >>>");
		return parolaDecriptata;
	}

}
