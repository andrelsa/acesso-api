package br.com.andre.acesso_api.adapter.convert;

import br.com.andre.acesso_api.adapter.dto.UsuarioDto;
import br.com.andre.acesso_api.core.domain.Pessoa;
import br.com.andre.acesso_api.core.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioConverter {

    public Usuario toDomain(UsuarioDto usuarioDto) {
        return new Usuario(
                usuarioDto.getId(),
                usuarioDto.getEmail(),
                usuarioDto.getSenha(),
                usuarioDto.getAdministrador(),
                new Pessoa(null, usuarioDto.getNome()));
    }

    public UsuarioDto toDto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(), usuario.getPessoa().getNome(), usuario.getEmail(), usuario.getSenha(), usuario.getAdministrador());
    }
}
