package com.devmob.minhagrade.Model

import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.DynamoDBDocument

@DynamoDBDocument
class Discipline {
    private var nome: String? = null
    private var periodo: Int? = null

    fun getNome(): String? {
        return nome
    }

    fun setNome(nome:String){
        this.nome = nome
    }

    fun getPeriodo(): Int?{
        return periodo
    }

    fun setPeriodo(periodo: Int){
        this.periodo = periodo
    }
}