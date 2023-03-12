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

import com.company.project.interfaces.ClienteService;
import com.company.project.interfaces.EmpleadoService;
import com.company.project.interfaces.ProductoService;
import com.company.project.interfaces.VentaService;
import com.company.project.model.Cliente;
import com.company.project.model.Empleado;
import com.company.project.model.Producto;
import com.company.project.model.Venta;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VentaServiceTest {
	
	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private ProductoService productoService;
	
	@Test
	public void buscarVentaPorClienteAndEmpleadoTest() {
		Venta venta = ventaService.buscarVentaPorClienteAndEmpleado("Sofia", "Juan").getBody();
		assertNotNull(venta);	
	}
	
	@Test
	public void registrarVentaTest() {
		Cliente cliente = clienteService.buscarClientePorDni("41361421S").getBody();
		Empleado empleado = empleadoService.buscarEmpleadoPorDni("43014945T").getBody();
		Producto producto = productoService.buscarProductoPorNombre("Producto 1").getBody();
		Venta venta = new Venta();
		venta.setCliente(cliente);
		venta.setEmpleado(empleado);
		venta.setFecha(new Date());
		venta.setProducto(producto);
		venta.setCantidad(1000);
		
		ventaService.registrarVenta(venta);
		
		Venta checkVenta = ventaService.buscarVentaPorClienteAndEmpleado("Diego", "Juan").getBody();
		assertNotNull(checkVenta);		
	}
	
	@Test
	public void eliminarVentaTest() {
		
		Cliente cliente = clienteService.buscarClientePorDni("42478852Z").getBody();
		Empleado empleado = empleadoService.buscarEmpleadoPorDni("43014945T").getBody();
		Producto producto = productoService.buscarProductoPorNombre("Producto 1").getBody();
		Venta venta = new Venta();
		venta.setCliente(cliente);
		venta.setEmpleado(empleado);
		venta.setFecha(new Date());
		venta.setProducto(producto);
		venta.setCantidad(1000);
		ventaService.registrarVenta(venta);
		
		ventaService.eliminarPorClienteAndEmpleado("42478852Z", "43014945T");	
		Venta checkVenta = ventaService.buscarVentaPorClienteAndEmpleado("Isabella", "Juan").getBody();
		
		assertNull(checkVenta);
	}
	
	
	@Test
	public void devolverVentasTest() {
		List<Venta> listaVentas = ventaService.devolverVentas().getBody();
		assertNotNull(listaVentas);
	}
	
	@Test
	public void actualizarVentaTest() {
		Venta venta = ventaService.buscarVentaPorClienteAndEmpleado("Sofia", "Juan").getBody();
		venta.setCantidad(2);
		Venta VentaActualizado = ventaService.actualizarVenta(venta).getBody();
		assertThat(VentaActualizado.getCantidad()).isEqualTo(2);
	}
	

}
