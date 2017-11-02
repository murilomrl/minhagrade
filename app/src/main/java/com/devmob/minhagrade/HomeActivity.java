package com.devmob.minhagrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imageButtonMinhaGrade;
    ImageButton imageButtonPeriodos;
    ImageButton imageButtonProgresso;
    ImageButton imageButtonDisciplinas;
    ImageButton imageButtonCalendario;
    ImageButton imageButtonApagar;


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

        imageButtonCalendario = (ImageButton) findViewById(R.id.disciplinas);
        imageButtonDisciplinas.setOnClickListener(this);

        imageButtonApagar = (ImageButton) findViewById(R.id.apagarDados);
        imageButtonApagar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.minhaGrade:
                Toast.makeText(this, "Minha Grade",Toast.LENGTH_SHORT).show();
                break;
            case R.id.periodos:
                Toast.makeText(this, "Periodos",Toast.LENGTH_SHORT).show();
                break;
            case R.id.progresso:
                Toast.makeText(this, "Progresso",Toast.LENGTH_SHORT).show();
                break;
            case R.id.disciplinas:
                Toast.makeText(this, "Disciplinas",Toast.LENGTH_SHORT).show();
                break;
            case R.id.calendario:
                Toast.makeText(this, "Calendario",Toast.LENGTH_SHORT).show();
                break;
            case R.id.apagarDados:
                Toast.makeText(this, "Apagar",Toast.LENGTH_SHORT).show();
                break;
        }

    }
}
