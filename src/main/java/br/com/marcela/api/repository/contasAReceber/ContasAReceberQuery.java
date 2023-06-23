package br.com.marcela.api.repository.contasAReceber;

import br.com.marcela.api.model.ContasAReceber;
import br.com.marcela.api.repository.filter.ContasAReceberFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContasAReceberQuery {

    public Page<ContasAReceber> filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable);
}
