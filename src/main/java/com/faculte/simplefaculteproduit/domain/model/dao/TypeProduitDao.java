/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.dao;


import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import java.math.BigDecimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author LENOVO
 */
@Repository
public interface TypeProduitDao extends JpaRepository<TypeProduit, Long>{
    public TypeProduit findByLibelle(String libelle);
    public TypeProduit findByCode(BigDecimal code);
}
