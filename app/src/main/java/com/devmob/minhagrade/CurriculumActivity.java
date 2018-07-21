package com.devmob.minhagrade;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

public class CurriculumActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curriculum);

        final Switch switchVisualizacao = (Switch) findViewById(R.id.switchVisualizacao);

        /**
         * Estou inserindo os fragments que vão alterar de acordo com o switch que vai interagir com o usuario
         * Por default o switch vai começar não selecionado
         * se o swtich estiver selecionado o fragment que que é carregado é a de Disciplinas, caso contrario a de periodos
         */
        FragmentManager fm = getFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        if(switchVisualizacao.isChecked()){
            Fragment fragmentSelected = new DisciplinasFragment();
            fragmentTransaction.add(R.id.fragment, fragmentSelected);
            fragmentTransaction.commit();
        }else{
            Fragment fragmentSelected = new PeriodosFragment();
            fragmentTransaction.add(R.id.fragment, fragmentSelected);
            fragmentTransaction.commit();
        }

        /**
         * Colocando o listener no switch de visualização que vai fazer a substituição das fragments
         */
        switchVisualizacao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction fragmentTransaction = fm.beginTransaction();
                if (switchVisualizacao.isChecked()) {
                    Fragment fragmentSelected = new DisciplinasFragment();
                    fragmentTransaction.replace(R.id.fragment,fragmentSelected);
                    fragmentTransaction.commit();
                }else{
                    Fragment fragmentSelected = new PeriodosFragment();
                    fragmentTransaction.replace(R.id.fragment,fragmentSelected);
                    fragmentTransaction.commit();
                }
            }
        });

    }

}
