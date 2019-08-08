package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Longeur implements Serializable {
  @Id
  private String nom;
  private String nomVoie;
  private Cotation cotation;

}
