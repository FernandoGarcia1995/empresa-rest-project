package com.company.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.interfaces.ProductoService;
import com.company.project.model.Cliente;
import com.company.project.model.Producto;
import com.company.project.repository.ProductoRepository;
import com.company.project.response.CommonResponse;

@Service
public class ProductoServiceImpl implements ProductoService {
	
	private static Logger log = LoggerFactory.getLogger(ProductoServiceImpl.class);
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public CommonResponse<Producto> buscarProductoPorNombre(String nombre) {
		Producto productoOut = new Producto();
		try {
			productoOut = productoRepository.findByNombre(nombre);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Producto>(productoOut);
	}

	@Override
	public CommonResponse<?> eliminarProductoPorNombre(String nombre) {
		Producto productoToDelete = new Producto();
		try {
			productoToDelete = productoRepository.findByNombre(nombre);
			productoRepository.delete(productoToDelete);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse("Se ha elimnado el producto - : " + nombre);
	}

	@Override
	public CommonResponse<List<Producto>> devolverProducto() {
		List<Producto> productos = new ArrayList<Producto>();
		try {
			productos = productoRepository.findAll();
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<List<Producto>>(productos);
	}

	@Override
	public CommonResponse<Producto> actualizarProducto(Producto producto) {
		Producto productoOut = new Producto();
		try {
			productoOut = productoRepository.save(producto);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Producto>(productoOut);
	}

	@Override
	public CommonResponse<Producto> registrarProducto(Producto producto) {
		Producto productoOut = new Producto();
		try {
			productoOut = productoRepository.save(producto);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Producto>(productoOut);
	}
	

}
