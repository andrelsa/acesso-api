package br.com.andre.acesso_api.core.service;

import br.com.andre.acesso_api.core.domain.Visitante;
import br.com.andre.acesso_api.core.exceptions.BusinessException;
import br.com.andre.acesso_api.core.ports.output.VisitanteRepositoryPort;
import br.com.andre.acesso_api.core.ports.input.VisitanteServicePort;

import java.util.Collection;

public class VisitanteService implements VisitanteServicePort {

    private final VisitanteRepositoryPort visitanteRepositoryPort;

    public VisitanteService(VisitanteRepositoryPort visitanteRepositoryPort) {
        this.visitanteRepositoryPort = visitanteRepositoryPort;
    }

    @Override
    public Visitante createVisitante(Visitante visitante) {
        visitanteRepositoryPort.obtainByRg(visitante.getRg())
                .ifPresent(v -> {
                    throw new BusinessException("Visitante já cadastrado!");

                });

        return visitanteRepositoryPort.create(visitante);
    }

    @Override
    public Visitante obtainByRg(String rg) {
        return visitanteRepositoryPort.obtainByRg(rg)
                .orElseThrow(() -> new IllegalArgumentException("Visitante não encontrado!"));

    }

    @Override
    public Collection<Visitante> listAll() {
        return visitanteRepositoryPort.listAll();
    }
}
