package br.com.marcela.api.resources;

import br.com.marcela.api.model.Cliente;
import br.com.marcela.api.model.ContasAReceber;
import br.com.marcela.api.repository.ContasAReceberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.OneToMany;
import java.util.List;

@RestController
@RequestMapping("/contasAReceber")

public class ContasAReceberResources {
    @Autowired
    private ContasAReceberRepository contasAReceberRepository;

    @GetMapping("/todos")
    public List<ContasAReceber> listarTodasContasAReceber() {
        return contasAReceberRepository.findAll();
    }

}

