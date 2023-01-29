package com.bolsadeideas.form.app.services;

import com.bolsadeideas.form.app.model.Pais;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class PaisServiceImpl  implements  PaisService {

  private List<Pais> listar;
  public PaisServiceImpl() {
    listar =   Arrays.asList( new Pais(1, "ES", "España"),
                     new Pais(2,"MX","Mexico"),
                      new Pais(3,"ARG", "Argentina"));
  }

  @Override
  public List<Pais> listar() {
    return listar;
  }

  @Override
  public Pais ObtenerPorId(Integer id) {
    return listar.stream()
        .filter(pais -> pais.getId().equals(id)).findFirst().orElse(null);
  }
}
