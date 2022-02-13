package ua.org.hibernate.dao;

import java.util.List;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface CommonDAO<T> {

  List<T> findAll();

  List<T> findAll(String email);

  T get(Long id);

  void update(T obj);

  void delete(Long id);

  void add(T obj);
}
