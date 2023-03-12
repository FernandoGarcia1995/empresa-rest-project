package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{
	
	Empleado findByDni(String dni);

}
