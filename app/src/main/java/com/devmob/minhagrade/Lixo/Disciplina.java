package com.devmob.minhagrade.Lixo;

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
        if (curso.equals("Ciência da Computação")){
            switch (numero){
                case 1:
                    disciplinas = Arrays.asList(new String[]
                            {"Cálculo Infinitesimal I", "Computação I", "Fund da Computacao Digital", "Números Inteiros Criptografia", "Sistemas de Informação"});
                    break;
                case 2:
                    disciplinas = Arrays.asList(new String[]
                            {"Cálculo Integ e Diferencial II","Circuitos Lógicos","Computação II", "Matemática Combinatória","Organização da Informação"});
                    break;
                case 3:
                    disciplinas = Arrays.asList(new String[]
                            {"Álgebra Linear Algorítima","Cálculo Int e Diferencial III", "Computação e Programação","Estrutura de Dados","Linguagens Formais","Mecânica, Oscilações e Ondas"});
                    break;
                case 4:
                    disciplinas = Arrays.asList(new String[]
                            {"Algoritmos e Grafos", "Cálculo Integ e Diferencial IV", "Cálculo Númerico","Computação Concorrente", "Eletromagnetismo e Ótica"});
                    break;
                case 5:
                    disciplinas = Arrays.asList(new String[]
                            {"Arquitetura de Computadores I", "Banco de Dados I", "Compiladores I", "Computadores e Sociedade", "Fund da Engenharia de Software", "Lógica"});
                    break;
                case 6:
                    disciplinas = Arrays.asList(new String[]
                            {"Computação Gráfica I", "Estatística e Probabilidade", "Inteligência Artificial", "Programação Linear I","ELETIVA"});
                    break;
                case 7:
                    disciplinas = Arrays.asList(new String[]
                            {"Avaliação de Desempenho", "Sistemas Operacionais I","ELETIVA","ELETIVA"});
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
        else if (curso.equals("BCMT")){
            switch (numero){
                case 1:
                    disciplinas = Arrays.asList(new String[]
                            {"Tóp Gerais Ciências da Terra", "Inovações Cient Tecn e Art I", "Introducao à Fisica A.", "Introducao à Fisica B", "Computacao I","Calculo Difer e Integral I","Introdução ao Cálculo"});
                    break;
                case 2:
                    disciplinas = Arrays.asList(new String[]
                            {"Inovações Cient Tecn e Art II","Fisica Experimental I","Fisica I", "Calculo Diferen e Integral II"});
                    break;
                case 3:
                    disciplinas = Arrays.asList(new String[]
                            {"Inovações Cient Tecn e Art III","Calculo Diferen e Integral III"});
                    break;
                case 4:
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
