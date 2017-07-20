package com.devmob.minhagrade.Adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kobayashi on 19/07/2017.
 */

public class DisciplinasAdapter extends BaseAdapter {

    private final List<Disciplina> disciplinaArrayList;
    private final Context context;

    public DisciplinasAdapter(List<Disciplina> disciplinaArrayList, Context context) {
        this.disciplinaArrayList = disciplinaArrayList;
        this.context = context;
    }


    @Override
    public int getCount() {
        return disciplinaArrayList != null ? disciplinaArrayList.size() : 0;
    }

    @Override
    public Object getItem(int position) {
        return disciplinaArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Infla a View
        View view = LayoutInflater.from(context).inflate(R.layout.listdisciplina,parent,false);

        // Faz ViewById das views que precisa atualizar
        TextView textView = (TextView)view.findViewById(R.id.nomeDisciplina);

        // Atualiza os valores das views
        Disciplina disciplina = disciplinaArrayList.get(position);
        // Coloca valor na TextView do listdisciplina.xml
        textView.setText(disciplina.getNome());

        // Retorna view
        return view;
    }
}
