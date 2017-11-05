package com.devmob.minhagrade.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.Model.Periodo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class DisciplinaDAO extends DBHelper{
    private static final String TAG = "DiscipliaDAO";

    public DisciplinaDAO(Context context) {
        super(context);
    }

    public void insere(Disciplina disciplina){
        onOpen();
        ContentValues values = new ContentValues();
        values.put("nome", disciplina.getNome());
        values.put("status", disciplina.getStatus());
        values.put("periodo", disciplina.getPeriodo());
        db.insert(DBHelper.TABLE_DISCIPLINA,null, values);
        onClose();
    }

    public void atualiza(Disciplina disciplina){
        onOpen();
        ContentValues values = new ContentValues();
        values.put("nome", disciplina.getNome());
        values.put("status",disciplina.getStatus());
        values.put("periodo",disciplina.getPeriodo());
        db.update(DBHelper.TABLE_DISCIPLINA,values," id = "+disciplina.getId(),null);
        onClose();
    }

    public List<Disciplina> getDisciplinasPorPeriodo(String periodo){
        List<Disciplina> disciplinas = new ArrayList<>();
        onOpen();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DBHelper.TABLE_DISCIPLINA+" WHERE periodo= '"+periodo+"'", null);
        while (cursor.moveToNext()){
            Disciplina disciplina = new Disciplina(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getInt(cursor.getColumnIndex("status")),
                    cursor.getString(cursor.getColumnIndex("periodo")));
            disciplinas.add(disciplina);
        }
        onClose();
        return disciplinas;
    }
    public List<Disciplina> getDisciplinas(){
        List<Disciplina> disciplinas = new ArrayList<>();
        onOpen();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DBHelper.TABLE_DISCIPLINA, null);
        while (cursor.moveToNext()){
            Disciplina disciplina = new Disciplina(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getInt(cursor.getColumnIndex("status")),
                    cursor.getString(cursor.getColumnIndex("periodo")));
            disciplinas.add(disciplina);
        }
        onClose();
        return disciplinas;
    }


    public void atualizaDisciplinas(List<Disciplina> disciplinaList){
//        onOpen();
        for (Disciplina disciplina: disciplinaList) {
            atualiza(disciplina);
        }
//        onClose();
    }
}
