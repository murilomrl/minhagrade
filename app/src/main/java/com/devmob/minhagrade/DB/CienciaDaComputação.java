package com.devmob.minhagrade.DB;

import android.content.Context;

import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.Model.Periodo;

import java.util.ArrayList;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class CienciaDaComputação {

    Context context;
    PeriodoDAO database;

    public CienciaDaComputação(Context context) {
        this.context = context;
        database = new PeriodoDAO(context);
    }

    public void populaCurso(){
        for (int i = 1; i<10; i++){
            Periodo periodo = new Periodo(i+"º período","Ciência da Computação");
            database.insere(periodo);
        }
    }

    public Periodo getPeriodoId(int id){
        return  database.getPeriodo(id);
    }
}
