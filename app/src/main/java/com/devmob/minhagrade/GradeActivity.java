package com.devmob.minhagrade;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.devmob.minhagrade.Model.LviewAdapter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.devmob.minhagrade.CourseActivity.MY_PREFS_NAME;

/**
 * Created by murilo on 29/06/17.
 */

public class GradeActivity extends AppCompatActivity {
    private ListView listasDeDisciplinas;
    private TableLayout[] tabelaDeDisciplinas;
    private LviewAdapter adapter;
    private String[] arrayLV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Intent intent = getIntent();
        final ArrayList<String> value = intent.getStringArrayListExtra("MESSAGE");

        Set<String> setDisc = new HashSet<>();
        //String[] setGrade = new String[100];
        List<String> setGrade = new ArrayList<>();
        //setGrade[0] = "Não há disciplinas.";
        SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        int i,k;
        int j = 0;
        for (i = 1; i < value.size(); i++) {
            Log.i("gradeAct", value.get(0).toString() + "periodo" + value.get(i).toString());
            if (prefs.contains(value.get(0).toString() + "periodo" + value.get(i).toString())) {
                setDisc = prefs.getStringSet(value.get(0).toString() + "periodo" + value.get(i).toString(), new HashSet<String>());
                Log.i("aqui", String.valueOf(setDisc.isEmpty()));
                Object[] arrayDisc = setDisc.toArray();
                for(k=0;k<arrayDisc.length;k++) {
                    setGrade.add(String.valueOf(arrayDisc[k]));
                    //Log.i("to aqui",setGrade[j]);
                    j++;
                }
            } else {
                Log.i("DeuRuim", "nada");
            }
        }
        Object[] gradeArray = setGrade.toArray();
        arrayLV= new String[gradeArray.length];
        for(i=0;i<gradeArray.length;i++){
            arrayLV[i]= gradeArray[i].toString();
            Log.i("disc", arrayLV[i]);
        }
        Log.i("size", String.valueOf(gradeArray.length));
        int orientacao = this.getResources().getConfiguration().orientation;
        if(orientacao == Configuration.ORIENTATION_LANDSCAPE) {

        }else{
            adapter = new LviewAdapter(this, R.layout.listdisciplina, arrayLV);
            listasDeDisciplinas = (ListView) findViewById(R.id.gradeSem);
            listasDeDisciplinas.setSaveEnabled(false);
            listasDeDisciplinas.setAdapter(adapter);
        }
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientacao = this.getResources().getConfiguration().orientation;
        if(orientacao == Configuration.ORIENTATION_LANDSCAPE) {

        }else{
            adapter = new LviewAdapter(this, R.layout.listdisciplina, arrayLV);
            listasDeDisciplinas = (ListView) findViewById(R.id.gradeSem);
            listasDeDisciplinas.setSaveEnabled(false);
            listasDeDisciplinas.setAdapter(adapter);
        }
    }
}
