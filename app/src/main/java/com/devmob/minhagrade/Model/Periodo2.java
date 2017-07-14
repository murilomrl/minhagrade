package com.devmob.minhagrade.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DevMob on 17/05/2017.
 */

public class Periodo2 {
    private String nome;
    List<Disciplina> disciplinas =new ArrayList<Disciplina>();

    public Periodo2(String nome) {
        this.nome = nome;
    }
}
