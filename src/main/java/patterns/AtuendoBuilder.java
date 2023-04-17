package patterns;

import domain.Atuendo;
import domain.Prenda;
import enums.CategoriaEnum;
import errors.AtuendoExcepcion;
import java.util.List;
import java.util.Random;

public class AtuendoBuilder {
  private Prenda accesorio;
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

  public AtuendoBuilder withPrendaSuperior(List<Prenda> prendas) {
      validatePrendasAreNotNullOrEmpty(prendas, CategoriaEnum.PARTE_SUPERIOR);
      this.prendaSuperior = prendas.get(getRandomIndex(prendas.size()));
      return this;
  }

  public AtuendoBuilder withPrendainferior(List<Prenda> prendas) {
    validatePrendasAreNotNullOrEmpty(prendas, CategoriaEnum.PARTE_INFERIOR);
    this.prendaInferior = prendas.get(getRandomIndex(prendas.size()));
    return this;
  }

  public AtuendoBuilder withCalzado(List<Prenda> prendas) {
    validatePrendasAreNotNullOrEmpty(prendas, CategoriaEnum.CALZADO);
    this.calzado = prendas.get(getRandomIndex(prendas.size()));
    return this;
  }

  public AtuendoBuilder withAccesorio(List<Prenda> prendas) {
    if (prendas != null && !prendas.isEmpty()) {
      this.accesorio = prendas.get(getRandomIndex(prendas.size()));
    }
    return this;
  }

  public Atuendo build() {
    return new Atuendo(accesorio, prendaSuperior, prendaInferior, calzado);
  }

  private void validatePrendasAreNotNullOrEmpty(List<Prenda> prendas, CategoriaEnum categoria) {
    if (prendas == null || prendas.isEmpty()) {
      throw AtuendoExcepcion.prendasOfCertainCategoryCannotBeEmptyOrNull(categoria.getName());
    }
  }

  private int getRandomIndex(int size) {
    Random random = new Random();
    return  random.nextInt(size);
  }

}
