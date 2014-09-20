/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import controller.Book;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Amjad
 */
public class ItpdbHibernateUtil {

    private static final SessionFactory sessionFactory;

    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

            fillDataIfEmpty();
  
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static void fillDataIfEmpty() {

            Session session = sessionFactory.openSession();
         
            List messages = session.createQuery("from Book").list();

            if (messages == null || messages.size() <= 0) 
            {

                 session.beginTransaction();
                int max = 8;
                for (int i = (max / 2); i < max; i++) 
                {
                    Book quickMessage = new Book();

                    quickMessage.setBookid(10 + i);
                    quickMessage.setTitle("Book Title-" + quickMessage.getBookid());

                    session.save(quickMessage);

                }
                session.getTransaction().commit();
            }
            
            session.close();
    }
}
