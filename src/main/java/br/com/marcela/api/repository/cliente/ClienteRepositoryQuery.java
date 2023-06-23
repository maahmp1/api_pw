package br.com.marcela.api.repository.cliente;

import br.com.marcela.api.model.Cliente;
import br.com.marcela.api.repository.filter.ClienteFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ClienteRepositoryQuery {

    public Page<Cliente> filtrar(ClienteFilter clienteFilter, Pageable pageable);
}
