package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.example.demo.daos.UsuarioDAO;
import com.example.demo.entidades.Usuarios;

@SpringBootApplication
public class SpringJdbcApplication {

	@Autowired
	private UsuarioDAO usuarioDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcApplication.class, args);
	}

	@EventListener({ ApplicationReadyEvent.class })
	public void ejecutarPruebasConsulta() {
		Usuarios u1 = usuarioDAO.findById(1).get();
		System.out.println("nombre: " + u1.getNombre());
		System.out.println("email: " + u1.getEmail());
	
		Usuarios u2 = usuarioDAO.findByNombreAndEmail("Marge Simpson", "marge@simpson.com")
		System.out.println("nombre:" + u2.getNombre());

		Usuarios u3 = usuarioDAO.findByEmailAndPassword("marge@simpson.com", "1234")
		System.out.println("nombre:" + u3.getNombre());
	
	}
}
