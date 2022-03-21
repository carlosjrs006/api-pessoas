package br.com.serasa.apipessoas.mappers;

import br.com.serasa.apipessoas.dtos.models.ResumoPessoaDTO;
import br.com.serasa.apipessoas.models.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResumoPessoaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ResumoPessoaDTO modelToDto(Pessoa pessoa) {

        return modelMapper.map(pessoa, ResumoPessoaDTO.class);
    }

    public List<ResumoPessoaDTO> modelListToDtoList(List<Pessoa> pessoas) {

        return pessoas.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }
}

