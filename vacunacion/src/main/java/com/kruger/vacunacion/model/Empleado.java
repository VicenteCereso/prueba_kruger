package com.kruger.vacunacion.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_empleado;

	@JoinColumn(name = "id_usuario")
	private Usuario id_usuario;

	@Column(name = "cedula", nullable = false)
	private String cedula;

	@Column(name = "nombres", nullable = false)
	private String nombres;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "correo_electronico", nullable = false)
	private String correo_electronico;

	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name = "fecha_nacimiento", nullable = true)
	private Date fecha_nacimiento;

	@Column(name = "direccion_domicilio")
	private String direccion_domicilio;

	@Column(name = "telefono_movil")
	private String telefono_movil;

	public long getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(long id_empleado) {
		this.id_empleado = id_empleado;
	}

	public Usuario getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Usuario id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo_electronico() {
		return correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		this.correo_electronico = correo_electronico;
	}

	public Date getFecha_nacimiento() {
		return fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}

	public String getDireccion_domicilio() {
		return direccion_domicilio;
	}

	public void setDireccion_domicilio(String direccion_domicilio) {
		this.direccion_domicilio = direccion_domicilio;
	}

	public String getTelefono_movil() {
		return telefono_movil;
	}

	public void setTelefono_movil(String telefono_movil) {
		this.telefono_movil = telefono_movil;
	}

	public Empleado() {
	}

	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", id_usuario=" + id_usuario + ", cedula=" + cedula
				+ ", nombres=" + nombres + ", apellidos=" + apellidos + ", correo_electronico=" + correo_electronico
				+ ", fecha_nacimiento=" + fecha_nacimiento + ", direccion_domicilio=" + direccion_domicilio
				+ ", telefono_movil=" + telefono_movil + "]";
	}


}
