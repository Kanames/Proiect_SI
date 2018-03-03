package com.Login;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beans.T_Profile;
import com.beans.T_User;

import generalHelper.CommonHelper;
import hibernateImp.HibernateUtil;

/**
 * Clasele de tip HelperDB sunt folosite in cadrul proiectului ca si clase
 * pentru operarea de metode DB precum INSERT, UPDATE, DELETE.
 * 
 * @author Stefan
 * @version 0.1
 */
public class LoginHelperDB {
	static final Logger log = Logger.getLogger(LoginHelperDB.class);

	public static void checkRegisterUser(T_User currentUser) throws Exception {
		log.debug("<<<< IN  checkRegisterUser() >>>>");
		SessionFactory sessionFactory = new HibernateUtil().getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		String hql2 = "FROM T_Profile u WHERE ch_prf_nickname = '"+currentUser.getNume()+"'";
		Query queryNickname = session.createQuery(hql2);
		List resultsNickname = queryNickname.getResultList();
		log.debug("resultsNickname.size(): "+resultsNickname.size());
		if( resultsNickname.size() != 1) {
			throw new Exception("User neinregistrat cu acest email sau nickname");
		}
		T_Profile profil = (T_Profile) resultsNickname.get(0);
		log.debug("profil: "+CommonHelper.trsfOut(profil));
		log.debug("<<<< OUT checkRegisterUser() >>>>");
		
		
		String hql = "FROM T_User WHERE ch_user_id = '"+profil.getId()+"'";
		Query queryUser = session.createQuery(hql);
		List resultsUser = queryUser.getResultList();
		log.debug("resultsUser.size(): "+resultsUser.size());
		T_User user = (T_User) resultsUser.get(0);
		String parolaUser = CommonHelper.decriptareParola(user.getPassword());
		log.debug("parolaUser(decriptata): "+parolaUser);
		if( !parolaUser.equals(currentUser.getPassword()) ) {
			throw new Exception("Parola gresita pentru User cu nickname-ul :" + currentUser.getNume());
		}
	}

}
