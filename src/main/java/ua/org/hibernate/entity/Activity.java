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
import org.hibernate.annotations.Type;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Entity
@Table(name = "activity", schema = "todolist", catalog = "postgres")
@NoArgsConstructor
@Getter
@Setter
public class Activity {


  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private Long id;

  @Type(type = "org.hibernate.type.NumericBooleanType")
  private boolean activated;

  @Column(updatable = false)
  private String uuid;

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

    Activity activity = (Activity) o;

    return id.equals(activity.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "Activity{" +
        "id=" + id +
        ", uuid='" + uuid + '\'' +
        ", user=" + user +
        '}';
  }
}
