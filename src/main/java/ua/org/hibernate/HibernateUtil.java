package ua.org.hibernate;

import java.io.File;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class HibernateUtil {

  private static final SessionFactory sessionFactory = initSessionFactory();

  private static SessionFactory initSessionFactory() {
    try {
      return new Configuration().configure(new File("src\\main\\resources\\hibernate.cfg.xml")).buildSessionFactory();
    }
    catch (Throwable ex) {
      System.err.println("Initial SessionFactory creation failed." + ex);
      throw new ExceptionInInitializerError(ex);
    }
  }

  public static SessionFactory getSessionFactory() {

    if (sessionFactory == null){
      initSessionFactory();
    }

    return sessionFactory;
  }

  public static void close() {
    getSessionFactory().close();
  }
}
