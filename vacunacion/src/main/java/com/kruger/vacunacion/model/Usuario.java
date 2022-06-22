package com.kruger.vacunacion.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column
	private String usuario;
	@ManyToOne
	@JoinColumn(name="id_rol")
	private Roles rol;
	@Column(name = "password")
	private String password;
	@JsonManagedReference 
	@JoinColumn(name="vacuna_empleado")
	private VacunaEmpleado vacunaEmpleado;

	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public Roles getRol() {
		return rol;
	}
	public void setRol(Roles rol) {
		this.rol = rol;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public VacunaEmpleado getVacunaEmpleado() {
		return vacunaEmpleado;
	}
	public void setVacunaEmpleado(VacunaEmpleado vacunaEmpleado) {
		this.vacunaEmpleado = vacunaEmpleado;
	}
	@Override
	public String toString() {
		return "Usuario [usuario=" + usuario + ", rol=" + rol + ", password=" + password + ", vacunaEmpleado="
				+ vacunaEmpleado + "]";
	}
	
	
}
