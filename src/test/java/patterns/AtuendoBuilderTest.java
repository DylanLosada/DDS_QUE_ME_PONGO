package patterns;

import domain.Atuendo;
import domain.Prenda;
import enums.CategoriaEnum;
import enums.TipoPrendaEnum;
import errors.AtuendoExcepcion;
import java.util.ArrayList;
import java.util.Collections;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AtuendoBuilderTest {

  private AtuendoBuilder builder;

  @BeforeEach
  void setUp() {
    builder = new AtuendoBuilder();
  }

  @Test
  void testBuilAtuendoWithoutPrendaSuperiorShouldFail() {
    AtuendoExcepcion exception = Assertions.assertThrows(AtuendoExcepcion.class,
        () -> builder
            .withPrendaSuperior(new ArrayList<>()));
    Assertions.assertEquals(exception.getMessage(), getErrorMessage(CategoriaEnum.PARTE_SUPERIOR));
  }

  @Test
  void testBuilAtuendoWithoutPrendaInferiorShouldFail() {
    AtuendoExcepcion exception = Assertions.assertThrows(AtuendoExcepcion.class,
        () -> builder
            .withPrendainferior(new ArrayList<>()));
    Assertions.assertEquals(exception.getMessage(), getErrorMessage(CategoriaEnum.PARTE_INFERIOR));
  }

  @Test
  void testBuilAtuendoWithoutCalzadoShouldFail() {
    AtuendoExcepcion exception = Assertions.assertThrows(AtuendoExcepcion.class,
        () -> builder
            .withCalzado(new ArrayList<>()));
    Assertions.assertEquals(exception.getMessage(), getErrorMessage(CategoriaEnum.CALZADO));
  }

  @Test
  void testBuilAtuendoWithoutAccesoriosShouldPass() {
    Assertions.assertDoesNotThrow(
        () -> builder
            .withAccesorio(new ArrayList<>()));
  }

  @Test
  void testBuilAtuendoWithAllRequiredCategoriesAndAccesoriosShouldPass() {
    Prenda pantalon = new Prenda(TipoPrendaEnum.PANTALON,CategoriaEnum.PARTE_INFERIOR, "Verde", "Tela", null);
    Prenda remera = new Prenda(TipoPrendaEnum.CAMISA_MANGA_CORTA,CategoriaEnum.PARTE_SUPERIOR, "Verde", "Tela", null);
    Prenda zapato = new Prenda(TipoPrendaEnum.ZAPATO ,CategoriaEnum.CALZADO, "Verde", "Tela", null);
    Prenda lentes = new Prenda(TipoPrendaEnum.LENTES_SOL,CategoriaEnum.ACCESORIO, "Verde", "plastico", null);
    Atuendo unAtuendo = new Atuendo(lentes, remera, pantalon, zapato);
    Atuendo otroAtuendo = builder
        .withPrendaSuperior(Collections.singletonList(remera))
        .withPrendainferior(Collections.singletonList(pantalon))
        .withCalzado(Collections.singletonList(zapato))
        .withAccesorio(Collections.singletonList(lentes))
        .build();
    Assertions.assertTrue(unAtuendo.equals(otroAtuendo));
  }

  @Test
  void testBuilAtuendoWithAllRequiredCategoriesShouldPass() {
    Prenda pantalon = new Prenda(TipoPrendaEnum.PANTALON,CategoriaEnum.PARTE_INFERIOR, "Verde", "Tela", null);
    Prenda remera = new Prenda(TipoPrendaEnum.CAMISA_MANGA_CORTA,CategoriaEnum.PARTE_SUPERIOR, "Verde", "Tela", null);
    Prenda zapato = new Prenda(TipoPrendaEnum.ZAPATO ,CategoriaEnum.CALZADO, "Verde", "Tela", null);
    Atuendo unAtuendo = new Atuendo(null, remera, pantalon, zapato);
    Atuendo otroAtuendo = builder
        .withPrendaSuperior(Collections.singletonList(remera))
        .withPrendainferior(Collections.singletonList(pantalon))
        .withCalzado(Collections.singletonList(zapato))
        .withAccesorio(new ArrayList<>())
        .build();
    Assertions.assertTrue(unAtuendo.equals(otroAtuendo));
  }

  private String getErrorMessage(CategoriaEnum categoriaEnum) {
    return "No hay prendas de la Categoria " + categoriaEnum.getName() + ", por lo que no se puede confeccionar un conjunto";
  }

}