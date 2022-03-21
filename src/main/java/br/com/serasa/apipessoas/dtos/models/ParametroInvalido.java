package br.com.serasa.apipessoas.dtos.models;

import lombok.Data;

@Data
public class ParametroInvalido {
    private String parametro;
    private String mensagem;

    public ParametroInvalido(String parametro, String mensagem) {
        this.parametro = parametro;
        this.mensagem = mensagem;
    }
}
