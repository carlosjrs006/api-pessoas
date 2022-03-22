package br.com.serasa.apipessoas.services;

import br.com.serasa.apipessoas.models.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {

     Pessoa criarPessoa(Pessoa pessoa);

     List<Pessoa> listarPessoas();

     Optional<Pessoa> buscarPessoa(Long id);

     String recuperarScoreDescricao(int score);

}
