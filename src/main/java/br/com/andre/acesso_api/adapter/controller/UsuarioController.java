package br.com.andre.acesso_api.adapter.controller;

import br.com.andre.acesso_api.adapter.convert.UsuarioConverter;
import br.com.andre.acesso_api.adapter.dto.UsuarioDto;
import br.com.andre.acesso_api.core.ports.input.UsuarioServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioServicePort usuarioServicePort;
    private final UsuarioConverter usuarioConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto) {
        return usuarioConverter
                .toDto(usuarioServicePort.createUsuario(usuarioConverter.toDomain(usuarioDto)));
    }
}
