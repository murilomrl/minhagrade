package com.devmob.minhagrade.Model;

/**
 * Created by DevMob on 17/05/2017.
 */

public class Disciplina {
    private String nome;
    /**
     * Status: 0 para não feito, 1 para fazendo e 2 para feito
     */
    private int status;

    public Disciplina(String nome) {
        this.nome = nome;
        this.status = 0;
    }

    public String getNome() {
        return nome;
    }
    public int getStatus(){ return status; }

    public void setStatus(int status) {
        this.status = status;
    }
}
