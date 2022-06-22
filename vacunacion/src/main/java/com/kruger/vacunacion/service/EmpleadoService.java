package com.kruger.vacunacion.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kruger.vacunacion.Utils.Utils;
import com.kruger.vacunacion.model.Empleado;
import com.kruger.vacunacion.model.Roles;
import com.kruger.vacunacion.model.Usuario;
import com.kruger.vacunacion.model.VacunaEmpleado;
import com.kruger.vacunacion.repository.EmpleadoRepository;
import com.kruger.vacunacion.repository.UsuarioRepository;
import com.kruger.vacunacion.repository.VacunaRepository;

@Service
public class EmpleadoService {

	private List<Empleado> empleados = new ArrayList<>();

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private VacunaRepository vacunaRepository;
	

	public List<Empleado> consultarEmpleados() {
		List<Empleado> lista = empleadoRepository.findAll();
		return lista;
	}

	public Object crearUsuario(Empleado empleado) {
		Usuario usuario = new Usuario();
		Roles rol = new Roles();
		
		if (empleado != null) {			
			rol.setId_rol(2);
			usuario.setUsuario(empleado.getCedula());
			usuario.setPassword(empleado.getCedula());
			usuario.setRol(rol);
			usuarioRepository.save(usuario);
			Empleado empleadoService = new Empleado();

			if (Utils.contieneSoloLetras(empleado.getApellidos())) {
				empleadoService.setApellidos(empleado.getApellidos());
			} else {
				return "Apellidos solo acepta letras, sin caracteres especiales";
			}

			if (Utils.validaCedula(empleado.getCedula())) {
				empleadoService.setCedula(empleado.getCedula());

			} else {
				return "Cedula Invalida";
			}
			if (Utils.contieneSoloLetras(empleado.getNombres())) {
				empleadoService.setNombres(empleado.getNombres());
			} else {
				return "Nombres solo acepta letras, sin caracteres especiales";
			}

			if (Utils.validarCorreo(empleado.getCorreo_electronico())) {
				empleadoService.setCorreo_electronico(empleado.getCorreo_electronico());
			} else {
				return "Ingrese correo valido";
			}
			empleadoService.setId_usuario(usuario);
			empleadoRepository.save(empleadoService);
		}
		
		return usuario;

	}

	public Object actualizarEmpleado(Empleado empleadoRequest) {
		VacunaEmpleado vacuna = new VacunaEmpleado();
		Empleado empleado = new Empleado();
		empleados = empleadoRepository.findAll();
		empleado = empleados.stream()
				.filter(currentUser -> currentUser.getId_empleado() == empleadoRequest.getId_empleado()).findFirst()
				.orElseThrow(() -> new RuntimeException("No existe el empleado"));

		if (empleadoRequest != null) {
			if (empleadoRequest.getId_usuario().getVacunaEmpleado().isEstado()) {
				vacuna.setTipo_vacuna(empleadoRequest.getId_usuario().getVacunaEmpleado().getTipo_vacuna());
				vacuna.setFecha_vacuna(java.sql.Date.valueOf(
						String.valueOf(empleadoRequest.getId_usuario().getVacunaEmpleado().getFecha_vacuna())));
				vacuna.setNumero_dosis(empleadoRequest.getId_usuario().getVacunaEmpleado().getNumero_dosis());
				vacuna.setEstado(empleadoRequest.getId_usuario().getVacunaEmpleado().isEstado());
				vacuna.setUsuario(empleado.getId_usuario());
				vacunaRepository.save(vacuna);
			}else {
				vacuna.setTipo_vacuna("");
				vacuna.setFecha_vacuna(null);
				vacuna.setEstado(!empleadoRequest.getId_usuario().getVacunaEmpleado().isEstado());
				vacuna.setUsuario(empleado.getId_usuario());
				vacunaRepository.save(vacuna);
			}

			if (Utils.contieneSoloLetras(empleado.getApellidos())) {
				empleado.setApellidos(empleado.getApellidos());
			}

			if (Utils.validaCedula(empleado.getCedula())) {
				empleado.setCedula(empleado.getCedula());
			}
			if (Utils.contieneSoloLetras(empleado.getNombres())) {
				empleado.setNombres(empleado.getNombres());
			}

			if (Utils.validarCorreo(empleado.getCorreo_electronico())) {
				empleado.setCorreo_electronico(empleado.getCorreo_electronico());
			}
			empleado.setFecha_nacimiento(java.sql.Date.valueOf(String.valueOf(empleadoRequest.getFecha_nacimiento())));
			empleado.setDireccion_domicilio(empleadoRequest.getDireccion_domicilio());
			empleado.setTelefono_movil(empleadoRequest.getTelefono_movil());
			empleado.getId_usuario().setVacunaEmpleado(vacuna);
			empleadoRepository.save(empleado);
			
		}else {
			return "Vacio";
		}
		return "Actualizado Correctamente";
	}

	public String eliminarEmpleado(Long idEmpleado) {
		String recursoBorrado = "Hubo problemas al eliminar registro";
		if (empleadoRepository.findById(idEmpleado).isPresent()) {
			Optional<Empleado> empleado = empleadoRepository.findById(idEmpleado);
			if(vacunaRepository.findById(empleado.get().getId_usuario().getVacunaEmpleado().getId_vacuna_empleado())!=null )
				vacunaRepository.deleteById(empleado.get().getId_usuario().getVacunaEmpleado().getId_vacuna_empleado());
			empleadoRepository.deleteById(idEmpleado);
			recursoBorrado = "Registro Eliminado";
		}
		return recursoBorrado;
	}
	
	public Object consultarXEstado(Boolean estado) {
		List<Empleado> lstEmpleados = new ArrayList<>();
		empleados = empleadoRepository.findAll();
		if (!empleados.isEmpty()) {
			for (int i = 0; i < empleados.size(); i++) {
				if (empleados.get(i).getId_usuario().getVacunaEmpleado()!=null) {
					if (empleados.get(i).getId_usuario().getVacunaEmpleado().isEstado() == estado) {
						lstEmpleados.add(empleados.get(i));
					}
				}
			}
		} else {
			return "No se encontraron registros";
		}
		return lstEmpleados;
	}
	
	public Object consultarXTipoVacuna(String tipoVacuna) {
		List<Empleado> lstEmpleados = new ArrayList<>();
		empleados = empleadoRepository.findAll();
		if (!empleados.isEmpty()) {
			for (int i = 0; i < empleados.size(); i++) {
				if (empleados.get(i).getId_usuario().getVacunaEmpleado()!=null) {
					if (empleados.get(i).getId_usuario().getVacunaEmpleado().getTipo_vacuna().equals(tipoVacuna.trim())) {
						lstEmpleados.add(empleados.get(i));
					}
				}
			}
		} else {
			return "No se encontraron registros";
		}
		return lstEmpleados;
	}
	
	public Object consultarXRangoFecha(String fechaDesde, String fechaHasta) {
		List<Empleado> lstEmpleados = new ArrayList<>();
		empleados = empleadoRepository.findAll();
		if (!empleados.isEmpty()) {
			for (int i = 0; i < empleados.size(); i++) {
				if (empleados.get(i).getId_usuario().getVacunaEmpleado()!=null) {
					if ( empleados.get(i).getId_usuario().getVacunaEmpleado().getFecha_vacuna().after(java.sql.Date.valueOf(fechaDesde))
							&& empleados.get(i).getId_usuario().getVacunaEmpleado().getFecha_vacuna().before(java.sql.Date.valueOf(fechaHasta))) {
						lstEmpleados.add(empleados.get(i));
					}
				}
			}
		} else {
			return "No se encontraron registros";
		}
		return lstEmpleados;
	}
}
