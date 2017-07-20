package com.devmob.minhagrade.Model;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.Log;

import com.devmob.minhagrade.Prefs;
import com.devmob.minhagrade.R;
import com.google.gson.Gson;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    }

    public Disciplina(String nome,int status) {
        this.nome = nome;
        this.status = status;
    }

    public String getNome() {
        return this.nome.toString();
    }
    public int getStatus(){
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    // Metodo que pega as disciplinas do Resource para a Activity
    public static ArrayList<Disciplina> getDisciplinas(ArrayList<String> value, Context context){
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        String[] disciplinasVetor = new String[0];
        int n = 0;
        Resources res = context.getResources();
        String[][] array = new String[0][];
        try {
            Field field = R.array.class.getField(value.get(0));
            TypedArray ta = res.obtainTypedArray(field.getInt(null));
            n = ta.length();
            array = new String[n][];
            for (int i = 0; i < n; ++i) {
                int id = ta.getResourceId(i, 0);
                if (id > 0) {
                    array[i] = res.getStringArray(id);
                } else {
                    // something wrong with the XML
                }
            }
            ta.recycle(); // Important!
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        String indice = value.get(1);
        int status;
        disciplinasVetor = array[Integer.parseInt(String.valueOf(indice.charAt(0)))-1];
        for (int i = 0;i<disciplinasVetor.length;i++){
            status = Prefs.getInt(context,disciplinasVetor[i]);
            if (status == 0) {
                disciplinas.add(new Disciplina(disciplinasVetor[i]));
            }
            else {
                disciplinas.add(new Disciplina(disciplinasVetor[i], status));
            }
        }
        //Log.i("Disciplina",disciplinas.getClass().toString());
        return disciplinas;
    }

}
