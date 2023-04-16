package errors;

public class CampoObligatorioException extends RuntimeException{

  public static RuntimeException categoriaObligatoria() {
    return new RuntimeException("La Categoria es un campo obligatorio");
  }

  public static RuntimeException materialObligatorio() {
    return new RuntimeException("El Material es un campo obligatorio");
  }

  public static RuntimeException colorPrincipalObligatorio() {
    return new RuntimeException("El Color Principal es un campo obligatorio");
  }

  public static RuntimeException tipoPrendaObligatorio() {
    return new RuntimeException("El Tipo de Prenda es un campo obligatorio");
  }

}
