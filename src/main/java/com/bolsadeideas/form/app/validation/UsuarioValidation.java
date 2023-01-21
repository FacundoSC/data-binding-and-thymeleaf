package com.bolsadeideas.form.app.validation;

import com.bolsadeideas.form.app.model.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UsuarioValidation implements Validator {
  @Override
  public boolean supports(Class<?> clazz) {
    return Usuario.class.isAssignableFrom(clazz);
  }

  @Override
  public void validate(Object target, Errors errors) {
    Usuario usuario = (Usuario) target;
    ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre","NotEmpty.user.nombre");
    if(!usuario.getIdentificador()
        .matches("[0-9]{2}[.][\\\\d]{3}[.][\\\\d]{3}[-][a-zA-Z]{1}")){
      errors.rejectValue("identificador", "Pattern.usuario.identificador");
    }


  }
}
