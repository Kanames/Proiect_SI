package hibernateImp;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beans.T_Chat;
import com.beans.T_Message;
import com.beans.T_Profile;
import com.beans.T_User;
import com.beans.T_VisitLog;

public class HibernateUtil {  
	  
    private static final SessionFactory sessionFactory;  

    static {  
        try {  
            // Create the SessionFactory from hibernate.cfg.xml  
            sessionFactory = new Configuration().configure()
            		.addAnnotatedClass(T_VisitLog.class)
            		.addAnnotatedClass(T_User.class)
            		.addAnnotatedClass(T_Profile.class)
            		.addAnnotatedClass(T_Message.class)
            		.addAnnotatedClass(T_Chat.class)
            		.buildSessionFactory();
        } catch (Throwable ex) {  
            // Make sure you log the exception, as it might be swallowed  
            System.err.println("Initial SessionFactory creation failed." + ex);  
            throw new ExceptionInInitializerError(ex);  
        }  
    }  
  
    public static SessionFactory getSessionFactory() {  
        return sessionFactory;  
    }  
    public static Session getSession() { 
    	Session s = sessionFactory.getCurrentSession(); 
        return  s; 
    }  
  
} 