package ua.org.hibernate.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.org.hibernate.HibernateUtil;
import ua.org.hibernate.dao.interfaces.objects.PriorityDAO;
import ua.org.hibernate.entity.Priority;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class PriorityDAOImpl implements PriorityDAO {

  @Override
  public List<Priority> findAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Priority> query = session.createQuery("FROM Priority");
    List<Priority> list = query.getResultList();
    session.close();
    return list;
  }

  @Override
  public List<Priority> findAll(String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Priority> query = session.createQuery("FROM Priority p where p.user.email like :email");
    query.setParameter("email", "%"+email+"%");
    List<Priority> list = query.getResultList();
    session.close();
    return list;
  }

  @Override
  public Priority get(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Priority user = session.get(Priority.class, id);
    session.close();
    return user;
  }

  @Override
  public void update(Priority obj) {
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
    Priority u = new Priority();
    u.setId(id);
    session.delete(u);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void add(Priority obj) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(obj);
    session.getTransaction().commit();
    session.close();
  }


}
