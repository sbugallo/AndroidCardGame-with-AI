package es.uvigo.teleco.prohis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {


    private Switch language, difficulty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_settings);


        /*
         * WE DEFINE THE BUTTONS
         */

        language = (Switch) findViewById(R.id.LanguageSwitch);
        difficulty = (Switch) findViewById(R.id.DifficultySwitch);

        language.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                if(language.isChecked()){
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Spanish", Toast.LENGTH_SHORT);

                    toast1.show();
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "English", Toast.LENGTH_SHORT);

                    toast1.show();
                }

            }
        });

        difficulty.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                if(difficulty.isChecked()){
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Hard", Toast.LENGTH_SHORT);

                    toast1.show();
                }else{
                    Toast toast1 =
                            Toast.makeText(getApplicationContext(),
                                    "Normal", Toast.LENGTH_SHORT);

                    toast1.show();
                }

            }
        });

    }

}

