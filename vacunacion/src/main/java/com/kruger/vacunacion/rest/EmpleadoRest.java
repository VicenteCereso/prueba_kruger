package com.kruger.vacunacion.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.kruger.vacunacion.model.Empleado;
import com.kruger.vacunacion.service.EmpleadoService;

@RestController
public class EmpleadoRest {
	

	private List<Empleado> lstEmpleado = new ArrayList<>();
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@GetMapping(value="admininistracion/consultar")
	private ResponseEntity<Object> getAllEmpleados(){
		lstEmpleado = empleadoService.consultarEmpleados();
		return ResponseEntity.ok(lstEmpleado);
	}
	
	@PostMapping(value = "/admininistracion/registrar") 
	public ResponseEntity<Object> registrarEmpleado(@RequestBody Empleado empleado){
		return ResponseEntity.ok(empleadoService.crearUsuario(empleado));
	}
	
	@PutMapping(value = "/admininistracion/actualizar") 
	public ResponseEntity<Object> updateEmpleado(@RequestBody Empleado empleado){			 
		return ResponseEntity.ok(empleadoService.actualizarEmpleado(empleado));
	}
	
	@DeleteMapping(value = "/admininistracion/eliminar") 
	public ResponseEntity<Object> eliminarEmpleado(Long idEmpleado){		
		return ResponseEntity.ok(empleadoService.eliminarEmpleado(idEmpleado));
	}

	@GetMapping(value="admininistracion/consultarXEstado")	
	private ResponseEntity<Object> getEmpleadosEstado(Boolean estado){
		return ResponseEntity.ok(empleadoService.consultarXEstado(estado));
	}
	
	@GetMapping(value="admininistracion/consultarXTipoVacuna")	
	private ResponseEntity<Object> getEmpleadosTipo(String tipoVacuna){
		return ResponseEntity.ok(empleadoService.consultarXTipoVacuna(tipoVacuna));
	}
	
	@GetMapping(value="admininistracion/consultarXFechaVacuna")	
	private ResponseEntity<Object> getEmpleadosFecha(String fechaDesde, String fechaHasta){
		return ResponseEntity.ok(empleadoService.consultarXRangoFecha(fechaDesde,fechaHasta));
	}
}
