package com.devmob.minhagrade.Model

class RootRoot {
    private var cursos: ArrayList<Course>? = null

    fun getCursos(): ArrayList<Course>?{
        return cursos
    }

    fun setCursos(cursos: ArrayList<Course>){
        this.cursos = cursos
    }
}