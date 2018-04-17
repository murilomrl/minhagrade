package com.devmob.minhagrade;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;

/**
 * Created by devmob on 27/03/17.
 */

@SuppressLint("SetJavaScriptEnabled")

public class ProgressActivity extends AppCompatActivity {

    private String curso;
    private TextView porcentagemConcluido;
    private TextView porcentagemCursando;
    private TextView porcentagemFaltando;
    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO(this);
    private int dadoConcluido, dadoCursando, dadoFaltando;

    PieChart pieChart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        final Intent intent = getIntent();
        curso =  Prefs.getString(this,"course");
        TextView course = (TextView) findViewById(R.id.course);

        course.setText(curso);

        getSupportActionBar().setTitle("Progresso");


        dadoConcluido = disciplinaDAO.quantidadeDisciplinasPorStatus(2);
        dadoCursando = disciplinaDAO.quantidadeDisciplinasPorStatus(1);
        dadoFaltando = disciplinaDAO.quantidadeDisciplinasPorStatus(0);

        porcentagemConcluido = (TextView) findViewById(R.id.porcentagemConcluido);
        porcentagemCursando = (TextView) findViewById(R.id.porcentagemCursando);
        porcentagemFaltando = (TextView) findViewById(R.id.porcentagemFaltam);

        porcentagemConcluido.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(2));
        porcentagemCursando.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(1));
        porcentagemFaltando.setText(disciplinaDAO.porcentagemDeDisciplinasPorStatus(0));

        pieChart();

    }

    private void pieChart(){
       pieChart = (PieChart) findViewById(R.id.piechart);

        ArrayList<PieEntry> entries  = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();

        if(dadoConcluido!=0) {
            entries.add(new PieEntry(disciplinaDAO.porcentagemDeDisciplinasPorStatusDouble(2), "Concluido", 0));
            colors.add(getResources().getColor(R.color.colorPieFeito));
        }
        if(dadoCursando!=0) {
            entries.add(new PieEntry(disciplinaDAO.porcentagemDeDisciplinasPorStatusDouble(1), "Cursando", 1));
            colors.add(getResources().getColor(R.color.colorPieFazendo));
        }
        if(dadoFaltando!=0) {
            entries.add(new PieEntry(disciplinaDAO.porcentagemDeDisciplinasPorStatusDouble(0), "Pendente", 2));
            colors.add(getResources().getColor(R.color.colorPieNaoFeito));
        }

        PieDataSet dataSet = new PieDataSet(entries,"");
        dataSet.setColors(colors);
        dataSet.setSliceSpace(2);
        dataSet.setValueTextSize(13);
        dataSet.setValueFormatter(new PercentFormatter());
//        dataSet.setValueTypeface(Typeface.defaultFromStyle(Typeface.BOLD));

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.setDrawHoleEnabled(false);
        pieChart.invalidate();
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setRotationEnabled(false);
        pieChart.getDescription().setEnabled(false);
        pieChart.setTouchEnabled(false);
//        pieChart.setDrawEntryLabels(false);
//        pieChart.setEntryLabelTypeface(Typeface.defaultFromStyle(Typeface.BOLD));
        pieChart.getLegend().setEnabled(false);

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
