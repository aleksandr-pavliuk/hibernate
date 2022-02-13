package ua.org.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Entity
@Table(name = "category", schema = "todolist", catalog = "postgres")
@NoArgsConstructor
@Getter
@Setter
public class Category {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  private String title;

  @Column(name = "completed_count", updatable = false)
  private Long completedCount;

  @Column(name = "uncompleted_count", updatable = false)
  private Long uncompletedCount;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Category category = (Category) o;

    return id.equals(category.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Category{" +
        "id=" + id +
        ", title='" + title + '\'' +
        ", user=" + user +
        '}';
  }
}
