package br.com.andre.acesso_api.adapter.repositories;

import br.com.andre.acesso_api.adapter.entities.MoradorEntity;
import br.com.andre.acesso_api.core.domain.Morador;
import br.com.andre.acesso_api.core.ports.output.MoradorRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class MoradorRepositoryAdapter implements MoradorRepositoryPort {
    private final MoradorRepository moradorRepository;
    private final PessoaRepositoryAdapter pessoaRepositoryAdapter;
    private final ModelMapper modelMapper;

    @Override
    public Morador create(Morador morador) {
        MoradorEntity entity = modelMapper.map(morador, MoradorEntity.class);
        entity.setPessoaEntity(pessoaRepositoryAdapter.createPessoa(morador.getPessoa()));
        MoradorEntity novoMorador = moradorRepository.save(entity);
        return modelMapper.map(novoMorador, Morador.class);
    }

    @Override
    public Morador obtainByCpf(String cpf) {
        MoradorEntity moradorByCpf = moradorRepository.findByCpf(cpf);

        if (moradorByCpf == null) {
            return null;
        }
        return modelMapper.map(moradorByCpf, Morador.class);
    }

    @Override
    public Collection<Morador> findAll() {
        return moradorRepository.findAll()
                .stream()
                .map(moradorEntity -> modelMapper.map(moradorEntity, Morador.class))
                .toList();
    }
}
