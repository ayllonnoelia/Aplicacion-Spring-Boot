package com.practica;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.practica.clase.Usuario;
import com.practica.repositorio.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class AplicacionSpringApplicationTests {

	@Autowired 
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Test
	public void crearUsuario(){
		Usuario usuario = new Usuario();
		usuario.setNombre("noelia.diaz@gmail.com");
		usuario.setPassword(encoder.encode("123456789"));
		Usuario respuesta = repo.save(usuario);
		
		assertTrue(respuesta.getPassword().equalsIgnoreCase(usuario.getPassword()));
	}

}


