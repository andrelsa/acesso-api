package br.com.andre.acesso_api.adapter.convert;

import br.com.andre.acesso_api.adapter.dto.MoradorDto;
import br.com.andre.acesso_api.adapter.dto.UsuarioDto;
import br.com.andre.acesso_api.core.domain.Morador;
import br.com.andre.acesso_api.core.domain.Pessoa;
import br.com.andre.acesso_api.core.domain.Usuario;
import org.springframework.stereotype.Component;

@Component
public class MoradorConverter {

    public Morador toDomain(MoradorDto moradorDto) {
        return new Morador(
                moradorDto.getId(),
                moradorDto.getCpf(),
                moradorDto.getEndereco(),
                moradorDto.getCeluar(),
                new Pessoa(null, moradorDto.getNome()));
    }

    public MoradorDto toDto(Morador morador) {
        return new MoradorDto(
                morador.getId(),
                morador.getPessoa().getNome(),
                morador.getCpf(),
                morador.getEndereco(),
                morador.getCelular());
    }
}
