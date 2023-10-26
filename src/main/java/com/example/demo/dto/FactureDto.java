package com.example.demo.dto;

import java.util.List;

/**
 * Classe permettant d'exposer des données au format JSON au client.
 */
public class FactureDto {

    private Long id;
    private ClientDto client;
    private List<LigneFactureDto> ligneFactures ;

    public FactureDto(Long id, ClientDto clientDto, List<LigneFactureDto> ligneFactures) {
        this.id = id;
        this.client = clientDto;
        this.ligneFactures = ligneFactures;
    }

    public ClientDto getClient() {
        return client;
    }

    public void setClient(ClientDto client) {
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<LigneFactureDto> getLigneFactures() {
        return ligneFactures;
    }

    public void setLigneFactures(List<LigneFactureDto> ligneFactures) {
        this.ligneFactures = ligneFactures;
    }
}
