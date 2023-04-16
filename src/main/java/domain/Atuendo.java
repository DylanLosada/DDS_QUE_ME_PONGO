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

}
