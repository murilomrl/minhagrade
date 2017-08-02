package com.devmob.minhagrade.Model;

import android.content.Context;

import com.devmob.minhagrade.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by DevMob on 17/05/2017.
 */

public class Curso {
    private String nome;

    public Curso(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
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
}
