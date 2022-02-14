package ua.org.hibernate.dao.impl;

import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.org.hibernate.HibernateUtil;
import ua.org.hibernate.dao.interfaces.objects.StatDAO;
import ua.org.hibernate.entity.Stat;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class StatDAOImpl implements StatDAO {

  @Override
  public Stat getByUser(String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Stat> query = session.createQuery("FROM Stat where user.email like :email");
    query.setParameter("email", "%"+email+"%");
    Stat stat = query.uniqueResult();
    session.close();
    return stat;
  }

  @Override
  public Stat getByUser(User user) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Stat> query = session.createQuery("FROM Stat where user.email like :email");
    query.setParameter("email", "%"+user.getEmail()+"%");
    Stat stat = query.uniqueResult();
    session.close();
    return stat;
  }

}
