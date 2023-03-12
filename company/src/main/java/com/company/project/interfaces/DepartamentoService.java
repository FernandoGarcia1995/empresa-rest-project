package com.company.project.interfaces;

import java.util.List;
import com.company.project.model.Departamento;
import com.company.project.response.CommonResponse;

public interface DepartamentoService {
	
	public CommonResponse<Departamento> buscarDepartamentoPorNombre(String nombre);
	
	public CommonResponse<?> eliminarDepartamentoPorNombre(String nombreDepartamento);
	
	public CommonResponse<List<Departamento>> devolverDepartamento();
	
	public CommonResponse<Departamento> actualizarDepartamento(Departamento departamento);
	
	public CommonResponse<Departamento> registrarDepartamento(Departamento departamento);

}
