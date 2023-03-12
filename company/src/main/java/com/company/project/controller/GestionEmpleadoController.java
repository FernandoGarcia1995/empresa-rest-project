package com.company.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.company.project.interfaces.EmpleadoService;
import com.company.project.model.Empleado;
import com.company.project.response.CommonResponse;

@RestController
@RequestMapping("/empleado")
public class GestionEmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;

	@PostMapping("/registrarEmpleado")
	public ResponseEntity<CommonResponse<Empleado>> registrarEmpleado (@RequestBody Empleado Empleado){
		return new ResponseEntity<CommonResponse<Empleado>>(empleadoService.registrarEmpleado(Empleado), HttpStatus.CREATED);
	}
	
	@GetMapping("/buscarEmpleado")
	public ResponseEntity<CommonResponse<Empleado>> buscarEmpleado(@RequestParam String dni) {
		return new ResponseEntity<CommonResponse<Empleado> >(empleadoService.buscarEmpleadoPorDni(dni), HttpStatus.OK);	
	}
	
	@DeleteMapping("/eliminarEmpleado")
	public ResponseEntity<CommonResponse> eliminarEmpleado(@RequestParam String dni) {
		return new ResponseEntity<CommonResponse>(empleadoService.eliminarEmpleadoPorDni(dni), HttpStatus.OK);	
	}
	
	@PostMapping("/actualizarEmpleado")
	public ResponseEntity<CommonResponse<Empleado>> actualizarEmpleado (@RequestBody Empleado empleado) {
		return new ResponseEntity<CommonResponse<Empleado>>(empleadoService.actualizarEmpleado(empleado), HttpStatus.OK);
	}
	
	@GetMapping("/devolverEmpleados")
	public ResponseEntity<CommonResponse<List<Empleado>>>devolverEmpleado () {
		return new ResponseEntity<CommonResponse<List<Empleado>>>(empleadoService.devolverEmpleados(), HttpStatus.OK);
	}
}
