/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.dao;


import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YOUNES
 */
@Repository
public interface CategorieProduitDao extends JpaRepository<CategorieProduit, Long>{
    public CategorieProduit findByLibelle(String libelle);
    
}
