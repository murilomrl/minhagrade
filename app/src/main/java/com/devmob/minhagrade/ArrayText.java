package com.devmob.minhagrade;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hylson on 25/04/2017.
 */

public class ArrayText {
    // Listas de Strings pré-definidas para o aplicativo
    private List<String> courses = new ArrayList<>();
    private List<String> periodos = new ArrayList<>();

    //Cria as listas com as strings
    public void createCourses(){
        courses.add("Ciencia da Computação");
        courses.add("Fisica");
        courses.add("Matematica Aplicada");
    }

    public void createPeriodo(int n){
        for (int i = 1;i<=n; i++) {
            periodos.add(i + "º periodo");
        }
    }

    //Retorna as Listas
    public List<String> getCourses() {
        return courses;
    }

    public List<String> getPeriodos() {
        return periodos;
    }
}
