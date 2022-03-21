package br.com.serasa.apipessoas.mappers;

import br.com.serasa.apipessoas.dtos.models.ItemListPessoaDTO;
import br.com.serasa.apipessoas.models.Pessoa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ItemListPessoaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ItemListPessoaDTO modelToDto(Pessoa pessoa) {

        return modelMapper.map(pessoa, ItemListPessoaDTO.class);
    }

    public List<ItemListPessoaDTO> modelListToDtoList(List<Pessoa> pessoas) {

        return pessoas.stream()
                .map(this::modelToDto)
                .collect(Collectors.toList());
    }
}
