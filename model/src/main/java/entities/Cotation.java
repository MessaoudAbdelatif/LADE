package entities;

public enum Cotation {

  A1A("3A") , A1B("3A+") , A1C("3B") , A1D("3B+") , A1E("3C") , A1F("3C+") ,
  B1A("4A") , B1B("4A+") , B1C("4B") , B1D("4B+") , B1E("4C") , B1F("4C+") ,
  C1A("5A") , C1B("5A+") , C1C("5B") , C1D("5B+") , C1E("5C") , C1F("5C+") ,
  D1A("6A") , D1B("6A+") , D1C("6B") , D1D("6B+") , D1E("6C") , D1F("6C+") ,
  E1A("7A") , E1B("7A+") , E1C("7B") , E1D("7B+") , E1E("7C") , E1F("7C+") ,
  F1A("8A") , F1B("8A+") , F1C("8B") , F1D("8B+") , F1E("8C") , F1F("8C+") ,
  G1A("9A") , G1B("9A+") , G1C("9B") , G1D("9B+") , G1E("9C") , G1F("9C+");

  private final String displayValue;

  Cotation(String displayValue) {
    this.displayValue = displayValue;
  }

  public String getDisplayValue() {
    return displayValue;
  }


}

