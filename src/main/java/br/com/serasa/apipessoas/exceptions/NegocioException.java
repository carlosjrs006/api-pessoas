package br.com.serasa.apipessoas.exceptions;

public class NegocioException extends RuntimeException {
    public NegocioException(String exception) {
        super(exception);
    }
}
