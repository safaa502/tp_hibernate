/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author user
 */
@Entity
public class LigneCommandeProduit {
    @Id
    LigneCommandepk pk;
    private int quantite;
    

    public LigneCommandepk getPk() {
        return pk;
    }

    public void setPk(LigneCommandepk pk) {
        this.pk = pk;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
