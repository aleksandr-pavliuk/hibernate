package ua.org.hibernate;

import org.hibernate.Session;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class Main {
  public static void main(String[] args) {

    Session session = HibernateUtil.getSessionFactory().openSession();

    session.getTransaction().begin();

    User user = new User();
    user.setEmail("newfromapap5s2@email.com");
    user.setUsername("newfromapps5aa");
    user.setPassword("2asdfsdfsdfaa");

    session.save(user);

    session.getTransaction().commit();

    System.out.println("user.getId() = " + user.getId());
    session.close();
    HibernateUtil.close();
  }
}
