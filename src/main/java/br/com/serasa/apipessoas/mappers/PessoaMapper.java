package br.com.serasa.apipessoas.mappers;

import br.com.serasa.apipessoas.dtos.forms.PessoaFormPostDTO;
import br.com.serasa.apipessoas.dtos.models.PessoaDTO;
import br.com.serasa.apipessoas.models.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PessoaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public Pessoa dtoPostToModel(PessoaFormPostDTO pessoaFormPostDto) {

        return modelMapper.map(pessoaFormPostDto, Pessoa.class);
    }

    public PessoaDTO modelToDto(Pessoa pessoa) {

        return modelMapper.map(pessoa, PessoaDTO.class);
    }

    public List<PessoaDTO> modelListToDtoList(List<Pessoa> pessoas) {

        return pessoas.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }


}
