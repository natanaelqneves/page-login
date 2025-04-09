package com.nqn.service;

import com.nqn.dto.DadosLogado;
import com.nqn.dto.DadosLogin;
import com.nqn.dto.DadosUsuario;
import com.nqn.modelo.Usuario;
import com.nqn.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository repository;

    public DadosLogado autenticarUsuario(DadosLogin dados) {
        Usuario usuario = repository.findByNomeDeUsuario(dados.nomeDeUsuario());
            if(usuario != null && dados.senha().equals(usuario.getSenha())) {
                return new DadosLogado(usuario.getId(), usuario.getNome(), usuario.getEmail());
            }
            return null;
        }
    }
