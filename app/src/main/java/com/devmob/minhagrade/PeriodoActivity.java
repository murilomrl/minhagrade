package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

import com.devmob.minhagrade.Adapter.DisciplinasAdapter;
import com.devmob.minhagrade.Model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class PeriodoActivity extends AppCompatActivity implements OnItemClickListener{

    private ListView listViewDeDisciplinas;
    private List<Disciplina> disciplinas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodo);

        Intent intent = getIntent();
        final ArrayList<String> value =  intent.getStringArrayListExtra("MESSAGE");
        TextView periodo = (TextView) findViewById(R.id.periodo);

        // Coloca o numero do periodo no TextView do Periodo
        periodo.setText(value.get(1));

        // Instancia a ListView
        listViewDeDisciplinas = (ListView) findViewById(R.id.listaDisciplinas);

        // Popula a Lista de disciplinas apartir do Model de Disciplinas
        disciplinas = Disciplina.getDisciplinas(value,this);

        // Usa DisciplinasAdapter para carregar as disciplinas
        listViewDeDisciplinas.setAdapter(new DisciplinasAdapter(disciplinas,this));

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

        // Pinta o ITEM da ListView de acordo com o status
        if (status == 2){
            view.setBackgroundColor(this.getResources().getColor(R.color.colorFeito));
        }
        else if (status == 1){
            view.setBackgroundColor(this.getResources().getColor(R.color.colorFazendo));
        }
        else{
            view.setBackgroundColor(this.getResources().getColor(R.color.colorNaoFeito));
        }

        Toast.makeText(PeriodoActivity.this, "Disciplina: "+disciplina.getNome(),Toast.LENGTH_SHORT).show();
    }

    //Private Resources

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
