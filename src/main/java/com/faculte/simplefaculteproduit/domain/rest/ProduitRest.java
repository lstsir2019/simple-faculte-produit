/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.rest;


import com.faculte.simplefaculteproduit.domain.bean.Produit;
import com.faculte.simplefaculteproduit.domain.model.dao.ProduitDao;
import com.faculte.simplefaculteproduit.domain.model.service.ProduitService;
import com.faculte.simplefaculteproduit.domain.rest.converter.ProduitVoConverter;
import com.faculte.simplefaculteproduit.domain.rest.vo.ProduitVo;
import java.awt.print.Pageable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YOUNES
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = {"/produit_api/produit"})
public class ProduitRest {

    @Autowired
    private ProduitService produitService;
    @Autowired
    private ProduitDao  dao;      

   
     ProduitVoConverter produitVoConverter = new ProduitVoConverter();
     

    @PostMapping("/")
    public int save(@RequestBody ProduitVo produitVo) {
        Produit p=produitVoConverter.toItem(produitVo);
        return produitService.save(p);
    }

    @GetMapping("/reference/{reference}")
    public ProduitVo findByReference(@PathVariable String reference) {
        final Produit produit = produitService.findByReference(reference);
        return new ProduitVoConverter().toVo(produit);
    }

    @GetMapping("/{id}")
    public ProduitVo find(@PathVariable Long id) {
        return new ProduitVoConverter().toVo(produitService.find(id));
    }

    @GetMapping("/")
    public List<ProduitVo> findAll() {
        
        return new ProduitVoConverter().toVo(produitService.findAll());
    }
   
   @GetMapping("/chercher")
    public List<ProduitVo> findByReferenceLike(@RequestParam(name = "reference",defaultValue = "")String reference
    ) 
    {
        
        return new  ProduitVoConverter().toVo(produitService.findByReferenceLike(reference+"%"));
    }
   
    @DeleteMapping("/delete/{reference}")
    public int deleteProduit(@PathVariable String reference) {
        return produitService.deleteProduit(reference);
    }
    

   
    
///////////////////////////////////////////////////////
    
    public ProduitService getProduitService() {
        return produitService;
    }

    public void setProduitService(ProduitService produitService) {
        this.produitService = produitService;
    }

    public ProduitDao getDao() {
        return dao;
    }

    public void setDao(ProduitDao dao) {
        this.dao = dao;
    }

   
    
}
