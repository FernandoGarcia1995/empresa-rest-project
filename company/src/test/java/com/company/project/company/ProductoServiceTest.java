package com.company.project.company;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.project.interfaces.ProductoService;
import com.company.project.model.Producto;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductoServiceTest {
	
	@Autowired
	private ProductoService productoService;
	
	@Test
	public void buscarProductoPorNombreTest() {
		Producto producto = productoService.buscarProductoPorNombre("Producto 1").getBody();
		assertNotNull(producto);
	}
	
	@Test
	public void registrarProductoTest() {
		Producto producto = new Producto();
		producto.setNombre("test 1");
		producto.setDescripcion("test 1 descripcion");
		producto.setStock(12000);
		producto.setFechaLanzamiento(new Date());
		productoService.registrarProducto(producto);
		
		Producto productoCheck = productoService.buscarProductoPorNombre("test 1").getBody();
		assertNotNull(productoCheck);
		
	}
	
	@Test
	public void eliminarProductoTest() {
		productoService.eliminarProductoPorNombre("Producto 1");
		
		Producto checkProducto = productoService.buscarProductoPorNombre("Producto 1").getBody();
		assertNull(checkProducto);
	}
	
	
	@Test
	public void devolverProductosTest() {
		List<Producto> productos = productoService.devolverProducto().getBody();
		assertNotNull(productos);
	}
	
	@Test
	public void actualizarProductoTest() {
		Producto producto = new Producto();
		producto.setNombre("test 2");
		producto.setDescripcion("test 2 descripcion");
		producto.setStock(12000);
		producto.setFechaLanzamiento(new Date());
		productoService.registrarProducto(producto);
		
		producto.setDescripcion("test");
		Producto productoActualizado = productoService.actualizarProducto(producto).getBody();
		
		
		assertThat(productoActualizado.getDescripcion()).isEqualTo("test");

	}
}
