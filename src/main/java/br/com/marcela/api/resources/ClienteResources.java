package br.com.marcela.api.resources;


import br.com.marcela.api.model.Cliente;
import br.com.marcela.api.model.ContasAReceber;
import br.com.marcela.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/clientes")


public class ClienteResources {
    @Autowired

    private ClienteRepository clienteRepository;

    @GetMapping("/todos")
    public List<Cliente> listarTodosClientes(){
    return clienteRepository.findAll();
    }

}
