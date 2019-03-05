/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.rest.converter;


import com.faculte.simplefaculteproduit.commun.util.NuberUtil;
import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import com.faculte.simplefaculteproduit.domain.rest.vo.TypeProduitVo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author LENOVO
 */
public class TypeProduitVoConverter implements AbstractConverter<TypeProduit, TypeProduitVo> {

    @Override
    public TypeProduit toItem(TypeProduitVo vo) {
        if (vo == null) {
            return null;
        } else {
            TypeProduit tp = new TypeProduit();
            tp.setLibelle(vo.getLibelle());
            tp.setCode(NuberUtil.toBigDecimale(vo.getCode()));
            return tp;
        }
    }

    @Override
    public TypeProduitVo toVo(TypeProduit item) {
        if (item == null) {
            return null;
        } else {
            TypeProduitVo vo = new TypeProduitVo();
            vo.setCode(NuberUtil.toBigString(item.getCode()));
            vo.setLibelle(item.getLibelle());
            return vo;
        }
    }

    public List<TypeProduitVo> toVo(List<TypeProduit> typeProduits) {
        if (typeProduits == null || typeProduits.isEmpty()) {
            return null;
        } else {
            List<TypeProduitVo> typeProduitVos = new ArrayList<>();
            for (TypeProduit typeProduit : typeProduits) {
                typeProduitVos.add(toVo(typeProduit));

            }
            return typeProduitVos;
        }

    }

    public List<TypeProduit> toItem(List<TypeProduitVo> typeProduitVos) {
        if (typeProduitVos == null || typeProduitVos.isEmpty()) {
            return null;
        } else {
            List<TypeProduit> typeProduits = new ArrayList<>();
            for (TypeProduitVo typeProduitVo : typeProduitVos) {
                typeProduits.add(toItem(typeProduitVo));
            }
            return typeProduits;
        }
    }
}
