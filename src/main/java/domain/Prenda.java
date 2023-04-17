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

  public TipoPrendaEnum getTipo() {
    return tipo;
  }

  public String getMaterial() {
    return material;
  }

  public String getColorPrincipal() {
    return colorPrincipal;
  }

  public String getColorSecundario() {
    return colorSecundario;
  }

  @Override
  public boolean equals(Object obj) {
    Prenda otraPrenda = (Prenda) obj;
    boolean isTipoEquals = false;
    boolean isCategoryEquals = false;
    boolean isColorPrimarioEquals = false;
    boolean isColorSecundarioEquals = false;
    boolean isMaterialEquals = false;

    if (this.tipo != null && otraPrenda.getTipo() != null) {
      isTipoEquals = this.tipo.equals(otraPrenda.getTipo());
    } else {
      isTipoEquals = (this.tipo == null && otraPrenda.getTipo() == null);
    }

    if (this.categoria != null && otraPrenda.getCategoria() != null) {
      isCategoryEquals = this.categoria.equals(otraPrenda.getCategoria());
    } else {
      isCategoryEquals = (this.categoria == null && otraPrenda.getCategoria() == null);
    }

    if (this.colorPrincipal != null && otraPrenda.getColorPrincipal() != null) {
      isColorPrimarioEquals = this.colorPrincipal.equals(otraPrenda.getColorPrincipal());
    } else {
      isColorPrimarioEquals = (this.colorPrincipal == null && otraPrenda.getColorPrincipal() == null);
    }

    if (this.colorSecundario != null && otraPrenda.getColorSecundario() != null) {
      isColorSecundarioEquals = this.colorSecundario.equals(otraPrenda.getColorSecundario());
    } else {
      isColorSecundarioEquals = (this.colorSecundario == null && otraPrenda.getColorSecundario() == null);
    }

    if (this.material != null && otraPrenda.getMaterial() != null) {
      isMaterialEquals = this.material.equals(otraPrenda.getMaterial());
    } else {
      isMaterialEquals = (this.material == null && otraPrenda.getMaterial() == null);
    }

    return isTipoEquals && isCategoryEquals && isMaterialEquals && isColorPrimarioEquals && isColorSecundarioEquals;
  }

}
