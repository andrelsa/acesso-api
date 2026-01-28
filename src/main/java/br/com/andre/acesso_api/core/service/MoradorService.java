package br.com.andre.acesso_api.core.service;

import br.com.andre.acesso_api.core.domain.Morador;
import br.com.andre.acesso_api.core.domain.Usuario;
import br.com.andre.acesso_api.core.ports.MoradorRepositoryPort;
import br.com.andre.acesso_api.core.ports.MoradorServicePort;
import br.com.andre.acesso_api.core.ports.UsuarioRepositoryPort;
import br.com.andre.acesso_api.core.ports.UsuarioServicePort;
import lombok.RequiredArgsConstructor;

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
}
