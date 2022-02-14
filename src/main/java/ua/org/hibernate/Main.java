package ua.org.hibernate;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaUpdate;
import jakarta.persistence.criteria.Root;
import java.util.Date;
import lombok.extern.log4j.Log4j2;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.org.hibernate.dao.impl.CategoryDAOImpl;
import ua.org.hibernate.dao.impl.PriorityDAOImpl;
import ua.org.hibernate.dao.impl.StatDAOImpl;
import ua.org.hibernate.dao.impl.TaskDAOImpl;
import ua.org.hibernate.dao.impl.UserDAOImpl;
import ua.org.hibernate.entity.Category;
import ua.org.hibernate.entity.Priority;
import ua.org.hibernate.entity.Role;
import ua.org.hibernate.entity.Stat;
import ua.org.hibernate.entity.Task;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Log4j2
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
    HibernateUtil.close();

    //сразу получаем готовый SessionFactory и сразу создаем сессию
    Session session = HibernateUtil.getSessionFactory().openSession();*/

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

   /* CriteriaBuilder cb = session.getCriteriaBuilder();
    CriteriaUpdate<User> criteriaUpdate = cb.createCriteriaUpdate(User.class);
    Root<User> root = criteriaUpdate.from(User.class);

    criteriaUpdate.set("email", "2345435");
    criteriaUpdate.where(cb.equal(root.get("id"), 10516));

    Transaction transaction = session.beginTransaction();
    session.createQuery(criteriaUpdate).executeUpdate();
    transaction.commit();

    session.close();// закрыть сессию

    HibernateUtil.close(); // закрыть Session Factory*/
    log.info("Hibernate tutorial started");

    //сразу получаем готовый SessionFactory и сразу создаем сессию
//    Session session = HibernateUtil.getSessionFactory().openSession();
    //        User user = new User();
//        user.setUsername("testuser");
//        user.setPassword("testuser");
//        user.setEmail("testuser@gmail.com");
//
//        UserDAOImpl userDAO = new UserDAOImpl();
//        userDAO.add(user);
//
//        // активируем пользователя (поле activated)
//        ActivityDAOImpl activityDAO = new ActivityDAOImpl();
//        Activity activity = activityDAO.getByUser(user);
//        activity.setActivated(true);
//        activityDAO.update(activity);

    UserDAOImpl userDAO = new UserDAOImpl();

    User user = userDAO.get(10025L);


    // создаем справочные значения
    PriorityDAOImpl priorityDAO = new PriorityDAOImpl();

    Priority priority = new Priority();
    priority.setColor("#fff");
    priority.setTitle("Новый приоритет");
    priority.setUser(user);
    priorityDAO.add(priority);

    CategoryDAOImpl categoryDAO = new CategoryDAOImpl();

    Category category = new Category();
    category.setTitle("Новая категория");
    category.setUser(user);
    categoryDAO.add(category);

    TaskDAOImpl taskDAO = new TaskDAOImpl();

    Task task = new Task();
    task.setUser(user);
    task.setTitle("Супер новая задача222");
    task.setCategory(category);
    task.setPriority(priority);
    task.setTaskDate(new Date());
    task.setCompleted(false);
    taskDAO.add(task);

    task.setCompleted(true);
    taskDAO.update(task);

    taskDAO.delete(task.getId());

    StatDAOImpl statDAO = new StatDAOImpl();
    Stat stat = statDAO.getByUser(user);

    log.info(stat.getCompletedTotal());

    log.info(category.getCompletedCount());

    HibernateUtil.close();
  }
}
