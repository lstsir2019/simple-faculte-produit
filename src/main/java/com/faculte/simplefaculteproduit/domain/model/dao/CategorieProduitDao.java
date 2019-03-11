/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.dao;

import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YOUNES
 */
@Repository
public interface CategorieProduitDao extends JpaRepository<CategorieProduit, Long> {

    public CategorieProduit findByLibelle(String libelle);

    public List<CategorieProduit> findByLibelleLike(String libelle);

    @Transactional
//    @Modifying
//    @Query("delete from CategorieProduit c where c.libelle = ?1")
    public void deleteByLibelle(String libelle);

}
