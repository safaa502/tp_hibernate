/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet.service;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import projet.entities.Commande;
import projet.entities.Commande;
import projet.entities.Produit;
import projet.util.HibernateUtil;

/**
 *
 * @author user
 */
public class CommandeService {
    public boolean create(Commande o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

   
    public boolean delete(Commande o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    
    public boolean update(Commande o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    
    public List<Commande> findAll(Commande o) {
        List<Commande> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Commande").list();
            tx.commit();
            return produits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return produits;
        } finally {
            if(session != null)
                session.close();
        }
    }

   
    public Commande findById(int id) {
        Commande produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Commande) session.get(Commande.class, id);
            tx.commit();
            return produit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return produit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    public void afficherProduitsCommandesDansCommande(Commande commande) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();

            // Utiliser une requête pour récupérer les produits commandés dans la commande donnée
            String sql = "SELECT lc.produit, lc.quantite FROM LigneCommandeProduit lc " +
                         "WHERE lc.commande_id = :commandeId";
            List<Object[]> results = session.createSQLQuery(sql)
                                            .setParameter("commandeId", commande.getId())
                                            .list();

            // Afficher les détails des produits commandés
            System.out.println("Commande : " + commande.getId() + " Date : " + commande.getDate());
            System.out.println("Liste des produits :");
            System.out.println("Référence\tPrix\tQuantité");

            for (Object[] result : results) {
                Produit produit = (Produit) result[0];
                int quantite = (int) result[1];

                System.out.println(
                    produit.getReference() + "\t" +
                    produit.getPrix() + " DH\t" +
                    quantite
                );
            }

            tx.commit();
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
