package generalHelper;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beans.T_VisitLog;

import hibernateImp.HibernateUtil;

public class CommonHelperDB {
	static final Logger log = Logger.getLogger(CommonHelperDB.class);
	public static void saveVisitLog(T_VisitLog visitLog){
		Session session =  new HibernateUtil().getSession();
		session.beginTransaction();
		session.save(visitLog);
		session.getTransaction().commit();
	}
}
