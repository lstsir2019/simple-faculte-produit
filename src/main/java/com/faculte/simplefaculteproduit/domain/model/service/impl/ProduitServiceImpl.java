/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.service.impl;


import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import com.faculte.simplefaculteproduit.domain.bean.Produit;
import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import com.faculte.simplefaculteproduit.domain.model.dao.ProduitDao;
import com.faculte.simplefaculteproduit.domain.model.service.CategorieProduitService;
import com.faculte.simplefaculteproduit.domain.model.service.ProduitService;
import com.faculte.simplefaculteproduit.domain.model.service.TypeProduitService;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 *
 * @author YOUNES
 */
@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    private ProduitDao produitDao;
    @Autowired
    private TypeProduitService typeProduitService;

    @Autowired
    private CategorieProduitService categorieProduitService;

    public int save(Produit produit) {
        Produit p = produitDao.findByReference(produit.getReference());
        if (p != null) {
            return -1;
        } else {
            CategorieProduit categorieProduit = categorieProduitService.findByLibelle(produit.getCategorieProduit().getLibelle());
            TypeProduit typeProduit = typeProduitService.findTypeByCode(produit.getTypeProduit().getCode());
            produit.setCategorieProduit(categorieProduit);
            produit.setTypeProduit(typeProduit);

            produitDao.save(produit);
            return 1;
        }

    }

    public Produit findByReference(String reference) {
        return produitDao.findByReference(reference);
    }

    public Produit find(Long id) {
        return produitDao.getOne(id);
    }

   public List<Produit> findAll() {
       return produitDao.findAll();
   }

    public TypeProduitService getTypeProduitService() {
        return typeProduitService;
    }

    public void setTypeProduitService(TypeProduitService typeProduitService) {
        this.typeProduitService = typeProduitService;
    }

    public CategorieProduitService getCategorieProduitService() {
        return categorieProduitService;
    }

    public void setCategorieProduitService(CategorieProduitService categorieProduitService) {
        this.categorieProduitService = categorieProduitService;
    }

    public ProduitDao getProduitDao() {
        return produitDao;
    }

    public void setProduitDao(ProduitDao produitDao) {
        this.produitDao = produitDao;
    }

    @Override
    public List<Produit> findByReferenceLike(String reference) {
        return produitDao.findByReferenceLike(reference);
    }

   

}
