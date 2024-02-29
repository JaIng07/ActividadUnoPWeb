package com.tarea.tarea.repositories;

import com.tarea.tarea.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //Query Methods

    //Simples
    List<Usuario> findByUsername(String username);
    List<Usuario> findByEmail(String email);
    List<Usuario> findByNombre(String nombre);
    List<Usuario> findByApellidos(String apellidos);
    List<Usuario> findByEdad(Integer edad);
    List<Usuario> findByRol(String rol);

    //Compuestos
    List<Usuario> findByNombreAndApellidos(String nombre, String apellidos);
    List<Usuario> findByUsernameAndRol(String username, String rol);
    List<Usuario> findByNombreOrApellidos(String nombre, String apellidos);

    //Personalizados

    //Encontrar usuario por foto
    @Query("SELECT u FROM Usuario u WHERE u.foto = ?1")
    List<Usuario> findByFoto(String foto);

    //Encontrar usuario con edad mayor o igual a
    @Query("SELECT u FROM Usuario u WHERE u.edad >= ?1")
    List<Usuario> findByEdadAfter(Integer edad);

    //Encontrar usuario por fecha de creación
    @Query("SELECT u FROM Usuario u WHERE u.create_at = ?1")
    List<Usuario> findByCreate_at(LocalDate create_at);
}
