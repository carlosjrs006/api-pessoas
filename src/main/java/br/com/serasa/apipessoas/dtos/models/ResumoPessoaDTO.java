package br.com.serasa.apipessoas.dtos.models;

import lombok.Data;
import lombok.Setter;

@Data
@Setter
public class ResumoPessoaDTO {

    private String nome;
    private String telefone;
    private int idade;
    private String scoreDescricao;

}
