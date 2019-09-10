package com.lade.app.dto;

import entities.Longeur;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class VoieDto {

  // __________Attributes____________
  private Long id;
  @NotEmpty
  private String nom;
  private String secteur;
  private String descreption;
  private String cotation;
  private List<Longeur> longeurs;


  // __________Constructor____________
  public VoieDto(String secteur) {
    this.secteur = secteur;
  }
}
