package com.rodrigo.usuarioCadastro.infrastructure.exception;

public class ConflictExcepition extends RuntimeException{

    public ConflictExcepition(String menssagem) {
        super(menssagem);
    }

    public ConflictExcepition(String menssagem, Throwable throwable) {
        super(menssagem, throwable);
    }
}
