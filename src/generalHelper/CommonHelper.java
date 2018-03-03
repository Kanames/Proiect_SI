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
	 * @param object
	 *            Obiectul pe care il dorim afisat un forma "Human readable"
	 * @return Obiectul reprezentat ca string. String-ul contine detali despre
	 *         obiect *atribut obiect* - *valoare atribut obiect*;
	 * @since 25/02/2018
	 */
	public static String trsfOut(Object object) {
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
		return representation.toString();
	}

	public static T_VisitLog creatVisitLog(HttpServletRequest request, String visitLogPage, String visitLogPageErr)
			throws IOException {
		log.debug("<<< IN createVisitLog() >>>");
		log.debug("request: " + trsfOut(request));
		T_VisitLog visitLog = new T_VisitLog();
		log.debug("request.getHeader(\"User-Agent\"): " + trsfOut(request.getHeader("User-Agent")));

		Enumeration<String> headerNames = request.getHeaderNames();
		if (headerNames != null) {
			while (headerNames.hasMoreElements()) {
				log.debug("Header: " + request.getHeader(headerNames.nextElement()));
			}
		}

		String browserDetails = request.getHeader("User-Agent");
		String userAgent = browserDetails;
		String user = userAgent.toLowerCase();
		String os = "";
		String browser = "";

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
		visitLog.setVisitLogPage(visitLogPage);
		visitLog.setVisitLogPageErr(visitLogPageErr);
		visitLog.setIp(request.getRemoteAddr());
		visitLog.setBrowserName(browser);
		visitLog.setOs(os);

		log.debug("<<< OUT creatVisitLog() >>>");
		return visitLog;
	}

	public static String getIp(HttpServletRequest request) {
		return request.getRemoteAddr();
	}

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

	private String constructCriteriaQuery(String conto13Cifre, String simbolR1C1, String simbolR1C2, String simbolR2C1, String simbolR2C2) {
		StringBuilder criteriaQuery=  new StringBuilder();
		
		Boolean isConto13CifreNull  = (conto13Cifre == null  && conto13Cifre == "")  ? !isSimbolValueInjectionSQL(conto13Cifre)  : false;
		Boolean isSimbolR1C1Null    = (simbolR1C1 == null && simbolR1C1 == "")       ? !isSimbolValueInjectionSQL(simbolR1C1)    : false;
		Boolean isSimbolR1C2Null 	= (simbolR1C2 == null && simbolR1C2 == "") 		 ? !isSimbolValueInjectionSQL(simbolR1C2)    : false;
		Boolean isSimbolR2C1Null 	= (simbolR2C1 == null && simbolR2C1 == "") 		 ? !isSimbolValueInjectionSQL(simbolR2C1)    : false;
		Boolean isSimbolR2C2Null 	= (simbolR2C2 == null && simbolR2C2 == "") 		 ? !isSimbolValueInjectionSQL(simbolR2C2)    : false;

		if(isConto13CifreNull){
			criteriaQuery.append(" ");
		}
		if (isSimbolR1C1Null) {
			criteriaQuery.append("  ");
		}
		if (isSimbolR1C2Null) {
			criteriaQuery.append(" ");
		}
		if (isSimbolR2C1Null) {
			criteriaQuery.append(" ");
		}
		if (isSimbolR2C2Null) {
			criteriaQuery.append("  ");
		}
		
		return criteriaQuery.toString();
	}
	
	private Boolean isSimbolValueInjectionSQL(String testInjectionSQL) {
		//testInjectionSQL.cheamaMetodaDinUtilStrings();
		return false;
	}
}
