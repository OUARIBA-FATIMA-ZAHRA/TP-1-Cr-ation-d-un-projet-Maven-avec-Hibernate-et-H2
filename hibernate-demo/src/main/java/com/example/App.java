package com.example;

import com.example.model.Produit;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("hibernate-demo");

        insererProduits(emf);
        lireProduits(emf);

        emf.close();
    }

    private static void insererProduits(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        em.persist(new Produit("Laptop", new BigDecimal("999.99")));
        em.persist(new Produit("Smartphone", new BigDecimal("499.99")));
        em.persist(new Produit("Tablette", new BigDecimal("299.99")));

        em.getTransaction().commit();
        em.close();

        System.out.println("Produits insérés avec succès !");
    }

    private static void lireProduits(EntityManagerFactory emf) {
        EntityManager em = emf.createEntityManager();

        List<Produit> produits =
                em.createQuery("SELECT p FROM Produit p", Produit.class)
                        .getResultList();

        System.out.println("\nListe des produits :");
        produits.forEach(System.out::println);

        System.out.println("\nRecherche produit ID=2");
        Produit p = em.find(Produit.class, 2L);
        System.out.println(p);

        em.close();
    }
}
