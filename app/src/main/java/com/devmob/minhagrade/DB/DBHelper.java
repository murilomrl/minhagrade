package com.devmob.minhagrade.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";
    private final Context context;
    protected SQLiteDatabase db;

    public static final String DB_NOME = "MinhaGrade.sqlite";
    private static final int VERSAO = 1;

//    Tabelas do BD
    public static final String TABLE_PERIODO = "Periodo";
    public static final String TABLE_DISCIPLINA = "Disciplina";
    public static final String TABLE_LEMBRETE = "Lembrete";

//    Nomes Comuns de coluna
    public static final String KEY_ID = "id";

//    Cria tabelas
    private static final String CREATE_PERIODO = "CREATE TABLE IF NOT EXISTS "+TABLE_PERIODO+"(nome TEXT NOT NULL PRIMARY KEY, curso TEXT NOT NULL)";
    private static final String CREATE_DISCIPLINA = "CREATE TABLE IF NOT EXISTS "+TABLE_DISCIPLINA+"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXT NOT NULL, status INTEGER NOT NULL, periodo TEXT NOT NULL, FOREIGN KEY(periodo) REFERENCES "+TABLE_PERIODO+"(nome))";
    private static final String CREATE_LEMBRETE = "CREATE TABLE IF NOT EXISTS "+TABLE_LEMBRETE+"("+KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, texto TEXT NOT NULL, tipo TEXT NOT NULL, dia INTEGER NOT NULL, mes INTEGER NOT NULL, ano INTEGER NOT NULL, disciplina TEXT, FOREIGN KEY(disciplina) REFERENCES "+TABLE_DISCIPLINA+"(nome))";

    public DBHelper(Context context) {
        super(context, DB_NOME, null, VERSAO);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG,"Criando Tabelas");
        db.execSQL(CREATE_PERIODO);
        db.execSQL(CREATE_DISCIPLINA);
        db.execSQL(CREATE_LEMBRETE);
        Log.d(TAG,"Tabelas Criadas");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(TAG, "Atualizando Banco de Dados de "+oldVersion+" para "+newVersion);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DISCIPLINA);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_PERIODO);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_LEMBRETE);
        onCreate(db);
    }

    public DBHelper onOpen(){
        db = this.getWritableDatabase();
        return this;
    }

    public void onClose(){
        db.close();
    }

}
