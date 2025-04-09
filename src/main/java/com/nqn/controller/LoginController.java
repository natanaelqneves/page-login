package com.nqn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nqn.dto.DadosLogado;
import com.nqn.dto.DadosLogin;
import com.nqn.dto.DadosUsuario;
import com.nqn.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.net.URI;


@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<String> login(@RequestBody DadosLogin dados) throws JsonProcessingException {
        DadosLogado dadosLogado = service.autenticarUsuario(dados);

        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(dadosLogado);
            if(dadosLogado != null){
                return ResponseEntity.ok(json);
            } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Erro na requisição");
        }
    }
    
}
