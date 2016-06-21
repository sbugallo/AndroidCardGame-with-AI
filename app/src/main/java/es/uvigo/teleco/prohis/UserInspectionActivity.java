package es.uvigo.teleco.prohis;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.Toast;


public class UserInspectionActivity extends AppCompatActivity {
    private ImageButton nextButton;

    // Players cards
    private String[] ia1Hand = new String[8];
    private String[] ia2Hand = new String[8];
    private String[] ia3Hand = new String[8];
    private String[] playerHand = new String[8];

    // Table cards
    private String[] tableCards;

    // Players money
    private int ia1Money,ia2Money,ia3Money,playerMoney;

    // Deck
    private Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_userinspection);
        ActionBar actionBar = getSupportActionBar();

        if (actionBar != null) {
            actionBar.setTitle("Investigation Phase");
        }

        Bundle bundle= this.getIntent().getBundleExtra("Bundle");

        playerHand = bundle.getStringArray("PlayerHand");
        ia1Hand =  bundle.getStringArray("IA1Hand");
        ia2Hand = bundle.getStringArray("IA2Hand");
        ia3Hand =  bundle.getStringArray("IA3Hand");

        playerMoney = bundle.getInt("PlayerMoney");
        ia1Money = bundle.getInt("IA1Money");
        ia2Money = bundle.getInt("IA2Money");
        ia3Money = bundle.getInt("IA3Money");

        tableCards = bundle.getStringArray("TableCards");
        deck = (Deck) bundle.getSerializable("Deck");

        /*
         * WE DEFINE THE BUTTONS
         */

        nextButton = (ImageButton) findViewById(R.id.BtnNext);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //We create the Intent
                Intent intent =
                        new Intent(UserInspectionActivity.this, GameActivity.class);

                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

                Bundle b = new Bundle();
                b.putStringArray("PlayerHand", playerHand);
                b.putInt("PlayerMoney", playerMoney);
                b.putStringArray("IA1Hand", ia1Hand);
                b.putInt("IA1Money", ia1Money);
                b.putStringArray("IA2Hand", ia2Hand);
                b.putInt("IA2Money", ia2Money);
                b.putStringArray("IA3Hand", ia3Hand);
                b.putInt("IA3Money", ia3Money);
                b.putStringArray("TableCards", tableCards);
                b.putSerializable("Deck", deck);


                //We add the bundle to the intent
                intent.putExtra("Bundle", b);

                //We start the activity
                startActivity(intent);

            }

        });

        AlertDialog dialog = createRadioListDialog();
        dialog.show();
    }

    public AlertDialog createRadioListDialog() {


        final String[] items = {"Yes", "No"};

        AlertDialog.Builder builder =
                new AlertDialog.Builder(this);

        builder.setTitle("Do you want to inspect?")
                .setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast toast1 =
                                Toast.makeText(getApplicationContext(),
                                        "Opción elegida: " + items[item], Toast.LENGTH_SHORT);

                        toast1.show();
                    }
                });

        return builder.create();
    }

}

