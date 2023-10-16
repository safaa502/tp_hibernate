/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.test;

import projet.entities.Categorie;
import projet.service.CategorieService;
import projet.service.ProduitService;
import projet.util.HibernateUtil;

/**
 *
 * @author user
 */
public class Test {
    public static void main(String[] args) {
       
        HibernateUtil.getSessionFactory();
        CategorieService cs = new CategorieService();
        ProduitService p = new ProduitService();
        cs.create(new Categorie("aa","lol456"));
        cs.create(new Categorie("bn","1236mm"));
        
        for(Categorie c : cs.findAll(null)){
            System.out.println(c);
            
            
        }
        
    }
}
