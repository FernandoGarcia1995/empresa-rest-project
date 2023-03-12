package com.company.project.company;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.project.interfaces.DepartamentoService;
import com.company.project.model.Departamento;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartamentoServiceTest {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@Test
	public void buscarDepartamentoPorNombreTest() {
		Departamento departamento = departamentoService.buscarDepartamentoPorNombre("estrategias").getBody();
		assertNotNull(departamento);
		
	}
	
	@Test
	public void registrarDepartamentoTest() {
		Departamento departamento = new Departamento();
		departamento.setNombre("test1");
		departamento.setDescripcion("test2");
		departamentoService.registrarDepartamento(departamento);
		
		Departamento checkDepartamento = departamentoService.buscarDepartamentoPorNombre("marketing").getBody();
		assertNotNull(checkDepartamento);
	}
	
	@Test
	public void eliminarDepartamentoTest() {
		departamentoService.eliminarDepartamentoPorNombre("marketing");
		
		Departamento checkDepartamento = departamentoService.buscarDepartamentoPorNombre("marketing").getBody();
		assertNull(checkDepartamento);
	}
	
	
	@Test
	public void devolverDepartamentosTest() {
		List<Departamento> departamentos = departamentoService.devolverDepartamento().getBody();
		assertNotNull(departamentos);
	}
	
	@Test
	public void actualizarClienteTest() {
		Departamento departamento = new Departamento();
		departamento.setNombre("test1");
		departamento.setDescripcion("test2");
		departamentoService.registrarDepartamento(departamento);
		
		departamento.setDescripcion("test3");
		Departamento departamentoActualizado = departamentoService.actualizarDepartamento(departamento).getBody();
		assertThat(departamentoActualizado.getDescripcion()).isEqualTo("test3");

	}

}
