/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.entities;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author safaa
 */

@Entity
@Table(name = "produits")
@NamedQuery(
    name = "Produit.findByPriceGreaterThan",
    query = "SELECT p FROM Produit p WHERE p.prix > :prix")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;
    private String reference ;
    private float prix;
    @ManyToOne
    private Categorie categorie;
    @OneToMany(mappedBy="pk.produit",fetch=FetchType.EAGER)
    private List<LigneCommandeProduit>lcp;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public List<LigneCommandeProduit> getLcp() {
        return lcp;
    }

    public void setLcp(List<LigneCommandeProduit> lcp) {
        this.lcp = lcp;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
    
}
