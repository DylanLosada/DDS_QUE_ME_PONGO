package domain;

import enums.CategoriaEnum;
import enums.TipoPrendaEnum;

public class Prenda {
  private final TipoPrendaEnum tipo;
  private final CategoriaEnum categoria;
  private final String material;
  private final String colorPrincipal;
  private final String colorSecundario;

  public Prenda(TipoPrendaEnum tipo, CategoriaEnum categoria, String material, String colorPrincipal, String colorSecundario) {
    this.tipo = tipo;
    this.categoria = categoria;
    this.material = material;
    this.colorPrincipal = colorPrincipal;
    this.colorSecundario = colorSecundario;
  }

  public CategoriaEnum getCategoria() {
    return categoria;
  }

}
