package ua.org.hibernate.dao.interfaces.objects;

import ua.org.hibernate.dao.interfaces.CommonDAO;
import ua.org.hibernate.dao.interfaces.FindDAO;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface UserDAO extends CommonDAO<User>, FindDAO<User> {

  User getByEmail(String email);
}
