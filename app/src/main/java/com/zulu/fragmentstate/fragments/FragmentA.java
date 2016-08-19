package com.zulu.fragmentstate.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.zulu.fragmentstate.R;

public class FragmentA extends Fragment implements AdapterView.OnItemClickListener {


    private ListView listView;
    //Puente para comunicarnos con la actividad y esta a su vez con el fragmento B
    private Communicator comunicador;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        listView = (ListView) v.findViewById(R.id.list_view);
        ArrayAdapter adaptador = ArrayAdapter.createFromResource(getActivity(), R.array.titles, android.R.layout.simple_list_item_1);
        listView.setAdapter(adaptador);
        listView.setOnItemClickListener(this);
        return v;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Send index selected of title to MainActivity
        comunicador.respond(position);
    }


    public interface Communicator {
        public void respond(int index);
    }

    public void setComunicador(Communicator comunicador) {
        this.comunicador = comunicador;
    }
}
