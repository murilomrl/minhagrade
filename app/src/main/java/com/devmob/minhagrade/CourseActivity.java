package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

//import com.devmob.minhagrade.Lixo.Cursos;

import com.devmob.minhagrade.Adapter.CursoAdapter;
import com.devmob.minhagrade.Adapter.PeriodoAdapter;
import com.devmob.minhagrade.DB.CienciaDaComputação;
import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.devmob.minhagrade.DB.PeriodoDAO;
import com.devmob.minhagrade.Model.Curso;
import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.Model.Periodo;
import com.devmob.minhagrade.Model.Prefs;
import com.devmob.minhagrade.support.API;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class CourseActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private Spinner periodoSpinner;
    private Button btnSubmit;
    private TextView naoAchouLink;
    private CursoAdapter cursoAdapter;
    private AlertDialog dialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);
        spinner = (Spinner) findViewById(R.id.spinner);

        dialog = new AlertDialog.Builder(this)
                //.setIcon(loading)?
                .setTitle("Aguarde")
                .setMessage("Baixando lista de disciplinas...")
                .setCancelable(false)
                .create();
        dialog.show();

        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final API service = retrofit.create(API.class);
        Call<List<Curso>> call = service.getCourses();
        call.enqueue(new Callback<List<Curso>>() {
            @Override
            public void onResponse(Call<List<Curso>> call, Response<List<Curso>> response) {
                if(response.isSuccessful()) {
                    cursoAdapter = new CursoAdapter(CourseActivity.this, response.body());
                    spinner.setAdapter(cursoAdapter);
                    dialog.dismiss();
                } else {
                    dialog.setTitle("Erro");
                    dialog.setMessage("Problemas no servidor. Tente novamente mais tarde.");
                }
            }

            @Override
            public void onFailure(Call<List<Curso>> call, Throwable t) {
                dialog.setTitle("Erro");
                dialog.setMessage("Não foi possível conectar com o servidor. Tente novamente mais tarde.");
            }
        });

//        PeriodoAdapter periodoAdapter = new PeriodoAdapter(this,Periodo.getPeriodos(this));
//        final CursoAdapter cursoAdapter = new CursoAdapter(getApplicationContext(),Curso.getCursos(getApplicationContext()));
//
//        spinner.setAdapter(cursoAdapter);

        naoAchouLink = (TextView) findViewById(R.id.naoAchouCurso);
        naoAchouLink.setClickable(true);
        naoAchouLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CourseActivity.this, NovoCursoActivity.class);
                ActivityOptionsCompat opts;
                opts =  ActivityOptionsCompat.makeCustomAnimation(CourseActivity.this,R.anim.slide_in_left,R.anim.slide_out_left);
                ActivityCompat.startActivity(CourseActivity.this,intent,opts.toBundle());
            }
        });

//        periodoSpinner = (Spinner) findViewById(R.id.periodo_spinner);
//
//        periodoSpinner.setAdapter(periodoAdapter);

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
        if(spinner.getAdapter() != null && spinner.getAdapter().getCount() > 0) {
            btnSubmit.setClickable(false);
//            Intent intent = new Intent(CourseActivity.this, HomeActivity.class);
//            String course = String.valueOf(spinner.getSelectedItem());
//        String periodo = String.valueOf(periodoSpinner.getSelectedItem());
//        CienciaDaComputação cc = new CienciaDaComputação(this);
//        cc.populaCurso();
//        String[] periodoString = periodo.split("º");
//        periodoString = periodoString[0].split(":");
//        Log.d("Teste",periodo);
//        Prefs.setString(this,"course", course);
//        Prefs.setInteger(this,"periodo",Integer.parseInt(periodoString[1]));
//        intent.putExtra("MESSAGE", course);
//        /**
//         * Animação de transição entre activitys
//         */
//        ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(CourseActivity.this,R.anim.slide_in_left,R.anim.slide_out_left);
//        ActivityCompat.startActivity(CourseActivity.this,intent,opts.toBundle());

            final Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            final API service = retrofit.create(API.class);
            Call<Curso> call = service.getCourse(((Curso) spinner.getSelectedItem()).getId());
            call.enqueue(new Callback<Curso>() {
                @Override
                public void onResponse(Call<Curso> call, Response<Curso> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        populaCurso(response.body());
                    } else {
                        //erro
                        Log.e("Response Courseact", "Erro onResponse");
                    }
                }

                @Override
                public void onFailure(Call<Curso> call, Throwable t) {
                    Log.e("Failure Courseact", "Erro " + t.getLocalizedMessage());
                }
            });
        }
    }

    private void populaCurso(Curso curso){
        PeriodoDAO database = new PeriodoDAO(this);
        DisciplinaDAO databaseDisciplina = new DisciplinaDAO(this);
        List<Periodo> periodos;

        for (int i = 1; i <= curso.getPeriodos(); i++){
            Periodo periodo = new Periodo(i + "º período",curso.getNome());
            database.insere(periodo);
        }

        periodos = database.getPeriodos();

        for(Disciplina d : curso.getDisciplinas()){
            databaseDisciplina.insere(new Disciplina(d.getNome(),0, periodos.get(d.getPeriodo() - 1).getNome()));
        }

        Prefs.setString(this,"course", curso.getNome());
        btnSubmit.setClickable(true);

        Intent intent = new Intent(CourseActivity.this, HomeActivity.class);
        ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(CourseActivity.this, R.anim.slide_in_left, R.anim.slide_out_left);
        ActivityCompat.startActivity(CourseActivity.this, intent, opts.toBundle());

    }
}