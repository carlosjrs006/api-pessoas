package br.com.serasa.apipessoas.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Score {

    INSUFICIENTE("Insuficiente"),
    INACEITAVEL("Inaceitável"),
    ACEITAVEL("Aceitável"),
    RECOMENDAVEL("Recomendável");

    private final String descricao;
}
