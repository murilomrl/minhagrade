package com.devmob.minhagrade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hylson on 25/04/2017.
 */

public class ListaDeCursos {
    // Listas de Strings pré-definidas para o aplicativo pode melhorar para entrar num MVC
    private List<String> courses = new ArrayList<>();


    //Cria as listas com as strings
    public void createCourses(){
        courses.add("Ciencia da Computação");
        courses.add("Fisica");
        courses.add("Matematica Aplicada");
        courses.add("Arquitetura");
        courses.add("Medicina");
        Collections.sort(courses);
    }


    //Retorna as Listas
    public List<String> getCourses() {
        return courses;
    }

}
