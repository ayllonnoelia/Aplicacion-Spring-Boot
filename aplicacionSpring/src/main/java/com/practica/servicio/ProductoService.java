package com.practica.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practica.clase.Producto;
import com.practica.repositorio.ProductoRepository;

@Service
public class ProductoService {

	@Autowired
	private ProductoRepository repo;
	
	//INSERTAR UN SOLO REGISTRO
	public Producto insertarProducto(Producto producto) {
		return repo.save(producto);
	}
	
	//INSERTAR VARIOS REGISTROS
	public List<Producto> insertarProductos(List<Producto> productos){
		return repo.saveAll(productos);
	}
	
	//VER TODOS LOS REGISTROS DE LA TABLA
	public List<Producto> verTodos(){
		return repo.findAll();
	}
	
	//MOSTRAR UN REGISTRO SEGUN SU ID
	public Producto productoPorId(int id) {
		return repo.findById(id).orElse(null);
	}
	
	//MOSTRAR UN REGISTRO SEGUN SU NOMBRE
	public Producto productoPorNombre(String nombre) {
		return repo.findByName(nombre);
	}
	
	//ELIMINAR UN REGISTRO SEGUN SU ID
	public String eliminarProducto(int id) {
		repo.deleteById(id);
		return "El producto cuyo id es: " + id + ", ha sido eliminado correctamente";
	}
	
	//ELIMINAR TODOS LOS REGISTROS
	public String eliminarTodos() {
		repo.deleteAll();
		return "Todos los registros existentes en la tabla han sido eliminados";
	}
	
	//MODIFICAR UN REGISTRO
	public Producto modificarProducto(Producto producto) {
		Producto mod = repo.findById(producto.getId()).orElse(null);
		mod.setName(producto.getName());
		mod.setPrice(producto.getPrice());
		return repo.save(mod);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
