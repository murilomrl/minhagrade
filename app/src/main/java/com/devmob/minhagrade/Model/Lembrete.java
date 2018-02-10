package com.devmob.minhagrade.Model;

/**
 * Created by murilo on 09/02/18.
 */

public class Lembrete {
    private int id;
    private String texto;
    private String tipo;    /*Trabalho, prova, workshop, etc.. (deixar livre pro usuário?) Lembrar de discutir isso*/

    /*SQLite ainda não suporta tipo date,
    então vou deixar dia, mês e ano separado mesmo*/
    private int dia;
    private int mes;
    private int ano;
    private String disciplina = ""; /*Opcional, pois pode ser um evento sem disciplina*/

    public Lembrete(int id, String texto, String tipo, int dia, int mes, int ano, String disciplina){
        this.id = id;
        this.texto = texto;
        this.tipo = tipo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.disciplina = disciplina;
    }

    public Lembrete(String texto, String tipo, int dia, int mes, int ano){
        this.texto = texto;
        this.tipo = tipo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Lembrete(String texto, String tipo, int dia, int mes, int ano, String disciplina){
        this.texto = texto;
        this.tipo = tipo;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.disciplina = disciplina;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getTexto(){
        return texto;
    }

    public void setTexto(String texto){
        this.texto = texto;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public int[] getData(){
        int[] data = new int[3];
        data[0] = dia;
        data[1] = mes;
        data[2] = ano;
        return data;
    }

    public void setData(int[] data){
        this.dia = data[0];
        this.mes = data[1];
        this.ano = data[2];
    }

    public String getDisciplina(){
        return disciplina;
    }

    public void setDisciplina(String disciplina){
        this.disciplina = disciplina;
    }
}
