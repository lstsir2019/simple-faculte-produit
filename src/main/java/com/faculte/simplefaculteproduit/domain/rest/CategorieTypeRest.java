/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.domain.rest;


import com.faculte.simplefaculteproduit.commun.pdf.GeneratePdf;
import com.faculte.simplefaculteproduit.domain.bean.CategorieProduit;
import com.faculte.simplefaculteproduit.domain.bean.Produit;
import com.faculte.simplefaculteproduit.domain.bean.TypeProduit;
import com.faculte.simplefaculteproduit.domain.model.service.CategorieProduitService;
import com.faculte.simplefaculteproduit.domain.model.service.ProduitService;
import com.faculte.simplefaculteproduit.domain.model.service.TypeProduitService;
import com.faculte.simplefaculteproduit.domain.rest.converter.CategorieProduitVoConverter;
import com.faculte.simplefaculteproduit.domain.rest.converter.TypeProduitVoConverter;
import com.faculte.simplefaculteproduit.domain.rest.vo.CategorieProduitVo;
import com.faculte.simplefaculteproduit.domain.rest.vo.TypeProduitVo;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @Autowired
    private ProduitService produitService;
    
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

  
 
    @GetMapping("/categorie/chercher")
    public List<CategorieProduitVo> findByLibelleLike(@RequestParam(name = "libelle",defaultValue = "") String libelle) {
        return cpvc.toVo(cps.findByLibelleLike(libelle+"%"));
    }
   @DeleteMapping("/categorie/delete/{libelle}") 
    public int deleteByLibelle(@PathVariable String libelle) {
        return cps.deleteByLibelle(libelle);
        
    }
   @PutMapping("/categorie/update/{libelle}")
    public int updateCat(@PathVariable String libelle,@RequestBody CategorieProduitVo categorieProduitVo) {
      CategorieProduit categorieProduit=  cpvc.toItem(categorieProduitVo);
        return cps.updateCat(libelle, categorieProduit);
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

    @DeleteMapping("/type/delete/{code}")
    public int deleteType(@PathVariable BigDecimal code) {
        return tps.deleteType(code);
    }

    @GetMapping("/type/chercher")
    public List<TypeProduitVo> findByLibelleLikeType(@RequestParam(name = "libelle",defaultValue = "") String libelle) {
        return tpvc.toVo(tps.findByLibelleLikeType(libelle+"%"));
    }
    @PutMapping("/type/update/{code}")
    public int updateType(@PathVariable BigDecimal code,@RequestBody TypeProduitVo typeProduitVo) {
        TypeProduit tp=tpvc.toItem(typeProduitVo);
        return tps.updateType(code, tp);
    }
    
      @GetMapping("/pdf/Libelle/{libelle}")
    public ResponseEntity<Object> reportCategorie(@PathVariable String libelle)throws JRException, IOException{
        Map<String,Object> params=new HashMap<>();
        
        List<Produit>  produits= produitService.findByCategorieProduitLibelle(libelle);
        CategorieProduit cp=cps.findByLibelle(libelle);
        
        
        
        params.put("libelle",cp.getLibelle());
        params.put("referenceCompteBuditaire",cp.getReferenceCompteBuditaire());
      
         if(produits==null || produits.isEmpty()){
            Produit p =new Produit();
            produits.add(p);
        }
      
       
        
        return GeneratePdf.generate("test", params,produits, "/rapport/rapport.jasper");
    }
    
    
    @GetMapping("/pdf/code/{code}")
    public ResponseEntity<Object> reportType(@PathVariable BigDecimal code)throws JRException, IOException{
        Map<String,Object> params=new HashMap<>();
        
        List<Produit>  produits= produitService.findByTypeProduitCode(code);
        TypeProduit typeProduit=tps.findTypeByCode(code);
        
        
        
        params.put("libelle",typeProduit.getLibelle());
        params.put("code",typeProduit.getCode());
        if(produits==null || produits.isEmpty()){
            Produit p =new Produit();
            produits.add(p);
        }
      
       
        
        return GeneratePdf.generate("test", params,produits, "/rapport/rapportType.jasper");
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

    public ProduitService getProduitService() {
        return produitService;
    }

    public void setProduitService(ProduitService produitService) {
        this.produitService = produitService;
    }
    
    
    
    
}
