package com.bolsadeideas.form.app.services;

import com.bolsadeideas.form.app.model.Pais;
import java.util.List;

public interface PaisService {
   List<Pais> listar();
   Pais ObtenerPorId(Integer id);
}
