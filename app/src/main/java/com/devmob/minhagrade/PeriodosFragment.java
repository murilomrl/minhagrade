package com.devmob.minhagrade;

import android.content.Intent;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.devmob.minhagrade.Adapter.PeriodoAdapter;
import com.devmob.minhagrade.DB.PeriodoDAO;
import com.devmob.minhagrade.Model.Periodo;
import com.devmob.minhagrade.Model.Prefs;

import java.util.ArrayList;
import java.util.List;

public class PeriodosFragment extends Fragment implements OnItemClickListener{

    private String curso;
    private PeriodoAdapter periodoArrayAdapter;
    private ListView listView;
    private List<Periodo> periodoList = new ArrayList<>();
    private PeriodoDAO periodoDAO;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        Cria a View que vai ser usada no Fragment
        View view = inflater.inflate(R.layout.fragment_periodos, container, false);

        periodoDAO = new PeriodoDAO(getActivity());

        curso =  Prefs.getString(getActivity(), "course");
        TextView course = (TextView) view.findViewById(R.id.course);
        listView = (ListView) view.findViewById(R.id.listaPeriodo);
        course.setText(curso);

        periodoList = periodoDAO.getPeriodos();
        listView.setAdapter(new PeriodoAdapter(getActivity(),periodoList));
        listView.setOnItemClickListener(this);

//        Retorna a view para a activity
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Periodo periodo = this.periodoList.get(position);
//        Log.d("Clickado",periodo.getNome());
        Intent intent = new Intent(getActivity(),PeriodoActivity.class);
        intent.putExtra("PERIODO", periodo.getNome());
        ActivityOptionsCompat opts =  ActivityOptionsCompat.makeCustomAnimation(getActivity(),R.anim.slide_in_left,R.anim.slide_out_left);
        ActivityCompat.startActivity(getActivity(),intent,opts.toBundle());
    }
}
