package com.practica.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.practica.clase.Producto;
import com.practica.repositorio.ProductoRepository;
import com.practica.servicio.ProductoService;

@Controller //HTML
//@RestController POSTMAN
public class ProductoController {
	
	@Autowired
	private ProductoService serv;
	
	@Autowired
	ProductoRepository prodRepo;
	
	
	/*
	 * *************************PÁGINA DE MENÚ PRINCIPAL****************************
	 * */
	
	@GetMapping("/")
    public String indexMostrar(Model model) {
        return "index";
    }
	
	
	/*
	 * *************************PÁGINAS CON MENSAJES CORRECTOS****************************
	 * */
	
	//PAGINA INSERCION CORRECTA
	@GetMapping("/insercionCorrecta")
    public String inserCorrect(Model model) {
        return "correcto";
    }
	
	//PAGINA ELIMINACION CORRECTA
	@GetMapping("/eliminacionCorrecta")
    public String elimCorrect(Model model) {
        return "eliminado";
    }
	
	//PAGINA ELIMINACION CORRECTA
	@GetMapping("/eliminacionTotalCorrecta")
    public String elimTotCorrect(Model model) {
        return "eliminadoss";
    }
	
	//PAGINA MODIFICACION CORRECTA
	@GetMapping("/modificacionCorrecta")
    public String modCorrect(Model model) {
        return "modificado";
    }
	
	/*
	 * *************************OPERACIONES CRUD POSTMAN Y HTML****************************
	 * */
	
	//VER TDOOS LOS REGISTROS POSTMAN / PANTALLA DE LISTADO DE REGISTROS HTML
	@GetMapping("/productos")
    public String verProductos(Model model) {
        model.addAttribute("productos", serv.verTodos());
        return "listado";
    }
		
	//VER UN REGISTRO SEGUN EL ID POSTMAN
	@GetMapping("/productos/{id}")
	public Producto productoPorId(@PathVariable int id) {
		return serv.productoPorId(id);
	}
	
	//VER UN REGISTRO SEGUN EL NOMBRE POSTMAN
	@GetMapping("/productos/{name}")
	public Producto productoPorNombre(@PathVariable String nombre) {
		return serv.productoPorNombre(nombre);
	}
	
	//PANTALLA DE INSERCION DE REGISTRO HTML
	@GetMapping("/insertar")
	public String formInsertUnico(Model model) {
		model.addAttribute("producto",new Producto());
		return "insertarProducto";
	}	

	//INSERTAR UN SOLO REGISTRO POSTMAN / INSERTAR REGISTRO Y MANDAR A PANTALLA DE COMPROBACION HTML
	@PostMapping("/insertarProducto")
	public String insertarProducto(/*@RequestBody*/ Producto producto) {
		serv.insertarProducto(producto);
		return "redirect:/insercionCorrecta";
	}
	
	//INSERTAR VARIOS REGISTROS POSTMAN
	@PostMapping("/insertarProductos")
	public List<Producto> insertarProductos(@RequestBody List<Producto> productos){
		return serv.insertarProductos(productos);
	}
	
	//BORRAR REGISTRO Y MANDAR A PANTALLA DE COMPROBACION HTML
	@GetMapping("/eliminarProducto/{id}")
	public String formEliminar(@PathVariable int id) {
		serv.eliminarProducto(id);
		return "redirect:/eliminacionCorrecta";
	}
	
	//BORRAR TODOS LOS REGISTROS Y MANDAR A PANTALLA DE COMPROBACION HTML
	@GetMapping("/eliminarTodos")
	public String formEliminarTodos() {
		serv.eliminarTodos();
		return "redirect:/eliminacionTotalCorrecta";
	}
	
	//ELIMINAR UN REGISTRO SEGUN SU ID POSTMAN
	@DeleteMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable int id) {
		return serv.eliminarProducto(id);
	}
	
	//PANTALLA DE MODIFICACION DE REGISTRO HTML
	@GetMapping("/modificar/{id}")
	public String formModificar(@PathVariable("id") Integer id, Model model) {
		Producto producto = prodRepo.findById(id).get();
		model.addAttribute("producto", producto);
		return "modificarProducto";
	}	

	
	//MODIFICAR REGISTRO Y MANDAR A PANTALLA DE COMPROBACION HTML
	@PostMapping("/modificarProducto")
	public String modProducto(/*@RequestBody*/ Producto producto) {
		serv.modificarProducto(producto);
		return "redirect:/modificacionCorrecta";
	}
	
	//MODIFICAR UN REGISTRO POSTMAN
	@PutMapping("/modificar")
	public Producto modificarProducto(@RequestBody Producto producto) {
		return serv.modificarProducto(producto);
	}
	
	
	
}
