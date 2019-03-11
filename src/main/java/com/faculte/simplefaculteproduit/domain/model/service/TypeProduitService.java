/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.service;

import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public interface TypeProduitService {

    public int save(TypeProduit typeProduit);

    public TypeProduit find(Long id);

    public List<TypeProduit> findAllType();

    public TypeProduit findTypeByCode(BigDecimal code);

    public TypeProduit findTypeByLibelle(String libelle);
    
    public int deleteType(BigDecimal code);

     public List<TypeProduit> findByLibelleLikeType(String libelle);
     
     public int updateType(BigDecimal code,TypeProduit typeProduit);

}
