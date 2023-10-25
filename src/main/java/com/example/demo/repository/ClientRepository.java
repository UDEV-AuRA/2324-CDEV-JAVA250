package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Article;
import com.example.demo.entity.Client;

/**
 * Repository permettant l'interraction avec la base de données pour les clients.
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

}
