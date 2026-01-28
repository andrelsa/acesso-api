package br.com.andre.acesso_api.infra;

import br.com.andre.acesso_api.core.ports.input.MoradorServicePort;
import br.com.andre.acesso_api.core.ports.input.UsuarioServicePort;
import br.com.andre.acesso_api.core.ports.input.VisitanteServicePort;
import br.com.andre.acesso_api.core.ports.output.MoradorRepositoryPort;
import br.com.andre.acesso_api.core.ports.output.UsuarioRepositoryPort;
import br.com.andre.acesso_api.core.ports.output.VisitanteRepositoryPort;
import br.com.andre.acesso_api.core.service.MoradorService;
import br.com.andre.acesso_api.core.service.UsuarioService;
import br.com.andre.acesso_api.core.service.VisitanteService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansConfig {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public UsuarioServicePort usuarioServiceImpl(UsuarioRepositoryPort usuarioRepositoryPort) {
        return new UsuarioService(usuarioRepositoryPort);
    }

    @Bean
    public MoradorServicePort moradorServicePort(MoradorRepositoryPort moradorRepositoryPort) {
        return new MoradorService(moradorRepositoryPort);
    }

    @Bean
    public VisitanteServicePort visitanteServicePort(VisitanteRepositoryPort visitanteRepositoryPort) {
        return new VisitanteService(visitanteRepositoryPort);
    }
}
