package com.zulu.fragmentstate;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.zulu.fragmentstate.fragments.FragmentA;
import com.zulu.fragmentstate.fragments.FragmentB;


public class MainActivity extends AppCompatActivity implements FragmentA.Communicator {

    public static final String INDEX_KEY = "key";
    private FragmentA fragmentA;
    private FragmentB fragmentB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeVariables();
    }

    private void initializeVariables() {
        fragmentA = (FragmentA) getSupportFragmentManager().findFragmentById(R.id.first_fragment);
        fragmentA.setComunicador(this);
    }


    @Override
    public void respond(int index) {
        //Initialize fragmentB and chech if its in portrait or landscape mode
        fragmentB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.second_fragment);

        //Check if landscape mode is the current mode
        if(fragmentB!=null && fragmentB.isVisible()){
            //Change the content of the fragment
            fragmentB.changeData(index);
        }else{
            //Portrairt mode only fragmentA visible
            Intent i = new Intent(this,DetailActivity.class);
            i.putExtra(INDEX_KEY,index);
            startActivity(i);
        }

    }
}
