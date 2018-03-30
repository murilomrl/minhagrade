package com.devmob.minhagrade;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.devmob.minhagrade.Adapter.DisciplinasAdapter;
import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.Model.Prefs;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class PeriodoActivity extends AppCompatActivity implements OnItemClickListener{

    private String curso;
    private ListView listViewDeDisciplinas;
    private List<Disciplina> disciplinas;
    private List<Disciplina> disciplinasComNovoStatus = new ArrayList<>();
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodo);

        Intent intent = getIntent();
        final String value =  intent.getStringExtra("PERIODO");
        TextView periodo = (TextView) findViewById(R.id.periodo);

        // Coloca o numero do periodo no TextView do Periodo
        periodo.setText(value);

        curso =  Prefs.getString(this, "course");
        getSupportActionBar().setTitle(curso);

        // Instancia a ListView
        listViewDeDisciplinas = (ListView) findViewById(R.id.listaDisciplinas);

        // Popula a Lista de disciplinas apartir do Model de Disciplinas
        disciplinas = disciplinaDAO.getDisciplinasPorPeriodo(value);
//        Log.d("LISTA", disciplinas.toString());

        // Usa DisciplinasAdapter para carregar as disciplinas
        listViewDeDisciplinas.setAdapter(new DisciplinasAdapter(disciplinas,this,0));

        // Set OnItemClickListener para cada item da ListView
        listViewDeDisciplinas.setOnItemClickListener(this);
    }

    // Metodo de OnItemClick, para fazer dessa forma a classe tem que ter Implements OnItemClickListener de AdapterView
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Instancia a disciplina de acordo com a posição
        Disciplina disciplina = disciplinas.get(position);

        //Instancia o status da disciplina que foi clicada
        int status = disciplina.getStatus();

        // Cria um ciclo de cliques para apenas 3 status possivel, ver os status no model Disciplina
        status = (status+1)%3;

        // Atualiza o status da disciplina
        disciplina.setStatus(status);

        disciplinaDAO.atualiza(disciplina);

        TextView statusDisciplina = (TextView) view.findViewById(R.id.statusDisciplina);

        // Pinta o ITEM da ListView de acordo com o status
        if (status == 2){
//            Prefs.setInteger(this,"Concluido",Prefs.getInt(this,"Concluido")+1);
            view.setBackgroundColor(this.getResources().getColor(R.color.colorFeito));
            statusDisciplina.setText("Concluido");
        }
        else if (status == 1){
            view.setBackgroundColor(this.getResources().getColor(R.color.colorFazendo));
            statusDisciplina.setText("Cursando");
        }
        else{
//            Prefs.setInteger(this,"Concluido",Prefs.getInt(this,"Concluido")-1);
            statusDisciplina.setText("Pendente");
            view.setBackgroundColor(this.getResources().getColor(R.color.colorNaoFeito));
        }
//        Log.i("Concluido", String.valueOf(Prefs.getInt(this,"Concluido")));
    }

    //Volta para a activity anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

    }

}
