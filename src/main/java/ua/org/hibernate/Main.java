package ua.org.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public class Main {

  public static void main(String[] args) {

    /*Session session = HibernateUtil.getSessionFactory().openSession();

    session.getTransaction().begin();

    User user = new User();
    user.setEmail("newfromapap45s2@email.com");
    user.setUsername("newfromapp4s5aa");
    user.setPassword("2asdfsdfsdfaa");

    session.save(user);

    session.getTransaction().commit();

    System.out.println("user.getId() = " + user.getId());
    session.close();
    HibernateUtil.close();*/

    //сразу получаем готовый SessionFactory и сразу создаем сессию
    Session session = HibernateUtil.getSessionFactory().openSession();

    // подготовка запроса - получение всех пользователей
//        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> root = criteriaQuery.from(User.class);
//        criteriaQuery.select(root); // конечный запрос select из таблицы User
//
//        Predicate p1 = criteriaBuilder.gt(root.get("id"), 10000);
//        Predicate p2 = criteriaBuilder.lt(root.get("id"), 20000);
//
//        criteriaQuery.select(root).where(criteriaBuilder.and(p1 ,p2));
//
//        // выполнение запроса с получением результата
//        Query query = session.createQuery(criteriaQuery);
//        List<User> users = query.getResultList();
    //        log.info(users);

// delete
//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaDelete<User> criteriaDelete = cb.createCriteriaDelete(User.class);
//        Root<User> root = criteriaDelete.from(User.class);
//        criteriaDelete.where(cb.equal(root.get("id"), 10514));
//
//        Transaction transaction = session.beginTransaction();
//        session.createQuery(criteriaDelete).executeUpdate();
//        transaction.commit();

    CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaUpdate<User> criteriaUpdate = cb.createCriteriaUpdate(User.class);
    Root<User> root = criteriaUpdate.from(User.class);

    criteriaUpdate.set("email", "2345435");
    criteriaUpdate.where(cb.equal(root.get("id"), 10516));

    Transaction transaction = session.beginTransaction();
    session.createQuery(criteriaUpdate).executeUpdate();
    transaction.commit();

    session.close();// закрыть сессию

    HibernateUtil.close(); // закрыть Session Factory
  }
}
