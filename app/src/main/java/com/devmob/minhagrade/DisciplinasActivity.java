package com.devmob.minhagrade;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.devmob.minhagrade.Adapter.DisciplinasAdapter;
import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.devmob.minhagrade.Model.Disciplina;

import java.util.List;

public class DisciplinasActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private DisciplinaDAO disciplinaDAO = new DisciplinaDAO(this);
    private List<Disciplina> disciplinaList;
    private ListView listView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disciplinas);
        textView = (TextView) findViewById(R.id.course);
        textView.setText(Prefs.getString(this,"course"));
        disciplinaList = disciplinaDAO.getDisciplinas();
        listView = (ListView) findViewById(R.id.listaDisciplinas);
        listView.setAdapter(new DisciplinasAdapter(disciplinaList,this,0));

        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Instancia a disciplina de acordo com a posição
        Disciplina disciplina = disciplinaList.get(position);

        //Instancia o status da disciplina que foi clicada
        int status = disciplina.getStatus();

        // Cria um ciclo de cliques para apenas 3 status possivel, ver os status no model Disciplina
        status = (status+1)%3;

        // Atualiza o status da disciplina
        disciplina.setStatus(status);

        //Salva dados
//        Prefs.setInteger(this,disciplina.getNome(),status);

        TextView statusDisciplina = (TextView) view.findViewById(R.id.statusDisciplina);

        // Pinta o ITEM da ListView de acordo com o status
        if (status == 2){
//            Prefs.setInteger(this,"Concluido",Prefs.getInt(this,"Concluido")+1);
            view.setBackgroundColor(this.getResources().getColor(R.color.colorFeito));
            statusDisciplina.setText("Concluido");
        }
        else if (status == 1){
            view.setBackgroundColor(this.getResources().getColor(R.color.colorFazendo));
            statusDisciplina.setText("Cursando");
        }
        else{
//            Prefs.setInteger(this,"Concluido",Prefs.getInt(this,"Concluido")-1);
            statusDisciplina.setText("Pendente");
            view.setBackgroundColor(this.getResources().getColor(R.color.colorNaoFeito));
        }
//        Log.i("Concluido", String.valueOf(Prefs.getInt(this,"Concluido")));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // app icon in action bar clicked; goto parent activity.
                disciplinaDAO.atualizaDisciplinas(disciplinaList);
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
        disciplinaDAO.atualizaDisciplinas(disciplinaList);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_right);

    }
}
