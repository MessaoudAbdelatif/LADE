package com.lade.app.dto.impl;

import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LongeurDto {


  // __________Attributes____________
  protected Long id;
  @NotEmpty
  protected String nom;
  protected String voie;
  protected String cotation;

}
