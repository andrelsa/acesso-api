package br.com.andre.acesso_api.core.ports.output;

import br.com.andre.acesso_api.core.domain.Morador;

import java.util.Collection;

public interface MoradorRepositoryPort {
    Morador create(Morador morador);

    Morador obtainByCpf(String cpf);

    Collection<Morador> findAll();
}
