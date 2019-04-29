/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.simplefaculteproduit.commun.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author
 */
public class DateUtil {

    public static String formateDate(String pattern, Date date) {
        if (date != null) {
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            return simpleDateFormat.format(date);
        } else {
            return "";
        }
    }

    
    
    public static Date parse(String date) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            return simpleDateFormat.parse(date);
        } catch (Exception e) {
            return null;
        }
    }

    public static java.sql.Date convertFormUtilToSql(java.util.Date date) {
        if (date != null) {
            return new java.sql.Date(date.getTime());
        } else {
            return null;
        }
    }

    public static java.sql.Timestamp convertFormUtilToTimestamp(java.util.Date date) {
        if (date != null) {
            return new java.sql.Timestamp(date.getTime());
        } else {
            return null;
        }
    }

}