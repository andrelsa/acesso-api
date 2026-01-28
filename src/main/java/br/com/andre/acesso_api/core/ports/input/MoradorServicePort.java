package br.com.andre.acesso_api.core.ports.input;

import br.com.andre.acesso_api.core.domain.Morador;

import java.util.Collection;

public interface MoradorServicePort {
    Morador createMorador(Morador morador);

    Collection<Morador> findAll();
}
