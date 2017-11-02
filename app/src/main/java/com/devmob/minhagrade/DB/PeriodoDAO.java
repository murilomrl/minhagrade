package com.devmob.minhagrade.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.devmob.minhagrade.Model.Curso;
import com.devmob.minhagrade.Model.Periodo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class PeriodoDAO extends DBHelper{
    private static final String TAG = "PeriodoDAO";

    public PeriodoDAO(Context context) {
        super(context);
    }

    public void insere(Periodo periodo){
        onOpen();
        ContentValues values = new ContentValues();
        values.put("nome", periodo.getNome());
        values.put("curso", periodo.getCurso());
        db.insert(DBHelper.TABLE_PERIODO,null, values);
        onClose();
    }

    public Periodo getPeriodo(Integer id){
        Periodo periodo = null;
        String sql = "SELECT * FROM "+DBHelper.TABLE_PERIODO+" WHERE "+DBHelper.KEY_ID+" = "+id;
        onOpen();
        Cursor cursor = db.rawQuery(sql,null);
        if (cursor.moveToNext()){
            periodo = new Periodo(
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("curso")));
        }
        onClose();
        return periodo;
    }

    public List<Periodo> getPeriodos(){
        List<Periodo> periodos = new ArrayList<>();
        onOpen();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DBHelper.TABLE_PERIODO, null);
        while (cursor.moveToNext()){
            Periodo periodo= new Periodo(
                    cursor.getString(cursor.getColumnIndex("nome")),
                    cursor.getString(cursor.getColumnIndex("curso")));
            periodos.add(periodo);
        }
        onClose();
        return periodos;
    }

    public boolean apagaTudo(){
        onOpen();
        db.execSQL("DELETE FROM "+ DBHelper.TABLE_DISCIPLINA);
        db.execSQL("DELETE FROM "+ DBHelper.TABLE_PERIODO);
        onClose();
        return true;
    }
}
