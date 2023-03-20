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

import com.company.project.interfaces.ProductoService;
import com.company.project.model.Producto;
import com.company.project.response.CommonResponse;

@RestController
@RequestMapping("/producto")
public class GestionProductoController {
	
	@Autowired
	private ProductoService productoService;

	@PostMapping("/registrarProducto")
	public ResponseEntity<CommonResponse<Producto>> registrarProducto (@RequestBody Producto producto){
		return new ResponseEntity<CommonResponse<Producto>>(productoService.registrarProducto(producto), HttpStatus.CREATED);
	}
	
	@GetMapping("/buscarProducto")
	public ResponseEntity<CommonResponse<Producto>> buscarProducto(@RequestParam String nombre) {
		return new ResponseEntity<CommonResponse<Producto> >(productoService.buscarProductoPorNombre(nombre), HttpStatus.OK);	
	}
	
	@DeleteMapping("/eliminarProducto")
	public ResponseEntity<CommonResponse> eliminarProducto(@RequestParam String nombre) {
		return new ResponseEntity<CommonResponse>(productoService.eliminarProductoPorNombre(nombre), HttpStatus.OK);	
	}
	
	@PostMapping("/actualizarProducto")
	public ResponseEntity<CommonResponse<Producto>> actualizarProducto (@RequestBody Producto producto) {
		return new ResponseEntity<CommonResponse<Producto>>(productoService.actualizarProducto(producto), HttpStatus.OK);
	}
	
	@GetMapping("/devolverProductos")
	public ResponseEntity<CommonResponse<List<Producto>>>devolverProducto () {
		return new ResponseEntity<CommonResponse<List<Producto>>>(productoService.devolverProducto(), HttpStatus.OK);
	}
}
