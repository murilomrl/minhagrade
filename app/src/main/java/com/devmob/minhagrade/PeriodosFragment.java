package com.devmob.minhagrade;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PeriodosFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

//        Cria a View que vai ser usada no Fragment
        View view = inflater.inflate(R.layout.fragment_periodos, container, false);


//        Retorna a view para a activity
        return view;
    }
}
