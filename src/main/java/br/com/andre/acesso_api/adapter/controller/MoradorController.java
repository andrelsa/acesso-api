package br.com.andre.acesso_api.adapter.controller;

import br.com.andre.acesso_api.adapter.convert.MoradorConverter;
import br.com.andre.acesso_api.adapter.dto.MoradorDto;
import br.com.andre.acesso_api.core.domain.Morador;
import br.com.andre.acesso_api.core.ports.MoradorServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/moradores")
@RequiredArgsConstructor
public class MoradorController {

    private final MoradorServicePort moradorServicePort;
    private final MoradorConverter moradorConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MoradorDto create(@RequestBody MoradorDto moradorDto) {
        Morador morador = moradorServicePort.createMorador(moradorConverter.toDomain(moradorDto));
        return moradorConverter.toDto(morador);
    }
}
