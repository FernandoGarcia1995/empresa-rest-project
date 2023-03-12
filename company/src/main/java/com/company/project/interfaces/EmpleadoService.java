package com.company.project.interfaces;

import java.util.List;

import com.company.project.model.Empleado;
import com.company.project.response.CommonResponse;

public interface EmpleadoService {
	
	public CommonResponse<Empleado> buscarEmpleadoPorDni(String dni);
	
	public CommonResponse<?> eliminarEmpleadoPorDni(String dni);
	
	public CommonResponse<List<Empleado>> devolverEmpleados();
	
	public CommonResponse<Empleado> actualizarEmpleado(Empleado empleado);
	
	public CommonResponse<Empleado> registrarEmpleado(Empleado empleado);

}
