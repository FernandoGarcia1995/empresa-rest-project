package com.company.project.interfaces;

import java.util.List;

import com.company.project.model.Cliente;
import com.company.project.response.CommonResponse;
public interface ClienteService {
	
	public CommonResponse<Cliente> buscarClientePorDni(String dni);
	
	public CommonResponse<?> eliminarClientePorDni(String dni);
	
	public CommonResponse<List<Cliente>> devolverCliente();
	
	public CommonResponse<Cliente> actualizarCliente(Cliente cliente);
	
	public CommonResponse<Cliente> registrarCliente(Cliente cliente);

}
