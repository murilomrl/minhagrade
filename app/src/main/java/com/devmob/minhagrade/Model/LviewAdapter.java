package com.devmob.minhagrade.Model;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.devmob.minhagrade.R;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by murilo on 28/05/17.
 */

public class LviewAdapter extends ArrayAdapter<String>{
    Set<String> setDisc= new HashSet<>();
    public LviewAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull String[] objects) {
        super(context, resource, objects);
    }

    public void setSetDisc(Set<String> setDisc, String[] disciplinas){
        this.setDisc=setDisc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        return view;
    }
}
