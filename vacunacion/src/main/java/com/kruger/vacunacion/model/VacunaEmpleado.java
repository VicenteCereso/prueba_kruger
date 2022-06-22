package com.kruger.vacunacion.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="vacuna_empleado")
public class VacunaEmpleado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id_vacuna_empleado;
	
	@JsonBackReference
	@ManyToOne
	@JoinColumn(name="usuario")
	private Usuario usuario;
	@Column(name="estado")
	private boolean estado;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	@Column(name="fecha_vacuna")
	private Date fecha_vacuna;
	@Column(name="numero_dosis")
	private int numero_dosis;
	@Column(name="tipo_vacuna")
	private String tipo_vacuna;
	
	
	public long getId_vacuna_empleado() {
		return id_vacuna_empleado;
	}
	public void setId_vacuna_empleado(long id_vacuna_empleado) {
		this.id_vacuna_empleado = id_vacuna_empleado;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	
	public Date getFecha_vacuna() {
		return fecha_vacuna;
	}
	public void setFecha_vacuna(Date fecha_vacuna) {
		this.fecha_vacuna = fecha_vacuna;
	}
	public int getNumero_dosis() {
		return numero_dosis;
	}
	public void setNumero_dosis(int numero_dosis) {
		this.numero_dosis = numero_dosis;
	}
	public String getTipo_vacuna() {
		return tipo_vacuna;
	}
	public void setTipo_vacuna(String tipo_vacuna) {
		this.tipo_vacuna = tipo_vacuna;
	}
	@Override
	public String toString() {
		return "VacunaEmpleado [id_vacuna_empleado=" + id_vacuna_empleado + ", usuario=" + usuario + ", estado="
				+ estado + ", fecha_vacuna=" + fecha_vacuna + ", numero_dosis=" + numero_dosis + ", tipo_vacuna="
				+ tipo_vacuna + "]";
	}
	

	
	
}
