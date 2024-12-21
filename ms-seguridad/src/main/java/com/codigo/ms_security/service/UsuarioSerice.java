package com.codigo.ms_security.service;

import com.codigo.ms_security.entity.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioSerice {
    UserDetailsService userDetailsService();

    Usuario getInfoUser(String email);
}
