package com.devmob.minhagrade.Model

class Course {
    private var nome: String? = null
    private var periodos: Int? = null
    private var disciplinas: ArrayList<Discipline>? = null

    fun getNome(): String? {
        return nome
    }

    fun setNome(nome:String){
        this.nome = nome
    }

    fun getPeriodos(): Int?{
        return periodos
    }

    fun setPeriodos(periodos: Int){
        this.periodos = periodos
    }
}