package br.com.andre.acesso_api.core.ports;

import br.com.andre.acesso_api.core.domain.Usuario;

public interface UsuarioRepositoryPort {
    Usuario create(Usuario usuario);
    Usuario obtemByEmail(String email);
}
