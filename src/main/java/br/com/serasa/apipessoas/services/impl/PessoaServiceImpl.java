package br.com.serasa.apipessoas.services.impl;

import br.com.serasa.apipessoas.exceptions.NegocioException;
import br.com.serasa.apipessoas.models.Pessoa;
import br.com.serasa.apipessoas.models.Score;
import br.com.serasa.apipessoas.repositories.PessoaRepository;
import br.com.serasa.apipessoas.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {


    @Autowired
    private PessoaRepository repository;

    @Override
    public Pessoa criarPessoa(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return repository.findAll();
    }

    @Override
    public Optional<Pessoa> buscarPessoa(Long id) {
        return repository.findById(id);
    }

    @Override
    public String recuperarScoreDescricao(int score) {
        var scoreDescricao = "";

        if (score >= 0 && score <= 200) {
            scoreDescricao = Score.INSUFICIENTE.getDescricao();
        } else if (score <= 500) {
            scoreDescricao = Score.INACEITAVEL.getDescricao();
        } else if (score <= 700) {
            scoreDescricao = Score.ACEITAVEL.getDescricao();
        } else if (score <= 1000) {
            scoreDescricao = Score.RECOMENDAVEL.getDescricao();
        } else {
            throw new NegocioException("Valor do score informado não esta dentro da faixa.");
        }


        return scoreDescricao;
    }
}
