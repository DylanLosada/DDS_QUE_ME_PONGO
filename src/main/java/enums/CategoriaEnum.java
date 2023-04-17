package enums;

public enum CategoriaEnum {
  PARTE_SUPERIOR("Parte Superior"),
  PARTE_INFERIOR("Parte Inferior"),
  CALZADO("Calzado"),
  ACCESORIO("Accesorios");

  private final String name;
  CategoriaEnum(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

}
