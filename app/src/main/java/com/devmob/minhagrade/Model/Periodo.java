package com.devmob.minhagrade.Model;

import android.content.Context;

import com.devmob.minhagrade.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class Periodo {
    private String nome ;
    private String curso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Periodo(String nome, String curso) {

        this.nome = nome;
        this.curso = curso;
    }

    public String toString(){
        return "Periodo:"+getNome()+" Curso:"+getCurso()+"\n";
    }

    public static ArrayList<Periodo> getPeriodos(Context context){
        ArrayList<Periodo> periodos = new ArrayList<>();
        String[] arrayPeriodo = context.getResources().getStringArray(R.array.periodo_spinner);
        List<String> list = Arrays.asList(arrayPeriodo);
        for (int i =0; i< list.size(); i++){
            periodos.add(new Periodo(list.get(i),null));
        }

        return periodos;
    }
}
