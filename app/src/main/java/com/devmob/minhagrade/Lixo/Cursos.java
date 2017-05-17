package com.devmob.minhagrade.Lixo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Hylson on 25/04/2017.
 */

public class Cursos {
    // Listas de Strings pré-definidas para o aplicativo pode melhorar para entrar num MVC
    private List<String> courses = new ArrayList<>();

    //Retorna as Listas
    public List<String> getCourses() {
        courses.add("Ciência da Computação");
        courses.add("Fisica");
        courses.add("Matematica Aplicada");
        courses.add("Arquitetura");
        courses.add("BCMT");
        Collections.sort(courses);
        return courses;
    }

}
