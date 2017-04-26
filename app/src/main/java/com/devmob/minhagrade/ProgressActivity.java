package com.devmob.minhagrade;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by devmob on 27/03/17.
 */

public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        ArrayText numeroPeriodos = new ArrayText();

//      Editar essa parte para o numero de periodos de acordo com o curso
        numeroPeriodos.createPeriodo(9);

        Intent intent = getIntent();
        String value =  intent.getStringExtra("MESSAGE");
        TextView course = (TextView) findViewById(R.id.course);
        course.setText(value);



        List<String> periodos = numeroPeriodos.getPeriodos();

        ListView listasDePeriodos = (ListView) findViewById(R.id.listaPeriodo);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.listperiodo, periodos);

        listasDePeriodos.setAdapter(adapter);

    }
}
