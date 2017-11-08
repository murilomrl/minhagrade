package com.devmob.minhagrade;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.devmob.minhagrade.DB.PeriodoDAO;
import com.devmob.minhagrade.Model.Prefs;

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

        imageButtonCalendario = (ImageButton) findViewById(R.id.calendario);
        imageButtonCalendario.setOnClickListener(this);

        imageButtonApagar = (ImageButton) findViewById(R.id.apagarDados);
        imageButtonApagar.setOnClickListener(this);
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
                Toast.makeText(this, "Em Breve",Toast.LENGTH_SHORT).show();
                Log.d("Calendario","oooooooi");
                break;
            case R.id.apagarDados:
                apagarDados();
                break;
        }

    }

    private void apagarDados(){
        final PeriodoDAO periodoDAO = new PeriodoDAO(this);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle("Confirmação");
        builder.setMessage("Você tem certeza que quer apagar os dados da sua grade?");
        builder.setPositiveButton("Sim",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        periodoDAO.apagaTudo();
                        Prefs.clear(HomeActivity.this);
                        HomeActivity.this.finish();
                        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);
                    }
                });
        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onBackPressed(){
        this.finishAffinity();
    }
}
