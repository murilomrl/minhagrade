package com.devmob.minhagrade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hylson on 27/04/2017.
 */

public class ListaDePeriodos {
    private List<String> periodos = new ArrayList<>();
    private int numero = 1;

    public void createPeriodo(String curso){
        numeroDePeriodos(curso);
        for (int i = 1;i<=this.numero; i++) {
            periodos.add(i + "º periodo");
        }
    }

    public List<String> getPeriodos() {
        return periodos;
    }

    private void numeroDePeriodos(String curso){
        if (curso.equals("Ciencia da Computação")){
            this.numero = 9;
        }
        if (curso.equals("Fisica")){
            this.numero = 9;
        }
        if (curso.equals("Matematica Aplicada")){
            this.numero = 10;
        }
        if (curso.equals("Arquitetura")){
            this.numero = 7;
        }
        if (curso.equals("Medicina")){
            this.numero = 10;
        }
    }
}
