package com.devmob.minhagrade;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.content.res.TypedArray;
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

import com.devmob.minhagrade.Model.LviewAdapter;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static com.devmob.minhagrade.CourseActivity.MY_PREFS_NAME;

public class PeriodoActivity extends AppCompatActivity {

    private ListView listasDeDisciplinas;
    private LviewAdapter adapter;
    String[] disciplinas = new String[0];
    Set<String> setDisc = new HashSet<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_periodo);

        Intent intent = getIntent();
        final ArrayList<String> value =  intent.getStringArrayListExtra("MESSAGE");
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

        // Lista de Disciplinas que é exibido
        disciplinas = array[Integer.parseInt(String.valueOf(indice.charAt(0)))-1];
        Log.d("Disciplinas","Dis: "+ Arrays.toString(disciplinas));
        adapter = new LviewAdapter(this, R.layout.listdisciplina, disciplinas);
        adapter.setSetDisc(setDisc,disciplinas);
        listasDeDisciplinas.setAdapter(adapter);
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        setDisc = prefs.getStringSet(value.get(2).toString()+"periodo"+value.get(1).toString(), new HashSet<String>());//"No name defined" is the default value.
        Log.i("setDisc", String.valueOf(setDisc.isEmpty()));
        //Log.d("PREF_COURSE",);
        listasDeDisciplinas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                view.setBackgroundResource(R.color.colorFeito);
                SharedPreferences.Editor editor = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
                if(!setDisc.contains(disciplinas[position]))
                    setDisc.add(disciplinas[position]);
                Log.i("clicado", String.valueOf(setDisc.isEmpty()));
                editor.putStringSet(value.get(2).toString()+"periodo"+value.get(1).toString(), setDisc);
                Log.i("periodoact",value.get(2).toString()+"periodo"+value.get(1).toString());
                editor.apply();
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
