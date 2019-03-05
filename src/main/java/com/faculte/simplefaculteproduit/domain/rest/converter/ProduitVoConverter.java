/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.rest.converter;


import com.faculte.simplefaculteproduit.domain.bean.Produit;
import com.faculte.simplefaculteproduit.domain.rest.vo.ProduitVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YOUNES
 */
public class ProduitVoConverter implements AbstractConverter<Produit, ProduitVo>{

    public Produit toItem(ProduitVo produitVo) {
        
        
        if (produitVo == null){
            return null;
        }else{
            Produit produit = new Produit();
            produit.setLibelle(produitVo.getLibelle());
            produit.setReference(produitVo.getReference());
            produit.setCategorieProduit(new CategorieProduitVoConverter().toItem(produitVo.getCategorieProduitVo()));
            produit.setTypeProduit(new TypeProduitVoConverter().toItem(produitVo.getTypeProduitVo()));
            return produit;
        }

         
    }

    public ProduitVo toVo(Produit produit) {
       if(produit==null){
           return null;
       }else{
           ProduitVo vo=new ProduitVo();
           vo.setLibelle(produit.getLibelle());
           vo.setReference(produit.getReference());
           vo.setCategorieProduitVo(new CategorieProduitVoConverter().toVo(produit.getCategorieProduit()));
           vo.setTypeProduitVo(new TypeProduitVoConverter().toVo(produit.getTypeProduit()));
           return vo;
       }
    }
    
     public List<ProduitVo> toVo(List<Produit> produits) {
        List<ProduitVo> produitVos = new ArrayList();
        if (produits != null && !produits.isEmpty()) {
            for (Produit produit : produits) {
                produitVos.add(toVo(produit));
            }
        }
        return produitVos;
    }

     public List<Produit> toItem(List<ProduitVo> produitVos){
         if(produitVos==null || produitVos.isEmpty()){
             return null;
         }else{
             List<Produit> produits=new ArrayList<>();
             for (ProduitVo produitVo : produitVos) {
                 produits.add(toItem(produitVo));
             }
             return produits;
         }
     }
}
