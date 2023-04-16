package domain;

import enums.CategoriaEnum;
import enums.TipoPrendaEnum;
import errors.CampoObligatorioException;
import errors.DomainException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import patterns.AtuendoBuilder;
import patterns.PrendaBuilder;

public class Usuarie {
  private HashMap<CategoriaEnum, List<Prenda>> guardarropa;

  public void loadPrenda(TipoPrendaEnum tipo, CategoriaEnum categoria, String material, String colorPrincipal, String colorSecundario) {
    Prenda loadedPrenda;
    try {
      loadedPrenda = new PrendaBuilder()
          .withPrenda(tipo)
          .withCategoria(categoria)
          .withMaterial(material)
          .withColorPrincipal(colorPrincipal)
          .withColorSecundario(colorSecundario)
          .build();
    } catch (CampoObligatorioException exception) {
      throw DomainException.cannotGeneratePrenda(exception.getMessage());
    }
    loadPrenda(loadedPrenda);
  }

  public Atuendo generateAtuendo() {
    validateThereArePrendas();
    return new AtuendoBuilder().build();
  }

  private void validateThereArePrendas() {
    if (guardarropa.isEmpty()) {
      throw DomainException.cannotGenerateAtuendo();
    }
  }

  private void loadPrenda(Prenda prenda) {
    CategoriaEnum categoria = prenda.getCategoria();
    if (guardarropa.containsKey(categoria)) {
      List<Prenda> prendas = guardarropa.get(categoria);
      prendas.add(prenda);
    } else {
      guardarropa.put(categoria, Collections.singletonList(prenda));
    }
  }

}
