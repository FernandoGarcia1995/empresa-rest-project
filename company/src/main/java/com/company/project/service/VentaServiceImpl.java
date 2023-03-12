package com.company.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.interfaces.VentaService;
import com.company.project.model.Venta;
import com.company.project.repository.VentaRepository;
import com.company.project.response.CommonResponse;

@Service
public class VentaServiceImpl implements VentaService {
	
	private static Logger log = LoggerFactory.getLogger(VentaServiceImpl.class);
	
	@Autowired
	private VentaRepository ventaRepository;

	//cambiar nombresCliente y nombreEmpleado por DNI
	@Override
	public CommonResponse<Venta> buscarVentaPorClienteAndEmpleado(String dniCliente, String dniEmpleado) {
		Venta ventaOut = new Venta();
		try {
			ventaOut = ventaRepository.findByClienteDniAndEmpleadoDni(dniEmpleado, dniCliente);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Venta>(ventaOut);
	}

	@Override
	public CommonResponse<?> eliminarPorClienteAndEmpleado(String dniCliente, String dniEmpleado) {
		try {
			Venta ventaToDeleted = ventaRepository.findByClienteDniAndEmpleadoDni(dniCliente, dniEmpleado);
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
	public CommonResponse<Venta> actualizarVenta(Venta venta) {
		Venta ventaOut = new Venta();
		try {
			ventaOut = ventaRepository.save(venta);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Venta>(ventaOut);
	}

	@Override
	public CommonResponse<Venta> registrarVenta(Venta venta) {
		Venta ventaOut = new Venta();
		try {
			ventaOut = ventaRepository.save(venta);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Venta>(ventaOut);
	}

}
