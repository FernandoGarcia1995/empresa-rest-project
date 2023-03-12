package com.company.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.project.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento,Long >{
	
	boolean existsDepartamentoByNombre(String nombreDepartamento);
	
	Departamento findByNombre(String nombreDepartamento);

}
