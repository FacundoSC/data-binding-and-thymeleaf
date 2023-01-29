package com.bolsadeideas.form.app.controllers;

import com.bolsadeideas.form.app.editor.NombreMayusculaEditor;
import com.bolsadeideas.form.app.model.Pais;
import com.bolsadeideas.form.app.model.Usuario;
import com.bolsadeideas.form.app.services.PaisService;
import com.bolsadeideas.form.app.validation.UsuarioValidation;
import jakarta.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class FormController {
  @Autowired
  private UsuarioValidation validation;

  @Autowired
  private PaisService paisService;


  @InitBinder
  public void initBinder(WebDataBinder binder){
    binder.addValidators(validation);
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    dateFormat.setLenient(false);
    binder.registerCustomEditor(Date.class,"fechaNacimiento" ,new CustomDateEditor(dateFormat, true));
    binder.registerCustomEditor(String.class,"nombre" ,new NombreMayusculaEditor());
  }

  @ModelAttribute("paises")
  public List<String> paises(){
    return Arrays.asList("España","Mexico", "Argentina", "Chile");
  }


  @ModelAttribute("paisesMap")
  public Map<String, String> paisesMap() {
    Map<String, String> paises = new HashMap<String, String>();
    paises.put("ES", "España");
    paises.put("ARG", "Argentina");
    paises.put("MX", "Mexico");
    return paises;
  }

  @ModelAttribute("listaPaises")
  public List<Pais> listaPaises() {
    return paisService.listar();
  }


  @GetMapping("/form")
  public String form(Model model) {
    Usuario usuario = new Usuario();
    usuario.setApellido("Cordoba");
    usuario.setNombre("Facundo");
    model.addAttribute("titulo", "formulario de usuario");
    model.addAttribute("user", usuario);
    return "form";
  }

  @PostMapping("/resultado")
  public String procesorForm(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model, SessionStatus sessionStatus) {
    model.addAttribute("user", usuario);
    if (result.hasErrors()) {
      return "form";
    }
    sessionStatus.setComplete();
    return "resultado";
  }


/*
  @PostMapping("/resultado")
  public String procesorForm(Model model,
                             @RequestParam String username,
                             @RequestParam String password,
                             @RequestParam String email, @RequestParam Map<String, String> params) {

    Usuario usuario = new Usuario();
    usuario.setUsername(username);
    usuario.setPassword(password);
    usuario.setEmail(email);

    model.addAttribute("usuario", usuario);

    model.addAttribute("titulo", "resultado Form");
    model.addAttribute("username_1", username);
    model.addAttribute("password_1", password);
    model.addAttribute("email_1", email);
    model.addAllAttributes(params);
    return "resultado";
  }

*/
}
