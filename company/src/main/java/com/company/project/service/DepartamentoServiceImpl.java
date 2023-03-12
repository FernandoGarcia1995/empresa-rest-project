package com.company.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.interfaces.DepartamentoService;
import com.company.project.model.Departamento;
import com.company.project.repository.DepartamentoRepository;
import com.company.project.response.CommonResponse;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	private static Logger log = LoggerFactory.getLogger(DepartamentoServiceImpl.class);
	
	@Autowired
	private DepartamentoRepository departamentoRepository;

	@Override
	public CommonResponse<Departamento> buscarDepartamentoPorNombre(String nombre) {
		Departamento departamentoOut = new Departamento();
		try {
			departamentoOut = departamentoRepository.findByNombre(nombre);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		
		return new CommonResponse<Departamento>(departamentoOut);
	}

	@Override
	public CommonResponse<?>  eliminarDepartamentoPorNombre(String nombreDepartamento) {
		Departamento departamentoToDelete = new Departamento();
		try {
			departamentoToDelete = departamentoRepository.findByNombre(nombreDepartamento);
			departamentoRepository.delete(departamentoToDelete);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		
		return new CommonResponse("Se ha elimnado departamento - {} " + nombreDepartamento);
	}

	@Override
	public CommonResponse<List<Departamento>> devolverDepartamento() {
		List<Departamento> departamentos = new ArrayList<Departamento>();
		try {
			departamentos = departamentoRepository.findAll();
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<List<Departamento>>(departamentos);
	}

	@Override
	public CommonResponse<Departamento> actualizarDepartamento(Departamento departamento) {
		Departamento departamentoOut = new Departamento();
		try {
			departamentoOut = departamentoRepository.save(departamento);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Departamento>(departamentoOut);
	}

	@Override
	public CommonResponse<Departamento> registrarDepartamento(Departamento departamento) {
		Departamento departamentoOut = new Departamento();
		try {
			departamentoOut = departamentoRepository.save(departamento);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Departamento>(departamentoOut);
	}
	
}
