package com.miguelsouza.API_REST.exceptions;

public class CepNotFoundException extends RuntimeException{

    public CepNotFoundException(String cep) {
        super("CEP não encontrado: " + cep);

    }
}
