package br.com.andre.acesso_api.core.ports.input;

import br.com.andre.acesso_api.core.domain.Usuario;

public interface UsuarioServicePort {
    Usuario createUsuario(Usuario usuario);
}
