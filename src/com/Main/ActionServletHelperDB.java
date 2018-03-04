package com.Main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.beans.T_Message;

import hibernateImp.HibernateUtil;

public class ActionServletHelperDB {
	static final Logger log = Logger.getLogger(ActionServletHelperDB.class);
	public static void saveMessage(String mesajScris, int idUser) {
		log.debug("<<< In saveMessage >>>");
		T_Message mesaj = new T_Message();
		mesaj.setBodyMsg(mesajScris);
		mesaj.setSenderID(idUser);
		mesaj.setStatusMsg(1);
		mesaj.setReceiverID(idUser);
		SessionFactory sessionFactory =  new HibernateUtil().getSessionFactory();
		Session session =  sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(mesaj);
		session.getTransaction().commit();
		log.debug("<<< OUT saveMessage >>>");
	}

	public static List selectMessages(Date date) {
		log.debug("<<< In selectMessages >>>");
		SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Session session =  new HibernateUtil().getSession();
		session.beginTransaction();
		String hql2 = "FROM T_Message WHERE ch_mess_time  > '"+sdf.format(date)+"'";
		System.out.println(hql2);
		Query mesajeDB = session.createQuery(hql2);
		List mesaje = mesajeDB.getResultList();
		log.debug("<<< OUT selectMessages >>>");
		session.getTransaction().commit();
		return mesaje;
	}
}
