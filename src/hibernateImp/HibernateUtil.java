package hibernateImp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.beans.T_Message;
import com.beans.T_VisitLog;

public class HibernateUtil {  
	  
    private static final SessionFactory sessionFactory;  

    static {  
        try {  
            // Create the SessionFactory from hibernate.cfg.xml  
            sessionFactory = new Configuration().configure()
            		.addAnnotatedClass(T_VisitLog.class)
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
  
} 