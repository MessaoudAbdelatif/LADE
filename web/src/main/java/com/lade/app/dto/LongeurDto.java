package com.lade.app.dto;

import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LongeurDto {


  // __________Attributes____________
  protected Long id;
  @NotEmpty
  protected String nom;
  protected String voie;
  protected String cotation;

  // __________Constructor____________
  public LongeurDto(String voie) {
    this.voie = voie;
  }
}
