package com.example.demo.service.mapper;

import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FactureDto;
import com.example.demo.dto.LigneFactureDto;
import com.example.demo.entity.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FactureMapper {

    @Autowired
    private ClientMapper clientMapper;
    @Autowired
    private LigneFactureMapper ligneFactureMapper;

    public FactureDto factureDto(Facture facture) {
        ClientDto clientDto = clientMapper.clientDto(facture.getClient());
        List<LigneFactureDto> ligneFactureDtos = facture.getLigneFactures()
                .stream()
                .map(ligneFacture -> ligneFactureMapper.ligneFactureDto(ligneFacture))
                .collect(Collectors.toList());
        return new FactureDto(facture.getId(),
                clientDto,
                ligneFactureDtos
        );
    }

}
