package generalHelper;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import com.beans.T_VisitLog;

import hibernateImp.HibernateUtil;
/**
 * Aceasta clasa este un helper general de folosit in toata aplicatia.Rolul lui
 * este de a mentine diferite metode refolosibile in aplicatie intr-un singur
 * loc.
 * @author Stefan
 * @category Helper Database
 * @version 0.1
 * @since 18/03/2018
 */
public class CommonHelperDB {
	static final Logger log = Logger.getLogger(CommonHelperDB.class);
	/**
	 * Metoda pentru logarea in baza de date a obiectului de tip T_Visitlog.
	 * @param visitLog Accepta un obiect de tipul T_VisitLog.
	 * @author Stefan
	 * @since 18/03/2018
	 */
	public static void saveVisitLog(T_VisitLog visitLog){
		log.debug("<<< IN saveVisitLog() >>>");
		Session session =  new HibernateUtil().getSession();
		session.beginTransaction();
		session.save(visitLog);
		session.getTransaction().commit();
		log.debug("<<< OUT saveVisitLog() >>>");
	}
}
