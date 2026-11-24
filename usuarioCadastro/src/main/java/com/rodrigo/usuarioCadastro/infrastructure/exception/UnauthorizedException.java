package com.rodrigo.usuarioCadastro.infrastructure.exception;

import javax.security.sasl.AuthenticationException;

public class UnauthorizedException extends AuthenticationException {

    public UnauthorizedException(String menssagem) {
        super(menssagem);
    }

    public UnauthorizedException(String menssagem, Throwable throwable) {
        super(menssagem, throwable);
    }
}
