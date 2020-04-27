/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udesc.dcc.bdes.ciclogeoinforest.dados.RestData;

/**
 *
 * @author Endrew-PC
 */
public class Estado {
    
    private Integer estCod;
    private Integer estNome;

    public Integer getEstCod() {
        return estCod;
    }

    public void setEstCod(Integer estCod) {
        this.estCod = estCod;
    }

    public Integer getEstNome() {
        return estNome;
    }

    public void setEstNome(Integer estNome) {
        this.estNome = estNome;
    }

    public Estado() {
    }

    public Estado(Integer estCod, Integer estNome) {
        this.estCod = estCod;
        this.estNome = estNome;
    }
    
}
