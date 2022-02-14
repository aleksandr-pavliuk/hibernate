package ua.org.hibernate.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.org.hibernate.HibernateUtil;
import ua.org.hibernate.dao.interfaces.objects.TaskDAO;
import ua.org.hibernate.entity.Task;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class TaskDAOImpl implements TaskDAO {

  @Override
  public List<Task> findAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Task> query = session.createQuery("FROM Task");
    List<Task> list = query.getResultList();
    session.close();
    return list;
  }

  @Override
  public List<Task> findAll(String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Task> query = session.createQuery("FROM Task t where t.user.email like :email");
    query.setParameter("email", "%"+email+"%");
    List<Task> list = query.getResultList();
    session.close();
    return list;
  }

  @Override
  public Task get(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Task user = session.get(Task.class, id);
    session.close();
    return user;
  }

  @Override
  public void update(Task obj) {
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
    Task u = new Task();
    u.setId(id);
    session.delete(u);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void add(Task obj) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(obj);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public List<Task> find(boolean completed, String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Task> query = session.createQuery("FROM Task t where t.user.email like :email and t.completed = :completed");
    query.setParameter("email", "%"+email+"%");
    query.setParameter("completed", completed);
    List<Task> list = query.getResultList();
    session.close();
    return list;
  }
}
