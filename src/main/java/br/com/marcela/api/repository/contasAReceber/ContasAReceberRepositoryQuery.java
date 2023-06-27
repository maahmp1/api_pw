package br.com.marcela.api.repository.contasAReceber;

import br.com.marcela.api.repository.filter.ContasAReceberFilter;
import br.com.marcela.api.repository.projections.ContasAReceberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasAReceberRepositoryQuery {
    public Page<ContasAReceberDto> filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable);
}
