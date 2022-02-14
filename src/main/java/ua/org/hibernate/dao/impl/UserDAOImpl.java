package ua.org.hibernate.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.org.hibernate.HibernateUtil;
import ua.org.hibernate.dao.interfaces.objects.UserDAO;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class UserDAOImpl implements UserDAO {


  @Override
  public List<User> findAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<User> query = session.createQuery("FROM User");
    List<User> list = query.getResultList();
    session.close();
    return list;
  }

  @Override
  public List<User> findAll(String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<User> query = session.createQuery("FROM User where email like :email");
    query.setParameter("email", "%" + email + "%");
    List<User> list = query.getResultList();
    session.close();
    return list;
  }

  @Override
  public User get(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    User user = session.get(User.class, id);
    session.close();
    return user;
  }

  @Override
  public void update(User obj) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(obj);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void delete(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    User u = new User();
    u.setId(id);
    session.delete(u);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void add(User obj) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(obj);
    session.getTransaction().commit();
    session.close();
  }


  @Override
  public User getByEmail(String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<User> query = session.createQuery("FROM User where email = :email");
    query.setParameter("email", email);
    User user = query.uniqueResult();
    session.close();
    return user;
  }
}
