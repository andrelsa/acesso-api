package br.com.andre.acesso_api.core.domain;

import java.time.LocalDateTime;

public class Visita {
    private Long id;
    private LocalDateTime dataHora;
    private Long idVisitante;
    private Long idMorador;

    public Visita() {
    }

    public Visita(Long id, LocalDateTime dataHora, Long idVisitante, Long idMorador) {
        this.id = id;
        this.dataHora = dataHora;
        this.idVisitante = idVisitante;
        this.idMorador = idMorador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Long getIdVisitante() {
        return idVisitante;
    }

    public void setIdVisitante(Long idVisitante) {
        this.idVisitante = idVisitante;
    }

    public Long getIdMorador() {
        return idMorador;
    }

    public void setIdMorador(Long idMorador) {
        this.idMorador = idMorador;
    }
}
