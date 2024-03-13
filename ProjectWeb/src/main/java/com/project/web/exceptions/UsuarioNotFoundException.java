package com.project.web.exceptions;

public class UsuarioNotFoundException extends Exception {
    public UsuarioNotFoundException() {
        super();
    }

    public UsuarioNotFoundException(String message) {
        super(message);
    }
}
