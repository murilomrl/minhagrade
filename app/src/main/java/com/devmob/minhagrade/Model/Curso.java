package com.devmob.minhagrade.Model;

import android.content.Context;
import android.util.Log;

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBAttribute;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBMapper;
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBTable;
import com.devmob.minhagrade.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by DevMob on 17/05/2017.
 */
@DynamoDBTable(tableName = "curso")
public class Curso {

    private String _id;
    private String nome;
    private int periodos;
    //    Total de créditos de eletivas
    private Float eletivas;
    private List<Disciplina> disciplinas = new ArrayList<>();

    public Curso(String nome, Float eletivas) {
        this._id = "";
        this.nome = nome;
        this.eletivas = eletivas;
    }

//    public Curso(String nome) {
//        this._id = "";
//        this.nome = nome;
//    }

    @DynamoDBAttribute(attributeName = "id")
    public String getId() {
        return _id;
    }

    @DynamoDBAttribute(attributeName = "nome")
    public String getNome() {
        return nome;
    }

    @DynamoDBAttribute(attributeName = "periodos")
    public int getPeriodos(){
        return periodos;
    }

    public Float getEletivas() {
        return eletivas;
    }

    public void setEletivas(Float eletivas) {
        this.eletivas = eletivas;
    }

    @DynamoDBAttribute(attributeName = "disciplinas")
    public List<Disciplina> getDisciplinas(){
        return disciplinas;
    }

    public String toString(){
        return (new Gson()).toJson(this);
    }
}
