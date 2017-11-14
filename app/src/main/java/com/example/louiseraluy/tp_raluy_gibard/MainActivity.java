package com.example.louiseraluy.tp_raluy_gibard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ThreadLocalRandom;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Référencer dans le code les les éléments avec lesquels nous allons interagir

        Button mPorte1Button;
        Button mPorte2Button;
        Button mPorte3Button;


        // Référencer les éléments graphiques avec l'aide de l'id qui se trouve dans le xml

        mPorte1Button=(Button) findViewById(R.id.activity_main_porte1_btn);
        mPorte2Button=(Button) findViewById(R.id.activity_main_porte2_btn);
        mPorte3Button=(Button) findViewById(R.id.activity_main_porte3_btn);

        final int porte_gagnante = random_entier(1,3); //la porte contenant la voiture
         //la porte qu'on ne garde pas pour la 2ème activité

        mPorte1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final int porte_gardee = porte_gardee(1,porte_gagnante);
                Intent gameActivity= new Intent(MainActivity.this, Game_Activity.class);
                gameActivity.putExtra("portGardee",porte_gardee);
                gameActivity.putExtra("porteGagnante",porte_gagnante);
                gameActivity.putExtra("porteChoisie","1");
                startActivity(gameActivity);
            }
        });

        mPorte2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        mPorte3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        Intent gameActivity= new Intent(MainActivity.this, Game_Activity.class);
        startActivity(gameActivity);


    }

    public int random_entier(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);

    }

    //algo qui élimine la porte

    public int porte_gardee(int valeur_porte,int porte_gagnante){
        if (valeur_porte==1 && porte_gagnante== 1){
            return random_entier(2,3);
        }

        else if (valeur_porte==2 && porte_gagnante== 2){
            int valPorte =2;
            while (valPorte== 2){
                valPorte = random_entier(1,3);
            }
            return  valPorte;
        }

        else if (valeur_porte==3 && porte_gagnante== 3){
            return random_entier(1,2);
        }
        else
            return 0;
    }
}
