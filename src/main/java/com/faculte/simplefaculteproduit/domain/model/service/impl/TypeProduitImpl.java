/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.service.impl;


import com.faculte.simplefaculteproduit.domain.bean.Produit;
import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import com.faculte.simplefaculteproduit.domain.model.dao.TypeProduitDao;
import com.faculte.simplefaculteproduit.domain.model.service.ProduitService;
import com.faculte.simplefaculteproduit.domain.model.service.TypeProduitService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author LENOVO
 */
@Service
public class TypeProduitImpl implements TypeProduitService{
    @Autowired
    TypeProduitDao typeProduitDao;
    @Autowired
    ProduitService produitService;
     
    @Override
    public int save(TypeProduit typeProduit) {
        TypeProduit tp=typeProduitDao.findByCode(typeProduit.getCode());
        if(tp!=null){
            return -1;
        }else{
             typeProduitDao.save(typeProduit);
             return 1;
        }
    }

    @Override
    public TypeProduit find(Long id) {
        return typeProduitDao.getOne(id);
    }

    @Override
    public List<TypeProduit> findAllType() {
        return typeProduitDao.findAll();
    }

    @Override
    public TypeProduit findTypeByLibelle(String libelle) {
        return typeProduitDao.findByLibelle(libelle);
    }

     @Override
    public TypeProduit findTypeByCode(BigDecimal code) {
       return typeProduitDao.findByCode(code);
    }
    public TypeProduitDao getTypeProduitDao() {
        return typeProduitDao;
    }

    public void setTypeProduitDao(TypeProduitDao typeProduitDao) {
        this.typeProduitDao = typeProduitDao;
    }

    @Override
    public int deleteType(BigDecimal code) {
        List<Produit> p=produitService.findByTypeProduitCode(code);
        TypeProduit tp=findTypeByCode(code);
        if(tp==null){
            return -1;
        }else{
            if(!p.isEmpty() && p!=null){
            produitService.deleteByTypeProduitCode(code);
         }
            typeProduitDao.delete(tp);
            return 1;
        }
    }

    @Override
     public List<TypeProduit> findByLibelleLikeType(String libelle){
        return typeProduitDao.findByLibelleLike(libelle);
    }

    @Override
    public int updateType(BigDecimal code, TypeProduit typeProduit) {
        TypeProduit tp=findTypeByCode(code);
        if(tp==null){
            return -1;
        }else{
            tp.setCode(code);
            tp.setLibelle(typeProduit.getLibelle());
            typeProduitDao.save(tp);
            return 1;
        }
    }

   
    
    
}
