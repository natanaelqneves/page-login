package com.nqn.modelo;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class TokenUsuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String token;
    @ManyToOne
    private Usuario usuario;
    private LocalDateTime dataDeExpiracao;

    public TokenUsuario() {
    }

    public TokenUsuario(String token, Usuario usuario) {
        this.token = token;
        this.usuario = usuario;
        this.dataDeExpiracao = LocalDateTime.now().plusMinutes(5);
    }

    public TokenUsuario(Long id, String token, Usuario usuario, LocalDateTime dataDeExpiracao) {
        this.id = id;
        this.token = token;
        this.usuario = usuario;
        this.dataDeExpiracao = dataDeExpiracao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuarioId(Usuario usuario) {
        this.usuario = usuario;
    }
}
