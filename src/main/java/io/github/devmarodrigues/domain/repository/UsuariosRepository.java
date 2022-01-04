package io.github.devmarodrigues.domain.repository;

import io.github.devmarodrigues.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuariosRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByLogin(String login);

}
