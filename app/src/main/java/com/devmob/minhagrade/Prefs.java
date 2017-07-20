package com.devmob.minhagrade;

import android.content.Context;
import android.content.SharedPreferences;

import static com.devmob.minhagrade.CourseActivity.MY_PREFS_NAME;

/**
 * Created by Kobayashi on 20/07/2017.
 */

public class Prefs {

    // Metodo para salvar String
    public static void setString(Context context, String chave, String valor){
        SharedPreferences pref = context.getSharedPreferences(MY_PREFS_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(chave,valor);
        editor.apply();
    }

    // Metodo para buscar String
    public static String getString(Context context, String chave){
        SharedPreferences pref = context.getSharedPreferences(MY_PREFS_NAME,context.MODE_PRIVATE);
        String valor = pref.getString(chave,"");
        return valor;
    }

    // Metodo para salvar int
    public static void setInteger(Context context, String chave, int valor){
        SharedPreferences pref = context.getSharedPreferences(MY_PREFS_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(chave,valor);
        editor.apply();
    }

    // Metodo para buscar int
    public static int getInt(Context context, String chave){
        SharedPreferences pref = context.getSharedPreferences(MY_PREFS_NAME,context.MODE_PRIVATE);
        int valor = pref.getInt(chave,0);
        return valor;
    }
}