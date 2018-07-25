package com.devmob.minhagrade;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.devmob.minhagrade.Adapter.DisciplinasAdapter;
import com.devmob.minhagrade.DB.DisciplinaDAO;
import com.devmob.minhagrade.Model.Disciplina;
import com.devmob.minhagrade.Model.Prefs;


import java.util.List;

public class DisciplinasFragment extends Fragment implements OnItemClickListener {

    private String curso;
    private List<Disciplina> disciplinaList;
    private ListView listView;
    private TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        Cria a View que vai ser usada no Fragment
        View view =  inflater.inflate(R.layout.fragment_disciplinas, container, false);

//        Trecho do código antigo que fazia a lista de disciplinas
        textView = (TextView) view.findViewById(R.id.course);

        curso = Prefs.getString(getActivity(),"course");
        textView.setText("Disciplinas do curso de "+curso);

        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(getActivity());
        disciplinaList = disciplinaDAO.getDisciplinas();
        listView = (ListView) view.findViewById(R.id.listaDisciplinas);
        listView.setAdapter(new DisciplinasAdapter(disciplinaList,getActivity(),0));

        listView.setOnItemClickListener(this);

//        Retorna a view para a activity
        return view;
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

        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(getActivity());
        disciplinaDAO.atualiza(disciplina);
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
    }
}
