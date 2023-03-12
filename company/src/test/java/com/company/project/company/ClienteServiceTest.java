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

import com.company.project.interfaces.ClienteService;
import com.company.project.model.Cliente;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClienteServiceTest {
	
	@Autowired
	private ClienteService clienteService;
	
	@Test
	public void buscarClientePorDniTest() {
		Cliente cliente = clienteService.buscarClientePorDni("79703048K").getBody();
		assertNotNull(cliente);
		
	}
	
	@Test
	public void registrarClienteTest() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Test");
		cliente.setApellido("TestNombre");
		cliente.setDni("25055983J");
		cliente.setDireccion("c\test nº31");
		cliente.setTelefono("665699487");
		cliente.setCorreoElectronico("test@gmail.com");
		cliente.setFechaRegistro(new Date());
		clienteService.registrarCliente(cliente);
		Cliente checkCliente = clienteService.buscarClientePorDni("25055983J").getBody();
		assertNotNull(checkCliente);
		
	}
	
	@Test
	public void eliminarClienteTest() {
		clienteService.eliminarClientePorDni("79703048K");
		Cliente checkAgainCiiente = clienteService.buscarClientePorDni("79703048K").getBody();
		assertNull(checkAgainCiiente);
	}
	
	
	@Test
	public void devolverClientesTest() {
		List<Cliente> clientes = clienteService.devolverCliente().getBody();
		assertNotNull(clientes);	
	}
	
	@Test
	public void actualizarClienteTest() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Test");
		cliente.setApellido("TestNombre");
		cliente.setDireccion("c\test nº31");
		cliente.setTelefono("665699487");
		cliente.setCorreoElectronico("test@gmail.com");
		cliente.setDni("23434317P");
		cliente.setFechaRegistro(new Date());
		clienteService.registrarCliente(cliente);
		
		cliente.setApellido("Update2");
		Cliente clienteActualizado = clienteService.actualizarCliente(cliente).getBody();
		
		assertThat(clienteActualizado.getApellido()).isEqualTo("Update2");
	}
	

}
