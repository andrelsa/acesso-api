package br.com.andre.acesso_api.adapter.repositories;

import br.com.andre.acesso_api.adapter.entities.VisitanteEntity;
import br.com.andre.acesso_api.core.domain.Visitante;
import br.com.andre.acesso_api.core.ports.VisitanteRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VisitanteRepositoryAdapter implements VisitanteRepositoryPort {

    private final VisitanteRepository visitanteRepository;
    private final PessoaRepositoryAdapter pessoaRepositoryAdapter;
    private final ModelMapper modelMapper;

    @Override
    public Visitante create(Visitante visitante) {
        VisitanteEntity visitanteEntity = modelMapper.map(visitante, VisitanteEntity.class);
        visitanteEntity.setPessoaEntity(pessoaRepositoryAdapter.createPessoa(visitante.getPessoa()));
        return modelMapper.map(visitanteRepository.save(visitanteEntity), Visitante.class);
    }

    @Override
    public Optional<Visitante> obtainByRg(String rg) {
        return visitanteRepository.findByRg(rg)
                .map(visitanteEntity -> modelMapper.map(visitanteEntity, Visitante.class));
    }

    @Override
    public Collection<Visitante> listAll() {
        return visitanteRepository.findAll().stream()
                .map(visitanteEntity -> modelMapper.map(visitanteEntity, Visitante.class))
                .toList();
    }
}