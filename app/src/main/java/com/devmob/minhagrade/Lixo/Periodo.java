package com.devmob.minhagrade.Lixo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hylson on 27/04/2017.
 */

public class Periodo {
    private List<String> periodos = new ArrayList<>();
    private int numero = 1;

    public List<String> getPeriodos(String curso) {
        criaPeriodosPeloCurso(curso);
        for (int i = 1;i<=this.numero; i++) {
            periodos.add(i + "º periodo");
        }
        return periodos;
    }

    private void criaPeriodosPeloCurso(String curso){

        if (curso.equals("Ciência da Computação")){
            this.numero = 9;
        }
        if (curso.equals("Fisica")){
            this.numero = 9;
        }
        if (curso.equals("Matematica Aplicada")){
            this.numero = 10;
        }
        if (curso.equals("Arquitetura")){
            this.numero = 10;
        }
        if (curso.equals("BCMT")){
            this.numero = 4;
        }
    }
}
