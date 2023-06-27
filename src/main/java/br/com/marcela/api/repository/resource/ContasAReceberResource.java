package br.com.marcela.api.repository.resource;


import br.com.marcela.api.model.ContasAReceber;
import br.com.marcela.api.repository.ContasAReceberRepository;
import br.com.marcela.api.repository.contasAReceber.ContasAReceberRepositoryQuery;
import br.com.marcela.api.repository.filter.ContasAReceberFilter;
import br.com.marcela.api.repository.projections.ContasAReceberDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contasareceber")
public class ContasAReceberResource {

    @Autowired
    private ContasAReceberRepository contasAReceberRepository;

    @GetMapping()
    public Page<ContasAReceberDto> pesquisar(ContasAReceberFilter contasAReceberFilter, Pageable pageable){
        return contasAReceberRepository.filtrar(contasAReceberFilter, pageable);
    }

    @GetMapping("/todos")
    public List<ContasAReceber> listarTodasContas(){
        return contasAReceberRepository.findAll();
    }

}
