package br.com.serasa.apipessoas.dtos.forms;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class PessoaFormPostDTO {

    @NotBlank
    private String nome;
    @NotNull
    private int idade;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotNull
    @Min(value = 0)
    @Max(value = 1000)
    private int score;
}
