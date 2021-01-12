package com.practica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practica.clase.Producto;
import com.practica.clase.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByNombre(String nombre);
	
}


