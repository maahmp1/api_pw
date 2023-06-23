package br.com.marcela.api.repository.contasAReceber;

import br.com.marcela.api.model.ContasAReceber;
import br.com.marcela.api.repository.filter.ContasAReceberFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ContasAReceberImpl implements ContasAReceberQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<ContasAReceber> filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable){
        return null;
    }
}
