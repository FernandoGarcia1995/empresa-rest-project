package com.company.project.company;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.company.project.interfaces.DepartamentoService;
import com.company.project.interfaces.EmpleadoService;
import com.company.project.model.Departamento;
import com.company.project.model.Empleado;


@RunWith(SpringRunner.class)
@SpringBootTest
class EmpleadoServiceTest {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Autowired
	private DepartamentoService departamentoService;

	@Test
	public void buscarEmpleadoPorDniTest() {
		Empleado empleado = empleadoService.buscarEmpleadoPorDni("43014945T").getBody();
		assertNotNull(empleado);
	}
	
	@Test
	public void registrarEmpleadoTest() {
		Empleado empleado = new Empleado();
		empleado.setNombre("test 1 nombre");
		empleado.setApellido("test 1 apellido");
		empleado.setDni("66363563F");
		empleado.setTelefono("665699486");
		empleado.setFechaContratacion(new Date());
		empleado.setSalario(2000);
		empleado.setCorreoElectronico("test@gmail.com");
		empleado.setFechaNacimiento(new Date());
		empleado.setDireccion("c\\ test n1");
		
		Departamento departamento = departamentoService.buscarDepartamentoPorNombre("marketing").getBody();
		empleado.setDepartamento(departamento);
		
		empleadoService.registrarEmpleado(empleado);
		
		Empleado checkEmpleado = empleadoService.buscarEmpleadoPorDni("66363563F").getBody();
		assertNotNull(checkEmpleado);
	}
	
	@Test
	public void eliminarEmpleadoTest() {
		Empleado empleado = new Empleado();
		empleado.setNombre("test 2 nombre");
		empleado.setApellido("test 2 apellido");
		empleado.setDni("80747891C");
		empleado.setTelefono("665699486");
		empleado.setFechaContratacion(new Date());
		empleado.setSalario(2000);
		empleado.setCorreoElectronico("test2@gmail.com");
		empleado.setFechaNacimiento(new Date());
		empleado.setDireccion("c\\ test n2");
		empleadoService.registrarEmpleado(empleado);
		
		Empleado empleadoExists = empleadoService.buscarEmpleadoPorDni("80747891C").getBody();
		assertNotNull(empleadoExists);
		
		empleadoService.eliminarEmpleadoPorDni("80747891C");
		Empleado checkEmpleado = empleadoService.buscarEmpleadoPorDni("80747891C").getBody();
		assertNull(checkEmpleado);
	}
	
	
	@Test
	public void devolverEmpleadosTest() {
		List<Empleado> empleados = empleadoService.devolverEmpleados().getBody();
		assertNotNull(empleados);	
	}
	
	@Test
	public void actualizarEmpleadoTest() {
		Empleado empleado = new Empleado();
		empleado.setNombre("test 3 nombre");
		empleado.setApellido("test 3 apellido");
		empleado.setDni("80747891C");
		empleado.setTelefono("665699486");
		empleado.setFechaContratacion(new Date());
		empleado.setSalario(2000);
		empleado.setCorreoElectronico("test3@gmail.com");
		empleado.setFechaNacimiento(new Date());
		empleado.setDireccion("c\\ test n3");
		empleadoService.registrarEmpleado(empleado);
		empleado.setApellido("Update");
		Empleado empleadoActualizaado = empleadoService.actualizarEmpleado(empleado).getBody();
		assertThat(empleadoActualizaado.getApellido()).isEqualTo("Update");
	}
	

}
