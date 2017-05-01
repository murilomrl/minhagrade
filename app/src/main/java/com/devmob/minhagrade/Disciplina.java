package com.devmob.minhagrade;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Hylson on 01/05/2017.
 */

public class Disciplina {
    private List<String> disciplinas;

    public List<String> getDisciplinas(String curso, String periodo){
        String[] separador = periodo.split("º");
        int numero = Integer.parseInt(separador[0]);
        if (curso.equals("Ciencia da Computação")){
            switch (numero){
                case 1:
                    disciplinas = Arrays.asList(new String[]
                            {"Cálculo Infinitesimal 1", "Computação 1", "Fundamentos da Computação Digital", "Números Inteiros e Criptografia", "Sistemas de Informação"});
                    break;
                case 2:
                    disciplinas = Arrays.asList(new String[]
                            {"Cálculo Integral e Diferencial 2","Circuitos Lógicos","Computação 2", "Matemática Combinatória","Organização da Informação"});
                    break;
                case 3:
                    disciplinas = Arrays.asList(new String[]
                            {"Álgebra Linear Algorítima","Cálculo Integral e Diferencial 3", "Computação e Programação","Estrutura de Dados","Linguagens Formais","Mecânica, Oscilações e Ondas"});
                    break;
                case 4:
                    disciplinas = Arrays.asList(new String[]
                            {"Algoritmos e Grafos", "Cálculo Integral e Diferencial 4", "Cálculo Númerico","Computação Concorrente", "Eletromagnetismo e Ótica"});
                    break;
                case 5:
                    disciplinas = Arrays.asList(new String[]
                            {"Arquitetura de Computadores 1", "Banco de Dados 1", "Compiladores 1", "Computadores e Sociedades", "Fundamentos da Engenharia de Software", "Lógica"});
                    break;
                case 6:
                    disciplinas = Arrays.asList(new String[]
                            {"Computação Gráfica", "Estatística e Probabilidade", "Inteligência Artificial", "Programação Linear","ELETIVA"});
                    break;
                case 7:
                    disciplinas = Arrays.asList(new String[]
                            {"Avaliação de Desempenho", "Sistemas Operacionais 1","ELETIVA","ELETIVA"});
                    break;
                case 8:
                    disciplinas = Arrays.asList(new String[]
                            {"Teleprocessamento e Redes","ELETIVA","ELETIVA","ELETIVA","ELETIVA"});
                    break;
                case 9:
                    disciplinas = Arrays.asList(new String[]
                            {"ELETIVA","ELETIVA","ELETIVA"});
                    break;
                default:
                    disciplinas = new ArrayList<String>();
            }
        }
        else {
            disciplinas = new ArrayList<>();
        }
        return disciplinas;
    }
}
