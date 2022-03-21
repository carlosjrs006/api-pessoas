package br.com.serasa.apipessoas.dtos.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Erro {

    private String descricao;
    private List<ParametroInvalido> parametrosInvalidos;

    public Erro() {
    }

    public Erro(String descricao) {
        this.descricao = descricao;
    }
}