package br.com.serasa.apipessoas.dtos.models;

import lombok.Data;




@Data
public class PessoaDTO {

    private Long id;
    private String nome;
    private int idade;
    private String telefone;
    private String cidade;
    private String estado;
    private int score;


}
