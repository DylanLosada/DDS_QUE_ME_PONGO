package errors;

public class CampoObligatorioException extends RuntimeException {
  private CampoObligatorioException(String message) {
    super(message);
  }

  public static RuntimeException categoriaObligatoria() {
    return new CampoObligatorioException("La Categoria es un campo obligatorio");
  }

  public static CampoObligatorioException materialObligatorio() {
    return new CampoObligatorioException("El Material es un campo obligatorio");
  }

  public static CampoObligatorioException colorPrincipalObligatorio() {
    return new CampoObligatorioException("El Color Principal es un campo obligatorio");
  }

  public static CampoObligatorioException tipoPrendaObligatorio() {
    return new CampoObligatorioException("El Tipo de Prenda es un campo obligatorio");
  }

  public static CampoObligatorioException tipoPrendaIsntEqualToCategoria() {
    return new CampoObligatorioException("La categoria seleccionada no coincide con la categoria de la prenda");
  }

}
