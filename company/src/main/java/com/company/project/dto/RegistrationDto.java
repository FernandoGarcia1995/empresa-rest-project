package com.company.project.dto;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import com.company.project.validators.FieldMatch;
import com.fasterxml.jackson.annotation.JsonFormat;

@FieldMatch(first = "password", second = "confirmPassword")
public class RegistrationDto {
	
	//user
    @NotNull(message = "El username no puede estar vacio")
    private String username;

    @NotNull(message = "El email no puede estar vacio")
    @Email(message = "Por favor , escribe un email valido")
    private String email;

    @NotNull(message = "La contrasenha no puede estar vacia")
    @Length(min = 7, message = "La contrasenha tiene que tener al menos 7 caracteres")
    private String password;
        
    @NotNull(message = "La contrasenha no puede estar vacia")
    @Length(min = 7, message = "La contrasenha tiene que tener al menos 7 caracteres")
    private String confirmPassword;
        
    //empleado
    @NotNull(message = "el nombre no puede estar vacio")
    private String nombre;

    @NotNull(message = "el apellido no puede estar vacio")
    private String apellido;
    
    @NotNull(message = "La fecha nacimiento no puede estar vacia")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private Date fechaNacimiento;

    @NotNull(message = "La direccion no puede estar vacia")
    private String direccion;

    @NotNull(message = "el telefono no puede estar vacio")
    private String telefono;

    @NotNull(message = "el salario no puede estar vacio")
    private Integer salario;
    
    @NotNull(message = "el dni no puede estar vacio")
    private String dni;
    
    //departamento
    @NotNull(message = "el nombre del departamento no puede estar vacio")
    private String departamento;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Integer getSalario() {
		return salario;
	}

	public void setSalario(Integer salario) {
		this.salario = salario;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	
}
