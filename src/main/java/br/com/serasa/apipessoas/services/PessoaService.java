package br.com.serasa.apipessoas.services;

import br.com.serasa.apipessoas.models.Pessoa;

import java.util.List;

public interface PessoaService {

     Pessoa criarPessoa(Pessoa pessoa);

     List<Pessoa> listaPessoas();

     Pessoa listaPessoaId(Long id);

}
