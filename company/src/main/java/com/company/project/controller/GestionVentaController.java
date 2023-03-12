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

import com.company.project.interfaces.VentaService;
import com.company.project.model.Venta;
import com.company.project.response.CommonResponse;

@RestController
@RequestMapping("/venta")
public class GestionVentaController {
	
	@Autowired
	private VentaService ventaService;
	
	@PostMapping("/registrarVenta")
	public ResponseEntity<CommonResponse<Venta>> registrarVenta (@RequestBody Venta venta){
		return new ResponseEntity<CommonResponse<Venta>>(ventaService.registrarVenta(venta), HttpStatus.CREATED);
	}
	
	@GetMapping("/buscarVenta")
	public ResponseEntity<CommonResponse<Venta>> buscarVenta(@RequestParam String dniCliente,@RequestParam String dniEmpleado) {
		return new ResponseEntity<CommonResponse<Venta> >(ventaService.buscarVentaPorClienteAndEmpleado(dniCliente, dniEmpleado), HttpStatus.OK);	
	}
	
	@DeleteMapping("/eliminarVenta")
	public ResponseEntity<CommonResponse> eliminarVenta (@RequestParam String dniCliente,@RequestParam String dniEmpleado) {
		return new ResponseEntity<CommonResponse>(ventaService.eliminarPorClienteAndEmpleado(dniCliente, dniEmpleado), HttpStatus.OK);	
	}
	
	@PostMapping("/actualizarVenta")
	public ResponseEntity<CommonResponse<Venta>> actualizarVentas (@RequestBody Venta venta) {
		return new ResponseEntity<CommonResponse<Venta>>(ventaService.actualizarVenta(venta), HttpStatus.OK);
	}
	
	@GetMapping("/devolverVentas")
	public ResponseEntity<CommonResponse<List<Venta>>>devolverVentas (@RequestBody Venta venta) {
		return new ResponseEntity<CommonResponse<List<Venta>>>(ventaService.devolverVentas(), HttpStatus.OK);
	}
}
