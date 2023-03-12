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

import com.company.project.interfaces.DepartamentoService;
import com.company.project.model.Departamento;
import com.company.project.response.CommonResponse;

@RestController
@RequestMapping("/departamento")
public class GestionDepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@PostMapping("/registrarDepartamento")
	public ResponseEntity<CommonResponse<Departamento>> registrarDepartamento (@RequestBody Departamento departamento){
		return new ResponseEntity<CommonResponse<Departamento>>(departamentoService.registrarDepartamento(departamento), HttpStatus.CREATED);
	}
	
	@GetMapping("/buscarDepartamento")
	public ResponseEntity<CommonResponse<Departamento>> buscarDepartamento(@RequestParam String nombreDepartamento) {
		return new ResponseEntity<CommonResponse<Departamento> >(departamentoService.buscarDepartamentoPorNombre(nombreDepartamento), HttpStatus.OK);	
	}
	
	@DeleteMapping("/eliminarDepartamento")
	public ResponseEntity<CommonResponse> eliminarDepartamento(@RequestParam String nombreDepartamento) {
		return new ResponseEntity<CommonResponse>(departamentoService.eliminarDepartamentoPorNombre(nombreDepartamento), HttpStatus.OK);	
	}
	
	@PostMapping("/actualizarDepartamento")
	public ResponseEntity<CommonResponse<Departamento>> actualizarDeparamento (@RequestBody Departamento departamento) {
		return new ResponseEntity<CommonResponse<Departamento>>(departamentoService.actualizarDepartamento(departamento), HttpStatus.OK);
	}
	
	@GetMapping("/devolverDepartamentos")
	public ResponseEntity<CommonResponse<List<Departamento>>>devolverVentas () {
		return new ResponseEntity<CommonResponse<List<Departamento>>>(departamentoService.devolverDepartamento(), HttpStatus.OK);
	}

}
