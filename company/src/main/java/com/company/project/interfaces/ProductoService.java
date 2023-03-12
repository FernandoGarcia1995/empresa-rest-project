package com.company.project.interfaces;

import java.util.List;
import com.company.project.model.Producto;
import com.company.project.response.CommonResponse;

public interface ProductoService {
	
	public CommonResponse<Producto> buscarProductoPorNombre(String nombre);
	
	public CommonResponse<?> eliminarProductoPorNombre(String nombre);
	
	public CommonResponse<List<Producto>> devolverProducto();
	
	public CommonResponse<Producto> actualizarProducto(Producto producto);
	
	public CommonResponse<Producto> registrarProducto(Producto producto);

}
