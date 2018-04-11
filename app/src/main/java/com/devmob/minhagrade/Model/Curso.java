package com.devmob.minhagrade.Model;

import android.content.Context;

import com.devmob.minhagrade.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by DevMob on 17/05/2017.
 */

public class Curso {

    private String _id;
    private String nome;
    private int periodos;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Curso(String nome) {
        this._id = "";
        this.nome = nome;
    }

    public String getId() {
        return _id;
    }

    public String getNome() {
        return nome;
    }

    public int getPeriodos(){
        return periodos;
    }

    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }

    public static ArrayList<Curso> getCursos(Context context){
        ArrayList<Curso> cursos = new ArrayList<Curso>();
        String[] arrayCourse = context.getResources().getStringArray(R.array.cursos_array);
        List<String> list = Arrays.asList(arrayCourse);
        Collections.sort(list);

        for (int i =0; i< list.size(); i++){
            cursos.add(new Curso(list.get(i)));
        }

        return cursos;
    }

    public String toString(){
        return (new Gson()).toJson(this);
    }
}
