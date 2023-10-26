package com.example.demo.dto;

/**
 * Classe permettant d'exposer des données au format JSON au client.
 */
public class LigneFactureDto {

    private String designation;
    private Integer quantite;
    private Double prixUnitaire;

    public LigneFactureDto(String designation, Double prixUnitaire, Integer quantite) {
        this.designation = designation;
        this.prixUnitaire = prixUnitaire;
        this.quantite = quantite;
    }

    public Double getPrix() {
        // pourrait être déplacé dans l'Entity LigneFacture.
        return prixUnitaire * quantite;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getQuantite() {
        return quantite;
    }

    public void setQuantite(Integer quantite) {
        this.quantite = quantite;
    }

    public Double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(Double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }
}
