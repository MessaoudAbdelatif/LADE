package entities;


import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String role;

  @ManyToMany(mappedBy = "roles")
  private List< UtilisateurConnecte > utilisateurConnectes;

  public Role() {
  }

  public Role(String role) {
    this.role = role;
  }
}
