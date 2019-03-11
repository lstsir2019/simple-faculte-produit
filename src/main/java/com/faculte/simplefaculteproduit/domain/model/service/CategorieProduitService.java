
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.service;

import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import java.util.List;

/**
 *
 * @author YOUNES
 */
public interface CategorieProduitService {

    public int save(CategorieProduit categorieProduit);

    public CategorieProduit find(Long id);

    public List<CategorieProduit> findAll();

    public CategorieProduit findByLibelle(String libelle);

   

    public List<CategorieProduit> findByLibelleLike(String libelle);

    public int deleteByLibelle(String libelle);
    
    public int updateCat(String libelle,CategorieProduit categorieProduit);

}
