package com.devmob.minhagrade;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.XShapeRenderer;

import java.util.ArrayList;

public class ChartActivity extends AppCompatActivity {

    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO(this);
    PieChart pieChart;

    private int dadoConcluido, dadoCursando, dadoFaltando;

    private CombinedChart combinedChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        dadoConcluido = disciplinaDAO.quantidadeDisciplinasPorStatus(2);
        dadoCursando = disciplinaDAO.quantidadeDisciplinasPorStatus(1);
        dadoFaltando = disciplinaDAO.quantidadeDisciplinasPorStatus(0);

//        pieChart();

        combinedChart = (CombinedChart) findViewById(R.id.chart);
        combinedChart.getDescription().setEnabled(false);
        combinedChart.setBackgroundColor(Color.WHITE);
        combinedChart.setDrawGridBackground(false);
        combinedChart.setDrawBarShadow(false);
        combinedChart.setHighlightFullBarEnabled(false);

        combinedChart.setDrawOrder( new CombinedChart.DrawOrder[]{
                CombinedChart.DrawOrder.SCATTER, CombinedChart.DrawOrder.LINE
        });

        CombinedData data = new CombinedData();

        data.setData(generateLineData());
        data.setData(generateScatterData());

        combinedChart.setData(data);
        combinedChart.invalidate();

    }

    private LineData generateLineData() {
        LineData data = new LineData();

        ArrayList<Entry> entries = new ArrayList<>();
        entries.add(new Entry(1,6));
        entries.add(new Entry(2,11));
        entries.add(new Entry(3,16));
        entries.add(new Entry(4,21));
        entries.add(new Entry(5,26));
        entries.add(new Entry(12,30));

        LineDataSet lineDataSet = new LineDataSet(entries,"Line");
        lineDataSet.setColor(Color.GREEN);
        lineDataSet.setLineWidth(2.5f);
        lineDataSet.setCircleColor(Color.GREEN);
        lineDataSet.setCircleRadius(5f);
        lineDataSet.setFillColor(Color.RED);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setDrawValues(true);
        lineDataSet.setValueTextSize(10f);
        lineDataSet.setValueTextColor(Color.GREEN);

        data.addDataSet(lineDataSet);
        return data;
    }

    private ScatterData generateScatterData() {
        ScatterData data = new ScatterData();

        ArrayList<Entry> entries =  new ArrayList<>();
        entries.add(new Entry(1,2));
        entries.add(new Entry(2,30));
        entries.add(new Entry(3,10));
        entries.add(new Entry(4,27));
        entries.add(new Entry(2,5));
        entries.add(new Entry(5,11));
        entries.add(new Entry(7,40));
        entries.add(new Entry(6,9));
        entries.add(new Entry(9,1));
        entries.add(new Entry(10,20));
        entries.add(new Entry(11,6));
        entries.add(new Entry(12,30));

        ScatterDataSet scatterDataSet = new ScatterDataSet(entries,"ScatterData");
        scatterDataSet.setColor(Color.RED);
        scatterDataSet.setShapeRenderer(new XShapeRenderer());
        scatterDataSet.setScatterShapeSize(50);
        scatterDataSet.setDrawValues(true);
        scatterDataSet.setValueTextSize(10f);
        data.addDataSet(scatterDataSet);
        return data;
    }

    private void pieChart(){
//        pieChart = (PieChart) findViewById(R.id.pieChart);

        ArrayList<PieEntry> entries  = new ArrayList<>();
        ArrayList<Integer> colors = new ArrayList<>();

        entries.add(new PieEntry(dadoConcluido,"Concluido",0));
        entries.add(new PieEntry(dadoCursando,"Cursando",1));
        entries.add(new PieEntry(dadoFaltando,"Pendente",2));

        colors.add(Color.GREEN);
        colors.add(Color.YELLOW);
        colors.add(Color.WHITE);

        PieDataSet dataSet = new PieDataSet(entries,"");
        dataSet.setColors(colors);
        dataSet.setSliceSpace(2);
        dataSet.setValueTextSize(12);

        PieData data = new PieData(dataSet);
        pieChart.setData(data);
        pieChart.setDrawHoleEnabled(false);
        pieChart.invalidate();
        pieChart.setEntryLabelColor(Color.BLACK);
        pieChart.setRotationEnabled(false);
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
