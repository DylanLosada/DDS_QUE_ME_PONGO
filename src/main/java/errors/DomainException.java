package errors;

public class DomainException extends RuntimeException {

  public static RuntimeException cannotGeneratePrenda(String message) {
    return new RuntimeException("No se ha podido cargar la Prenda dado que: "
        .concat(message));
  }

  public static RuntimeException cannotGenerateAtuendo() {
    return new RuntimeException("No se ha podido generar un Atuendo dado que: "
        .concat("No existen prendas cargadas aun."));
  }

}
