package com.devmob.minhagrade.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.Model.Lembrete;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by murilo on 09/02/18.
 */

public class LembreteDAO extends DBHelper{
    private static final String TAG = "LembreteDAO";

    public LembreteDAO(Context context) {
        super(context);
    }

    public int insere(Lembrete lembrete){
        onOpen();
        int verif;
        ContentValues values = new ContentValues();
        if(lembrete.getTexto().equals("") || lembrete.getTipo().equals("")){
            verif=0;
        }
        else {
            values.put("texto", lembrete.getTexto());
            values.put("tipo", lembrete.getTipo());
            values.put("dia", lembrete.getData()[0]);
            values.put("mes", lembrete.getData()[1]);
            values.put("ano", lembrete.getData()[2]);
            values.put("disciplina", lembrete.getDisciplina());
            db.insert(DBHelper.TABLE_LEMBRETE, null, values);
            verif=1;
        }
        onClose();
        return verif;
    }

    public void atualiza(Lembrete lembrete){
        onOpen();
        ContentValues values = new ContentValues();
        values.put("texto", lembrete.getTexto());
        values.put("tipo", lembrete.getTipo());
        values.put("dia", lembrete.getData()[0]);
        values.put("mes", lembrete.getData()[1]);
        values.put("ano", lembrete.getData()[2]);
        values.put("nomeDisciplina", lembrete.getDisciplina());
        db.update(DBHelper.TABLE_DISCIPLINA,values," id = "+lembrete.getId(),null);
        onClose();
    }

    public List<Lembrete> getLembretePorData(int dia, int mes, int ano){
        List<Lembrete> lembretes = new ArrayList<>();
        onOpen();
        Cursor cursor = db.rawQuery("SELECT * FROM "+DBHelper.TABLE_LEMBRETE+" WHERE dia= "+dia+" and mes= "+mes+" and ano= "+ano, null);
        while (cursor.moveToNext()){
            Lembrete lembrete = new Lembrete(
                    cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("texto")),
                    cursor.getString(cursor.getColumnIndex("tipo")),
                    cursor.getInt(cursor.getColumnIndex("dia")),
                    cursor.getInt(cursor.getColumnIndex("mes")),
                    cursor.getInt(cursor.getColumnIndex("ano")),
                    cursor.getString(cursor.getColumnIndex("disciplina"))
                    );
            lembretes.add(lembrete);
        }
        onClose();
        return lembretes;
    }
}
