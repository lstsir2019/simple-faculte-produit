/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.dao;


import com.faculte.simplefaculteproduit.domain.bean.Produit;
import java.awt.print.Pageable;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YOUNES
 */
@Repository
public interface ProduitDao extends JpaRepository<Produit, Long>,PagingAndSortingRepository<Produit, Long>{
    public Produit findByReference(String reference);

    
   
    public List<Produit> findByReferenceLike(String reference);
  @Transactional
  public void deleteByReference(String reference);
  
    
}
