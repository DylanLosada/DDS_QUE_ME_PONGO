package domain;

public class Atuendo {
  private final Prenda accesorio;
  private final Prenda prendaSuperior;
  private final Prenda prendaInferior;
  private final Prenda calzado;

  public Atuendo(Prenda accesorio, Prenda prendaSuperior, Prenda prendaInferior, Prenda calzado) {
    this.accesorio = accesorio;
    this.prendaSuperior = prendaSuperior;
    this.prendaInferior = prendaInferior;
    this.calzado = calzado;
  }

  public Prenda getAccesorio() {
    return accesorio;
  }

  public Prenda getPrendaSuperior() {
    return prendaSuperior;
  }

  public Prenda getPrendaInferior() {
    return prendaInferior;
  }

  public Prenda getCalzado() {
    return calzado;
  }

  @Override
  public boolean equals(Object obj) {
    Atuendo otroAtuendo = (Atuendo) obj;
    boolean isAccesorioEquals = false;

    if (this.accesorio != null && otroAtuendo.getAccesorio() != null) {
      isAccesorioEquals = this.accesorio.equals(otroAtuendo.getAccesorio());
    } else {
      isAccesorioEquals = (this.accesorio == null && otroAtuendo.getAccesorio() == null);
    }

    return this.prendaSuperior.equals(otroAtuendo.getPrendaSuperior())
        && this.prendaInferior.equals(otroAtuendo.getPrendaInferior())
        && isAccesorioEquals
        && this.calzado.equals(otroAtuendo.getCalzado());
  }

}
