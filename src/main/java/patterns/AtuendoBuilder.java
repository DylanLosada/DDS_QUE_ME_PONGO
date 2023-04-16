package patterns;

import domain.Atuendo;
import domain.Prenda;

public class AtuendoBuilder {
  private Prenda accesorio;
  private Prenda prendaSuperior;
  private Prenda prendaInferior;
  private Prenda calzado;

//  public AtuendoBuilder withPrendaSuperior(List<Prenda> prendas) {
//      if (prendas != null) {
//        this.prendaSuperior = prendas.
//      }
//  }

  public Atuendo build() {
    return new Atuendo(accesorio, prendaSuperior, prendaInferior, calzado);
  }

}
