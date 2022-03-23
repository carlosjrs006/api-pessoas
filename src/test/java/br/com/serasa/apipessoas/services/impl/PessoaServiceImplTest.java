package br.com.serasa.apipessoas.services.impl;

import br.com.serasa.apipessoas.models.Pessoa;
import br.com.serasa.apipessoas.repositories.PessoaRepository;
import br.com.serasa.apipessoas.services.PessoaService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PessoaServiceImplTest {

    private static final Long ID_VALIDO = 1L;
    private static final String NOME_VALIDO = "carlos";
    private static final String CIDADE_VALIDA = "brasilia";
    private static final String ESTADO_VALIDO = "DF";
    private static final String TELEFONE_VALIDO = "61 992055814";
    private static final int SCORE_INACEITAVEL = 500;
    private static final int IDADE_VALIDA = 20;
    private static final int SCORE_RECOMENDAVEL = 1000;


    private PessoaService pessoaService;

    @MockBean
    private PessoaRepository pessoaRepository;

    private Pessoa pessoa;
    private Pessoa pessoa2;

    private List<Pessoa> pessoas = new ArrayList<>();

    @Before
    public void setUp() throws Exception {
        pessoaService = new PessoaServiceImpl(pessoaRepository);
        pessoa = new Pessoa();
        pessoa.setId(ID_VALIDO);
        pessoa.setScore(SCORE_INACEITAVEL);
        pessoa.setCidade(CIDADE_VALIDA);
        pessoa.setNome(NOME_VALIDO);
        pessoa.setIdade(IDADE_VALIDA);
        pessoa.setTelefone(TELEFONE_VALIDO);
        pessoa.setEstado(ESTADO_VALIDO);

        pessoa2 = new Pessoa();
        pessoa2.setId(ID_VALIDO);
        pessoa2.setScore(SCORE_RECOMENDAVEL);
        pessoa2.setCidade(CIDADE_VALIDA);
        pessoa2.setNome(NOME_VALIDO);
        pessoa2.setIdade(IDADE_VALIDA);
        pessoa2.setTelefone(TELEFONE_VALIDO);
        pessoa2.setEstado(ESTADO_VALIDO);

        pessoas.add(pessoa);
        pessoas.add(pessoa2);
    }

    @Test
    public void criarPessoaSucesso() {
        pessoaService.criarPessoa(pessoa);
        verify(pessoaRepository).save(pessoa);
    }


    @Test
    public void listarPessoasSucesso() {
        when(pessoaRepository.findAll()).thenReturn(pessoas);
        List<Pessoa> pessoasList = pessoaService.listarPessoas();
        assertThat(pessoasList).isEqualTo(pessoas);
    }

    @Test
    public void listarPessoasNoContent() {
        List<Pessoa> listaVazia = new ArrayList<>();
        when(pessoaRepository.findAll()).thenReturn(listaVazia);
        List<Pessoa> pessoasList = pessoaService.listarPessoas();
        assertThat(pessoasList).isEqualTo(listaVazia);
    }

    @Test
    public void buscarPessoaSucesso() {
        when(pessoaRepository.findById(ID_VALIDO)).thenReturn(Optional.of(pessoa));
        Optional<Pessoa> testePessoa = pessoaService.buscarPessoa(ID_VALIDO);
        assertThat(testePessoa).isEqualTo(Optional.of(pessoa));
    }

    @Test
    public void buscarPessoaNoContent() {
        when(pessoaRepository.findById(100L)).thenReturn(Optional.empty());
        Optional<Pessoa> testePessoa = pessoaService.buscarPessoa(100L);
        assertThat(testePessoa).isEqualTo(Optional.empty());
    }

    @Test
    public void recuperarScoreDescricao() {
        int score = pessoa.getScore();
        String testeScore = pessoaService.recuperarScoreDescricao(score);
        assertThat(testeScore).isEqualTo("Inaceitável");
    }
}