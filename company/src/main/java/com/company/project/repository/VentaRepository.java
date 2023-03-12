package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.company.project.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long > {
	
	@Query ("FROM Venta where empleado.dni = :nombreEmpleado AND cliente.dni = :nombreCliente")
	Venta findByClienteDniAndEmpleadoDni(String dniEmpleado,String dniCliente);

}
