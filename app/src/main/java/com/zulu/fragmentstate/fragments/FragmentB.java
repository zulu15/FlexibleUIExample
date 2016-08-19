package com.zulu.fragmentstate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zulu.fragmentstate.R;


public class FragmentB extends Fragment {

    private TextView txtResultado;
    private String data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_b, container, false);
        txtResultado = (TextView) v.findViewById(R.id.txt_description);

        return v;
    }


    public void changeData(int index){
        String[] descripciones = getResources().getStringArray(R.array.descriptions);
        txtResultado.setText(descripciones[index]);

    }
}

