package com.lade.app.dto.impl;

import entities.Longeur;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class VoieDto {

  // __________Attributes____________
  private Long id;
  @NotEmpty
  private String nom;
  private String secteur;
  private String description;
  private String cotation;
  private List<Longeur> longeurs;
}
