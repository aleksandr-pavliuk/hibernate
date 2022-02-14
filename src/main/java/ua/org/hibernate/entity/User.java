package ua.org.hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String email;

  @Column(name = "userpassword", nullable = false, length = -1)
  private String password;

  private String username;

  @ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
  private Set<Role> roles = new HashSet<>();

//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  private List<Task> tasks;
//
//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  private List<Category> categories;
//
//  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
//  private List<Category> priorities;
//
//  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
//  private Activity activity;
//
//  @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
//  private Stat stat;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    User user = (User) o;

    return id.equals(user.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", email='" + email + '\'' +
        ", username='" + username + '\'' +
        '}';
  }
}
