package br.com.serasa.apipessoas.controllers;

import br.com.serasa.apipessoas.dtos.forms.PessoaFormPostDTO;
import br.com.serasa.apipessoas.dtos.models.ItemListPessoaDTO;
import br.com.serasa.apipessoas.dtos.models.PessoaDTO;
import br.com.serasa.apipessoas.dtos.models.ResumoPessoaDTO;
import br.com.serasa.apipessoas.mappers.ItemListPessoaMapper;
import br.com.serasa.apipessoas.mappers.PessoaMapper;
import br.com.serasa.apipessoas.mappers.ResumoPessoaMapper;
import br.com.serasa.apipessoas.models.Pessoa;
import br.com.serasa.apipessoas.services.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/serasa/api/pessoas")
public class PessoaController {

    @Autowired
    private PessoaServiceImpl pessoaService;

    @Autowired
    private PessoaMapper pessoaMapper;

    @Autowired
    private ResumoPessoaMapper resumoPessoaMapper;

    @Autowired(required = true)
    private ItemListPessoaMapper itemListPessoaMapper;


    @PostMapping
    public ResponseEntity<PessoaDTO> salvar(@RequestBody @Valid PessoaFormPostDTO pessoaFormPostDTO) {
        Pessoa pessoa = pessoaMapper.dtoPostToModel(pessoaFormPostDTO);
        PessoaDTO pessoaDTO = pessoaMapper.modelToDto(pessoaService.criarPessoa(pessoa));
        return new ResponseEntity<PessoaDTO>(pessoaDTO, HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<ItemListPessoaDTO>> buscarTodos() {

        List<Pessoa> pessoas = pessoaService.listarPessoas();
        if (pessoas.isEmpty()) {
            //Caso acordado que em cenario de array vazio seja retornado 200, retirar if
            return ResponseEntity.noContent().build();
        } else {
            List<ItemListPessoaDTO> pessoaListDTO = itemListPessoaMapper.modelListToDtoList(pessoas);
            return ResponseEntity.ok(pessoaListDTO);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResumoPessoaDTO> buscarPorId(@PathVariable Long id) {

        Optional<Pessoa> pessoa = pessoaService.buscarPessoa(id);
        if (!pessoa.isPresent()) {
            return ResponseEntity.noContent().build();
        } else {
            ResumoPessoaDTO resumoPessoaDTO = resumoPessoaMapper.modelToDto(pessoa.get());
            return ResponseEntity.ok(resumoPessoaDTO);
        }

    }
}
