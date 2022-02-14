package ua.org.hibernate.dao.impl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import ua.org.hibernate.HibernateUtil;
import ua.org.hibernate.dao.interfaces.objects.CategoryDAO;
import ua.org.hibernate.entity.Category;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class CategoryDAOImpl implements CategoryDAO {

  @Override
  public List<Category> findAll() {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Category> query = session.createQuery("FROM Category");
    List<Category> list = query.getResultList();
    session.close();
    return list;
  }

  @Override
  public List<Category> findAll(String email) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Query<Category> query = session.createQuery("FROM Category p where p.user.email like :email");
    query.setParameter("email", "%"+email+"%");
    List<Category> list = query.getResultList();
    session.close();
    return list;
  }

  @Override
  public Category get(Long id) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    Category user = session.get(Category.class, id);
    session.close();
    return user;
  }

  @Override
  public void update(Category obj) {
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
    Category u = new Category();
    u.setId(id);
    session.delete(u);
    session.getTransaction().commit();
    session.close();
  }

  @Override
  public void add(Category obj) {
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    session.save(obj);
    session.getTransaction().commit();
    session.close();
  }


}

