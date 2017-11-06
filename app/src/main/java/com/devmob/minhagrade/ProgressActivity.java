package com.devmob.minhagrade;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import com.devmob.minhagrade.Lixo.Periodo;

import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.devmob.minhagrade.Model.Disciplina;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by devmob on 27/03/17.
 */

public class ProgressActivity extends AppCompatActivity {

    private String curso;
    private TextView porcentagemConcluido;
    private TextView porcentagemCursando;
    private TextView porcentagemFaltando;
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        final Intent intent = getIntent();
        curso =  Prefs.getString(this,"course");
        TextView course = (TextView) findViewById(R.id.course);
        course.setText(curso);

        porcentagemConcluido = (TextView) findViewById(R.id.porcentagemConcluido);
        porcentagemCursando = (TextView) findViewById(R.id.porcentagemCursando);
        porcentagemFaltando = (TextView) findViewById(R.id.porcentagemFaltam);

        porcentagemConcluido.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(2));
        porcentagemCursando.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(1));
        porcentagemFaltando.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(0));

    }


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
