package com.bolsadeideas.form.app.model;

import com.bolsadeideas.form.app.validation.IdentificadorRegex;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public class Usuario {

 // @Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][a-zA-Z]{1}")
  @IdentificadorRegex
  private String  identificador;

  private String nombre;
 // @NotEmpty
 private String apellido;
  @NotBlank
  @Size(min = 3, max = 8)
  private String username;
  //@NotEmpty
  private String password;
  //@NotEmpty
  //@Email
  private String email;

  @NotNull
  @Min(5)
  @Max(5000)
  private Integer cuenta;



  @NotEmpty
  private String pais;

  public String getPais() {
    return pais;
  }

  public void setPais(String pais) {
    this.pais = pais;
  }
  @NotNull
 // @Past
 // @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date fechaNacimiento;

  public Date getFechaNacimiento() {
    return fechaNacimiento;
  }

  public void setFechaNacimiento(Date fechaNacimiento) {
    this.fechaNacimiento = fechaNacimiento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getApellido() {
    return apellido;
  }

  public void setApellido(String apellido) {
    this.apellido = apellido;
  }

  public String getIdentificador() {
    return identificador;
  }

  public void setIdentificador(String identificador) {
    this.identificador = identificador;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  public Integer getCuenta() {
    return cuenta;
  }

  public void setCuenta(Integer cuenta) {
    this.cuenta = cuenta;
  }
}
