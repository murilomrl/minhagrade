package com.devmob.minhagrade;
//
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TableRow;
//
import com.devmob.minhagrade.Adapter.DisciplinasAdapter;
import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.Model.LviewAdapter;
//
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import static com.devmob.minhagrade.Prefs.MY_PREFS_NAME;

///**
// * Created by murilo on 29/06/17.


public class GradeActivity extends AppCompatActivity {

    private ListView listViewDeDisciplinas;
    private ArrayList<Disciplina> disciplinas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Intent intent = getIntent();
        final ArrayList<String> value = intent.getStringArrayListExtra("MESSAGE");

        int orientacao = this.getResources().getConfiguration().orientation;
        if(orientacao == Configuration.ORIENTATION_LANDSCAPE) {

        }else{
            Log.i("oi","0");
            // Instancia a ListView
            listViewDeDisciplinas = (ListView) findViewById(R.id.gradeSem);
            Log.i("oi","a");
            // Popula a Lista de disciplinas apartir do Model de Disciplinas
            disciplinas = Disciplina.getDisciplinasGrade(value,this);
            Log.i("oi",disciplinas.get(0).getNome());
            // Usa DisciplinasAdapter para carregar as disciplinas
            listViewDeDisciplinas.setAdapter(new DisciplinasAdapter(disciplinas,this));
            Log.i("oi","c");
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
        }
    }
}
