package br.com.marcela.api.repository.resource;

import br.com.marcela.api.repository.ContasAReceberRepository;
import br.com.marcela.api.repository.filter.ContasAReceberFilter;
import br.com.marcela.api.repository.projections.ContasAReceberDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;

public class ContasAReceberResource {

   

    @GetMapping()
    public Page<ContasAReceberDto> filtrar(ContasAReceberFilter contasAReceberFilter, Pageable pageable){
        return ContasAReceberRepository.filtrar(contasAReceberFilter, pageable);
    }

}
