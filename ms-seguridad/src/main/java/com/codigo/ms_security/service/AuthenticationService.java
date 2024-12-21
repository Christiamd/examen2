package com.codigo.ms_security.service;

import com.codigo.ms_security.aggregates.request.SignInRefreshToken;
import com.codigo.ms_security.aggregates.request.SignInRequest;
import com.codigo.ms_security.aggregates.request.SignUpRequest;
import com.codigo.ms_security.aggregates.response.SignInResponse;
import com.codigo.ms_security.entity.Usuario;

import java.util.List;

public interface AuthenticationService {

    //SIGNUP --> REGISTRARSE
    Usuario signUpUser(SignUpRequest signUpRequest);
    Usuario signUpAdmin(SignUpRequest signUpRequest);
    List<Usuario> todos();

    //METODOS DE AUTENTICACION
    SignInResponse signIn(SignInRequest signInRequest);
    // OBTENER NEUVO TOKEN DESDE UN REFRESH TOKEN
    SignInResponse getTokenByRefresh(SignInRefreshToken signInRefreshToken);;


}
