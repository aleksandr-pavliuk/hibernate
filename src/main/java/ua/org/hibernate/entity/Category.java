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
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class Category {

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Id
  private long id;

  private long title;

  @Column(name = "completed_count", updatable = false)
  private long completedCount;

  @Column(name = "uncompleted_count", updatable = false)
  private long uncompletedCount;

  @ManyToOne
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;

}
