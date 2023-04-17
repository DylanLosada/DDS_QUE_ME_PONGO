package domain;

import enums.CategoriaEnum;
import enums.TipoPrendaEnum;
import errors.DomainException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UsuarieTest {
  private final Usuarie usuarie = new Usuarie();

  @Test
  void testLoadPrendaWithoutSomeRequiredFieldShoulFail() {
    DomainException exception = Assertions.assertThrows(DomainException.class,
        () -> usuarie.loadPrenda(TipoPrendaEnum.PANTALON, null, "Tela", "Verde", null));
    Assertions.assertEquals(exception.getMessage(), "No se ha podido cargar la Prenda dado que: "
        .concat("La Categoria es un campo obligatorio"));
  }

  @Test
  void testLoadPrendaWithAllRequiredFieldAndSameTipoPrendaAndCategoryShoulPass() {
    Assertions.assertDoesNotThrow(
        () -> usuarie.loadPrenda(TipoPrendaEnum.PANTALON, CategoriaEnum.PARTE_INFERIOR, "Tela", "Verde", null));
  }

  @Test
  void testLoadPrendaWithAllRequiredFieldAndSameTipoPrendaAndCategoryShoulPassWhenGetGuardarropaHasNewPrenda() {
    Prenda prenda = new Prenda(TipoPrendaEnum.PANTALON, CategoriaEnum.PARTE_INFERIOR, "Tela", "Verde", null);
    usuarie.loadPrenda(TipoPrendaEnum.PANTALON, CategoriaEnum.PARTE_INFERIOR, "Tela", "Verde", null);
    Assertions.assertTrue(prenda.equals(usuarie.getGuardarropa().get(CategoriaEnum.PARTE_INFERIOR).get(0)));
  }

}