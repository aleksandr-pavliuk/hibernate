package ua.org.hibernate.dao.interfaces.objects;

import ua.org.hibernate.dao.interfaces.CommonDAO;
import ua.org.hibernate.entity.Activity;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface ActivityDAO extends CommonDAO<Activity> {

  Activity getByUser(String email);
  Activity getByUser(User user);

}
