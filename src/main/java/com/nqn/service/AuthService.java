package com.nqn.service;

import com.nqn.dto.RequestLogin;
import com.nqn.dto.RequestRegister;
import com.nqn.modelo.TokenUsuario;
import com.nqn.modelo.Usuario;
import com.nqn.repository.TokenUsuarioRepository;
import com.nqn.repository.UsuarioRepository;
import com.nqn.security.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TokenUsuarioRepository tokenRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private JWTUtils jwtUtils;

    public String login(@RequestBody RequestLogin request){
        Usuario usuario = usuarioRepository.findByMatricula(request.matricula())
                .orElseThrow(()-> new UsernameNotFoundException("Usuário não encontrado"));

        if (!passwordEncoder.matches(request.senha(), usuario.getSenha())) {
            throw new BadCredentialsException("Credenciais inválidas");
        } else {
        }
        String token = jwtUtils.gerarToken(request.matricula());

        tokenRepository.save(new TokenUsuario(token, usuario));
        return token;
    }

    public Usuario register(@RequestBody RequestRegister request) {
        if (usuarioRepository.findByMatricula(request.matricula()).isPresent()) {
            throw new IllegalArgumentException("Matrícula já registrada!");
        }

        String senhaCodificada = passwordEncoder.encode(request.senha());

        Usuario novoUsuario = new Usuario();
        novoUsuario.setNome(request.nome());
        novoUsuario.setEmail(request.email());
        novoUsuario.setMatricula(request.matricula());
        novoUsuario.setSenha(senhaCodificada);

        // Salva no banco de dados
        return usuarioRepository.save(novoUsuario);
    }


}
