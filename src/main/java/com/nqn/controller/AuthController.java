package com.nqn.controller;

import com.nqn.dto.RequestLogin;
import com.nqn.dto.RequestRegister;
import com.nqn.dto.ResponseToken;
import com.nqn.modelo.Usuario;
import com.nqn.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ResponseToken> login(@RequestBody RequestLogin request) {
        String token = authService.login(request);
        return ResponseEntity.ok(new ResponseToken(token));
    }

    @PostMapping("/registro")
    public ResponseEntity<Usuario> registro(@RequestBody RequestRegister request) {
        return ResponseEntity.ok(authService.register(request));
    }
}
