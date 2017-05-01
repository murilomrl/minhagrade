package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class PeriodoActivity extends AppCompatActivity {

    private ListView listasDeDisciplinas;
    private Disciplina disciplina = new Disciplina();
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodo);

        Intent intent = getIntent();
        ArrayList<String> value =  intent.getStringArrayListExtra("MESSAGE");
        TextView periodo = (TextView) findViewById(R.id.periodo);
        periodo.setText(value.get(1));

        listasDeDisciplinas = (ListView) findViewById(R.id.listaDisciplinas);

        adapter = new ArrayAdapter<String>(this, R.layout.listperiodo, disciplina.getDisciplinas(value.get(0),value.get(1)));

        listasDeDisciplinas.setAdapter(adapter);

    }

    //Volta para a activity anterior
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
