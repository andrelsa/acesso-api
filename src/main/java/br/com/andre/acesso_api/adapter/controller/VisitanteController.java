package br.com.andre.acesso_api.adapter.controller;

import br.com.andre.acesso_api.adapter.convert.VisitanteConverter;
import br.com.andre.acesso_api.adapter.dto.VisitanteDto;
import br.com.andre.acesso_api.core.domain.Visitante;
import br.com.andre.acesso_api.core.ports.VisitanteServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/visitantes")
@RequiredArgsConstructor
public class VisitanteController {

    private final VisitanteConverter visitanteConverter;
    private final VisitanteServicePort visitanteServicePort;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VisitanteDto create(@RequestBody VisitanteDto visitanteDto) {
        Visitante visitante = visitanteServicePort.createVisitante(visitanteConverter.toDomain(visitanteDto));
        return visitanteConverter.toDto(visitante);
    }


    @GetMapping("/{rg}")
    public VisitanteDto obtainByRg(@PathVariable String rg) {
        Visitante visitante = visitanteServicePort.obtainByRg(rg);
        return visitanteConverter.toDto(visitante);
    }

    @GetMapping
    public List<VisitanteDto> listAll(){
        return visitanteServicePort.listAll().stream()
                .map(visitanteConverter::toDto)
                .collect(Collectors.toList());
    }
}
