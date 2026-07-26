package com.allan.user_crud_api.exception;

public class UsuarioNaoEncontradoException extends RuntimeException{

    public UsuarioNaoEncontradoException(Long id){
        super("Usuário com id " + id + " não encontrado");
    }
}
