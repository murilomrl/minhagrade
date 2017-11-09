package com.devmob.minhagrade;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.devmob.minhagrade.Adapter.DisciplinasAdapter;
import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.devmob.minhagrade.Model.Disciplina;
import java.util.ArrayList;
import java.util.List;

///**
// * Created by murilo on 29/06/17.


public class GradeActivity extends AppCompatActivity implements View.OnClickListener{

    static final int REQUEST_CODE = 41324;
    private ListView listViewDeDisciplinas;
    private List<Disciplina> disciplinas;
    private ListView listViewAdd;
    private List<Disciplina> disciplinasPendentes;
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO(this);
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Intent intent = getIntent();
        final ArrayList<String> value = intent.getStringArrayListExtra("MESSAGE");

        FloatingActionButton add = (FloatingActionButton) findViewById(R.id.addDisc);
        listViewDeDisciplinas = (ListView) findViewById(R.id.gradeSem);

        disciplinas = disciplinaDAO.getDisciplinasPorStatus(1);

        listViewDeDisciplinas.setAdapter(new DisciplinasAdapter(disciplinas,this,1));

        add.setOnClickListener(this);

    }

    // Metodo pra atualizar a grade assim que a activity que adiciona disciplinas terminar
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE) {
            finish();
            startActivity(getIntent());
        }
    }

    @Override
    public void onClick(View v) {
        LayoutInflater inflater = getLayoutInflater();
        final View alertLayout = inflater.inflate(R.layout.activity_discadd,null);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        alertDialog = builder.create();

        Button button = (Button) alertLayout.findViewById(R.id.concAddDisc);
        ListView listView = (ListView) alertLayout.findViewById(R.id.discToAdd);

        disciplinasPendentes = disciplinaDAO.getDisciplinasPorStatus(0);

        final DisciplinasAdapter disciplinasAdapter = new DisciplinasAdapter(disciplinasPendentes,this,99);


        listView.setAdapter(disciplinasAdapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Disciplina> disciplinas = disciplinasAdapter.getMinhaGrade();

                disciplinaDAO.atualizaDisciplinas(disciplinas);
                alertDialog.dismiss();
                GradeActivity.this.finish();
                GradeActivity.this.startActivity(GradeActivity.this.getIntent());
            }
        });

        alertDialog.setView(alertLayout);

        alertDialog.show();
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

}
