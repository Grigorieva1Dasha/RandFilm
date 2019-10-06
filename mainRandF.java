package com.example.user.randf;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class mainRandF extends AppCompatActivity {

    String[] myfilms;
    TextView filmTitle;
    boolean[] watch;
    int filmid = 0;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_rand_f);
        filmTitle = findViewById(R.id.filmT);
        myfilms = getResources().getStringArray(R.array.films);
        watch = new boolean[myfilms.length];
        for (int i = 0; i < myfilms.length; i++){
            watch[i] = false;
        }
    }
    public void onClick(View v) {
        if (v.getId() == R.id.myrand){
            if (count == myfilms.length){
                filmTitle.setText("No films");
            }
            else {
                filmid = (int)(Math.random() * myfilms.length);
                while (watch[filmid]){
                    filmid = (int)(Math.random() * myfilms.length);
                }
                filmTitle.setText(myfilms[filmid]);
                watch[filmid] = true;
                count++;
            }
        }
        if (v.getId() == R.id.del){
            for (int i = 0; i < myfilms.length; i++){
                watch[i] = false;
            }
            count = 0;
            filmTitle.setText("Press Rand to choose a film");
        }
    }
}
