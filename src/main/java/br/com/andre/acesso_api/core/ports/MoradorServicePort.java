package br.com.andre.acesso_api.core.ports;

import br.com.andre.acesso_api.core.domain.Morador;

public interface MoradorServicePort {
    Morador createMorador(Morador morador);
}
