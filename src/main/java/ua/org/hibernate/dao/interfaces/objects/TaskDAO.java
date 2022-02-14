package ua.org.hibernate.dao.interfaces.objects;

import java.util.List;
import ua.org.hibernate.dao.interfaces.CommonDAO;
import ua.org.hibernate.dao.interfaces.FindDAO;
import ua.org.hibernate.entity.Task;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
public interface TaskDAO extends CommonDAO<Task>, FindDAO<Task> {

  List<Task> find(boolean completed, String email);
}
