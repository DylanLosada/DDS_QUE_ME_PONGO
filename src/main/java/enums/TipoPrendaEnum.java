package enums;

public enum TipoPrendaEnum {
  ZAPATO(CategoriaEnum.CALZADO),
  CAMISA_MANGA_CORTA(CategoriaEnum.PARTE_SUPERIOR),
  PANTALON(CategoriaEnum.PARTE_INFERIOR),
  LENTES_SOL(CategoriaEnum.ACCESORIO);

  private final CategoriaEnum categoria;

  TipoPrendaEnum(CategoriaEnum categoria) {
    this.categoria = categoria;
  }

  public CategoriaEnum getCategoria() {
    return this.categoria;
  }

}
