/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.commun.util;

import static aj.org.objectweb.asm.Opcodes.DOUBLE;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author LENOVO
 */
public class NuberUtil {
    private static final Double ZERO_DOUBLE =0D;
    private static final Integer ZERO_INT= 0;
    private static final String CHAINE_VIDE="";
    
    public static Double toDouble(String value){
        if(value==null || value.isEmpty()){
            return ZERO_DOUBLE;
        }else{
       return Double.parseDouble(value);
        }
        
    }
    public static Date toDate(String value) throws ParseException{
           if(value==null || value.isEmpty()){
            return null;
        }else{
       DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
         Date date=format.parse(value);
         return date;
        }
       
    }
    public static String toDateString(Date value){
        if(value==null){
            return CHAINE_VIDE;
        }else{
            DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
            String stringDate=format.format(value);
            return stringDate;
        }
           
    }
     public static BigDecimal toBigDecimale(String value){
        if(value==null || value.isEmpty()){
            return BigDecimal.ZERO;
        }else{
       return  new BigDecimal(value);
        }
        
    }

    public static Integer toInt(String value) {
        if(value==null || value.isEmpty()){
            return ZERO_INT;
        }else{
            return Integer.parseInt(value);
           }
    }
    public static String toBigString(BigDecimal value){
        if(value==null){
            return CHAINE_VIDE;
        }else{
            return String.valueOf(value);
        }
        
    }
    }
