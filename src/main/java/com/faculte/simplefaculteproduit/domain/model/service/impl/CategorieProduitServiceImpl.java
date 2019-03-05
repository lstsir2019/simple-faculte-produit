/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.model.service.impl;


import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import com.faculte.simplefaculteproduit.domain.model.dao.CategorieProduitDao;
import com.faculte.simplefaculteproduit.domain.model.service.CategorieProduitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author YOUNES
 */
@Service
public class CategorieProduitServiceImpl implements CategorieProduitService{
    @Autowired
    private CategorieProduitDao categorieProduitDao;

  
    
    @Override
    public int save(CategorieProduit categorieProduit){
        CategorieProduit  cp = categorieProduitDao.findByLibelle(categorieProduit.getLibelle());
        if(cp!=null){
            return -1;
        }else{
             categorieProduitDao.save(categorieProduit);
             return 1;
        }
        
    }
    
    @Override
    public CategorieProduit find(Long id){
        return categorieProduitDao.getOne(id);
    }
    
    @Override
    public List<CategorieProduit> findAll(){
        return categorieProduitDao.findAll();
    }

    public CategorieProduitDao getCategorieProduitDao() {
        return categorieProduitDao;
    }

    public void setCategorieProduitDao(CategorieProduitDao categorieProduitDao) {
        this.categorieProduitDao = categorieProduitDao;
    }

    @Override
    public CategorieProduit findByLibelle(String libelle) {
     return categorieProduitDao.findByLibelle(libelle);
    }

    @Override
    public int delate(String libelle) {
        CategorieProduit cp=findByLibelle(libelle);
        if(cp==null){
            return -1;
        }else{
            categorieProduitDao.delete(cp);
            return 1;
        }
        
    }
    
    
    

  
    
}
