package com.practica.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.practica.clase.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

	Producto findByName(String nombre);

}
