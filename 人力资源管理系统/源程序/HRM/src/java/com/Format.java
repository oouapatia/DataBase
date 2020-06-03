/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

public class Format {
    public String FormatSql(String value){
        if(value.equals(""))
            return null;
        else
            return "'"+value+"'";
    }
}
