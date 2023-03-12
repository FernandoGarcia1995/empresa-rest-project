package com.company.project.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.project.interfaces.EmpleadoService;
import com.company.project.model.Empleado;
import com.company.project.repository.EmpleadoRepository;
import com.company.project.response.CommonResponse;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{

	private static Logger log = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	
	@Autowired
	private EmpleadoRepository empleadoRepository;
	
	@Override
	public CommonResponse<Empleado> buscarEmpleadoPorDni(String dni) {
		Empleado empleadoOut = new Empleado();
		try {
			empleadoOut = empleadoRepository.findByDni(dni);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Empleado>(empleadoOut);
	}

	@Override
	public CommonResponse<?> eliminarEmpleadoPorDni(String dni) {
		Empleado empleadoToDelete = new Empleado();
		try {
			empleadoToDelete = empleadoRepository.findByDni(dni);
			empleadoRepository.delete(empleadoToDelete);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse("Se ha eliminado empleado - {} " + dni);
	}

	@Override
	public CommonResponse<List<Empleado>> devolverEmpleados() {
		List<Empleado> empleados = new ArrayList<Empleado>();
		try {
			empleados = empleadoRepository.findAll();
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<List<Empleado>>(empleados);
	}

	@Override
	public CommonResponse<Empleado> actualizarEmpleado(Empleado empleado) {
		Empleado empleadoOut = new Empleado();
		try {
			empleadoOut = empleadoRepository.save(empleado);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Empleado>(empleadoOut);
	}

	@Override
	public CommonResponse<Empleado> registrarEmpleado(Empleado empleado) {
		Empleado empleadoOut = new Empleado();
		try {
			empleadoOut = empleadoRepository.save(empleado);
		} catch (Exception ex) {
			log.error("ERROR - {}", ex.getLocalizedMessage());
		}
		return new CommonResponse<Empleado>(empleadoOut);
	}


}
