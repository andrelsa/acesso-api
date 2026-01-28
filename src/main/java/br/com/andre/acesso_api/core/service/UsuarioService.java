package br.com.andre.acesso_api.core.service;

import br.com.andre.acesso_api.core.domain.Usuario;
import br.com.andre.acesso_api.core.ports.UsuarioRepositoryPort;
import br.com.andre.acesso_api.core.ports.UsuarioServicePort;

public class UsuarioService implements UsuarioServicePort {

    private final UsuarioRepositoryPort usuarioRepositoryPort;

    public UsuarioService(UsuarioRepositoryPort usuarioRepositoryPort) {
        this.usuarioRepositoryPort = usuarioRepositoryPort;
    }

    @Override
    public Usuario createUsuario(Usuario usuario) {
        Usuario usuarioExistente = usuarioRepositoryPort.obtemByEmail(usuario.getEmail());
        if (usuarioExistente!= null){
            throw new IllegalArgumentException("Usuário já cadastrado!");
        }
        return usuarioRepositoryPort.create(usuario);
    }
}
