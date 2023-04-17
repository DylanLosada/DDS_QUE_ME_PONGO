package errors;

public class DomainException extends RuntimeException {
  public DomainException(String message) {
    super(message);
  }

  public static DomainException cannotGeneratePrenda(String message) {
    return new DomainException("No se ha podido cargar la Prenda dado que: "
        .concat(message));
  }

  public static DomainException cannotGenerateAtuendoBecouseThereArentPrendas() {
    return new DomainException("No se ha podido generar un Atuendo dado que: "
        .concat("No existen prendas cargadas aun."));
  }

  public static DomainException cannotGenerateAtuendoBecouseThereIsntASpecificCategory(String message) {
    return new DomainException("No se ha podido generar un Atuendo dado que: "
        .concat(message));
  }

}
