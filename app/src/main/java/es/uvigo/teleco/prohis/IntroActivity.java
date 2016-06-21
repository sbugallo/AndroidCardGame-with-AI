package es.uvigo.teleco.prohis;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;

public class IntroActivity extends AppCompatActivity {


    private ImageButton newGameButton,settingsButton,aboutButton,exitButton;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*
         *  WE HIDE THE STATUS BAR
         */
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_intro);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.hide();
        }

        /*
         * WE DEFINE THE BUTTONS
         */

        newGameButton = (ImageButton) findViewById(R.id.BtnNewGame);
        settingsButton = (ImageButton) findViewById(R.id.BtnSettings);
        aboutButton = (ImageButton) findViewById(R.id.BtnAbout);
        exitButton= (ImageButton) findViewById(R.id.BtnExit);


        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(IntroActivity.this , GameActivity.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });

        settingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(IntroActivity.this, SettingsActivity.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });


        aboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el Intent
                Intent intent =
                        new Intent(IntroActivity.this, AboutActivity.class);

                //Iniciamos la nueva actividad
                startActivity(intent);
            }
        });


        exitButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
