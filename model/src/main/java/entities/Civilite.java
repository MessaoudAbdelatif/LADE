package entities;

public enum Civilite {
  MR("Mr"),
  MME("Mme"),
  MLLE("Mlle");
  private final String name;

  Civilite(String name) {
    this.name = name;
  }
}
