package com.company.project.interfaces;

import java.util.List;

import com.company.project.model.Venta;
import com.company.project.response.CommonResponse;

public interface VentaService {
	
	public CommonResponse<Venta> buscarVentaPorClienteAndEmpleado(String dniCliente,String dniEmpleado);
	
	public CommonResponse<?> eliminarPorClienteAndEmpleado(String dniCliente, String dniEmpleado);
	
	public CommonResponse<List<Venta>> devolverVentas();
	
	public CommonResponse<Venta> actualizarVenta(Venta venta);
	
	public CommonResponse<Venta> registrarVenta(Venta venta);
	
}
