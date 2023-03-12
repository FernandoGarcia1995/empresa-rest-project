package com.company.project.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.interfaces.ClienteService;
import com.company.project.model.Cliente;
import com.company.project.repository.ClienteRepository;
import com.company.project.response.CommonResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	private static Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Override
	@Transactional
	public CommonResponse<Cliente> buscarClientePorDni(String dni) {
		Cliente clienteOut = new Cliente();
		try {
			clienteOut = clienteRepository.findByDni(dni);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Cliente>(clienteOut);
	}

	@Override
	@Transactional
	public CommonResponse<List<Cliente>> devolverCliente() {
		List<Cliente> clientes = new ArrayList<Cliente>();
 		try {
 			clientes = clienteRepository.findAll();
 		} catch (Exception ex) {
 			log.error("ERROR - {}", ex.getLocalizedMessage());
 		}
		return new CommonResponse<List<Cliente>>(clientes);
	}

	@Override
	@Transactional
	public CommonResponse<Cliente> actualizarCliente(Cliente cliente) {
		Cliente clienteOut = new Cliente();
		try {
			clienteOut = clienteRepository.save(cliente);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Cliente>(clienteOut);
	}

	@Override
	@Transactional
	public CommonResponse<Cliente> registrarCliente(Cliente cliente) {
		Cliente clienteOut = new Cliente();
		try {
			clienteOut = clienteRepository.save(cliente);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		
		return new CommonResponse<Cliente>(clienteOut);
	}

	@Override
	public CommonResponse eliminarClientePorDni(String dni) {
		Cliente clienteToDelete = new Cliente();
		try {
			clienteToDelete = clienteRepository.findByDni(dni);
			clienteRepository.delete(clienteToDelete);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse("Se ha elimnado el cliente - dni: " + dni);
	}

}
