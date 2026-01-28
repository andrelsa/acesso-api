package br.com.andre.acesso_api.core.ports;

import br.com.andre.acesso_api.core.domain.Morador;

public interface MoradorRepositoryPort {
    Morador create(Morador morador);
    Morador obtainByCpf(String cpf);
}
