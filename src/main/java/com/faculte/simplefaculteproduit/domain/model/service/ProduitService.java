/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.service;


import com.faculte.simplefaculteproduit.domain.bean.Produit;
import java.awt.print.Pageable;
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
}
