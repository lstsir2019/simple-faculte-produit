/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.rest.converter;


import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import com.faculte.simplefaculteproduit.domain.rest.vo.CategorieProduitVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YOUNES
 */
public class CategorieProduitVoConverter implements AbstractConverter<CategorieProduit, CategorieProduitVo>{

    public CategorieProduit toItem(CategorieProduitVo categorieProduitVo) {
      if(categorieProduitVo==null){
          return null;
      }else{
          CategorieProduit categorieProduit=new CategorieProduit();
          categorieProduit.setLibelle(categorieProduitVo.getLibelle());
          categorieProduit.setReferenceCompteBuditaire(categorieProduitVo.getReferenceCompteBuditaire());
          return categorieProduit;
      }
    }

    public CategorieProduitVo toVo(CategorieProduit categorieProduit) {
        if(categorieProduit==null){
            return null;
        }else{
            CategorieProduitVo vo=new CategorieProduitVo();
            vo.setLibelle(categorieProduit.getLibelle());
            vo.setReferenceCompteBuditaire(categorieProduit.getReferenceCompteBuditaire());
            return vo;
        }
    }

    public List<CategorieProduitVo> toVo(List<CategorieProduit> categorieProduits) {
        List<CategorieProduitVo> categorieProduitVos = new ArrayList();
        if (categorieProduits != null && !categorieProduits.isEmpty()) {
            for (CategorieProduit categorieProduit : categorieProduits) {
                categorieProduitVos.add(toVo(categorieProduit));
            }
        }
        return categorieProduitVos;
    }

}
