package com.bolsadeideas.form.app.controllers;

import com.bolsadeideas.form.app.model.Usuario;
import jakarta.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("user")
public class FormController {

  @GetMapping("/form")
  public String form(Model model) {
    Usuario usuario = new Usuario();
    usuario.setApellido("Cordoba");
    usuario.setNombre("Facundo");
    usuario.setIdentificador("134lLKG");
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
