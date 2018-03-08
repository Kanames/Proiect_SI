package com.Register;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beans.T_Profile;
import com.beans.T_User;

import hibernateImp.HibernateUtil;
/**
 * Clasele de tip HelperDB sunt folosite in cadrul proiectului ca si clase pentru operarea de metode DB precum INSERT, UPDATE, DELETE.
 * @author Stefan
 * @version 0.2
 */
public class RegisterHelperDB {
	static final Logger log = Logger.getLogger(RegisterHelperDB.class);
	/**
	 * Metoda de salvare a obiectului T_User in baza ta de date.
	 * @param user Obiectul de tip T_User care este mapat la tabela CH_USER va fi salvat ca record in aceasta.
	 */
	public static void saveUser(T_User user){
		log.debug("<<<< IN saveUser() >>>>"); 
		Session session =  new HibernateUtil().getSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		log.debug("<<<< OUT saveUser() >>>>"); 
	}
	/**
	 * Metoda de salvare a obiectului T_Profile in baza ta de date
	 * @param profil Obiectul de tip T_Profile care este mapat la tabela CH_PROFILE va fi salvat ca record in aceasta.
	 */
	public static void saveProfilUser(T_Profile profil){
		log.debug("<<<< IN saveProfilUser() >>>>"); 
		Session session =  new HibernateUtil().getSession();
		session.beginTransaction();
		session.save(profil);
		session.getTransaction().commit();
		log.debug("<<<< IN saveProfilUser() >>>>"); 
	}
	public static void checkNicknameExists(String nickname) throws Exception {
		Session session =  new HibernateUtil().getSession();
		session.beginTransaction();
		String hql = "FROM T_Profile u WHERE ch_prf_nickname = '"+nickname+"'";
		Query queryNickname = session.createQuery(hql);
		List resultsNickname = queryNickname.getResultList();
		log.debug("resultsNickname.size(): "+resultsNickname.size());
		if( resultsNickname.size() == 1) {
			throw new Exception("User deja inregistrat cu acest nickname");
		}
		
	}

}
