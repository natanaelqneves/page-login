package com.nqn.repository;

import com.nqn.modelo.TokenUsuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TokenUsuarioRepository extends JpaRepository<TokenUsuario, Long> {
}
