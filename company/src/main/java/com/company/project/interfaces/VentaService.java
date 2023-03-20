package com.company.project.interfaces;

import java.util.List;

import com.company.project.model.Venta;
import com.company.project.response.CommonResponse;

public interface VentaService {
	
	public CommonResponse<Venta> BuscarClienteDniAndEmpleadoDniAndProductoNombre(String dniCliente,String dniEmpleado,String productoNombre);
	
	public CommonResponse<?> eliminarPorClienteDniAndEmpleadoDniAndProductoNombre(String dniCliente, String dniEmpleado,String nombreProducto);
	
	public CommonResponse<List<Venta>> devolverVentas();
	
	public CommonResponse<Venta> actualizarVenta(Venta venta,String dniCliente, String dniEmpleado,String nombreProducto);
	
	public CommonResponse<Venta> registrarVenta(Venta venta,String dniCliente,String dniEmpleado,String nombreProducto);
	
}
