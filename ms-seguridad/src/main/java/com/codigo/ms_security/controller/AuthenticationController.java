package com.codigo.ms_security.controller;

import com.codigo.ms_security.aggregates.request.SignInRefreshToken;
import com.codigo.ms_security.aggregates.request.SignInRequest;
import com.codigo.ms_security.aggregates.request.SignUpRequest;
import com.codigo.ms_security.aggregates.response.SignInResponse;
import com.codigo.ms_security.entity.Usuario;
import com.codigo.ms_security.service.AuthenticationService;
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
@RequestMapping("api/authentication/v1/")
@RequiredArgsConstructor
@RefreshScope
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    //@Value("${dato.propiedad}")


    //OBTENER UN ACCESS TOKEN POR MEDIO DE LOGIN
    @PostMapping("/signin")
    public ResponseEntity<SignInResponse> signIn(
            @RequestBody SignInRequest signInRequest){
        return ResponseEntity.ok(authenticationService
                .signIn(signInRequest));
    }
    //OBTENER UN ACCESS TOKEN PO MEDIO DE REFRESHTOKEN
    @PostMapping("/refreshToken")
    public ResponseEntity<SignInResponse> signInRefresh(
            @RequestBody SignInRefreshToken signInRefreshToken){
        return ResponseEntity.ok(authenticationService
                .getTokenByRefresh(signInRefreshToken));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Usuario>> getALl(){
        return ResponseEntity.ok(authenticationService.todos());
    }

    @GetMapping("/clave")
    public ResponseEntity<String> getClaveFirma(@RequestHeader("X-Code-App") String valor){
        String dato;
        if(valor.equals("Validado")){
            Key key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
            dato = Base64.getEncoder().encodeToString(key.getEncoded());
        }else {
            dato=null;
        }

        return ResponseEntity.ok(dato);
    }

    /*@GetMapping("/prueba")
    public ResponseEntity<String> getPrueba(){
        return ResponseEntity.ok(datoPropiedad);
    }*/
}
