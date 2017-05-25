package com.devmob.minhagrade;

import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
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

        Resources res = getResources();
        String[][] array = new String[0][];
        try {
            Field field = R.array.class.getField(value.get(0));
            TypedArray ta = res.obtainTypedArray(field.getInt(null));
            int n = ta.length();
            array = new String[n][];
            for (int i = 0; i < n; ++i) {
                int id = ta.getResourceId(i, 0);
                if (id > 0) {
                    array[i] = res.getStringArray(id);
                } else {
                    // something wrong with the XML
                }
            }
            ta.recycle(); // Important!
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        String indice = value.get(1);
        //Log.i("array", array[Integer.parseInt(String.valueOf(indice.charAt(0)))][0]);
        adapter = new ArrayAdapter<String>(this, R.layout.listdisciplina, array[Integer.parseInt(String.valueOf(indice.charAt(0)))-1]);

        listasDeDisciplinas.setAdapter(adapter);
        listasDeDisciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundResource(R.color.colorFeito);

                //adapter.getItem(position);
                Toast.makeText(PeriodoActivity.this,"Fazendo",Toast.LENGTH_SHORT).show();
            }
        });

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
