package com.devmob.minhagrade.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.PeriodoActivity;
import com.devmob.minhagrade.Prefs;
import com.devmob.minhagrade.ProgressActivity;
import com.devmob.minhagrade.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kobayashi on 19/07/2017.
 */

public class DisciplinasAdapter extends BaseAdapter {

    private final List<Disciplina> disciplinaArrayList;
    private final Context context;
    private final int act;

    // Variável act criada simplesmente para não precisar de dois adapters...
    public DisciplinasAdapter(List<Disciplina> disciplinaArrayList, Context context, int act) {
        this.disciplinaArrayList = disciplinaArrayList;
        this.context = context;
        this.act = act;
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
    public View getView(int position, final View convertView, ViewGroup parent) {
        View view;
        final Disciplina disciplina;

        if(this.act==1) {
            //Infla a View
            view = LayoutInflater.from(context).inflate(R.layout.gradedisciplina, parent, false);
            // Faz ViewById das views que precisa atualizar
            TextView textView = (TextView)view.findViewById(R.id.nomeDisciplina);

            // Atualiza os valores das views
            disciplina = disciplinaArrayList.get(position);

            // Coloca valor na TextView do listdisciplina.xml
            textView.setText(disciplina.getNome());

            // Parte dos icones clicáveis
            ImageButton check = (ImageButton) view.findViewById(R.id.checkIcon);

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Prefs.setInteger(context,disciplina.getNome(),2);
                }
            });

            ImageButton delete = (ImageButton) view.findViewById(R.id.deleteIcon);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Prefs.setInteger(context,disciplina.getNome(),0);
                    Toast.makeText(context,"12",Toast.LENGTH_SHORT).show();
                }
            });

        }else {
            //Infla a View
            view = LayoutInflater.from(context).inflate(R.layout.listdisciplina, parent, false);

            // Faz ViewById das views que precisa atualizar
            TextView textView = (TextView) view.findViewById(R.id.nomeDisciplina);

            // Atualiza os valores das views
            disciplina = disciplinaArrayList.get(position);

            // Coloca valor na TextView do listdisciplina.xml
            textView.setText(disciplina.getNome());
        }

        // Colorir Item pelo status
        if (disciplina.getStatus() == 2){
            view.setBackgroundColor(context.getResources().getColor(R.color.colorFeito));
        }
        else if (disciplina.getStatus() == 1){
            view.setBackgroundColor(context.getResources().getColor(R.color.colorFazendo));
        }
        else{
            view.setBackgroundColor(context.getResources().getColor(R.color.colorNaoFeito));
        }

        // Retorna view
        return view;
    }
}
