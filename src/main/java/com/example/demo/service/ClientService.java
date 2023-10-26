package com.example.demo.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.ClientDto;
import com.example.demo.repository.ClientRepository;
import com.example.demo.service.mapper.ClientMapper;

/**
 * Service contenant les actions métiers liées aux clients.
 */
@Service
@Transactional
public class ClientService {

    private ClientRepository clientRepository;
    private ClientMapper clientMapper;

    public ClientService(ClientRepository clientRepository, ClientMapper clientMapper) {
        this.clientRepository = clientRepository;
        this.clientMapper = clientMapper;
    }

    public List<ClientDto> findAll() {
        return clientRepository.findAll().stream().map(client -> clientMapper.clientDto(client)).collect(toList());
    }

}
