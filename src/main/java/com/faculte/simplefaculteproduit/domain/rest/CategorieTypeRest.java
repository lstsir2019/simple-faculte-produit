/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.rest;


import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import com.faculte.simplefaculteproduit.domain.model.service.CategorieProduitService;
import com.faculte.simplefaculteproduit.domain.model.service.TypeProduitService;
import com.faculte.simplefaculteproduit.domain.rest.converter.CategorieProduitVoConverter;
import com.faculte.simplefaculteproduit.domain.rest.converter.TypeProduitVoConverter;
import com.faculte.simplefaculteproduit.domain.rest.vo.CategorieProduitVo;
import com.faculte.simplefaculteproduit.domain.rest.vo.TypeProduitVo;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author LENOVO
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping(value = {"/produit_api/categoriType"})
public class CategorieTypeRest {
    @Autowired
    private CategorieProduitService cps;
    @Autowired 
    private TypeProduitService tps;
    
    CategorieProduitVoConverter cpvc=new CategorieProduitVoConverter();
    TypeProduitVoConverter tpvc=new TypeProduitVoConverter();
    
//************CATEGORIE PRODUIT***************
    @PostMapping("/categorie/create")
    public int save(@RequestBody CategorieProduitVo categorieProduitVo) {
        
        CategorieProduit cp=cpvc.toItem(categorieProduitVo);
        
       return cps.save(cp);
         
    }

    public CategorieProduit find(Long id) {
        return cps.find(id);
    }
    @GetMapping("/categorie/findAll")
    public List<CategorieProduitVo> findAll() {
        return cpvc.toVo(cps.findAll());
    }
    @GetMapping("/categorie/libelle/{libelle}")
    public CategorieProduitVo findByLibelle(String libelle) {
        
        return cpvc.toVo(cps.findByLibelle(libelle));
    }

    @DeleteMapping("/categorie/delete/{libelle}")
    public int delate(@PathVariable String libelle) {
      return cps.delate(libelle);
    }
    
    //*********TYPE PRODUIT******************
    @GetMapping("/type/findAll")
    public List<TypeProduitVo> findAllType() {
        return tpvc.toVo(tps.findAllType());
    }
     @GetMapping("/type/code/{code}")
    public TypeProduitVo findTypeByCode(BigDecimal code) {
        return tpvc.toVo(tps.findTypeByCode(code));
    }
    

    @PostMapping("/type/create")
    public int save(@RequestBody TypeProduitVo typeProduitVo) {
        TypeProduit tp=tpvc.toItem(typeProduitVo);
        return tps.save(tp);
    }

    //************GETTER SETTER
    public TypeProduitService getTps() {
        return tps;
    }

    public void setTps(TypeProduitService tps) {
        this.tps = tps;
    }
    
    

    public CategorieProduitService getCps() {
        return cps;
    }

    public void setCps(CategorieProduitService cps) {
        this.cps = cps;
    }
    
    
    
}
