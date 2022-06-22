package com.kruger.vacunacion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kruger.vacunacion.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

}
