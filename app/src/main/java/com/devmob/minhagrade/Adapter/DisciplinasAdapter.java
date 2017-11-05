package com.devmob.minhagrade.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.devmob.minhagrade.GradeActivity;
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

            // Coloca valor na TextView do adapter_disciplina.xml
            textView.setText(disciplina.getNome());

            // Parte dos icones clicáveis
            ImageButton check = (ImageButton) view.findViewById(R.id.checkIcon);

            check.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setCancelable(true);
                    builder.setTitle("Confirmação");
                    builder.setMessage("Você tem certeza que quer colocar disciplina como concluída?");
                    builder.setPositiveButton("Sim",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//                                    Prefs.setInteger(context,disciplina.getNome(),2);
//                                    Prefs.setInteger(context,"Concluido",Prefs.getInt(context,"Concluido")+1);
                                    ((Activity) context).finish();
                                    ((Activity) context).startActivity(((Activity) context).getIntent());
                                }
                            });
                    builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });

            ImageButton delete = (ImageButton) view.findViewById(R.id.deleteIcon);
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setCancelable(true);
                    builder.setTitle("Confirmação");
                    builder.setMessage("Você tem certeza que quer remover a disciplina da sua grade?");
                    builder.setPositiveButton("Sim",
                            new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
//                                    Prefs.setInteger(context,disciplina.getNome(),0);
                                    ((Activity) context).finish();
                                    ((Activity) context).startActivity(((Activity) context).getIntent());
                                }
                            });
                    builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            });

        }else {
            if(act==0) {
                //Infla a View
                view = LayoutInflater.from(context).inflate(R.layout.adapter_disciplina, parent, false);

                // Faz ViewById das views que precisa atualizar
                TextView textView = (TextView) view.findViewById(R.id.nomeDisciplina);

                // FindViewById de status
                TextView status = (TextView) view.findViewById(R.id.statusDisciplina);

                // Atualiza os valores das views
                disciplina = disciplinaArrayList.get(position);

                // Coloca valor na TextView do adapter_disciplina.xml
                textView.setText(disciplina.getNome());

                // Colorir Item pelo status
                if (disciplina.getStatus() == 2) {
                    status.setText("Concluido");
                    view.setBackgroundColor(context.getResources().getColor(R.color.colorFeito));
                } else if (disciplina.getStatus() == 1) {
                    status.setText("Cursando");
                    view.setBackgroundColor(context.getResources().getColor(R.color.colorFazendo));
                } else {
                    status.setText("Pendente");
                    view.setBackgroundColor(context.getResources().getColor(R.color.colorNaoFeito));
                }
            }else{
                //Infla a View
                view = LayoutInflater.from(context).inflate(R.layout.adicionardisciplina, parent, false);
                // Atualiza os valores das views
                disciplina = disciplinaArrayList.get(position);
                // Botoes de Radio
                RadioButton btdisc = (RadioButton) view.findViewById(R.id.radiobtDisc);
                btdisc.setText(disciplina.getNome());
                // Modifica prefs ao mudar o check
                btdisc.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if(isChecked) {
//                            Prefs.setInteger(context, disciplina.getNome(), 1);
                        }
                        else{
//                            Prefs.setInteger(context, disciplina.getNome(), 0);
                        }
                    }
                });

            }
        }



        // Retorna view
        return view;
    }
}
