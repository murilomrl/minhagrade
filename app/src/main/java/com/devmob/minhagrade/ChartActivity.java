package com.devmob.minhagrade;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.devmob.minhagrade.DB.PeriodoDAO;
import com.devmob.minhagrade.Model.Service;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.ScatterData;
import com.github.mikephil.charting.data.ScatterDataSet;
import com.github.mikephil.charting.renderer.scatter.CircleShapeRenderer;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ChartActivity extends AppCompatActivity {

    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO(this);
    private PeriodoDAO periodoDAO = new PeriodoDAO(this);
    private int dadoConcluido, dadoCursando, dadoFaltando;

    private CombinedChart combinedChart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Service.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Service service = retrofit.create(Service.class);
        Call<ResponseBody> requestJSON = service.listBody();
        requestJSON.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(!response.isSuccessful()) {
                    Log.i("tag","erro: " + response.code());
                }
                else{
                    try {
                        String json;
                        json = response.body().string();

                        ArrayList<Entry> entries = this.JsonToEntries(json);

                        dadoConcluido = disciplinaDAO.quantidadeDisciplinasPorStatus(2);
                        dadoCursando = disciplinaDAO.quantidadeDisciplinasPorStatus(1);
                        dadoFaltando = disciplinaDAO.quantidadeDisciplinasPorStatus(0);

                        setTitle("DisciplinasXPeríodo");

                        combinedChart = (CombinedChart) findViewById(R.id.chart);
                        combinedChart.getDescription().setEnabled(false);
                        combinedChart.setBackgroundColor(Color.WHITE);
                        combinedChart.setDrawGridBackground(false);
                        combinedChart.setDrawBarShadow(false);
                        combinedChart.setHighlightFullBarEnabled(false);

                        combinedChart.setDrawOrder( new CombinedChart.DrawOrder[]{
                                CombinedChart.DrawOrder.LINE, CombinedChart.DrawOrder.SCATTER
                        });

                        CombinedData data = new CombinedData();
                        XAxis xAxis = combinedChart.getXAxis();

                        data.setData(generateLineData(entries));
                        data.setData(generateScatterData());

                        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

                        YAxis yAxisRight = combinedChart.getAxisRight();
                        yAxisRight.setDrawLabels(false);

                        combinedChart.setData(data);
                        combinedChart.invalidate();


                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            private ArrayList<Entry> JsonToEntries(String json){
                ArrayList<Entry> entries = new ArrayList<>();
                json = json.replace("{","");
                json = json.replace("}","");
                String[] stringPontos = json.split(",");

                Log.i("Json",json);
                for (int i = 0; i < stringPontos.length; i++) {
                    String[] s = stringPontos[i].split(":");
                    entries.add(new Entry(i, Float.parseFloat(s[1])));

                }

                return entries;
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("tag","erro: " + t.getMessage());
            }
        });


    }

    private LineData generateLineData(ArrayList<Entry> entries) {
        LineData data = new LineData();

        int disciplinasAcumuladas = 0;
//        ArrayList<Entry> entries = new ArrayList<>();
//
//        for (int i = 1; i <= periodoDAO.getPeriodos().size()+1;i++){
//            entries.add(new Entry(i,disciplinasAcumuladas));
//            disciplinasAcumuladas = disciplinasAcumuladas+disciplinaDAO.getDisciplinasPorPeriodo(i+"º período").size();
//
//        }


        LineDataSet lineDataSetDCC = new LineDataSet(entries,"DCC");
        lineDataSetDCC.setColor(Color.GREEN);
        lineDataSetDCC.setLineWidth(2.5f);
        lineDataSetDCC.setDrawCircles(false);

        lineDataSetDCC.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSetDCC.setDrawValues(true);
        lineDataSetDCC.setValueTextSize(10f);
        data.addDataSet(lineDataSetDCC);

        return data;
    }

    private ScatterData generateScatterData() {
        ScatterData data = new ScatterData();

        ArrayList<Entry> entries =  new ArrayList<>();
        entries.add(new Entry(15,disciplinaDAO.getDisciplinasPorStatus(2).size()));

        ScatterDataSet scatterDataSet = new ScatterDataSet(entries,"Você");
        scatterDataSet.setColor(Color.RED);
        scatterDataSet.setShapeRenderer(new CircleShapeRenderer());
        scatterDataSet.setScatterShapeSize(25);
        scatterDataSet.setDrawValues(true);
        scatterDataSet.setValueTextSize(10f);
        data.addDataSet(scatterDataSet);
        return data;
    }



//    private void pieChart(){
////        pieChart = (PieChart) findViewById(R.id.pieChart);
//
//        ArrayList<PieEntry> entries  = new ArrayList<>();
//        ArrayList<Integer> colors = new ArrayList<>();
//
//        entries.add(new PieEntry(dadoConcluido,"Concluido",0));
//        entries.add(new PieEntry(dadoCursando,"Cursando",1));
//        entries.add(new PieEntry(dadoFaltando,"Pendente",2));
//
//        colors.add(Color.GREEN);
//        colors.add(Color.YELLOW);
//        colors.add(Color.WHITE);
//
//        PieDataSet dataSet = new PieDataSet(entries,"");
//        dataSet.setColors(colors);
//        dataSet.setSliceSpace(2);
//        dataSet.setValueTextSize(12);
//
//        PieData data = new PieData(dataSet);
//        pieChart.setData(data);
//        pieChart.setDrawHoleEnabled(false);
//        pieChart.invalidate();
//        pieChart.setEntryLabelColor(Color.BLACK);
//        pieChart.setRotationEnabled(false);
//    }



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
