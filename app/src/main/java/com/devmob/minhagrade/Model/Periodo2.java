package com.devmob.minhagrade.Model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DevMob on 17/05/2017.
 */

public class Periodo2 {
    private String nome;
    List<Disciplina2> disciplinas =new ArrayList<Disciplina2>();

    public Periodo2(String nome) {
        this.nome = nome;
    }
}
