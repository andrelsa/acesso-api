package br.com.andre.acesso_api.core.service;

import br.com.andre.acesso_api.core.domain.Morador;
import br.com.andre.acesso_api.core.ports.output.MoradorRepositoryPort;
import br.com.andre.acesso_api.core.ports.input.MoradorServicePort;

import java.util.Collection;

public class MoradorService implements MoradorServicePort {

    private final MoradorRepositoryPort moradorRepositoryPort;

    public MoradorService(MoradorRepositoryPort moradorRepositoryPort) {
        this.moradorRepositoryPort = moradorRepositoryPort;
    }

    @Override
    public Morador createMorador(Morador morador) {
        Morador moradorExistente = moradorRepositoryPort.obtainByCpf(morador.getCpf());
        if (moradorExistente != null){
            throw new IllegalArgumentException("Morador já cadastrado!");
        }
        return moradorRepositoryPort.create(morador);
    }

    @Override
    public Collection<Morador> findAll() {
        return moradorRepositoryPort.findAll();
    }
}
