package com.example.demo.daos;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entidades.Usuarios;

@Repository
public interface UsuarioDAO extends CrudRepository<Usuarios, Integer> {

    // Consulta derivada
    public Usuario findByNombreAndEmail(String nombre, String email);

    public Usuario findByEmailAndPassword(String email, String password  )

    //Consulta especifica
    @Query("SELECT * FROM usuarios WHERE email=:elEMail AND password=:elPassword")
    public Usuario obtenUsuario(@Param("elEmail") String email, @Param("elPassword") String password);

}
