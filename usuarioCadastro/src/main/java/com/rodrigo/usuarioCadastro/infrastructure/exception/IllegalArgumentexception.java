package com.rodrigo.usuarioCadastro.infrastructure.exception;

public class IllegalArgumentexception extends RuntimeException {

    public IllegalArgumentexception(String menssagem) {
        super(menssagem);
    }

    public IllegalArgumentexception(String menssagem, Throwable throwable) {
        super(menssagem, throwable);
    }
}
