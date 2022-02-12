package ua.org.hibernate.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alex
 * @link http://healthfood.net.ua
 */
@Entity
@Table(name = "user_data", schema = "todolist", catalog = "postgres")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

  @Basic
  @Column(name = "email", nullable = false, length = -1)
  private String email;

  @Basic
  @Column(name = "userpassword", nullable = false, length = -1)
  private String userpassword;

  @Basic
  @Column(name = "username", nullable = false, length = -1)
  private String username;

  @Id
  @Column(name = "id", nullable = false)
  private Long id;

}
