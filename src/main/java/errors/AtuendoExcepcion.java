package errors;

public class AtuendoExcepcion extends RuntimeException {
  private AtuendoExcepcion(String message) {
    super(message);
  }

  public static AtuendoExcepcion prendasOfCertainCategoryCannotBeEmptyOrNull(String category) {
    return new AtuendoExcepcion("No hay prendas de la Categoria " + category + ", por lo que no se puede confeccionar un conjunto");
  }

}
