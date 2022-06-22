package com.kruger.vacunacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.vacunacion.model.VacunaEmpleado;

public interface VacunaRepository extends JpaRepository<VacunaEmpleado, Long>{

}
