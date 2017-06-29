package com.devmob.minhagrade;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by devmob on 27/03/17.
 */

public class ProgressActivity extends AppCompatActivity {

    private ListView listasDePeriodos;
    private Periodo periodo;
    private ArrayAdapter<String> adapter;
    private String curso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        periodo = new Periodo();

        final Intent intent = getIntent();
        curso =  intent.getStringExtra("MESSAGE");
        TextView course = (TextView) findViewById(R.id.course);
        course.setText(curso);

        //Teste de back button
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        listasDePeriodos = (ListView) findViewById(R.id.listaPeriodo);

        Resources res = getResources();
        TypedArray ta = res.obtainTypedArray(R.array.map);
        int n = ta.length();
        String[][] array = new String[n][];
        for (int i = 0; i < n; ++i) {
            int id = ta.getResourceId(i, 0);
            if (id > 0) {
                array[i] = res.getStringArray(id);
            } else {
                // something wrong with the XML
            }
        }
        ta.recycle(); // Important!
        final HashMap<String,List<String>> mapa_curso = new HashMap<>();
        for (int i = 0; i < array[0].length; i++){
            List<String> lista = new ArrayList<>();
            lista.add(0,array[1][i]);
            lista.add(1,array[2][i]);
            mapa_curso.put(array[0][i],lista);
        }

        //Log.i("Curso ", String.valueOf(mapa_curso.get(curso).get(1)));

        final List<String> periodos = new ArrayList<>();
        //Log.i("periodos ", String.valueOf(mapa_cursos.get("Arquitetura").get(0)));
        for (int i = 1; i<=Integer.parseInt(String.valueOf(mapa_curso.get(curso).get(0))); i++) {
            periodos.add(i + "º periodo");
        }

        Button grade = (Button) findViewById(R.id.grade);
        grade.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgressActivity.this, GradeActivity.class);
                ArrayList<String> message = new ArrayList<>();
                message.add(curso);
                message.addAll(periodos);
                intent.putExtra("MESSAGE", message);
                Log.i("koe",curso);
                /**
                 * Animação de transição entre activitys
                 */
                ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(ProgressActivity.this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(ProgressActivity.this,intent,opts.toBundle());
            }
        });

        adapter = new ArrayAdapter<String>(this,R.layout.listperiodo, periodos);

        listasDePeriodos.setAdapter(adapter);

        listasDePeriodos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String periodoSelecionado = (String) adapter.getItem(position);
                Toast.makeText(ProgressActivity.this,periodoSelecionado,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ProgressActivity.this, PeriodoActivity.class);
                String periodo = String.valueOf(periodoSelecionado);
                ArrayList<String> message = new ArrayList<>();

                message.add(mapa_curso.get(curso).get(1));
                message.add(periodo);
                message.add(curso);
                intent.putExtra("MESSAGE", message);
                /**
                 * Animação de transição entre activitys
                 */
                ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(ProgressActivity.this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(ProgressActivity.this,intent,opts.toBundle());
                //ProgressActivity.this.startActivity(intent);
            }
        });

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
