package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

//import com.devmob.minhagrade.Lixo.Cursos;

import com.devmob.minhagrade.Adapter.CursoAdapter;
import com.devmob.minhagrade.DB.CienciaDaComputação;
import com.devmob.minhagrade.Model.Curso;
import com.devmob.minhagrade.Model.Prefs;

public class CourseActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    private Button btnSubmit;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        addItemsOnSpinner();
        addListenerOnButton();
        String course = Prefs.getString(this,"course");//"No name defined" is the default value.
//        Log.d("CURSO", course);
        if(!course.isEmpty()){
            Intent intent = new Intent(CourseActivity.this, HomeActivity.class);
            intent.putExtra("MESSAGE", course);
            startActivity(intent);
        }
    }

    // add items into spinner dynamically
    public void addItemsOnSpinner() {
        //Cursos courses = new Cursos();

        spinner = (Spinner) findViewById(R.id.spinner);
        CursoAdapter cursoAdapter = new CursoAdapter(getApplicationContext(),Curso.getCursos(getApplicationContext()));

        spinner.setAdapter(cursoAdapter);
    }

    // get the selected dropdown list value
    public void addListenerOnButton() {

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(CourseActivity.this, HomeActivity.class);
        String message = String.valueOf(spinner.getSelectedItem());
        CienciaDaComputação cc = new CienciaDaComputação(this);
        cc.populaCurso();
        Prefs.setString(this,"course", message);
        intent.putExtra("MESSAGE", message);
        /**
         * Animação de transição entre activitys
         */
        ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(CourseActivity.this,R.anim.slide_in_left,R.anim.slide_out_left);
        ActivityCompat.startActivity(CourseActivity.this,intent,opts.toBundle());

    }
}