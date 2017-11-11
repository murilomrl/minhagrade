package com.devmob.minhagrade;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

//import com.devmob.minhagrade.Lixo.Periodo;

import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.devmob.minhagrade.Model.Prefs;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.charts.ScatterChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;

import java.util.ArrayList;

/**
 * Created by devmob on 27/03/17.
 */

@SuppressLint("SetJavaScriptEnabled")

public class ProgressActivity extends AppCompatActivity implements View.OnClickListener {

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
        Button button = (Button) findViewById(R.id.chartsButton);

        button.setOnClickListener(this);
        course.setText(curso);

        porcentagemConcluido = (TextView) findViewById(R.id.porcentagemConcluido);
        porcentagemCursando = (TextView) findViewById(R.id.porcentagemCursando);
        porcentagemFaltando = (TextView) findViewById(R.id.porcentagemFaltam);

        porcentagemConcluido.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(2));
        porcentagemCursando.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(1));
        porcentagemFaltando.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(0));


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, ChartActivity.class);
        ActivityOptionsCompat opts = ActivityOptionsCompat.makeCustomAnimation(this,R.anim.slide_in_left,R.anim.slide_out_left);
        ActivityCompat.startActivity(this,intent,opts.toBundle());
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
