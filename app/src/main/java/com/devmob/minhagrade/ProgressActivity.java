package com.devmob.minhagrade;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by devmob on 27/03/17.
 */

public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        final ListaDePeriodos periodos = new ListaDePeriodos();

        Intent intent = getIntent();
        String value =  intent.getStringExtra("MESSAGE");
        TextView course = (TextView) findViewById(R.id.course);
        course.setText(value);

        periodos.createPeriodo(value);

        //Teste de back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ListView listasDePeriodos = (ListView) findViewById(R.id.listaPeriodo);

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listperiodo, periodos.getPeriodos());

        listasDePeriodos.setAdapter(adapter);

        listasDePeriodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String periodoSelecionado = (String) adapter.getItem(position);
                Toast.makeText(ProgressActivity.this,periodoSelecionado,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProgressActivity.this, PeriodoActivity.class);
                String message = String.valueOf(periodoSelecionado);
                intent.putExtra("MESSAGE", message);
                ProgressActivity.this.startActivity(intent);
            }
        });

    }
}
