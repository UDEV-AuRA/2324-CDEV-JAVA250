package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Client;
import com.example.demo.entity.Facture;

/**
 * Repository permettant l'interraction avec la base de données pour les clients.
 */
@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {

    List<Facture> findByClientId(Long clientId);
}
