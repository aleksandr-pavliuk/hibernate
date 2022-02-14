package ua.org.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.org.hibernate.HibernateUtil;
import ua.org.hibernate.dao.interfaces.objects.ActivityDAO;
import ua.org.hibernate.entity.Activity;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class ActivityDAOImpl implements ActivityDAO {

  @Override
  public Activity get(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Activity user = session.get(Activity.class, id); // получаем единичный объект
    session.close();
    return user;
  }

  @Override
  public void update(Activity obj) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.update(obj);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void delete(Long id) {
    throw new IllegalStateException("you cant delete activity by yourself - only DB can");
  }

  @Override
  public void add(Activity obj) {
    throw new IllegalStateException("you cant add activity by yourself - only DB's trigger can");
  }

  @Override
  public Activity getByUser(String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Activity> query = session.createQuery("FROM Activity where user.email like :email");
    query.setParameter("email", "%"+email+"%");
    Activity stat = query.uniqueResult();
    session.close();
    return stat;
  }

  @Override
  public Activity getByUser(User user) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Activity> query = session.createQuery("FROM Activity where user.email like :email");
    query.setParameter("email", "%"+user.getEmail()+"%");
    Activity stat = query.uniqueResult();
    session.close();
    return stat;
  }
}
