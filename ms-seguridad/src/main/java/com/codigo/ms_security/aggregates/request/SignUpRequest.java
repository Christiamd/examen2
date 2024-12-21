package com.codigo.ms_security.aggregates.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequest {
    private String nombres;
    private String apellidos;
    private String email;
    private String password;
    private String tipoDoc;
    private String numDoc;
}
