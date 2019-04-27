/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.search;

import com.faculte.simplefaculteproduit.commun.util.SearchUtil;
import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import com.faculte.simplefaculteproduit.domain.bean.Produit;
import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gouss
 */
@Repository
public class ProduitSearch {

    @PersistenceContext
    public EntityManager entityManager;

    public List<Produit> searchProsuitByQuery(String reference, String categorieLibelle, BigDecimal typeCode) {
        String query = "SELECT p FROM Produit p WHERE 1=1";

        query += SearchUtil.addConstraint("p", "reference", "LIKE", reference);
        query += SearchUtil.addConstraint("p", "categorieProduit.libelle", "LIKE", categorieLibelle);
        query += SearchUtil.addConstraint("p", "typeProduit.code", "LIKE", typeCode);
//        if (categorieLibelle != null && !categorieLibelle.equals("")) {
//            query += "AND p.categorieProduit.libelle='" + categorieLibelle + "'";
//        }
//        if (typeCode != null && !typeCode.equals("")) {
//            query += "AND p.typeProduit.code='" + typeCode + "'";
//        }

        return entityManager.createQuery(query).getResultList();
    }

}
