package com.tarea.tarea.repositories;

import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.junit.jupiter.api.Test;
import com.tarea.tarea.entities.Usuario;

@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UsuarioRepositoryTest {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    public void UsuarioRepository_SaveAll_ReturnSavedUsser(){

        Usuario usuario = Usuario.builder()
        .nombre("nelson")
        .apellidos("martinez")
        .email("nelsonmartinezdh@gmail.com").build();

        @SuppressWarnings("null")
        Usuario savedUsuario = usuarioRepository.save(usuario);

        Assertions.assertThat(savedUsuario).isNotNull();
        Assertions.assertThat(savedUsuario.getId()).isGreaterThan(0);
    }

    @SuppressWarnings("null")
    @Test
    public void UsuarioRepository_SaveAll_ReturnMoreThanOneUsser(){
        Usuario usuario1 = Usuario.builder()
        .nombre("javier")
        .email("javier@gmail.com")
        .build();

        Usuario usuario2 = Usuario.builder()
        .nombre("julian")
        .email("julian@gmail.com")
        .build();

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

        List<Usuario> usserList = usuarioRepository.findAll();

        Assertions.assertThat(usserList).isNotNull();
        Assertions.assertThat(usserList.size()).isEqualTo(2);
        
    }

    @SuppressWarnings("null")
    @Test
    public void UsuarioRepository_FindById(){
        Usuario usuario = Usuario.builder()
        .nombre("javier")
        .email("javier@gmail.com")
        .build();

        usuarioRepository.save(usuario);

        Usuario usser = usuarioRepository.findById(usuario.getId()).get();

        Assertions.assertThat(usser).isNotNull();
        Assertions.assertThat(usser.getEmail()).isEqualTo("javier@gmail.com");
    }

    @SuppressWarnings("null")
    @Test
    public void UsuarioRepository_UpdateUsuario_ReturnUsuarioNotNull(){
        Usuario usuario = Usuario.builder()
        .nombre("rosa")
        .email("rosa@gmail.com")
        .build();

        usuarioRepository.save(usuario);

        Usuario usuarioSaved = usuarioRepository.findById(usuario.getId()).get();
        usuarioSaved.setEmail("rosaRoja@gmail.com");
        usuarioSaved.setNombre("Rosa");

        Usuario updatedUsuario = usuarioRepository.save(usuarioSaved);

        Assertions.assertThat(updatedUsuario.getNombre()).isNotNull();
        Assertions.assertThat(updatedUsuario.getEmail()).isNotNull();
    }

    @SuppressWarnings("null")
    @Test
    public void UsuarioRepository_UsserDeleted_ReturnUsuarioIsEmpty(){
        Usuario usuario = Usuario.builder()
        .nombre("rosa")
        .email("rosa@gmail.com")
        .build();

        usuarioRepository.save(usuario);

        usuarioRepository.deleteById(usuario.getId());
        Optional<Usuario> usserReturn = usuarioRepository.findById(usuario.getId());
        
        Assertions.assertThat(usserReturn).isEmpty();
    }
    
}
