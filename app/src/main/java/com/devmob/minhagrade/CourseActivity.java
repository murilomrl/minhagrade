package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

//import com.devmob.minhagrade.Lixo.Cursos;

import com.devmob.minhagrade.Adapter.CursoAdapter;
import com.devmob.minhagrade.Adapter.PeriodoAdapter;
import com.devmob.minhagrade.DB.CienciaDaComputação;
import com.devmob.minhagrade.Model.Curso;
import com.devmob.minhagrade.Model.Periodo;
import com.devmob.minhagrade.Model.Prefs;


public class CourseActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private Spinner periodoSpinner;
    private Button btnSubmit;
    private TextView naoAchouLink;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        spinner = (Spinner) findViewById(R.id.spinner);

        CursoAdapter cursoAdapter = new CursoAdapter(getApplicationContext(),Curso.getCursos(getApplicationContext()));

        PeriodoAdapter periodoAdapter = new PeriodoAdapter(this,Periodo.getPeriodos(this));

        spinner.setAdapter(cursoAdapter);

        naoAchouLink = (TextView) findViewById(R.id.naoAchouCurso);
        naoAchouLink.setClickable(true);
        naoAchouLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this, NovoCursoActivity.class);
                startActivity(intent);
            }
        });

        periodoSpinner = (Spinner) findViewById(R.id.periodo_spinner);

        periodoSpinner.setAdapter(periodoAdapter);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);

        String course = Prefs.getString(this,"course");//"No name defined" is the default value.
//        Log.d("CURSO", course);
        if(!course.isEmpty()){
            Intent intent = new Intent(CourseActivity.this, HomeActivity.class);
            intent.putExtra("MESSAGE", course);
            startActivity(intent);
        }
    }

    @Override
    public void onClick(View v) {
        btnSubmit.setClickable(false);
        Intent intent = new Intent(CourseActivity.this, HomeActivity.class);
        String course = String.valueOf(spinner.getSelectedItem());
        String periodo = String.valueOf(periodoSpinner.getSelectedItem());
        CienciaDaComputação cc = new CienciaDaComputação(this);
        cc.populaCurso();
        String[] periodoString = periodo.split("º");
        periodoString = periodoString[0].split(":");
        Log.d("Teste",periodo);
        Prefs.setString(this,"course", course);
        Prefs.setInteger(this,"periodo",Integer.parseInt(periodoString[1]));
        intent.putExtra("MESSAGE", course);
        /**
         * Animação de transição entre activitys
         */
        ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(CourseActivity.this,R.anim.slide_in_left,R.anim.slide_out_left);
        ActivityCompat.startActivity(CourseActivity.this,intent,opts.toBundle());

    }
}