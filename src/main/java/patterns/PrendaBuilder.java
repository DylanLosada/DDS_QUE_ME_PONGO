package patterns;

import domain.Prenda;
import enums.CategoriaEnum;
import enums.TipoPrendaEnum;
import errors.CampoObligatorioException;

public class PrendaBuilder {
  private TipoPrendaEnum tipoPrenda;
  private CategoriaEnum categoria;
  private String material;
  private String colorPrincipal;
  private String colorSecundario;

  public PrendaBuilder withPrenda(TipoPrendaEnum prenda) {
    if (this.categoria != null && prenda != null && !this.categoria.equals(prenda.getCategoria())) {
      throw CampoObligatorioException.tipoPrendaIsntEqualToCategoria();
    }
    this.tipoPrenda = prenda;
    return this;
  }

  public PrendaBuilder withCategoria(CategoriaEnum categoria) {
    if (this.tipoPrenda != null && categoria != null && !this.tipoPrenda.getCategoria().equals(categoria)) {
      throw CampoObligatorioException.tipoPrendaIsntEqualToCategoria();
    }
    this.categoria = categoria;
    return this;
  }

  public PrendaBuilder withMaterial(String material) {
    this.material = material;
    return this;
  }

  public PrendaBuilder withColorPrincipal(String color) {
    this.colorPrincipal = color;
    return this;
  }

  public PrendaBuilder withColorSecundario(String color) {
    this.colorSecundario = color;
    return this;
  }

  public Prenda build() {
    validateAttributes();
    return new Prenda(this.tipoPrenda, this.categoria, this.material, this.colorPrincipal, this.colorSecundario);
  }

  private void validateAttributes() {
    if (this.tipoPrenda == null) {
      throw CampoObligatorioException.tipoPrendaObligatorio();
    }

    if (this.categoria == null) {
      throw CampoObligatorioException.categoriaObligatoria();
    }

    if (this.colorPrincipal == null) {
      throw CampoObligatorioException.colorPrincipalObligatorio();
    }

    if (this.material == null) {
      throw CampoObligatorioException.materialObligatorio();
    }
  }

}
