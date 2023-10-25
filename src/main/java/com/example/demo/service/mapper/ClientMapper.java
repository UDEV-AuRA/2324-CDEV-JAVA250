package com.example.demo.service.mapper;

import org.springframework.stereotype.Component;
import com.example.demo.dto.ClientDto;
import com.example.demo.entity.Client;

@Component
public class ClientMapper {

    public ClientDto clientDto(Client cient) {
        return new ClientDto(cient.getId(), cient.getNom(), cient.getPrenom());
    }

}
