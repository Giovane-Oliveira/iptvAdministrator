/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.iptv.model;

/**
 *
 * @author Giovane Oliveira
 */
public class Clientes {
 String NOME, DATAVENCIMENTO, DATAVENCSISTEMA, OBS, FORMAPAG;
 int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getDATAVENCIMENTO() {
        return DATAVENCIMENTO;
    }

    public void setDATAVENCIMENTO(String DATAVENCIMENTO) {
        this.DATAVENCIMENTO = DATAVENCIMENTO;
    }

    public String getDATAVENCSISTEMA() {
        return DATAVENCSISTEMA;
    }

    public void setDATAVENCSISTEMA(String DATAVENCSISTEMA) {
        this.DATAVENCSISTEMA = DATAVENCSISTEMA;
    }

    public String getOBS() {
        return OBS;
    }

    public void setOBS(String OBS) {
        this.OBS = OBS;
    }

    public String getFORMAPAG() {
        return FORMAPAG;
    }

    public void setFORMAPAG(String FORMAPAG) {
        this.FORMAPAG = FORMAPAG;
    }
}
