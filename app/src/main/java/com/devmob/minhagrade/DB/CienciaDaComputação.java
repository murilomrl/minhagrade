package com.devmob.minhagrade.DB;

import android.content.Context;

import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.Model.Periodo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class CienciaDaComputação {

    Context context;
    PeriodoDAO database;
    DisciplinaDAO databaseDisciplina;
    List<Periodo> periodos;

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
        periodos = database.getPeriodos();
        databaseDisciplina.insere(new Disciplina("Cálculo Infinitesimal I",0,periodos.get(0).getNome()));
        databaseDisciplina.insere(new Disciplina("Computação I",0,periodos.get(0).getNome()));
        databaseDisciplina.insere(new Disciplina("Fund da Computacao Digital",0,periodos.get(0).getNome()));
        databaseDisciplina.insere(new Disciplina("Números Inteiros Criptografia",0,periodos.get(0).getNome()));
        databaseDisciplina.insere(new Disciplina("Sistemas de Informação",0,periodos.get(0).getNome()));
//      2º Periodo
        databaseDisciplina.insere(new Disciplina("Cálculo Integ e Diferencial II",0,periodos.get(1).getNome()));
        databaseDisciplina.insere(new Disciplina("Circuitos Lógicos",0,periodos.get(1).getNome()));
        databaseDisciplina.insere(new Disciplina("Computação II",0,periodos.get(1).getNome()));
        databaseDisciplina.insere(new Disciplina("Matemática Combinatória",0,periodos.get(1).getNome()));
        databaseDisciplina.insere(new Disciplina("Organização da Informação",0,periodos.get(1).getNome()));
//      3º Periodo
        databaseDisciplina.insere(new Disciplina("Álgebra Linear Algorítima",0,periodos.get(2).getNome()));
        databaseDisciplina.insere(new Disciplina("Cálculo Int e Diferencial III",0,periodos.get(2).getNome()));
        databaseDisciplina.insere(new Disciplina("Computação e Programação",0,periodos.get(2).getNome()));
        databaseDisciplina.insere(new Disciplina("Estrutura de Dados",0,periodos.get(2).getNome()));
        databaseDisciplina.insere(new Disciplina("Linguagens Formais",0,periodos.get(2).getNome()));
        databaseDisciplina.insere(new Disciplina("Mecânica, Oscilações e Ondas",0,periodos.get(2).getNome()));
//      4º Periodo
        databaseDisciplina.insere(new Disciplina("Algoritmos e Grafos",0,periodos.get(3).getNome()));
        databaseDisciplina.insere(new Disciplina("Cálculo Integ e Diferencial IV",0,periodos.get(3).getNome()));
        databaseDisciplina.insere(new Disciplina("Cálculo Númerico",0,periodos.get(3).getNome()));
        databaseDisciplina.insere(new Disciplina("Computação Concorrente",0,periodos.get(3).getNome()));
        databaseDisciplina.insere(new Disciplina("Eletromagnetismo e Ótica",0,periodos.get(3).getNome()));
//      5º Periodo
        databaseDisciplina.insere(new Disciplina("Arquitetura de Computadores I",0,periodos.get(4).getNome()));
        databaseDisciplina.insere(new Disciplina("Banco de Dados I",0,periodos.get(4).getNome()));
        databaseDisciplina.insere(new Disciplina("Compiladores I",0,periodos.get(4).getNome()));
        databaseDisciplina.insere(new Disciplina("Computadores e Sociedade",0,periodos.get(4).getNome()));
        databaseDisciplina.insere(new Disciplina("Fund da Engenharia de Software",0,periodos.get(4).getNome()));
        databaseDisciplina.insere(new Disciplina("Lógica",0,periodos.get(4).getNome()));
//      6º Periodo
        databaseDisciplina.insere(new Disciplina("Computação Gráfica I",0,periodos.get(5).getNome()));
        databaseDisciplina.insere(new Disciplina("Estatística e Probabilidade",0,periodos.get(5).getNome()));
        databaseDisciplina.insere(new Disciplina("Inteligência Artificial",0,periodos.get(5).getNome()));
        databaseDisciplina.insere(new Disciplina("Programação Linear I",0,periodos.get(5).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 1",0,periodos.get(5).getNome()));
//      7º Periodo
        databaseDisciplina.insere(new Disciplina("Avaliação de Desempenho",0,periodos.get(6).getNome()));
        databaseDisciplina.insere(new Disciplina("Sistemas Operacionais I",0,periodos.get(6).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 2",0,periodos.get(6).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 3",0,periodos.get(6).getNome()));
//      8º Periodo
        databaseDisciplina.insere(new Disciplina("Teleprocessamento e Redes",0,periodos.get(7).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 4",0,periodos.get(7).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 5",0,periodos.get(7).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 6",0,periodos.get(7).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 7",0,periodos.get(7).getNome()));
//      9º Periodo
        databaseDisciplina.insere(new Disciplina("ELETIVA 8",0,periodos.get(8).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 9",0,periodos.get(8).getNome()));
        databaseDisciplina.insere(new Disciplina("ELETIVA 10",0,periodos.get(8).getNome()));
    }

}
