package com.bolsadeideas.form.app.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class IdentificadorRegexValidador implements ConstraintValidator<IdentificadorRegex, String> {
  @Override
  public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
    return value.matches("[0-9]{2}[.][\\\\d]{3}[.][\\\\d]{3}[-][a-zA-Z]{1}");
  }
}
