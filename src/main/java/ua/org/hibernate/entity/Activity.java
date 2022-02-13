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
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class Activity {


  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;

  @Type(type = "org.hibernate.type.NumericBooleanType")
  private boolean activated;

  @Column(updatable = false)
  private String uuid;

  @Column(name = "uncompleted_count", updatable = false)
  private long uncompletedCount;

  @OneToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

}
