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

import com.company.project.interfaces.ClienteService;
import com.company.project.model.Cliente;
import com.company.project.response.CommonResponse;

@RestController
@RequestMapping("/cliente")
public class GestionClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping("/registrarCliente")
	public ResponseEntity<CommonResponse<Cliente>> registrarCliente (@RequestBody Cliente cliente){
		return new ResponseEntity<CommonResponse<Cliente> >((clienteService.registrarCliente(cliente)), HttpStatus.OK);	
	}
	
	@GetMapping("/buscarCliente")
	public ResponseEntity<CommonResponse<Cliente>> buscarCliente (@RequestParam String dni) {
		return new ResponseEntity<CommonResponse<Cliente> >(clienteService.buscarClientePorDni(dni), HttpStatus.OK);	
	}
	
	@DeleteMapping("/eliminarCliente")
	public ResponseEntity<CommonResponse> borrarCliente (@RequestParam String dni) {
		return new ResponseEntity<CommonResponse>(clienteService.eliminarClientePorDni(dni), HttpStatus.OK);	
	}
	
	@GetMapping("/devolverClientes")
	public ResponseEntity<CommonResponse<List<Cliente>>> devolverClientes () {
		return new ResponseEntity<CommonResponse<List<Cliente>>>(clienteService.devolverCliente(), HttpStatus.OK);	
	}
	
	@GetMapping("/actualizarCliente")
	public ResponseEntity<CommonResponse<Cliente>> actualizarCliente (@RequestBody Cliente cliente) {
		return new ResponseEntity<CommonResponse<Cliente>>(clienteService.actualizarCliente(cliente), HttpStatus.OK);
	}

}
