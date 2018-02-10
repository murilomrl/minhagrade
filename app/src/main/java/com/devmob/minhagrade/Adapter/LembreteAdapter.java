package com.devmob.minhagrade.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devmob.minhagrade.Model.Lembrete;
import com.devmob.minhagrade.R;

import java.util.List;

/**
 * Created by murilo on 10/02/18.
 */

public class LembreteAdapter extends RecyclerView.Adapter<LembreteAdapter.ViewHolder> {
    private Context context;
    private List<Lembrete> listaLembrete;

    public LembreteAdapter(Context context, List<Lembrete> listaLembrete) {
        this.context = context;
        this.listaLembrete = listaLembrete;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView texto;
        public TextView tipo;
        public TextView data;
        public TextView disciplina;
        public ViewGroup viewGroup;

        public ViewHolder(View view){
            super(view);
            texto = (TextView) view.findViewById(R.id.textoCard);
            tipo = (TextView) view.findViewById(R.id.tipoCard);
            data = (TextView) view.findViewById(R.id.dataCard);
            disciplina = (TextView) view.findViewById(R.id.disciplinaCard);
            viewGroup = (ViewGroup) itemView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lembrete_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.viewGroup.;
        Lembrete lembrete = listaLembrete.get(position);
        holder.texto.setText(lembrete.getTexto());
        holder.tipo.setText(lembrete.getTipo());
        holder.data.setText("Data: "+lembrete.getData()[0]+"/"+lembrete.getData()[1]+"/"+lembrete.getData()[2]);
        holder.disciplina.setText(lembrete.getDisciplina());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        //Log.i("AQUI",String.valueOf(listaLembrete.size()));
        return listaLembrete.size();
    }
}
