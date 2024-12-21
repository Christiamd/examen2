package com.codigo.ms_security.controller;

import com.codigo.ms_security.aggregates.request.SignInRefreshToken;
import com.codigo.ms_security.aggregates.request.SignInRequest;
import com.codigo.ms_security.aggregates.request.SignUpRequest;
import com.codigo.ms_security.aggregates.response.SignInResponse;
import com.codigo.ms_security.entity.Usuario;
import com.codigo.ms_security.service.AuthenticationService;
import com.codigo.ms_security.service.UsuarioSerice;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Key;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping("api/users/v1/")
@RequiredArgsConstructor
@RefreshScope
public class UsersController {

    private final AuthenticationService authenticationService;
    private final UsuarioSerice usuarioSerice;



    @PostMapping("/signupadmin")
    public ResponseEntity<Usuario> signUpAdmin(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService
                .signUpAdmin(signUpRequest));
    }

    @PostMapping("/signupuser")
    public ResponseEntity<Usuario> signUpUser(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(authenticationService
                .signUpUser(signUpRequest));
    }
    @GetMapping("/{username}")
    public ResponseEntity<Usuario> getInfoUser(@PathVariable String username) {
        return ResponseEntity.ok(usuarioSerice.getInfoUser(username));
    }


}
