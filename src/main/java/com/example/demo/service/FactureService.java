package com.example.demo.service;

import static java.util.stream.Collectors.toList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dto.ClientDto;
import com.example.demo.dto.FactureDto;
import com.example.demo.repository.ClientRepository;
import com.example.demo.repository.FactureRepository;
import com.example.demo.service.mapper.ClientMapper;
import com.example.demo.service.mapper.FactureMapper;

/**
 * Service contenant les actions métiers liées aux clients.
 */
@Service
@Transactional
public class FactureService {

    @Autowired
    private FactureRepository factureRepository;
    @Autowired
    private FactureMapper factureMapper;

    public List<FactureDto> findAll() {
        return factureRepository.findAll().stream().map(client -> factureMapper.factureDto(client)).collect(toList());
    }

    public List<FactureDto> findByClient(Long clientId) {
        return factureRepository.findByClientId(clientId)
            .stream()
            .map(client -> factureMapper.factureDto(client))
            .collect(toList());
    }
}
