package com.devmob.minhagrade.Model;

import android.content.Context;

import com.devmob.minhagrade.R;
import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

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
    @SerializedName("name")
    @Expose
    private String nome;
    @SerializedName("path")
    @Expose
    private String path;
    @SerializedName("periodos")
    @Expose
    private int periodos;
    //    Total de créditos de eletivas
    @SerializedName("eletivas")
    @Expose
    private Float eletivas;
    private ArrayList<Disciplina> disciplinas = new ArrayList<>();

    public Curso(String nome, String path) {
        this._id = "";
        this.nome = nome;
        this.path = path;
    }

//    public Curso(String nome) {
//        this._id = "";
//        this.nome = nome;
//    }

    public String getPath() {
        return path;
    }

    public String getNome() {
        return nome;
    }

    public int getPeriodos(){
        return periodos;
    }

    public Float getEletivas() {
        return eletivas;
    }

    public void setEletivas(Float eletivas) {
        this.eletivas = eletivas;
    }

    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }

//    public static ArrayList<Curso> getCursos(Context context){
//        ArrayList<Curso> cursos = new ArrayList<Curso>();
//        String[] arrayCourse = context.getResources().getStringArray(R.array.cursos_array);
//        List<String> list = Arrays.asList(arrayCourse);
//        Collections.sort(list);
//
//        for (int i =0; i< list.size(); i++){
//            cursos.add(new Curso(list.get(i)));
//        }
//
//        return cursos;
//    }

    public String toString(){
        return (new Gson()).toJson(this);
    }
}
