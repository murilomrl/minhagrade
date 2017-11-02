package com.devmob.minhagrade.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.devmob.minhagrade.Model.Curso;
import com.devmob.minhagrade.Model.Periodo;
import com.devmob.minhagrade.R;

import java.util.List;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class PeriodoAdapter extends BaseAdapter {

    Context context;
    List<Periodo> periodoList;
    LayoutInflater layoutInflater;

    public PeriodoAdapter(Context context, List<Periodo> periodoList) {
        this.context = context;
        this.periodoList = periodoList;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return periodoList.size();
    }

    @Override
    public Object getItem(int position) {
        return periodoList.get(position).getNome();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Periodo periodo;
        convertView = layoutInflater.inflate(R.layout.listperiodo,null);
        TextView nomePeriodo = (TextView) convertView.findViewById(R.id.nomePeriodo);

        periodo = periodoList.get(position);

        nomePeriodo.setText(periodo.getNome());

        return convertView;
    }
}
