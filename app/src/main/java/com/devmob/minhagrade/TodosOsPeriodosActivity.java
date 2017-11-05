package com.devmob.minhagrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.devmob.minhagrade.Adapter.PeriodoAdapter;
import com.devmob.minhagrade.DB.PeriodoDAO;
import com.devmob.minhagrade.Model.Periodo;

import java.util.ArrayList;
import java.util.List;

public class TodosOsPeriodosActivity extends AppCompatActivity {

    private String curso;
    private PeriodoAdapter periodoArrayAdapter;
    private ListView listView;
    private List<Periodo> periodoList = new ArrayList<>();
    private PeriodoDAO periodoDAO = new PeriodoDAO(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        final Intent intent = getIntent();
        curso =  Prefs.getString(this, "course");
        TextView course = (TextView) findViewById(R.id.course);
        listView = (ListView) findViewById(R.id.listaPeriodo);
        course.setText(curso);

        periodoList = periodoDAO.getPeriodos();
        listView.setAdapter(new PeriodoAdapter(this,periodoList));

    }
}
