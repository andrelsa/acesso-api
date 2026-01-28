package br.com.andre.acesso_api.adapter.repositories;

import br.com.andre.acesso_api.adapter.entities.MoradorEntity;
import br.com.andre.acesso_api.adapter.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoradorRepository extends JpaRepository<MoradorEntity, Long> {
    MoradorEntity findByCpf(String cpf);
}
