package br.com.marcela.api.repository;

import br.com.marcela.api.model.ContasAReceber;
import br.com.marcela.api.repository.contasAReceber.ContasAReceberQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContasAReceberRepository extends JpaRepository<ContasAReceber, Integer>, ContasAReceberQuery {
}
