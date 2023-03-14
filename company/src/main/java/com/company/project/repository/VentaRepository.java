package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.company.project.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long > {
	
	@Query ("FROM Venta where empleado.dni = :dniEmpleado AND cliente.dni = :dniCliente")
	Venta findByClienteDniAndEmpleadoDni(String dniEmpleado,String dniCliente);

}
