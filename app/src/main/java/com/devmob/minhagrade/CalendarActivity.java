package com.devmob.minhagrade;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import com.devmob.minhagrade.Adapter.LembreteAdapter;
import com.devmob.minhagrade.DB.LembreteDAO;
import com.devmob.minhagrade.Model.Lembrete;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CalendarActivity extends AppCompatActivity implements View.OnClickListener {
    private final LembreteDAO lembreteDAO= new LembreteDAO(this);
    private Lembrete lembrete;
    private List<Lembrete> lembretes;
    private CalendarView calendarView;
    private EditText textoView;
    private EditText tipoView;
    private EditText disciplinaView;
    private RecyclerView lembretesRecyclerView;
    private LembreteAdapter lembreteAdapter;
    private Button btnCriarLembrete;
    private Button btnVerLembrete;
    private Button btnFecharLembrete;
    private Button btnCancelarLembrete;
    private Button btnSubmit;
    private String texto;
    private String tipo;
    private int dia;
    private int mes;
    private int ano;
    private String disciplina;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        calendarView = (CalendarView) findViewById(R.id.calendarView);
        btnCriarLembrete = (Button) findViewById(R.id.btnCriarLembreteCalendar);
        textoView = (EditText) findViewById(R.id.texto);
        tipoView = (EditText) findViewById(R.id.tipo);
        disciplinaView = (EditText) findViewById(R.id.disciplina);
        btnSubmit = (Button) findViewById(R.id.btnSubmitCalendar);
        btnVerLembrete = (Button) findViewById(R.id.btnVerLembreteCalendar);
        btnFecharLembrete = (Button) findViewById(R.id.btnFecharLembreteCalendar);
        btnCancelarLembrete = (Button) findViewById(R.id.btnCancelCalendar);
        lembretesRecyclerView = (RecyclerView) findViewById(R.id.recyclerViewLembrete);
        lembretesRecyclerView.setHasFixedSize(true);
        lembretes = new ArrayList<>();
        lembreteAdapter = new LembreteAdapter(this,lembretes);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        lembretesRecyclerView.setLayoutManager(layoutManager);
        lembretesRecyclerView.setAdapter(lembreteAdapter);
        btnSubmit.setOnClickListener(this);
        btnCriarLembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.setVisibility(View.INVISIBLE);
                btnCancelarLembrete.setVisibility(View.VISIBLE);
                btnVerLembrete.setVisibility(View.INVISIBLE);
                textoView.setVisibility(View.VISIBLE);
                tipoView.setVisibility(View.VISIBLE);
                disciplinaView.setVisibility(View.VISIBLE);
                btnSubmit.setVisibility(View.VISIBLE);
            }
        });
        btnVerLembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //pega o long retornado pelo getDate e transforma para nosso formato
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String selectedDate = sdf.format(new Date(calendarView.getDate()));
                //Toast.makeText(getApplicationContext(),selectedDate,Toast.LENGTH_SHORT).show();
                dia = Integer.parseInt(selectedDate.substring(0,2));
                mes = Integer.parseInt(selectedDate.substring(3,5));
                ano = Integer.parseInt(selectedDate.substring(6,10));
                //Toast.makeText(getApplicationContext(),"data: "+dia+","+mes+","+ano,Toast.LENGTH_SHORT).show();
                List<Lembrete> lembretesData = lembreteDAO.getLembretePorData(dia,mes,ano);
                lembretes.clear();
                lembretes.addAll(lembretesData);
                lembreteAdapter.notifyDataSetChanged();
                Toast.makeText(getApplicationContext(),"Texto: "+lembretes.get(0).getTexto(),Toast.LENGTH_SHORT).show();
                v.setVisibility(View.INVISIBLE);
                btnCriarLembrete.setVisibility(View.INVISIBLE);
                lembretesRecyclerView.setVisibility(View.VISIBLE);
                btnFecharLembrete.setVisibility(View.VISIBLE);
            }
        });
        btnFecharLembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lembretesRecyclerView.setVisibility(View.INVISIBLE);
                v.setVisibility(View.INVISIBLE);
                btnCriarLembrete.setVisibility(View.VISIBLE);
                btnVerLembrete.setVisibility(View.VISIBLE);
            }
        });
        btnCancelarLembrete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnSubmit.setVisibility(View.INVISIBLE);
                v.setVisibility(View.INVISIBLE);
                textoView.setVisibility(View.INVISIBLE);
                tipoView.setVisibility(View.INVISIBLE);
                disciplinaView.setVisibility(View.INVISIBLE);
                btnCriarLembrete.setVisibility(View.VISIBLE);
                btnVerLembrete.setVisibility(View.VISIBLE);
                textoView.setHint(R.string.lembrete_texto);
                tipoView.setHint(R.string.lembrete_tipo);
                disciplinaView.setHint(R.string.lembrete_disciplina);
            }
        });
        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int year, int month, int day) {
                //Converte a data pra long pra poder usar o setDate
                Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                long milliTime = calendar.getTimeInMillis();

                calendarView.setDate(milliTime);
            }
        });
    }


    @Override
    public void onClick(View v) {
        //pega o long retornado pelo getDate e transforma para nosso formato
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String selectedDate = sdf.format(new Date(calendarView.getDate()));
        //Toast.makeText(getApplicationContext(),selectedDate,Toast.LENGTH_SHORT).show();
        dia = Integer.parseInt(selectedDate.substring(0,2));
        mes = Integer.parseInt(selectedDate.substring(3,5));
        ano = Integer.parseInt(selectedDate.substring(6,10));
        //Toast.makeText(getApplicationContext(),"data: "+dia+","+mes+","+ano,Toast.LENGTH_SHORT).show()
        texto = String.valueOf(textoView.getText());
        tipo = String.valueOf(tipoView.getText());
        disciplina = String.valueOf(disciplinaView.getText());
        lembrete = new Lembrete(texto, tipo, dia, mes, ano, disciplina);
        int valida = lembreteDAO.insere(lembrete);
        if(valida==1){
            Toast.makeText(getApplicationContext(),"Lembrete inserido com sucesso!",Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getApplicationContext(),"Erro ao inserir lembrete, Texto e/ou Tipo não inseridos!",Toast.LENGTH_LONG).show();
        }
        v.setVisibility(View.INVISIBLE);
        textoView.setVisibility(View.INVISIBLE);
        tipoView.setVisibility(View.INVISIBLE);
        disciplinaView.setVisibility(View.INVISIBLE);
        btnCriarLembrete.setVisibility(View.VISIBLE);
        btnVerLembrete.setVisibility(View.VISIBLE);
        textoView.setHint(R.string.lembrete_texto);
        tipoView.setHint(R.string.lembrete_tipo);
        disciplinaView.setHint(R.string.lembrete_disciplina);
    }
}
