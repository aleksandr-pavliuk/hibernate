package ua.org.hibernate;

import org.hibernate.Session;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class Main {
  public static void main(String[] args) {

    Session session = HibernateUtil.getSessionFactory().openSession();
    session.close();
    HibernateUtil.close();
  }
}
