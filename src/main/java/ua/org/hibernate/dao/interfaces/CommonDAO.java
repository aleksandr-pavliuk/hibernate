package ua.org.hibernate.dao.interfaces;

import java.util.List;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface CommonDAO<T> {

  T get(Long id);

  void update(T obj);

  void delete(Long id);

  void add(T obj);
}
