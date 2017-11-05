package com.devmob.minhagrade.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.devmob.minhagrade.Model.Curso;
import com.devmob.minhagrade.Model.Periodo;
import com.devmob.minhagrade.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kobayashi on 02/11/2017.
 */

public class PeriodoAdapter extends BaseAdapter {

    private final Context context;
     private final List<Periodo> periodoList;

    public PeriodoAdapter(Context context, List<Periodo> periodoList) {
        this.context = context;
        this.periodoList = periodoList;
        //Log.d("list", periodoList.toString());
    }

    @Override
    public int getCount() {
        return  periodoList != null?periodoList.size():0;
    }

    @Override
    public Object getItem(int position) {
        return periodoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_periodo, parent, false);

        TextView nomePeriodo = (TextView) view.findViewById(R.id.textViewPeriodo);
        Periodo periodo = periodoList.get(position);
        nomePeriodo.setText(periodo.getNome());

        return view;
    }
}
