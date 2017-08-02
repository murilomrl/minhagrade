package com.devmob.minhagrade.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.devmob.minhagrade.Model.Curso;
import com.devmob.minhagrade.R;

import java.util.List;

/**
 * Created by Kobayashi on 01/08/2017.
 */

public class CursoAdapter extends BaseAdapter {
    Context context;
    List<Curso> cursos;
    LayoutInflater layoutInflater;

    public CursoAdapter(Context context, List<Curso> cursos) {
        this.context = context;
        this.cursos = cursos;
        layoutInflater = (LayoutInflater.from(context));
    }

    @Override
    public int getCount() {
        return cursos.size();
    }

    @Override
    public Object getItem(int position) {
        return cursos.get(position).getNome();
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Curso curso;
        view = layoutInflater.inflate(R.layout.spinnercurso,null);
        TextView nomeCurso = (TextView) view.findViewById(R.id.nomeCurso);

        curso = cursos.get(i);

        nomeCurso.setText(curso.getNome());

        return view;
    }
}
