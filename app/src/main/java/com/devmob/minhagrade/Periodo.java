package com.devmob.minhagrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hylson on 27/04/2017.
 */

public class Periodo {
    private List<String> periodos = new ArrayList<>();
    private int numero = 1;
    //private List<List<String>> periodosComDisciplinas = new ArrayList<List<String>>();
    String [][] disciplinas;

    public List<String> getPeriodos(String curso) {
        criaPeriodosPeloCurso(curso);
        for (int i = 1;i<=this.numero; i++) {
            periodos.add(i + "º periodo");
            //periodosComDisciplinas.add(i, Arrays.asList(disciplinas[i]));
        }
        return periodos;
    }

    private void criaPeriodosPeloCurso(String curso){

        if (curso.equals("Ciencia da Computação")){
            this.numero = 9;
            disciplinas = new String[][]{
                    //Coloque aqui as disicplinas por periodo
                    {"Cálculo Infinitesimal 1","Computação 1","Fundamentos da Computação Digital","Números Inteiros e Criptografia","Sistemas de Informação"},
                    {"Cálculo Integral e Diferencial 2","Circuitos Lógicos","Computação 2", "Matemática Combinatória","Organização da Informação"},
                    {"Álgebra Linear Algorítima","Cálculo Integral e Diferencial 3", "Computação e Programação","Estrutura de Dados","Linguagens Formais","Mecânica, Oscilações e Ondas"},
                    {"Algoritmos e Grafos", "Cálculo Integral e Diferencial 4", "Cálculo Númerico","Computação Concorrente", "Eletromagnetismo e Ótica"},
                    {"Arquitetura de Computadores 1", "Banco de Dados 1", "Compiladores 1", "Computadores e Sociedades", "Fundamentos da Engenharia de Software", "Lógica"},
                    {"Computação Gráfica", "Estatística e Probabilidade", "Inteligência Artificial", "Programação Linear","ELETIVA"},
                    {"Avaliação de Desempenho", "Sistemas Operacionais 1","ELETIVA","ELETIVA"},
                    {"Teleprocessamento e Redes","ELETIVA","ELETIVA","ELETIVA","ELETIVA"},
                    {"ELETIVA","ELETIVA","ELETIVA"}
            };
        }
        if (curso.equals("Fisica")){
            this.numero = 9;
        }
        if (curso.equals("Matematica Aplicada")){
            this.numero = 10;
        }
        if (curso.equals("Arquitetura")){
            this.numero = 7;
        }
        if (curso.equals("Medicina")){
            this.numero = 10;
        }
        if (curso.equals("BCMT")){
            this.numero = 9;
        }
    }
}
