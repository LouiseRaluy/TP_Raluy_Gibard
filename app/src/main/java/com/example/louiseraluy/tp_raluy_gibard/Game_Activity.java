package com.example.louiseraluy.tp_raluy_gibard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class Game_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_);

        Intent intent=getIntent();

        String porte_gardee = intent.getStringExtra("porteGardee");
        String porte_choisie= intent.getStringExtra("porteChosie");
        String porte_gagnante=intent.getStringExtra("porteGagnante");

        Button porteButtonUne=(Button) findViewById(R.id.activity_game_porte1_btn);
        Button porteButtonDeux=(Button) findViewById(R.id.activity_game_porte2_btn);
        Button mPorteGardee=(Button) findViewById(R.id.activity_game_garder_btn);

        porteButtonUne.setText("Porte "+porte_gardee);
        porteButtonDeux.setText("Porte "+porte_choisie);

    }
}
