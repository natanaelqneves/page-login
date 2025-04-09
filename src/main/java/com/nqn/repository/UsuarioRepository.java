package com.nqn.repository;

import com.nqn.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Usuario findByNomeDeUsuario(String nomeDeUsuario);
}
