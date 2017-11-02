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
    DisciplinaDAO databaseDisciplina;

    public CienciaDaComputação(Context context) {
        this.context = context;
        database = new PeriodoDAO(context);
        databaseDisciplina = new DisciplinaDAO(context);
    }

    public void populaCurso(){
        for (int i = 1; i<10; i++){
            Periodo periodo = new Periodo(i+"º período","Ciência da Computação");
            database.insere(periodo);
        }
//      1º Periodo
        databaseDisciplina.insere(new Disciplina("Cálculo Infinitesimal I",0,1));
        databaseDisciplina.insere(new Disciplina("Computação I",0,1));
        databaseDisciplina.insere(new Disciplina("Fund da Computacao Digital",0,1));
        databaseDisciplina.insere(new Disciplina("Números Inteiros Criptografia",0,1));
        databaseDisciplina.insere(new Disciplina("Sistemas de Informação",0,1));
//      2º Periodo
        databaseDisciplina.insere(new Disciplina("Cálculo Integ e Diferencial II",0,2));
        databaseDisciplina.insere(new Disciplina("Circuitos Lógicos",0,2));
        databaseDisciplina.insere(new Disciplina("Computação II",0,2));
        databaseDisciplina.insere(new Disciplina("Matemática Combinatória",0,2));
        databaseDisciplina.insere(new Disciplina("Organização da Informação",0,2));
//      3º Periodo
        databaseDisciplina.insere(new Disciplina("Álgebra Linear Algorítima",0,3));
        databaseDisciplina.insere(new Disciplina("Cálculo Int e Diferencial III",0,3));
        databaseDisciplina.insere(new Disciplina("Computação e Programação",0,3));
        databaseDisciplina.insere(new Disciplina("Estrutura de Dados",0,3));
        databaseDisciplina.insere(new Disciplina("Linguagens Formais",0,3));
        databaseDisciplina.insere(new Disciplina("Mecânica, Oscilações e Ondas",0,3));
//      4º Periodo
        databaseDisciplina.insere(new Disciplina("Algoritmos e Grafos",0,4));
        databaseDisciplina.insere(new Disciplina("Cálculo Integ e Diferencial IV",0,4));
        databaseDisciplina.insere(new Disciplina("Cálculo Númerico",0,4));
        databaseDisciplina.insere(new Disciplina("Computação Concorrente",0,4));
        databaseDisciplina.insere(new Disciplina("Eletromagnetismo e Ótica",0,4));
//      5º Periodo
        databaseDisciplina.insere(new Disciplina("Arquitetura de Computadores I",0,5));
        databaseDisciplina.insere(new Disciplina("Banco de Dados I",0,5));
        databaseDisciplina.insere(new Disciplina("Compiladores I",0,5));
        databaseDisciplina.insere(new Disciplina("Computadores e Sociedade",0,5));
        databaseDisciplina.insere(new Disciplina("Fund da Engenharia de Software",0,5));
        databaseDisciplina.insere(new Disciplina("Lógica",0,5));
//      6º Periodo
        databaseDisciplina.insere(new Disciplina("Computação Gráfica I",0,6));
        databaseDisciplina.insere(new Disciplina("Estatística e Probabilidade",0,6));
        databaseDisciplina.insere(new Disciplina("Inteligência Artificial",0,6));
        databaseDisciplina.insere(new Disciplina("Programação Linear I",0,6));
        databaseDisciplina.insere(new Disciplina("ELETIVA 1",0,6));
//      7º Periodo
        databaseDisciplina.insere(new Disciplina("Avaliação de Desempenho",0,7));
        databaseDisciplina.insere(new Disciplina("Sistemas Operacionais I",0,7));
        databaseDisciplina.insere(new Disciplina("ELETIVA 2",0,7));
        databaseDisciplina.insere(new Disciplina("ELETIVA 3",0,7));
//      8º Periodo
        databaseDisciplina.insere(new Disciplina("Teleprocessamento e Redes",0,8));
        databaseDisciplina.insere(new Disciplina("ELETIVA 4",0,8));
        databaseDisciplina.insere(new Disciplina("ELETIVA 5",0,8));
        databaseDisciplina.insere(new Disciplina("ELETIVA 6",0,8));
        databaseDisciplina.insere(new Disciplina("ELETIVA 7",0,8));
//      9º Periodo
        databaseDisciplina.insere(new Disciplina("ELETIVA 8",0,9));
        databaseDisciplina.insere(new Disciplina("ELETIVA 9",0,9));
        databaseDisciplina.insere(new Disciplina("ELETIVA 10",0,9));
    }

    public Periodo getPeriodoId(int id){
        return  database.getPeriodo(id);
    }
}
