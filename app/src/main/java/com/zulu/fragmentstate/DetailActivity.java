package com.zulu.fragmentstate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.zulu.fragmentstate.fragments.FragmentB;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        int index = getIntent().getIntExtra(MainActivity.INDEX_KEY,0);
        FragmentB fragmentoB = (FragmentB) getSupportFragmentManager().findFragmentById(R.id.second_fragment);

        if(fragmentoB!=null){
            fragmentoB.changeData(index);
        }


    }
}
