package ua.org.hibernate.dao.interfaces;

import java.util.List;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface FindDAO<T> {

  List<T> findAll();

  List<T> findAll(String email);

}
