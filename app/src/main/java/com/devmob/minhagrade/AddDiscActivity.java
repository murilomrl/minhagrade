package com.devmob.minhagrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.devmob.minhagrade.Adapter.DisciplinasAdapter;
import com.devmob.minhagrade.Model.Disciplina;

import java.util.ArrayList;

/**
 * Created by murilo on 02/08/17.
 */

public class AddDiscActivity extends AppCompatActivity{

    private ListView listViewDeDisciplinas;
    private ArrayList<Disciplina> disciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discadd);
        Intent intent = getIntent();
        final ArrayList<String> value = intent.getStringArrayListExtra("MESSAGE");
        // Salva alteracoes
        Button concluido = (Button) findViewById(R.id.concAddDisc);
        concluido.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AddDiscActivity.this.finish();
                overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
            }
        });
        // Instancia a ListView
        listViewDeDisciplinas = (ListView) findViewById(R.id.discToAdd);
        // Popula a Lista de disciplinas apartir do Model de Disciplinas

        disciplinas = Disciplina.getDisciplinasPorStatus(value,this,0);
        listViewDeDisciplinas.setAdapter(new DisciplinasAdapter(disciplinas, this, 2));
    }

    //Volta para a activity anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);

    }
}

