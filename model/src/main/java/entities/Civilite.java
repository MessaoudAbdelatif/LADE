package entities;

public enum Civilite {
  MR("Mr"),
  MME("Mme"),
  MLLE("Mlle");

  private final String value;

  Civilite(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}