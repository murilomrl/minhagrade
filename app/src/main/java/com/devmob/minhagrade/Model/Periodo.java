package com.devmob.minhagrade.Model;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class Periodo {
    private String nome ;
    private String curso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Periodo(String nome, String curso) {

        this.nome = nome;
        this.curso = curso;
    }
}
