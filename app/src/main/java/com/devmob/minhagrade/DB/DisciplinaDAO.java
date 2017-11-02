package com.devmob.minhagrade.DB;

import android.content.ContentValues;
import android.content.Context;

import com.devmob.minhagrade.Model.Disciplina;

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

}
