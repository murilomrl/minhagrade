package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imageButtonMinhaGrade;
    ImageButton imageButtonPeriodos;
    ImageButton imageButtonProgresso;
    ImageButton imageButtonDisciplinas;
    ImageButton imageButtonCalendario;
    ImageButton imageButtonConfiguracoes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        imageButtonMinhaGrade = (ImageButton) findViewById(R.id.minhaGrade);
        imageButtonMinhaGrade.setOnClickListener(this);

        imageButtonPeriodos = (ImageButton) findViewById(R.id.periodos);
        imageButtonPeriodos.setOnClickListener(this);

        imageButtonProgresso = (ImageButton) findViewById(R.id.progresso);
        imageButtonProgresso.setOnClickListener(this);

        imageButtonDisciplinas = (ImageButton) findViewById(R.id.disciplinas);
        imageButtonDisciplinas.setOnClickListener(this);

        imageButtonCalendario = (ImageButton) findViewById(R.id.calendario);
        imageButtonCalendario.setOnClickListener(this);

        imageButtonConfiguracoes = (ImageButton) findViewById(R.id.configuracoes);
        imageButtonConfiguracoes.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent;
        ActivityOptionsCompat opts;
        switch (v.getId()){
            case R.id.minhaGrade:
                intent = new Intent(this, GradeActivity.class);
                opts =  ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(this,intent,opts.toBundle());
                break;
            case R.id.periodos:
                intent = new Intent(this, TodosOsPeriodosActivity.class);
                opts =  ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(this,intent,opts.toBundle());
                break;
            case R.id.progresso:
                intent = new Intent(this, ProgressActivity.class);
                opts =  ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(this,intent,opts.toBundle());
                break;
            case R.id.disciplinas:
                intent = new Intent(this, DisciplinasActivity.class);
                opts = ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(this,intent,opts.toBundle());
                break;
            case R.id.calendario:
                intent = new Intent(this, CalendarActivity.class);
                opts = ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(this,intent,opts.toBundle());
                break;
            case R.id.configuracoes:
                intent = new Intent(this, SettingsActivity.class);
                opts = ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(this,intent,opts.toBundle());
                break;
        }

    }

    @Override
    public void onBackPressed(){
        this.finishAffinity();
    }


}
