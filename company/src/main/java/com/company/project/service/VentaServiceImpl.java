package com.company.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.interfaces.VentaService;
import com.company.project.model.Cliente;
import com.company.project.model.Empleado;
import com.company.project.model.Producto;
import com.company.project.model.Venta;
import com.company.project.repository.ClienteRepository;
import com.company.project.repository.EmpleadoRepository;
import com.company.project.repository.ProductoRepository;
import com.company.project.repository.VentaRepository;
import com.company.project.response.CommonResponse;

@Service
public class VentaServiceImpl implements VentaService {
	
	private static Logger log = LoggerFactory.getLogger(VentaServiceImpl.class);
	
	@Autowired
	private VentaRepository ventaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Autowired
	private ProductoRepository productoRepository;
	
	

	@Override
	public CommonResponse<Venta> BuscarClienteDniAndEmpleadoDniAndProductoNombre(String dniCliente, String dniEmpleado,String productoNombre) {
		Venta ventaOut = new Venta();
		try {
			ventaOut = ventaRepository.findByClienteDniAndEmpleadoDniAndProductoNombre(dniEmpleado, dniCliente, productoNombre);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Venta>(ventaOut);
	}

	@Override
	public CommonResponse<?> eliminarPorClienteDniAndEmpleadoDniAndProductoNombre(String dniCliente, String dniEmpleado,String productoNombre){
		try {
			Venta ventaToDeleted = ventaRepository.findByClienteDniAndEmpleadoDniAndProductoNombre(dniEmpleado, dniCliente, productoNombre);
			ventaRepository.delete(ventaToDeleted);	
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse("Venta eliminada");
	}

	@Override
	public CommonResponse<List<Venta>> devolverVentas() {
		List<Venta> listVentas = new ArrayList<Venta>();
		try {
			listVentas = ventaRepository.findAll();
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<List<Venta>>(listVentas);
	}

	@Override
	public CommonResponse<Venta> actualizarVenta(Venta venta,String dniCliente, String dniEmpleado,String productoNombre) {
		Venta ventaOut = new Venta();
		try {
			Cliente cliente = clienteRepository.findByDni(dniCliente);
			Empleado empleado = empleadoRepository.findByDni(dniEmpleado);
			Producto producto = productoRepository.findByNombre(productoNombre);
			
			venta.setCliente(cliente);
			venta.setEmpleado(empleado);
			venta.setProducto(producto);
			
			ventaOut = ventaRepository.save(venta);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Venta>(ventaOut);
	}

	@Override
	public CommonResponse<Venta> registrarVenta(Venta venta,String dniCliente, String dniEmpleado,String productoNombre) {
		Venta ventaOut = new Venta();
		try {
			Cliente cliente = clienteRepository.findByDni(dniCliente);
			Empleado empleado = empleadoRepository.findByDni(dniEmpleado);
			Producto producto = productoRepository.findByNombre(productoNombre);
			
			venta.setCliente(cliente);
			venta.setEmpleado(empleado);
			venta.setProducto(producto);
			
			ventaOut = ventaRepository.save(venta);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Venta>(ventaOut);
	}

}
