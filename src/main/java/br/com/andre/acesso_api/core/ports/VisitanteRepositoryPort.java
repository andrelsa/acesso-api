package br.com.andre.acesso_api.core.ports;

import br.com.andre.acesso_api.core.domain.Visitante;

import java.util.Collection;
import java.util.Optional;

public interface VisitanteRepositoryPort {
    Visitante create(Visitante visitante);
    Optional<Visitante> obtainByRg(String rg);

    Collection<Visitante> listAll();
}
