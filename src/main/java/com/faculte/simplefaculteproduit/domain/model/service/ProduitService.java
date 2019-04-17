/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.service;

import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import com.faculte.simplefaculteproduit.domain.bean.Produit;
import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import java.awt.print.Pageable;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 *
 * @author YOUNES
 */
public interface ProduitService {

    public int save(Produit produit);

    public Produit findByReference(String reference);

    public Produit find(Long id);

    public List<Produit> findAll();

    // public Page<Produit> findByReferenceLike(String reference , Pageable pageable);
    public List<Produit> findByReferenceLike(String reference);

    public int deleteProduit(String reference);

    public int updateProduit(Produit produit);

    public List<Produit> findByCategorieProduitLibelle(String libelle);

    public List<Produit> findByTypeProduitCode(BigDecimal code);

    public void deleteByCategorieProduitLibelle(String libelle);

    public void deleteByTypeProduitCode(BigDecimal code);

    public List<Produit> searchByQuery(String reference, String categorieLibelle, BigDecimal typeCode);
}
