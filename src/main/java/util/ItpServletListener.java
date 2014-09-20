/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;




import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Web application lifecycle listener.
 *
 * @author Amjad
 */
public class ItpServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        //To change body of generated methods, choose Tools | Templates.
        ItpdbHibernateUtil.getSessionFactory();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
       //To change body of generated methods, choose Tools | Templates.
    }
}
