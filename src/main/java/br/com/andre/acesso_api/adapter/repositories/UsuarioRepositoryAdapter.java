package br.com.andre.acesso_api.adapter.repositories;

import br.com.andre.acesso_api.adapter.entities.PessoaEntity;
import br.com.andre.acesso_api.adapter.entities.UsuarioEntity;
import br.com.andre.acesso_api.core.domain.Pessoa;
import br.com.andre.acesso_api.core.domain.Usuario;
import br.com.andre.acesso_api.core.ports.UsuarioRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioRepository usuarioRepository;
    private final PessoaRepositoryAdapter pessoaRepositoryAdapter;
    private final ModelMapper modelMapper;

    @Override
    public Usuario create(Usuario usuario) {
        UsuarioEntity usuarioEntity = modelMapper.map(usuario, UsuarioEntity.class);
        usuarioEntity.setPessoaEntity(pessoaRepositoryAdapter.createPessoa(usuario.getPessoa()));
        UsuarioEntity save = usuarioRepository.save(usuarioEntity);

        return modelMapper.map(save, Usuario.class);
    }

    @Override
    public Usuario obtemByEmail(String email) {
        UsuarioEntity usuarioByEmail = usuarioRepository.findByEmail(email);
        if (usuarioByEmail == null) {
            return null;
        }
        return modelMapper.map(usuarioByEmail, Usuario.class);
    }

}
