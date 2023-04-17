package patterns;

import enums.CategoriaEnum;
import enums.TipoPrendaEnum;
import errors.CampoObligatorioException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PrendaBuilderTest {
  private final String MATERIAL_GENERIC = "Tela de algodon";
  private final String MAIN_COLOR = "Verde";

  private PrendaBuilder builder;

  @BeforeEach
  void setUp() {
    builder = new PrendaBuilder();
  }

  @Test
  void testBuilPrendaWithPrendaCategoryNotEqualToCategory() {
    PrendaBuilder prendaBuilder = builder
        .withPrenda(TipoPrendaEnum.PANTALON);
    CampoObligatorioException exception = Assertions.assertThrows(CampoObligatorioException.class,
        () -> prendaBuilder.withCategoria(CategoriaEnum.CALZADO));
    Assertions.assertEquals(exception.getMessage(), "La categoria seleccionada no coincide con la categoria de la prenda");
  }

  @Test
  void testBuilPrendaWithCategoryNotEqualToPrendaCategory() {
    PrendaBuilder prendaBuilder = builder
        .withCategoria(CategoriaEnum.CALZADO);
    CampoObligatorioException exception = Assertions.assertThrows(CampoObligatorioException.class,
        () -> prendaBuilder.withPrenda(TipoPrendaEnum.PANTALON));
    Assertions.assertEquals(exception.getMessage(), "La categoria seleccionada no coincide con la categoria de la prenda");
  }

  @Test
  void testBuilPrendaWithOutCategoryShouldFail() {
    PrendaBuilder prendaBuilder = builder
        .withPrenda(TipoPrendaEnum.PANTALON)
        .withColorPrincipal(MAIN_COLOR)
        .withMaterial(MATERIAL_GENERIC);
    CampoObligatorioException exception = Assertions.assertThrows(CampoObligatorioException.class,
        prendaBuilder::build);
    Assertions.assertEquals(exception.getMessage(), "La Categoria es un campo obligatorio");
  }

  @Test
  void testBuilPrendaWithOutPrendaShouldFail() {
    PrendaBuilder prendaBuilder = builder
        .withCategoria(CategoriaEnum.CALZADO)
        .withColorPrincipal(MAIN_COLOR)
        .withMaterial(MATERIAL_GENERIC);
    CampoObligatorioException exception = Assertions.assertThrows(CampoObligatorioException.class,
        prendaBuilder::build);
    Assertions.assertEquals(exception.getMessage(), "El Tipo de Prenda es un campo obligatorio");
  }

  @Test
  void testBuilPrendaWithOutColorPrincipalShouldFail() {
    PrendaBuilder prendaBuilder = builder
        .withCategoria(CategoriaEnum.CALZADO)
        .withPrenda(TipoPrendaEnum.ZAPATO)
        .withMaterial(MATERIAL_GENERIC);
    CampoObligatorioException exception = Assertions.assertThrows(CampoObligatorioException.class,
        prendaBuilder::build);
    Assertions.assertEquals(exception.getMessage(), "El Color Principal es un campo obligatorio");
  }

  @Test
  void testBuilPrendaWithOutMaterialShouldFail() {
    PrendaBuilder prendaBuilder = builder
        .withCategoria(CategoriaEnum.CALZADO)
        .withColorPrincipal(MAIN_COLOR)
        .withPrenda(TipoPrendaEnum.ZAPATO);
    CampoObligatorioException exception = Assertions.assertThrows(CampoObligatorioException.class,
        prendaBuilder::build);
    Assertions.assertEquals(exception.getMessage(), "El Material es un campo obligatorio");
  }

  @Test
  void testBuilPrendaWithAllRequiredFieldsShouldPass() {
    PrendaBuilder prendaBuilder = builder
        .withPrenda(TipoPrendaEnum.PANTALON)
        .withCategoria(CategoriaEnum.PARTE_INFERIOR)
        .withColorPrincipal(MAIN_COLOR)
        .withMaterial(MATERIAL_GENERIC);
    Assertions.assertDoesNotThrow(prendaBuilder::build);
  }

}