package com.example.demo.dto;

/**
 * Classe permettant d'exposer des données au format JSON au client.
 */
public class ArticleDto {
    private Long id;
    private String libelle;
    private double prix;
    private String imageUrl;

    public ArticleDto() {
    }

    public ArticleDto(Long id, String libelle, double prix, String imageUrl) {
        this.id = id;
        this.libelle = libelle;
        this.prix = prix;
        this.imageUrl = imageUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
