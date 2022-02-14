package ua.org.hibernate.dao.interfaces.objects;

import ua.org.hibernate.entity.Stat;
import ua.org.hibernate.entity.User;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface StatDAO {

  Stat getByUser(String email);
  Stat getByUser(User user);
}
