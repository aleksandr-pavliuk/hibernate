package ua.org.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
@Table(name = "stat", schema = "todolist", catalog = "postgres")
@NoArgsConstructor
@Getter
@Setter
public class Stat {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Column(name = "completed_total", updatable = false)
  private Long completedTotal;

  @Column(name = "uncompleted_total", updatable = false)
  private Long uncompletedTotal;

  @OneToOne
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

    Stat stat = (Stat) o;

    return id.equals(stat.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Stat{" +
        "id=" + id +
        ", user=" + user +
        '}';
  }
}
