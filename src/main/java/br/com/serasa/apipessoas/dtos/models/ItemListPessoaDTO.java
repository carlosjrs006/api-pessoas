package br.com.serasa.apipessoas.dtos.models;


import lombok.Data;

@Data
public class ItemListPessoaDTO {

    private String nome;
    private String cidade;
    private String estado;
    private String scoreDescricao;

}
