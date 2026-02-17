package com.example.model;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private BigDecimal prix;

    public Produit() {
    }

    public Produit(String nom, BigDecimal prix) {
        this.nom = nom;
        this.prix = prix;
    }

    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prix=" + prix +
                '}';
    }
}
