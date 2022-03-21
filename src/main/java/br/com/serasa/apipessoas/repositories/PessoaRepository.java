package br.com.serasa.apipessoas.repositories;

import br.com.serasa.apipessoas.models.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
